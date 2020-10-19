package br.usjt.ads20.atividaded1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlinx.android.synthetic.main.university_view.view.*

class UniversityAdapter(private val universities: List<University>, private val context: Context, private val listener: (University) -> Unit) : Adapter<UniversityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.university_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = universities[position]
        holder.bindView(university)
        holder.itemView.setOnClickListener { listener(university) }
    }

    override fun getItemCount(): Int {
        return universities.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(university: University) {
            val image = itemView.image
            val name = itemView.name
            val country = itemView.country
            val url = itemView.url

            image.setImageBitmap(Util.drawLogo(context, university.alphaTwoCode))
            name.text = university.name
            country.text = university.country
            url.text = university.webPages
        }
    }
}