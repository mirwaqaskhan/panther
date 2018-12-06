package com.byteful.panther.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.byteful.panther.R
import com.byteful.panther.api.pojo.response.PlaylistsItem
import com.byteful.panther.api.pojo.response.playlistdetail.TrackListItem
import kotlinx.android.synthetic.main.catogery_item.view.*
import kotlinx.android.synthetic.main.panthar_header_layout.view.*
import kotlinx.android.synthetic.main.track_item.view.*


class TrackListAdapter(val list:List<TrackListItem>, val context: Context): RecyclerView.Adapter<TrackListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.track_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setValue(list[position])

    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val trackIcon:ImageView=itemView.trackImageIV
        val titleTime:TextView=itemView.titleTime
        val songTitleTV:TextView=itemView.songTitleTV
        val isExplictTV:TextView=itemView.isExplictTV
        val artistTV:TextView=itemView.artistTV
        init {

        }

        fun setValue(playlistsItem: TrackListItem){
            Glide.with(context!!).load(playlistsItem.cover_image_url).into(trackIcon);
            songTitleTV.text=playlistsItem.title
            if(playlistsItem.is_explicit){
                isExplictTV.visibility=View.INVISIBLE
            }
            artistTV.text=playlistsItem.artist

        }

    }


}