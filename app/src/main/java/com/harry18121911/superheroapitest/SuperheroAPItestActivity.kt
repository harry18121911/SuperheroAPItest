package com.harry18121911.superheroapitest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.google.gson.Gson
import com.harry18121911.superheroapitest.databinding.ActivitySuperheroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroAPItestActivity: AppCompatActivity() {

    private lateinit var  binding : ActivitySuperheroBinding

    private lateinit var  retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()

    }

    private fun initUI(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful){
                Log.i("APITEST","SUCCESS")
            }else{
                Log.i("APITEST", "ERROR IT TYPE, CHANGE")
            }

        }
    }

    private fun getRetrofit(): Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}