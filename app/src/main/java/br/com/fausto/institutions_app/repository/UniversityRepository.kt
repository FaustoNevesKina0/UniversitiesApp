package br.com.fausto.institutions_app.repository

import br.com.fausto.institutions_app.database.UniversityDao
import br.com.fausto.institutions_app.model.UniversityParsedItem
import br.com.fausto.institutions_app.retrofit.UniversityClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UniversityRepository(private val universityDao: UniversityDao) {

    private val universityClient = UniversityClient()

    fun getListOfUniversities(name: String, success: (MutableList<UniversityParsedItem>?) -> Unit, failure: () -> Unit) {
        universityClient.getUniversities(name, success = {
            clearTable()
            loadListToDB(it!!)
            success(it)
        }, failure = {
            failure()
        })
    }

    private fun loadListToDB(list: MutableList<UniversityParsedItem>) {
        GlobalScope.launch {
            for (item in list) {
                universityDao.save(item)
            }
        }
    }

    fun loadListFromDB(success: (MutableList<UniversityParsedItem>) -> Unit) {
        GlobalScope.launch {
            val listToDB = async {
                universityDao.loadAll()
            }
            success(listToDB.await())
        }
    }

    fun clearTable() = GlobalScope.launch { universityDao.clearTable() }

}