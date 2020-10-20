package br.com.fausto.institutions_app.repository

import androidx.lifecycle.MutableLiveData
import br.com.fausto.institutions_app.model.University
import br.com.fausto.institutions_app.retrofit.UniversityClient

class UniversityRepository {
    private val universityClient = UniversityClient()
    val universityList = MutableLiveData<List<University>>()

    fun getListOfUniversities(name: String, success: () -> Unit, failure: () -> Unit) {
        universityClient.getUniversities(name, success = {
            universityList.value
            success()
        }, failure = {
            failure()
        })
    }
}