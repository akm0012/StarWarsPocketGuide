package com.andrewkingmarshall.starwarspocketguide.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrewkingmarshall.starwarspocketguide.objects.Person
import com.andrewkingmarshall.starwarspocketguide.views.PersonItemView


class PersonAdapter(
    private var people: List<Person>,
    private val personClickedListener: PersonClickedListener? = null
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    interface PersonClickedListener {
        fun onPersonClicked(person: Person)
    }

    class PersonViewHolder(val personItemView: PersonItemView) : RecyclerView.ViewHolder(
        personItemView
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonViewHolder {

        val itemView = PersonItemView(parent.context)

        // manually set the CustomView's size
        itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.personItemView.setPerson(person)
        holder.personItemView.setOnClickListener {
            personClickedListener?.onPersonClicked(person)
        }
    }

    override fun getItemCount() = people.size

    fun setPeople(people: List<Person>) {
        this.people = people
        notifyDataSetChanged()
    }
}