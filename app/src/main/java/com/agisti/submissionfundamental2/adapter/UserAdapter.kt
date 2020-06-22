package com.agisti.submissionfundamental2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agisti.submissionfundamental2.R
import com.agisti.submissionfundamental2.model.UserItems
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user_items.view.*

class UserAdapter(private val mData: ArrayList<UserItems>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(items: ArrayList<UserItems>){
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): UserViewHolder {
        val mView = LayoutInflater.from(viewGroup.context).inflate(R.layout.user_items, viewGroup, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) {
        userViewHolder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userItems: UserItems) {
            with(itemView){
               Glide.with(context)
                   .load(userItems.avatar)
                   .into(img_avatar)
                txt_username.text = userItems.username

                itemView.setOnClickListener {onItemClickCallback?.onItemClicked(userItems)}
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(userItems: UserItems)
    }
}
