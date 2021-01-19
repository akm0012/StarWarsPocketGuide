package com.andrewkingmarshall.starwarspocketguide.objects

import com.andrewkingmarshall.starwarspocketguide.network.dtos.PersonDto
import com.google.gson.annotations.SerializedName

data class Person(

    val id: String,

    val name: String,

    val height: String,

    val mass: String,

    val hairColor: String,

    val skinColor: String,

    val eyeColor: String,

    val birthYear: String,

    val gender: String,

    val isFavorited: Boolean,
) {
//    constructor(
//        personDto: PersonDto,
//        isFavorited: Boolean
//    ) : this(
//
//
//
//    )

}
