package com.andrewkingmarshall.starwarspocketguide.network

import com.andrewkingmarshall.starwarspocketguide.network.response.PeopleSearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceInterface {

    @GET("people")
    fun searchPeople(@Query("search") searchQuery: String): Observable<PeopleSearchResponse>

}