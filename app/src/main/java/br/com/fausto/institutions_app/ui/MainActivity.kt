package br.com.fausto.institutions_app.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fausto.institutions_app.R
import br.com.fausto.institutions_app.database.AppDatabase
import br.com.fausto.institutions_app.model.UniversityParsedItem
import br.com.fausto.institutions_app.repository.UniversityRepository
import br.com.fausto.institutions_app.util.ConnectionChecker
import com.facebook.stetho.Stetho
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UniversityAdapter.OnUniversityListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var txtName: EditText
    lateinit var context: Context
    lateinit var repository: UniversityRepository
    private var listOfUniversities: MutableList<UniversityParsedItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = progressBarMainActivity
        txtName = edit_text_search
        context = this
        repository = UniversityRepository(AppDatabase.getInstance(this).universityDao)
        Stetho.initializeWithDefaults(this)
    }

    fun btnSearch(view: View) {
        progressBar.visibility = View.VISIBLE
        loadUniversitiesList(txtName.text.toString()) {
            listOfUniversities = it
            runOnUiThread {
                recyclerView.adapter = UniversityAdapter(it, this, this)
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    private fun loadUniversitiesList(name: String, finished: (MutableList<UniversityParsedItem>) -> Unit) {
        val repository = UniversityRepository(AppDatabase.getInstance(this).universityDao)
        if (ConnectionChecker.hasInternetConnection(this)) {
            repository.getListOfUniversities(name, success = {
                progressBar.visibility = View.INVISIBLE
                finished(it!!)
            }, failure = {
                progressBar.visibility = View.INVISIBLE
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
            })
        } else {
            Toast.makeText(this, "Last result displayed, to make a new research, connect to the ethernet", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.INVISIBLE
            repository.loadListFromDB(success = {
                finished(it)
            })
        }
    }

    override fun onUniversityClick(position: Int) {
        val universityItem = listOfUniversities!![position]
        val uri = Uri.parse(universityItem.web_pages!![0])
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}