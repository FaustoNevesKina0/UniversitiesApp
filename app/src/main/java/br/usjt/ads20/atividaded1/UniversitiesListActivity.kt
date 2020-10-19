package br.usjt.ads20.atividaded1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_universities.*
import java.util.*

class UniversitiesListActivity : AppCompatActivity() {
    lateinit var list: List<University>
    var activity: Activity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_universities)
        activity = this
        val intent = intent
        val keyValue = intent.getStringExtra(MainActivity.NAME)
        val universities = intent.getSerializableExtra(MainActivity.UNIVERSITIES) as ArrayList<University>
        UniversityData.setUniversities(universities)
        list = UniversityData.getUniversities(keyValue)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = UniversityAdapter(list, this) {
            val uri = Uri.parse(it.webPages)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}