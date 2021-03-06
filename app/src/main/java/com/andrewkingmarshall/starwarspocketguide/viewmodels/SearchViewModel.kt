package com.andrewkingmarshall.starwarspocketguide.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import com.andrewkingmarshall.starwarspocketguide.repository.PeopleRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class SearchViewModel
@Inject constructor(
    private val peopleRepository: PeopleRepository
) : ViewModel() {

    val goToPersonDetailEvent = SingleLiveEvent<Person>()

    private val compositeDisposable = CompositeDisposable()
    private var peopleLiveData = MutableLiveData<List<Person>>()

    fun getSearchResultLiveData(): LiveData<List<Person>> {
        return peopleLiveData
    }

    fun onSearchQueryUpdated(searchQuery: String) {
        compositeDisposable.add(peopleRepository.getPeopleForSearchQuery(searchQuery)
            .map { peopleLiveData.postValue(it) }
            .subscribe(
                { Timber.d("People search complete") },
                { error -> Timber.e(error) }
            )
        )
    }

    fun onPersonSelected(person: Person) {
        goToPersonDetailEvent.value = person
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}