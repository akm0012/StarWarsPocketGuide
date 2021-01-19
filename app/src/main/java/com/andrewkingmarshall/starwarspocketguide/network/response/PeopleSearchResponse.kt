package com.andrewkingmarshall.starwarspocketguide.network.response

import com.andrewkingmarshall.starwarspocketguide.network.dtos.PersonDto

data class PeopleSearchResponse(
    val count: Int,

    val next: String?,

    val previous: String?,

    val results: List<PersonDto>
)

