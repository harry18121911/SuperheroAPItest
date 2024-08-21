package com.harry18121911.superheroapitest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/v2/pokemon/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<SuperheroDataResponse>
}