package com.example.moskovchuk_final_project.data

import androidx.constraintlayout.core.motion.utils.Utils
import androidx.lifecycle.MutableLiveData
import com.example.moskovchuk_final_project.api.APIRickMorty
import retrofit2.Callback
import com.example.moskovchuk_final_project.data.fromJson.*
import com.squareup.moshi.internal.Util
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitController: Callback<List<ResponseDataClass>> {

    val characterResult = MutableLiveData<ResponseDataClass>{}

    fun getCharacterResult(){

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Utils.API_URL)
            .addCorvercFactory(MoshiConverterFactory.create())
            .client
            .building()

        val api: APIRickMorty = retrofit.create(APIRickMorty::class.java)
        val call: Call<ResponseDataClass> = api.getCharacterList()
        call.enqueue(this)
    }
    override fun onResponse(call: Call<List<ResponseDataClass>>, response: Response<List<ResponseDataClass>>) {
        if (response.isSuccessful){
            characterResult.postValue((response.body()))
        } else println(response.errorBody())
        }
    }

    override fun onFailure(call: Call<List<ResponseDataClass>>, t: Throwable) {
        t.printStackTrace()
    }
}