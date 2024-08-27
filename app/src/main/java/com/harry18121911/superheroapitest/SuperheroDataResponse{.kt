package com.harry18121911.superheroapitest

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(@SerializedName("response") val response: String, @SerializedName("results") val superHeroes:List<SuperheroItemResponse>)

data class SuperheroItemResponse(@SerializedName("id") val superHeroId :String,
                                 @SerializedName("name") val name: String,
                                 @SerializedName("image") val superHeroImage: SuperheroImageResponse)

data class SuperheroImageResponse(@SerializedName("url") val url:String )