package com.harry18121911.superheroapitest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.harry18121911.superheroapitest.DetailsSuperHeroActivity.Companion.EXTRA_ID
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

    private lateinit var  adapter: SuperheroAdapter

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

        adapter = SuperheroAdapter{superheroId ->navigateToDetail(superheroId)}
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun searchByName(query:String){
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            var myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful){
                Log.i("APITEST","SUCCESS")
                val response: SuperheroDataResponse? = myResponse.body()
                if (response != null) {
                    if(response.superHeroes != null){
                        Log.i("APITEST",response.toString())
                        runOnUiThread {
                            adapter.updateList(response.superHeroes)
                            binding.progressBar.isVisible = false
                        }
                    }else{
                        Log.i("APITEST", "FINDING NULL ERROR")
                        runOnUiThread {
                            adapter.updateList()
                            binding.progressBar.isVisible = false
                        }
                    }
                }
            }else{
                Log.i("APITEST", "ERROR IT TYPE, CHANGE")
            }

        }
    }

    private fun getRetrofit(): Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://superheroapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    private fun navigateToDetail(id:String){
        val intent = Intent(this, DetailsSuperHeroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }

}

