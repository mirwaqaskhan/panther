package com.byteful.panther.ui.activities.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.byteful.panther.R
import com.byteful.panther.databinding.SplashActivityBinding
import com.byteful.panther.ui.bases.BaseActivity
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.os.CountDownTimer
import com.byteful.panther.ui.activities.mainactivity.MainActivity


class SplashActivity:BaseActivity<SplashActivityBinding>(){

    override fun init(savedInstanceState: Bundle?) {


        object : CountDownTimer(5000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                MainActivity.startMainActivity(this@SplashActivity)
            }
        }.start()

    }

    override fun setLayout(): Int {
        return R.layout.splash_activity
    }

}