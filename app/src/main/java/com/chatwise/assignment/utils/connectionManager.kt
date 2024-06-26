package com.chatwise.assignment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class connectionManager {

    fun checkConectivity(context:Context):Boolean{
        var connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetwork:NetworkInfo? = connectivityManager.activeNetworkInfo

        if(activeNetwork?.isConnected != null){
            return activeNetwork.isConnected
        }else{
            return false
        }

    }
}