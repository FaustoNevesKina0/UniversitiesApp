package br.com.fausto.institutions_app.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities

object ConnectionChecker {
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network: Network? = connectivityManager.activeNetwork
        val capabilities = connectivityManager
                .getNetworkCapabilities(network)
        return (capabilities != null
                && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED))
    }
}