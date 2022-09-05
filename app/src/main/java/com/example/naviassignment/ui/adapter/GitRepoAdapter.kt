package com.example.naviassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.naviassignment.R
import com.example.naviassignment.data.GitResponse
import com.example.naviassignment.databinding.GitRepoAdapterViewBinding

class GitRepoAdapter : ListAdapter<GitResponse, GitRepoAdapter.ViewHolder>(DiffCallBack()) {
    private lateinit var viewBinding: GitRepoAdapterViewBinding

    inner class ViewHolder(private val viewBinding: GitRepoAdapterViewBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(holderData: GitResponse) {
            viewBinding.modelData = holderData
            viewBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        viewBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.git_repo_adapter_view, parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val holderData = getItem(holder.absoluteAdapterPosition)
        holder.bind(holderData)
    }

    class DiffCallBack : DiffUtil.ItemCallback<GitResponse>() {
        override fun areItemsTheSame(oldItem: GitResponse, newItem: GitResponse): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: GitResponse,
            newItem: GitResponse
        ): Boolean =
            oldItem.id == newItem.id
    }
}