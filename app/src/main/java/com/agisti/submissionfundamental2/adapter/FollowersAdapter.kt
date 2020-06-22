package com.agisti.submissionfundamental2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agisti.submissionfundamental2.R
import com.agisti.submissionfundamental2.model.FollowersItems
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.followers_items.view.*
import kotlinx.android.synthetic.main.user_items.view.*
import kotlinx.android.synthetic.main.user_items.view.img_avatar
import kotlinx.android.synthetic.main.user_items.view.txt_username


class FollowersAdapter(private val mDataFollowers: ArrayList<FollowersItems>): RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder>(){

    fun setData(itemsfollow: ArrayList<FollowersItems>){
        mDataFollowers.clear()
        mDataFollowers.addAll(itemsfollow)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): FollowersViewHolder {
        val mView = LayoutInflater.from(viewGroup.context).inflate(R.layout.followers_items, viewGroup, false)
        return FollowersViewHolder(mView)
    }

    override fun getItemCount(): Int = mDataFollowers.size

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        holder.bind(mDataFollowers[position])
    }
    inner class FollowersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(followersItems: FollowersItems) {
            with(itemView){
                Glide.with(context)
                    .load(followersItems.avatar)
                    .into(img_avatar_followers)
                txt_username_followers.text = followersItems.username
            }
        }
    }
}
