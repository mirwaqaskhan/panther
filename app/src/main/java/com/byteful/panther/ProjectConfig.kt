package com.byteful.panther

import android.content.Context
import android.content.SharedPreferences



class ProjectConfig(val context: Context){

    private lateinit var mSharedPreferences: SharedPreferences
    private lateinit var mEditor: SharedPreferences.Editor
    private val NAME = "panther"

    init {
        mSharedPreferences=context.getSharedPreferences(NAME,Context.MODE_PRIVATE)
        mEditor=mSharedPreferences.edit()
        mEditor.apply()
    }

}