package com.byteful.panther.ui.activities.mainactivity

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.byteful.panther.ProjectApplication
import com.byteful.panther.R
import com.byteful.panther.databinding.MainActivityBinding
import com.byteful.panther.eventhandler.MainActivityEventHandlers
import com.byteful.panther.ui.bases.BaseActivity
import javax.inject.Inject
import android.arch.lifecycle.Observer
import android.support.v7.widget.GridLayoutManager
import com.byteful.panther.api.pojo.request.PlaylistResponse
import com.byteful.panther.ui.adapter.CategoriesAdapter

class MainActivity:BaseActivity<MainActivityBinding>(),MainActivityEventHandlers{

    /*
   Variable Declaration
   */

    @Inject
    lateinit var mainActivityFactory:MainActivityFactory

    lateinit var mMainActivityViewModel: MainActivityViewModel

    lateinit var mCategoriesAdapter: CategoriesAdapter

    override fun init(savedInstanceState: Bundle?) {
        (application as ProjectApplication).createMainActivityComponent().inject(this)
        mMainActivityViewModel= ViewModelProviders.of(this,mainActivityFactory)[MainActivityViewModel::class.java]
        subscribeLiveEvents()
    }


    fun subscribeLiveEvents(){

        var isDataLoading=object: Observer<Boolean> {
            override fun onChanged(t: Boolean?) {
                t?.let {
                    if(t) {
                        showLoading()
                    }
                    else {
                        hideLoading()
                    }

                }
            }

        }

        var playlistResponse=object: Observer<PlaylistResponse>{
            override fun onChanged(t: PlaylistResponse?) {
                t?.playlists?.let {
                    mCategoriesAdapter=CategoriesAdapter(it,this@MainActivity)
                    viewDataBinding.playlistRecyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
                    viewDataBinding.playlistRecyclerView.adapter=mCategoriesAdapter
                }
            }

        }

        mMainActivityViewModel.getLoading().observe(this,isDataLoading)
        mMainActivityViewModel.getPlayListResponse().observe(this,playlistResponse)

    }

    override fun setLayout(): Int {
        return R.layout.main_activity
    }
}