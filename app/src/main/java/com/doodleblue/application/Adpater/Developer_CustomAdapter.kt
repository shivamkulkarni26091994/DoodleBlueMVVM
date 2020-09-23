package com.doodleblue.application.Adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView


import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.doodleblue.application.R
import com.doodleblue.application.databinding.RowListItemBinding
import com.doodleblue.application.model.DeveloperModel
import com.doodleblue.application.ui.home.HomeFragment
import java.util.*

class Developer_CustomAdapter :
    RecyclerView.Adapter<Developer_CustomAdapter.DeveloperViewHolder>(){
    private var mDeveloperModel: ArrayList<DeveloperModel>? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): DeveloperViewHolder {
        val mDeveloperListItemBinding = DataBindingUtil.inflate<RowListItemBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.row_list_item, viewGroup, false
        )

        return DeveloperViewHolder(mDeveloperListItemBinding)
    }

    override fun onBindViewHolder(mDeveloperViewHolder: DeveloperViewHolder, i: Int) {
        val currentStudent = mDeveloperModel!![i]


        mDeveloperViewHolder.mDeveloperListItemBinding.developerModel = currentStudent


    }

    override fun getItemCount(): Int {
        return if (mDeveloperModel != null) {
            mDeveloperModel!!.size
        } else {
            0
        }
    }

    fun setDeveloperList(mDeveloperModel: ArrayList<DeveloperModel>) {
        this.mDeveloperModel = mDeveloperModel
        notifyDataSetChanged()
    }

    inner class DeveloperViewHolder(var mDeveloperListItemBinding: RowListItemBinding) :
        RecyclerView.ViewHolder(mDeveloperListItemBinding.root)

   }
