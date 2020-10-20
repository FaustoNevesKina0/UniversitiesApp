package br.com.fausto.institutions_app

import br.com.fausto.institutions_app.model.University
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

object UniversityNetwork {
    fun searchUniversities(url: String?): ArrayList<University?> {
        val universities = ArrayList<University?>()
        val client = OkHttpClient()
        val request = Request.Builder().url(url!!).build()
        val response = client.newCall(request).execute()
        val json = response.body!!.string()
        try {
            val list = JSONArray(json)
            for (i in 0 until list.length()) {
                val university = University(null, null, null, null, null)
                val item = list[i] as JSONObject
                university.name = item.getString("name")
                university.alphaTwoCode = item.getString("alpha_two_code")
                university.country = item.getString("country")
                val pages = item.getJSONArray("web_pages")
                university.webPages = pages.getString(0)
                if (universities.size > 1200) {
                    return universities
                } else {
                    universities.add(university)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return universities
    }
}