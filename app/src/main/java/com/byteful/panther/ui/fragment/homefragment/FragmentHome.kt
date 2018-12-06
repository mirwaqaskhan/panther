package com.byteful.panther.ui.fragment.homefragment

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.byteful.panther.ProjectApplication
import com.byteful.panther.R
import com.byteful.panther.api.pojo.response.PlaylistResponse
import com.byteful.panther.api.pojo.response.playlistdetail.DetailResponse
import com.byteful.panther.databinding.LayoutHomeFragmentBinding
import com.byteful.panther.ui.activities.mainactivity.MainActivity
import com.byteful.panther.ui.activities.mainactivity.MainActivityFactory
import com.byteful.panther.ui.activities.mainactivity.MainActivityViewModel
import com.byteful.panther.ui.adapter.CategoriesAdapter
import com.byteful.panther.ui.bases.BaseActivity
import com.byteful.panther.ui.fragment.BaseFragment
import com.byteful.panther.ui.fragment.detailfragment.FragmentDetail
import javax.inject.Inject

class FragmentHome :BaseFragment<LayoutHomeFragmentBinding>(), CategoriesAdapter.onItemClickListener{



    lateinit var mMainActivityViewModel: MainActivityViewModel
    lateinit var mCategoriesAdapter: CategoriesAdapter


    @Inject
    lateinit var mainActivityFactory:MainActivityFactory

    override fun getLayoutId(): Int {
        return R.layout.layout_home_fragment
    }


    override fun showed(){
        ProjectApplication().appComponent.inject(this)
        mMainActivityViewModel= ViewModelProviders.of(activity as MainActivity, mainActivityFactory)[MainActivityViewModel::class.java]
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

        var playlistResponse=object: Observer<PlaylistResponse> {
            override fun onChanged(t: PlaylistResponse?) {
                t?.playlists?.let {
                    mCategoriesAdapter= CategoriesAdapter(it,context!!,this@FragmentHome)
                    viewDataBinding.playlistRecyclerView.layoutManager= GridLayoutManager(context,2)
                    viewDataBinding.playlistRecyclerView.adapter=mCategoriesAdapter
                }
            }

        }

        var playlistDetailResponse=object : Observer<DetailResponse>{
            override fun onChanged(t: DetailResponse?) {
               t?.track_list?.let {
                   replaceFragment()
               }
            }

        }

        mMainActivityViewModel.getOfferDetailListResponse().observe(this,playlistDetailResponse)
        mMainActivityViewModel.getLoading().observe(this,isDataLoading)
        mMainActivityViewModel.getPlayListResponse().observe(this,playlistResponse)

    }

    override fun onItemClick(url: String) {
       mMainActivityViewModel.callDetailResponseApi(url)

    }

    fun replaceFragment(){
        val newFragment = FragmentDetail()

        fragmentManager?.let {
            val transaction =  it.beginTransaction()
            transaction.replace(R.id.fragment_container, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }


}