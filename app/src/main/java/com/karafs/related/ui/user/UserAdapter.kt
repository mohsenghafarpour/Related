package com.karafs.related.ui.user

import androidx.recyclerview.widget.DiffUtil
import com.karafs.related.R
import com.karafs.related.base.BaseAdapter
import com.karafs.related.data.User

class UserAdapter : BaseAdapter<User>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_user
    }
}