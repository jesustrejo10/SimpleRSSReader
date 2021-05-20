package com.jesustrejo10.simplerssreader.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(@LayoutRes layoutId: Int, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    ) {
    abstract fun bind(item: T, listener: BaseItemAdapterListener<T>? = null)
}