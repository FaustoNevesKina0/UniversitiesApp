package br.com.fausto.institutions_app.viewmodel

import androidx.lifecycle.ViewModel
import br.com.fausto.institutions_app.model.UniversityParsed
import br.com.fausto.institutions_app.retrofit.UniversityClient

class UniversityViewModel() : ViewModel() {

    private val universityClient = UniversityClient()

    fun getListOfUniversities(name: String, success: (UniversityParsed?) -> Unit, failure: () -> Unit) {
        universityClient.getUniversities(name, success = {
            success(it)
        }, failure = {
            failure()
        })
    }
}