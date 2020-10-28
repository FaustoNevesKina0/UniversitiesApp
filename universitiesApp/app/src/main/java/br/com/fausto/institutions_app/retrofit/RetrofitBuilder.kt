package br.com.fausto.institutions_app.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun universityService(): UniversityService = retrofit.create(UniversityService::class.java)

}