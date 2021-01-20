package com.andrewkingmarshall.starwarspocketguide.repository

import android.content.Context
import com.andrewkingmarshall.beachbuddy.extensions.getFromSharedPrefs
import com.andrewkingmarshall.beachbuddy.extensions.saveToSharedPrefs
import com.andrewkingmarshall.starwarspocketguide.network.ApiService
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    @ApplicationContext val context: Context,
    private val apiService: ApiService
) {

    fun getPeopleForSearchQuery(searchQuery: String): Single<List<Person>> {
        return apiService.searchPeople(searchQuery)
            .subscribeOn(Schedulers.io())
            .flatMapIterable { it.results }
            .map { Person(it, getFromSharedPrefs(context, it.getId(), false)) }
            .toList()
    }

    fun setPersonIsFavorited(person: Person, isFavorited: Boolean) {
        isFavorited.saveToSharedPrefs(context, person.id)
    }

}