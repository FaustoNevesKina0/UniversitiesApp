package br.com.fausto.institutions_app

import br.com.fausto.institutions_app.model.University
import java.util.*
import java.util.Collections.sort

object UniversityData {
    private var universities: List<University>? = null
    fun setUniversities(pUniversities: List<University>?) {
        universities = pUniversities
    }

    fun getUniversities(keyValue: String?): List<University> {
        val list = universities
        val filter: List<University>?
        val universities: List<University>
        if (keyValue == null || keyValue.isEmpty()) {
            filter = list
        } else {
            filter = ArrayList()
            for (university in list!!) {
                val nome = university.name
                if (nome!!.toUpperCase().contains(keyValue.toUpperCase())) {
                    filter.add(university)
                }
            }
        }
        universities = filter!!.toTypedArray().toList()
        sort(universities)
        return universities
    }
}