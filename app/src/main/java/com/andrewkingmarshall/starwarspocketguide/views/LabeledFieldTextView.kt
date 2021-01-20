package com.andrewkingmarshall.starwarspocketguide.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.andrewkingmarshall.starwarspocketguide.R
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import kotlinx.android.synthetic.main.view_item_person.view.*
import kotlinx.android.synthetic.main.view_item_person.view.nameTextView
import kotlinx.android.synthetic.main.view_person_detail_attribute.view.*

class LabeledFieldTextView(context: Context, attrs: AttributeSet) :
    ConstraintLayout(context, attrs) {

    init {
        View.inflate(context, R.layout.view_person_detail_attribute, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.LabeledFieldTextView)
        labelTextView.text = attributes.getString(R.styleable.LabeledFieldTextView_lftv_fieldLabel)
        attributes.recycle()
    }

    fun setField(field: String) {
        detailTextView.text = field
    }
}