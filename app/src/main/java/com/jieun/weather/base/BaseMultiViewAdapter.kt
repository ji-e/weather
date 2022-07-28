package com.jieun.weather.base

import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class BaseMultiViewAdapter<ITEM : Any>(
    private val viewHolderMapper: (ITEM) -> Int,
    private val viewHolderType: MutableList<Pair<Int, Int>>,
    private val viewModel: ViewModel,
    diffUtil: DiffUtil.ItemCallback<ITEM>
) : ListAdapter<ITEM, BaseViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val viewHolderType = viewHolderType[viewType]
        return BaseViewHolder(
            parent = parent,
            layoutResourceId = viewHolderType.first,
            bindingItemId = viewHolderType.second,
            viewModel = viewModel
        )
    }

    override fun getItemViewType(position: Int): Int = viewHolderMapper(getItem(position))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        holder.bind(getItem(position))
}
