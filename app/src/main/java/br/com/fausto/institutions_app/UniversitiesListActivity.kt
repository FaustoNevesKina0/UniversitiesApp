package br.com.fausto.institutions_app

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_universities.*
import java.util.*


class UniversitiesListActivity : AppCompatActivity(), UniversityAdapter.OnUniversityListener {
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

        recyclerView.adapter = UniversityAdapter(list, this, this)
    }

    override fun onUniversityClick(position: Int) {
        var universityItem = list[position]
        val uri = Uri.parse(universityItem.webPages)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}