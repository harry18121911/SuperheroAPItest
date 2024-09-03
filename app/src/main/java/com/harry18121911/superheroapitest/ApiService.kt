package com.harry18121911.superheroapitest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/2e4d8b6e448472b2556995fca039533c/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<SuperheroDataResponse>

    @GET("/api/2e4d8b6e448472b2556995fca039533c/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String):Response<SuperheroDetailsResponse>

}
