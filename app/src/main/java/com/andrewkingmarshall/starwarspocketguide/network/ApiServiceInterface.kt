package com.andrewkingmarshall.starwarspocketguide.network

import com.andrewkingmarshall.starwarspocketguide.network.response.PeopleSearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    @GET("people/?search/{SEARCH_QUERY}")
    fun searchPeople(@Path("SEARCH_QUERY") searchQuery: String): Observable<PeopleSearchResponse>

}