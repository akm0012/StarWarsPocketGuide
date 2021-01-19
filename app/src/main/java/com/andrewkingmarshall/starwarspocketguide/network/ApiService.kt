package com.andrewkingmarshall.starwarspocketguide.network

import com.andrewkingmarshall.starwarspocketguide.network.response.PeopleSearchResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class ApiService @Inject constructor(retrofit: Retrofit) {

    private val apiService: ApiServiceInterface =
        retrofit.create(ApiServiceInterface::class.java)

    fun searchPeople(searchQuery: String): Observable<PeopleSearchResponse> {
        return apiService.searchPeople(searchQuery)
    }

}