package br.com.fausto.institutions_app.model

import java.io.Serializable

class UniversityParsedItem(
        var alpha_two_code: String?,
        var country: String?,
        var domains: List<String>?,
        var name: String?,
        var state_province: Any?,
        var web_pages: List<String>?
) : Serializable