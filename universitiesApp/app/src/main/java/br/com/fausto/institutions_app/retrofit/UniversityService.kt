package br.com.fausto.institutions_app.retrofit

import br.com.fausto.institutions_app.model.UniversityParsed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityService {
    @GET("/search")
    fun getUniversities(@Query("name") universityName: String): Call<UniversityParsed>
}