package com.harry18121911.superheroapitest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter (var superheroList:List<SuperheroItemResponse> = emptyList(), private val onItemSelected:(String)->Unit):RecyclerView.Adapter<SuperheroViewHolder>(){

    fun updateList(superheroList: List<SuperheroItemResponse>){
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperheroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }

    override fun onBindViewHolder(viewHolder: SuperheroViewHolder, position: Int) {
        viewHolder.bind( superheroList[position], onItemSelected)
    }

}