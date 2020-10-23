package br.com.fausto.institutions_app.retrofit

import br.com.fausto.institutions_app.model.UniversityParsed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val REQUEST_FAILED = "FAILED REQUEST"

class UniversityClient {

    lateinit var universityService: UniversityService
    private fun request(
            call: Call<UniversityParsed>,
            success: (list: UniversityParsed?) -> Unit,
            failure: (error: String?) -> Unit
    ) {
        call.enqueue(object : Callback<UniversityParsed> {
            override fun onResponse(call: Call<UniversityParsed>, response: Response<UniversityParsed>) {
                if (response.isSuccessful) {
                    success(response.body())
                } else {
                    failure(REQUEST_FAILED)
                }
            }

            override fun onFailure(call: Call<UniversityParsed>, t: Throwable) {
                failure(t.message)
            }
        })
    }

    fun getUniversities(
            name: String,
            success: (list: UniversityParsed?) -> Unit,
            failure: (error: String?) -> Unit) {

        universityService = RetrofitBuilder().universityService()
        request(universityService.getUniversities(name), success, failure)
    }
}