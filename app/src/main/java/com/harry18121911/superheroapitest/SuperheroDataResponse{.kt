package com.harry18121911.superheroapitest

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(@SerializedName("weight") val weight: Int, @SerializedName("forms") val forms:List<SuperheroItemResponse>)

data class SuperheroItemResponse(@SerializedName("name") val superHeroName :String,
                                 @SerializedName("url") val superHeroURL: String)

