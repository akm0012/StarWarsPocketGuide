package com.andrewkingmarshall.starwarspocketguide.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrewkingmarshall.beachbuddy.extensions.toast
import com.andrewkingmarshall.starwarspocketguide.R
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import kotlinx.android.synthetic.main.activity_person_detail.*

class PersonDetailActivity : AppCompatActivity() {

    companion object {
        const val PERSON_EXTRA = "PERSON_EXTRA"
        fun getIntent(context: Context, person: Person): Intent {
            return Intent(context, PersonDetailActivity::class.java).apply {
                putExtra(PERSON_EXTRA, person)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_person_detail)

        val person = intent.extras?.get(PERSON_EXTRA) as Person

        nameField.setField(person.name)
        heightField.setField(person.height)
        massField.setField(person.mass)
        hairColorField.setField(person.hairColor)
        skinColorField.setField(person.skinColor)
        eyeColorField.setField(person.eyeColor)
        birthYearField.setField(person.birthYear)
        genderField.setField(person.gender)

        favoriteCheckBox.isChecked = person.isFavorited
    }
}