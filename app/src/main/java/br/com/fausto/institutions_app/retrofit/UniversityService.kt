package br.com.fausto.institutions_app.retrofit

import br.com.fausto.institutions_app.model.University
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityService {
    @GET("/search?name=universityName")
    fun getUniversities(@Query("universityName") universityName: String): Call<List<University>>
}