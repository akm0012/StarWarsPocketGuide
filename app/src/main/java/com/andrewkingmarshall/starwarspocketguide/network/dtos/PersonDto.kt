package com.andrewkingmarshall.starwarspocketguide.network.dtos

import com.google.gson.annotations.SerializedName

data class PersonDto(

    val name: String = "",

    val height: String = "",

    val mass: String = "",

    @SerializedName("hair_color")
    val hairColor: String = "",

    @SerializedName("skin_color")
    val skinColor: String = "",

    @SerializedName("eye_color")
    val eyeColor: String = "",

    @SerializedName("birth_year")
    val birthYear: String = "",

    val gender: String = "",

    /**
     *  Used to create an Id, in the example case, 22.
     *  Ex: "url": "http://swapi.dev/api/people/22/"
     */
    val url: String = "",
) {
    fun getId(): String {

        // If no url us the name as the Id
        if (url.isBlank()) {
            return name
        }

        var id = url.substringAfter("/people/", missingDelimiterValue = name)

        if (id != name) {
            id = id.substring(0, id.length - 1)
        }

        return id
    }
}