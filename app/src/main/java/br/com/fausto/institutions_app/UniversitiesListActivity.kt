package br.com.fausto.institutions_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fausto.institutions_app.model.UniversityParsed
import br.com.fausto.institutions_app.model.UniversityParsedItem
import kotlinx.android.synthetic.main.activity_list_universities.*


class UniversitiesListActivity : AppCompatActivity(), UniversityAdapter.OnUniversityListener {
//    lateinit var viewModel: UniversityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_universities)

        val intent = intent
        val list: ArrayList<UniversityParsed> = intent.getSerializableExtra("list") as ArrayList<UniversityParsed>

        val list1 = list.toArray()
        val list2: Array<UniversityParsedItem>
        val arrayParseado = ArrayList<UniversityParsedItem>()

        val listaFinal: List<UniversityParsedItem>
        val arrayFinal: Array<UniversityParsedItem>

        listaFinal = arrayParseado.toList()
//        arrayFinal = arrayParseado.toArray() as Array<UniversityParsedItem>

        for (i in list1) {
            arrayParseado.add(i as UniversityParsedItem)
            Log.e("MORGAN FREEMAN", i.name.toString())
        }

//        for (e in listaFinal) {
//            Log.e("DENZEL WASHINGTON", e.name.toString())
//        }

        recyclerView.adapter = UniversityAdapter(arrayParseado, this, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    override fun onUniversityClick(position: Int) {
//        val universityItem = list[position]
//        val uri = Uri.parse(universityItem.web_pages!![0])
//        val intent = Intent(Intent.ACTION_VIEW, uri)
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivity(intent)
//        }
    }
}