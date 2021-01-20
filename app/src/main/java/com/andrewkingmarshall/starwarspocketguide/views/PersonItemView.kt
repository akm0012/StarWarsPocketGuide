package com.andrewkingmarshall.starwarspocketguide.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.andrewkingmarshall.starwarspocketguide.R
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import kotlinx.android.synthetic.main.view_item_person.view.*

class PersonItemView : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        View.inflate(context, R.layout.view_item_person, this)
    }

    private fun resetView() {
        nameTextView.text = ""
        favoritedIndicator.visibility = View.GONE
    }

    fun setPerson(person: Person) {
        resetView()

        nameTextView.text = person.name

        if (person.isFavorited) {
            favoritedIndicator.visibility = View.VISIBLE
        }
    }
}