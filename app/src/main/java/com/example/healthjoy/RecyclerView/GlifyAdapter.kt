package com.example.healthjoy.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.healthjoy.Model.GliphyResponseModel
import com.example.healthjoy.R
import com.example.healthjoy.databinding.RecyclerViewItemBinding

class GlifyAdapter(private val context: Context) : ListAdapter<GliphyResponseModel.GliphyData, GlifyAdapter.ViewHolder>(GlifyAdapterDiffCallback()) {

    private lateinit var binding: RecyclerViewItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = RecyclerViewItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currGlify = getItem(position)
        holder.setupUI(currGlify)
    }


    inner class ViewHolder(private val itemViewBinding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(itemViewBinding.root) {

        fun setupUI(gliphyModel: GliphyResponseModel.GliphyData){
            if (gliphyModel.username.isEmpty())
                itemViewBinding.userNameTV.text = "No Username"
            else
                itemViewBinding.userNameTV.text = gliphyModel.username

            if (gliphyModel.user.description.isEmpty())
                itemViewBinding.descriptionTV.text = "No Description"
            else
                itemViewBinding.descriptionTV.text = gliphyModel.user.description

            Glide.with(context)
                .load(gliphyModel.user.avatarUrl)
                .placeholder(R.drawable.ic_baseline_person_24)
                .skipMemoryCache(false)
                .into(itemViewBinding.avatarIV)
            Glide.with(context)
                .load(gliphyModel.images.original.url)
                .skipMemoryCache(false)
                .into(itemViewBinding.mainIV)
        }
    }
}

class GlifyAdapterDiffCallback : DiffUtil.ItemCallback<GliphyResponseModel.GliphyData>() {
    override fun areItemsTheSame(oldItem: GliphyResponseModel.GliphyData, newItem: GliphyResponseModel.GliphyData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GliphyResponseModel.GliphyData, newItem: GliphyResponseModel.GliphyData): Boolean {
        return oldItem.images.original == newItem.images.original
    }

}
