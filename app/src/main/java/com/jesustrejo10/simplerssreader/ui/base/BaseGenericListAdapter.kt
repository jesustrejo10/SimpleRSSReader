package com.jesustrejo10.simplerssreader.ui.base

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView

abstract class BaseGenericListAdapter<T, VH : BaseViewHolder<T>>(
    @Nullable var listener: BaseItemAdapterListener<T>? = null,
    @NonNull var items: List<T> = listOf()
) : RecyclerView.Adapter<VH>() {

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item: T? = items[position]
        item?.let {
            holder.bind(it, listener)
        }
    }

    override fun getItemCount(): Int = items.size
}