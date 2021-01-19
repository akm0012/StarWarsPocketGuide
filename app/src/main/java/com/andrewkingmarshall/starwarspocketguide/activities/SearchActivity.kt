package com.andrewkingmarshall.starwarspocketguide.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.andrewkingmarshall.starwarspocketguide.R
import com.andrewkingmarshall.starwarspocketguide.viewmodels.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

import javax.inject.Inject

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    @Inject
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloButton.setOnClickListener {
            searchViewModel.onSearchQueryUpdated("Fett")
        }

        searchViewModel.getSearchResultLiveData().observe(this, { people ->
            Timber.d("New people: $people")
        })
    }
}