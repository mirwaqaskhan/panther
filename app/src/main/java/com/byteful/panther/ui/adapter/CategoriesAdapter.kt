package com.byteful.panther.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.byteful.panther.R
import com.byteful.panther.api.pojo.request.PlaylistsItem
import kotlinx.android.synthetic.main.catogery_item.view.*

class CategoriesAdapter(val list:List<PlaylistsItem>,val context:Context):RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.catogery_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.setValue(list[position])
    }


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val previewImage=itemView.coverImageIV
        val title=itemView.titleTV

        fun setValue(playlistsItem: PlaylistsItem){
            Glide.with(context).load(playlistsItem.coverImagePreviewUrl).into(previewImage);
            title.text=playlistsItem.nameDisplay
        }

    }

}