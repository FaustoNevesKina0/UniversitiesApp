package br.com.fausto.institutions_app.retrofit

import android.util.Log
import br.com.fausto.institutions_app.model.University
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val REQUEST_FAILED = "FAILED REQUEST"

class UniversityClient {

    lateinit var universityService: UniversityService

    private fun request(
            call: Call<List<University>>,
            success: (list: List<University>?) -> Unit,
            failure: (error: String?) -> Unit
    ) {
        call.enqueue(object : Callback<List<University>> {
            override fun onResponse(call: Call<List<University>>, response: Response<List<University>>) {
                if (response.isSuccessful) {
                    Log.e("status code", response.code().toString())
                    success(response.body())
                } else {
                    failure(REQUEST_FAILED)
                }
            }

            override fun onFailure(call: Call<List<University>>, t: Throwable) {
                failure(t.message)
            }
        })
    }

    fun getUniversities(
            name: String,
            success: (list: List<University>?) -> Unit,
            failure: (error: String?) -> Unit) {

        universityService = RetrofitBuilder().universityService()
        request(universityService.getUniversities(name), success, failure)
    }

//    fun getUniversities(universityName: String, success: () -> Unit, failure: () -> Unit) {
//        val call = RetrofitBuilder().universityService().getUniversities(universityName)
//        call.enqueue(object : Callback<List<University>> {
//            override fun onResponse(call: Call<List<University>>, response: Response<List<University>>) {
//                if (response.isSuccessful) {
//                    Log.e("requisição deu certo", "requisição deu certo")
//                    success()
//                }
//            }
//
//            override fun onFailure(call: Call<List<University>>, t: Throwable) {
//                Log.e("requisição falhou", "requisição falhou")
//                failure()
//            }
//        })
//    }
}