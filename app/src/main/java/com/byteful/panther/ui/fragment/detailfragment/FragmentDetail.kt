package com.byteful.panther.ui.fragment.detailfragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.byteful.panther.ProjectApplication
import com.byteful.panther.R
import com.byteful.panther.api.pojo.response.playlistdetail.DetailResponse
import com.byteful.panther.databinding.LayoutFragmentDetailBinding
import com.byteful.panther.databinding.LayoutHomeFragmentBinding
import com.byteful.panther.ui.activities.mainactivity.MainActivity
import com.byteful.panther.ui.activities.mainactivity.MainActivityFactory
import com.byteful.panther.ui.activities.mainactivity.MainActivityViewModel
import com.byteful.panther.ui.adapter.CategoriesAdapter
import com.byteful.panther.ui.adapter.TrackListAdapter
import com.byteful.panther.ui.fragment.BaseFragment
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.panthar_header_layout.view.*


class FragmentDetail : BaseFragment<LayoutFragmentDetailBinding>(){



    lateinit var mMainActivityViewModel: MainActivityViewModel
    lateinit var mTrackListAdapter: TrackListAdapter


    @Inject
    lateinit var mainActivityFactory: MainActivityFactory

    override fun getLayoutId(): Int {
        return R.layout.layout_fragment_detail
    }


    override fun showed(){
        ProjectApplication().appComponent.inject(this)
        mMainActivityViewModel= ViewModelProviders.of(activity as MainActivity, mainActivityFactory)[MainActivityViewModel::class.java]
        setContent()
    }

    fun setContent(){
        mMainActivityViewModel.trackList.let {
            mTrackListAdapter=TrackListAdapter(it,context!!)
            viewDataBinding.playlistRecyclerView.layoutManager=LinearLayoutManager(context)
            viewDataBinding.playlistRecyclerView.adapter=mTrackListAdapter
        }
        mMainActivityViewModel.playlistDetailResponse.value?.description?.let {
            viewDataBinding.collapsing.descriptionTV.text=it
        }
        mMainActivityViewModel.playlistDetailResponse.value?.name_display?.let {
            viewDataBinding.collapsing.titleTV.text=it
        }

        mMainActivityViewModel.playlistDetailResponse.value?.cover_image_url?.let {
            Glide.with(context!!).load(it).into(viewDataBinding.collapsing.backgroundIV);
        }

    }

}