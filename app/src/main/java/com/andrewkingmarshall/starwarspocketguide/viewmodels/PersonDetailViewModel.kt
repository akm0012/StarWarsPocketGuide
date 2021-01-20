package com.andrewkingmarshall.starwarspocketguide.viewmodels

import androidx.lifecycle.ViewModel
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import com.andrewkingmarshall.starwarspocketguide.repository.PeopleRepository
import javax.inject.Inject

class PersonDetailViewModel
@Inject constructor(
    private val peopleRepository: PeopleRepository
) : ViewModel() {

    fun onPersonFavorited(person: Person, isFavorited: Boolean) {
        peopleRepository.setPersonIsFavorited(person, isFavorited)
    }
}