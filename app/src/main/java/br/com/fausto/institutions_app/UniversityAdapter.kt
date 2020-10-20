package br.com.fausto.institutions_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import br.com.fausto.institutions_app.model.University
import kotlinx.android.synthetic.main.university_view.view.*

class UniversityAdapter(private val universities: List<University>, private val context: Context, private var listener: OnUniversityListener /*, private val listener: (University) -> Unit*/) : Adapter<UniversityAdapter.ViewHolder>() {

    private var universityListener: OnUniversityListener = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.university_view, parent, false)
        return ViewHolder(view, universityListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = universities[position]
//        holder.itemView.setOnClickListener { listener(university) }
        holder.bindView(university)
    }

    override fun getItemCount(): Int {
        return universities.size
    }

    inner class ViewHolder(itemView: View, listener: OnUniversityListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var universityListener = listener
        fun bindView(university: University) {
            val image = itemView.image
            val name = itemView.name
            val country = itemView.country
            val url = itemView.url

            image.setImageBitmap(Util.drawLogo(context, university.alphaTwoCode))
            image.setOnClickListener(this)
            name.text = university.name
            name.setOnClickListener(this)
            country.text = university.country
            country.setOnClickListener(this)
            url.text = university.webPages
            url.setOnClickListener(this)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            universityListener.onUniversityClick(adapterPosition)
        }
    }

    interface OnUniversityListener {
        fun onUniversityClick(position: Int)
    }

}