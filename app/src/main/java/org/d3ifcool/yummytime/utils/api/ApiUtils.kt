package org.d3ifcool.yummytime.utils.api

import android.content.Context
import androidx.appcompat.app.AlertDialog

class ApiUtils {
    fun getAPI(): ApiService = ApiClient().retrofit().create(ApiService::class.java)

    fun showDialog(context: Context, title: String, message: String): AlertDialog {
        val dialog = AlertDialog.Builder(context).setTitle(title).setMessage(message).show()

        if (dialog.isShowing) dialog.cancel()
        return dialog
    }
}