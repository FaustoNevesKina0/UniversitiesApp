package br.usjt.ads20.atividaded1

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var txtName: EditText
    private val url = "http://universities.hipolabs.com/search?name="
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Stetho.initializeWithDefaults(this)
        progressBar = progressBarMainActivity
        txtName = edit_text_search
        context = this
    }

    fun btnSearch(view: View) {
        progressBar.visibility = View.VISIBLE
        getAllUniversities().execute(url + txtName.text.toString())
    }

//    suspend fun getUniversidades(url: String) {
//        val job = coroutineScope {
//            UniversityNetwork.searchUniversities(url)
//        }
//    }

    private inner class getAllUniversities : AsyncTask<String?, Void?, ArrayList<University?>>() {
        override fun doInBackground(vararg params: String?): ArrayList<University?> {
            var universidades = ArrayList<University?>()
            try {
                universidades = UniversityNetwork.searchUniversities(params[0])
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return universidades
        }

        override fun onPostExecute(universities: ArrayList<University?>) {
            progressBar.visibility = View.INVISIBLE
            val intent = Intent(context, UniversitiesListActivity::class.java)
            val name = txtName.text.toString()
            intent.putExtra(NAME, name)
            intent.putExtra(UNIVERSITIES, universities)
            startActivity(intent)
        }
    }

    companion object {
        const val NAME = "br.usjt.ads20.provad1.nome"
        const val UNIVERSITIES = "br.usjt.ads20.appfilmes.provad1"
    }
}