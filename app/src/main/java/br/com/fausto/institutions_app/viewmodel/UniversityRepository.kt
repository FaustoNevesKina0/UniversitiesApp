package br.com.fausto.institutions_app.viewmodel

import br.com.fausto.institutions_app.database.UniversityDao
import br.com.fausto.institutions_app.model.UniversityParsed
import br.com.fausto.institutions_app.model.UniversityParsedItem
import br.com.fausto.institutions_app.retrofit.UniversityClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UniversityRepository(private val universityDao: UniversityDao) {

    private val universityClient = UniversityClient()
    private lateinit var arrayListUniversities: ArrayList<UniversityParsed>
    private val listParsed = ArrayList<UniversityParsedItem>()

    fun getListOfUniversities(name: String, success: (MutableList<UniversityParsedItem>?) -> Unit, failure: () -> Unit) {
        universityClient.getUniversities(name, success = {
            arrayListUniversities = it as ArrayList<UniversityParsed>
            loadIntoDB(arrayListUniversities)
            success(it)
        }, failure = {
            failure()
        })
    }

    private fun loadIntoDB(arrayList: ArrayList<UniversityParsed>) {
        GlobalScope.launch {
            val list = arrayList.toArray()
            for (item in list) {
                listParsed.add(item as UniversityParsedItem)
            }
            for (university in listParsed) {
                universityDao.save(university)
            }
        }
    }
}