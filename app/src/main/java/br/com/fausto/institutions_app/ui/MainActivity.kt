package br.com.fausto.institutions_app.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.fausto.institutions_app.R
import br.com.fausto.institutions_app.viewmodel.UniversityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var txtName: EditText
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = progressBarMainActivity
        txtName = edit_text_search
        context = this
    }

    fun btnSearch(view: View) {
        progressBar.visibility = View.VISIBLE
        loadUniversitiesList(txtName.text.toString())
    }

    private fun loadUniversitiesList(name: String) {
        val viewModel = ViewModelProvider(this).get(UniversityViewModel::class.java)
        viewModel.getListOfUniversities(name, success = {
            val intent = Intent(this, UniversitiesListActivity::class.java)
            intent.putExtra("list", it)
            progressBar.visibility = View.INVISIBLE
            startActivity(intent)
        }, failure = {
            Toast.makeText(this, "Check your ethernet connection", Toast.LENGTH_SHORT).show()
        })
    }
}