package com.karafs.related.utils.ba

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.karafs.related.base.BaseAdapter


@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun <T> RecyclerView.setRecyclerViewData(data: MutableList<T>?) {
    if (adapter is BaseAdapter<*>) {
        (adapter as BaseAdapter<T>).submitList(data)
    }
}
