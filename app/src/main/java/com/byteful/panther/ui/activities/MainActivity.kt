package com.byteful.panther.ui.activities

import android.os.Bundle
import com.byteful.panther.R
import com.byteful.panther.databinding.MainActivityBinding
import com.byteful.panther.eventhandler.MainActivityEventHandlers
import com.byteful.panther.ui.bases.BaseActivity

class MainActivity:BaseActivity<MainActivityBinding>(),MainActivityEventHandlers{

    override fun init(savedInstanceState: Bundle?) {
    }

    override fun setLayout(): Int {
        return R.layout.main_activity
    }
}