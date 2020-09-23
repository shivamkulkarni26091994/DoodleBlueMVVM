package com.doodleblue.application.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.doodleblue.application.model.DeveloperModel
import com.doodleblue.application.network.RetrofitClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import com.google.gson.JsonObject
import com.google.gson.JsonParser


import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeveloperRepository {
    private val mmDeveloperModelmist = ArrayList<DeveloperModel>()
    private val mutableLiveData = MutableLiveData<List<DeveloperModel>>()

    ////call to internet and  retun  MutableLiveData
    fun getMutableLiveData(): MutableLiveData<List<DeveloperModel>> {

        ///ini Retrofit Class
        val userDataService = RetrofitClient.service

        ///call the API that define In Interface
        val call = userDataService.apiRequestsArray

        call.enqueue(object : Callback<JsonObject> {
            internal var message: String? = null

            override fun onResponse(call: Call<JsonObject>, resp: Response<JsonObject>) {

                /// parse the data if  Response successfully and store data in MutableLiveData  and retrun to DeveloperViewModel class
                val gson = GsonBuilder().create()
                if (resp != null && resp.body() != null) {

                    val json = JsonParser().parse(resp.body()!!.toString()).asJsonObject
                    //Log.e("data",json.toString())
                    if (json != null) {
                        val jss=json.getAsJsonArray("data")
                        if (jss != null)


                            for (i in 0..jss.size() - 1) {
                                try {

                                    val jsonobj =
                                        JsonParser().parse(jss.get(i).toString()).asJsonObject
                                    val responseModel =
                                        gson.fromJson(jsonobj, DeveloperModel::class.java)
                                    mmDeveloperModelmist.add(responseModel)

                                } catch (ex: Exception) {

                                }


                            }
                        mutableLiveData.value = mmDeveloperModelmist

                    }
                }


            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.printStackTrace()

            }
        })


        return mutableLiveData
    }

    companion object {

        private val TAG = "DeveloperRepository"
    }
}


