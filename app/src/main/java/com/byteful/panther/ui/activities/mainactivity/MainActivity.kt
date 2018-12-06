package com.byteful.panther.ui.activities.mainactivity

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.byteful.panther.ProjectApplication
import com.byteful.panther.R
import com.byteful.panther.databinding.MainActivityBinding
import com.byteful.panther.eventhandler.MainActivityEventHandlers
import com.byteful.panther.ui.bases.BaseActivity
import javax.inject.Inject
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import com.byteful.panther.api.pojo.response.PlaylistResponse
import com.byteful.panther.ui.adapter.CategoriesAdapter
import com.byteful.panther.ui.fragment.homefragment.FragmentHome

class MainActivity:BaseActivity<MainActivityBinding>(),MainActivityEventHandlers{

    /*
   Variable Declaration
   */

    @Inject
    lateinit var mainActivityFactory:MainActivityFactory

    lateinit var mMainActivityViewModel: MainActivityViewModel



    override fun init(savedInstanceState: Bundle?) {
        ProjectApplication().appComponent.inject(this)
        mMainActivityViewModel= ViewModelProviders.of(this,mainActivityFactory)[MainActivityViewModel::class.java]

        setFirstFragment()
    }
    override fun setLayout(): Int {
        return R.layout.main_activity
    }

    fun setFirstFragment(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = FragmentHome()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }




    companion object {
          fun startMainActivity(activity:Activity){
              val intent= Intent(activity,MainActivity::class.java)
              activity.startActivity(intent)
          }
    }
}