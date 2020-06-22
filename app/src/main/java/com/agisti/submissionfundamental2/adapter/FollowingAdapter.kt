package com.agisti.submissionfundamental2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agisti.submissionfundamental2.R
import com.agisti.submissionfundamental2.model.FollowingItems
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.following_items.view.*


class FollowingAdapter(private val mDataFollowing: ArrayList<FollowingItems>): RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder>(){

    fun setData(itemsfollow: ArrayList<FollowingItems>){
        mDataFollowing.clear()
        mDataFollowing.addAll(itemsfollow)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): FollowingViewHolder {
        val mView = LayoutInflater.from(viewGroup.context).inflate(R.layout.following_items, viewGroup, false)
        return FollowingViewHolder(mView)
    }

    override fun getItemCount(): Int = mDataFollowing.size

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        holder.bind(mDataFollowing[position])
    }
    inner class FollowingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(followingItems: FollowingItems) {
            with(itemView){
                Glide.with(context)
                    .load(followingItems.avatar)
                    .into(img_avatar_following)
                txt_username_following.text = followingItems.username
            }
        }
    }
}