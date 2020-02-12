package com.krikorherlopian.internship

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krikorherlopian.internship.model.Results
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_layout.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    override val containerView: View?
        get() = itemView

    fun bind(item: Results) {
        itemView.title.text = item.source
        itemView.subtitle.text = item.type
    }
}