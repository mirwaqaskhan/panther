package com.byteful.panther.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface


/**
 * Created by Shami on 5/6/2018.
 */
object DialogeUtils{

    fun showErrorDialog(context: Context, title: String, message: String) {
        AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                .create().show()
    }

}
