package com.harry18121911.superheroapitest

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.harry18121911.superheroapitest.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: SuperheroItemResponse){
        binding.tvSuperheroName.text = superheroItemResponse.name
        Picasso.get().load(superheroItemResponse.superHeroImage.url).into(binding.ivSuperhero)
    }


}