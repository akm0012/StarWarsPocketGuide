package com.andrewkingmarshall.starwarspocketguide.network.dtos

import junit.framework.Assert.assertEquals
import org.junit.Test

class PersonDtoTest {

    @Test
    fun `get id happy path`() {

        val personDto = PersonDto(
            url = "http://swapi.dev/api/people/22/"
        )

        val expected = "22"
        val actual = personDto.getId()

        assertEquals(expected, actual)
    }

    @Test
    fun `get id empty`() {

        val personDto = PersonDto(
            name = "Andrew",
            url = ""
        )

        val expected = "Andrew"
        val actual = personDto.getId()

        assertEquals(expected, actual)
    }

    @Test
    fun `get id bad url`() {

        val personDto = PersonDto(
            name = "Andrew",
            url = "http://swapi.dev/api/22/"
        )

        val expected = "Andrew"
        val actual = personDto.getId()

        assertEquals(expected, actual)
    }
}