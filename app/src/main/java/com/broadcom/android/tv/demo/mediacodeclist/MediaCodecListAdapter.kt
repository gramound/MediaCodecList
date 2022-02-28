package com.broadcom.android.tv.demo.mediacodeclist

import android.media.MediaCodecInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.broadcom.android.tv.demo.mediacodeclist.databinding.FragmentCodecBinding

class MediaCodecListAdapter(private val mValues: Array<MediaCodecInfo>) :
    RecyclerView.Adapter<MediaCodecListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentCodecBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemNumber.text = position.toString()
        holder.binding.content.text = mValues[position].name
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val binding: FragmentCodecBinding) :
        RecyclerView.ViewHolder(binding.root)
}