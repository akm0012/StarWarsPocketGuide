package com.andrewkingmarshall.starwarspocketguide.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andrewkingmarshall.beachbuddy.extensions.toast
import com.andrewkingmarshall.starwarspocketguide.R
import com.andrewkingmarshall.starwarspocketguide.adapter.PersonAdapter
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import com.andrewkingmarshall.starwarspocketguide.viewmodels.SearchViewModel
import com.jakewharton.rxbinding2.widget.RxSearchView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

import javax.inject.Inject

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    companion object {
        const val UPDATE_PERSON_REQUEST_CODE = 7591
    }

    @Inject
    lateinit var searchViewModel: SearchViewModel

    lateinit var personAdaptor: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)

        setUpSearchView()

        setUpRecyclerView()

        // Listen for the search results to change
        searchViewModel.getSearchResultLiveData().observe(this, { people ->
            Timber.d("People changed: $people")
            personAdaptor.setPeople(people)
        })

        // Listen for when we should go to the Detail Activity
        searchViewModel.goToPersonDetailEvent.observe(this, { person ->
            startActivityForResult(
                PersonDetailActivity.getIntent(this@SearchActivity, person),
                UPDATE_PERSON_REQUEST_CODE
            )
        })
    }

    private fun setUpRecyclerView() {
        personAdaptor = PersonAdapter(ArrayList(), object : PersonAdapter.PersonClickedListener {
            override fun onPersonClicked(person: Person) {
                searchViewModel.onPersonSelected(person)
            }
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = personAdaptor
        }
    }

    @SuppressLint("CheckResult")
    private fun setUpSearchView() {
        RxSearchView.queryTextChanges(searchView)
            // Wait a bit before telling the ViewModel something happened.
            // This will ensure you don't call more network calls than you really need to.
            .throttleWithTimeout(800, TimeUnit.MILLISECONDS)
            .subscribe {
                Timber.d("Searching for $it")
                searchViewModel.onSearchQueryUpdated(it.toString())
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Update the person in the adapter
        if (requestCode == UPDATE_PERSON_REQUEST_CODE && resultCode == RESULT_OK) {
            data?.let {
                personAdaptor.setPersonIsFavorited(
                    it.getStringExtra(PersonDetailActivity.PERSON_ID_EXTRA),
                    it.getBooleanExtra(PersonDetailActivity.IS_PERSON_FAVORITED, false)
                )
            }
        }
    }
}