package com.andrewkingmarshall.starwarspocketguide.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.andrewkingmarshall.starwarspocketguide.R
import com.andrewkingmarshall.starwarspocketguide.viewmodels.SearchViewModel
import com.jakewharton.rxbinding2.widget.RxSearchView
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_search.*
import timber.log.Timber
import java.util.concurrent.TimeUnit

import javax.inject.Inject

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var searchViewModel: SearchViewModel

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        RxSearchView.queryTextChanges(searchView)
            // Wait a bit before telling the ViewModel something happened.
            // This will ensure you don't call more network calls than you really need to.
            .throttleWithTimeout(800, TimeUnit.MILLISECONDS)
            .subscribe {
                Timber.d("Searching for $it")
                searchViewModel.onSearchQueryUpdated(it.toString())
            }

        searchViewModel.getSearchResultLiveData().observe(this, { people ->
            Timber.d("New people: $people")
        })
    }
}