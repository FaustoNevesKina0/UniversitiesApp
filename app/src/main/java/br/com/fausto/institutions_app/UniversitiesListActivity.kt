package br.com.fausto.institutions_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fausto.institutions_app.model.UniversityParsed
import br.com.fausto.institutions_app.model.UniversityParsedItem
import kotlinx.android.synthetic.main.activity_list_universities.*

class UniversitiesListActivity : AppCompatActivity(), UniversityAdapter.OnUniversityListener {

    private lateinit var arrayParseado: ArrayList<UniversityParsedItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_universities)
        val intent = intent
        val list: ArrayList<UniversityParsed> = intent.getSerializableExtra("list") as ArrayList<UniversityParsed>
        val list2 = list.toArray()
        arrayParseado = ArrayList()

        for (i in list2) {
            arrayParseado.add(i as UniversityParsedItem)
        }

        recyclerView.adapter = UniversityAdapter(arrayParseado, this, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    override fun onUniversityClick(position: Int) {
        val universityItem = arrayParseado[position]
        val uri = Uri.parse(universityItem.web_pages!![0])
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}