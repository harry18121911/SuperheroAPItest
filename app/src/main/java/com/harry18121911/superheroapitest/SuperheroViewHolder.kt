package com.harry18121911.superheroapitest

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.harry18121911.superheroapitest.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: SuperheroItemResponse){
        binding.tvSuperheroName.text = superheroItemResponse.superHeroName
    }
}