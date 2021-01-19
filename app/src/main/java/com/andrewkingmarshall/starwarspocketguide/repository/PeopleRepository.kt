package com.andrewkingmarshall.starwarspocketguide.repository

import com.andrewkingmarshall.starwarspocketguide.network.ApiService
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val apiService: ApiService
) {


    fun getPeopleForSearchQuery(searchQuery: String): Single<List<Person>> {
        return apiService.searchPeople(searchQuery)
            .subscribeOn(Schedulers.io())
            .flatMapIterable { it.results }
            .map { Person(it, false) }
            .toList()
    }


}