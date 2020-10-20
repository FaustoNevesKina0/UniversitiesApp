package br.com.fausto.institutions_app.model

import android.widget.ImageView
import java.io.Serializable

class University(var image: ImageView?, var name: String?, var country: String?, var alphaTwoCode: String?, var webPages: String?)
    : Serializable, Comparable<University> {
    override fun compareTo(other: University): Int {
        return name!!.compareTo(other.name!!)
    }
}