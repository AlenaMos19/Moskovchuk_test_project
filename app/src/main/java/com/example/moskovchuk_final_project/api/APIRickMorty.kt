package com.example.moskovchuk_final_project.api

import com.example.moskovchuk_final_project.data.fromJson.ResponseDataClass
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIRickMorty {

    @Headers("Content-type: application/json")
    @GET("character")
    fun getCharacterList():retrofit2.Call<ResponseDataClass>
}