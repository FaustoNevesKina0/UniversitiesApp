package br.com.fausto.institutions_app.repository

import br.com.fausto.institutions_app.database.UniversityDao
import br.com.fausto.institutions_app.model.UniversityParsed
import br.com.fausto.institutions_app.model.UniversityParsedItem
import br.com.fausto.institutions_app.retrofit.UniversityClient

class UniversityRepository(private val universityDao: UniversityDao) {

    private val universityClient = UniversityClient()
    private lateinit var arrayListUniversities: ArrayList<UniversityParsed>

    fun getListOfUniversities(name: String, success: (MutableList<UniversityParsedItem>?) -> Unit, failure: () -> Unit) {
        universityClient.getUniversities(name, success = {
            arrayListUniversities = it as ArrayList<UniversityParsed>
            success(it)
        }, failure = {
            failure()
        })
    }
}