package br.com.fausto.institutions_app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fausto.institutions_app.model.UniversityParsed
import br.com.fausto.institutions_app.retrofit.UniversityClient

class UniversityViewModel() : ViewModel() {

    private val universityClient = UniversityClient()

    var universityList: MutableLiveData<UniversityParsed> = MutableLiveData()

    fun getList(): UniversityParsed {
        return universityList.value!!
    }

    fun loadList(list: UniversityParsed) {
        universityList.value = list
    }

    fun getListOfUniversities(name: String, success: (UniversityParsed?) -> Unit, failure: () -> Unit) {
        universityClient.getUniversities(name, success = {
//            Log.e("lista 1", it.toString())
//            Log.e("lista 2", it!![0].alpha_two_code.toString())
//            Log.e("lista 3", it[0].name.toString())

//            loadList(it!!)
//            universityList.postValue(it)

            success(it)
        }, failure = {
            Log.e("deu ruim", it.toString())
            failure()
        })
    }
}