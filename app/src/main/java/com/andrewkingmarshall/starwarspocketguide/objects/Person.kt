package com.andrewkingmarshall.starwarspocketguide.objects

import com.andrewkingmarshall.starwarspocketguide.network.dtos.PersonDto
import java.io.Serializable

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

    var isFavorited: Boolean,

): Serializable {
    constructor(
        personDto: PersonDto,
        isFavorited: Boolean
    ) : this(
        personDto.getId(),
        personDto.name,
        personDto.height,
        personDto.mass,
        personDto.hairColor,
        personDto.skinColor,
        personDto.eyeColor,
        personDto.birthYear,
        personDto.gender,
        isFavorited,
    )

}
