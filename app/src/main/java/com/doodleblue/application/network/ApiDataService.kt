package com.doodleblue.application.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONObject

import retrofit2.Call
import retrofit2.http.GET

interface ApiDataService {


    @get:GET("v2/assets")
    val apiRequestsArray: Call<JsonObject>

}