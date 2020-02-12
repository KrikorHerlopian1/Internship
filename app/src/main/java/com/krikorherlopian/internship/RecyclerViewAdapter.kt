package com.krikorherlopian.internship

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.krikorherlopian.internship.model.Results
import com.krikorherlopian.internship.model.RowDetailsItem
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerViewAdapter(
    private val list: MutableList<Any>,
    var context: Context,
    var listListener: ListListener?
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val MAIN_VIEW = 0
    private val DETAIL_VIEW = 1
    var lastPosition = -1
    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        try {
            holder.itemView.clearAnimation()
        } catch (e: Exception) {
            Log.d("Recycler View Adapter", "Exception")
        }
        holder.itemView.clearAnimation()
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun add(position: Int, result: Results) {
        list.add(position, result)
        notifyItemRangeInserted(0, 1)
        notifyItemRangeChanged(0, list.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animation = AnimationUtils.loadAnimation(
            context,
            if (position > lastPosition)
                R.anim.up_from_bottom
            else
                R.anim.down_from_top
        )
        holder.itemView.startAnimation(animation)
        lastPosition = position
        when (holder.itemViewType) {
            MAIN_VIEW -> configureViewHolder(holder, position)
            DETAIL_VIEW -> configureViewHolderDetail(holder, position)
        }
    }


    private fun configureViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder && list.get(position) is Results) {
            var result = list.get(position) as Results
            holder.bind(result)
            var sqlLogoUrl: String = ""
            when (result.type) {
                "REVIEW_RESULT" -> sqlLogoUrl = result.review.sqLogoUrl
                "INTERVIEW_RESULT" -> sqlLogoUrl = result.interview.sqLogoUrl
                "SALARY_RESULT" -> sqlLogoUrl = result.salary.sqLogoUrl
            }
            Glide.with(context).load(sqlLogoUrl)
                .into(
                    (holder as MyViewHolder).itemView.thumbnail
                )
            holder.itemView.setOnClickListener {
                listListener?.rowClicked(position)
            }
        }
    }

    private fun configureViewHolderDetail(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder && list.get(position) is RowDetailsItem) {
            var rowDetailsItem = list.get(position) as RowDetailsItem
            holder.itemView.title.setText(rowDetailsItem.title)
            holder.itemView.subtitle.setText(rowDetailsItem.subtitle)
            Glide.with(context).load(rowDetailsItem.resId)
                .into(
                    (holder as MyViewHolder).itemView.thumbnail
                )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(parent.inflate(R.layout.item_layout))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if(list.get(position) is Results)
            return MAIN_VIEW;
        return DETAIL_VIEW;
    }


    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }
}
