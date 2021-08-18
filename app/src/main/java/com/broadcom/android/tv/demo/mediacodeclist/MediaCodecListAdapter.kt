package com.broadcom.android.tv.demo.mediacodeclist

import android.media.MediaCodecInfo
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import com.broadcom.android.tv.demo.mediacodeclist.MediaCodecListFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_codec.view.*

class MediaCodecListAdapter(
    private val mValues: Array<MediaCodecInfo>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MediaCodecListAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener = View.OnClickListener { v ->
        val item = v.tag as MediaCodecInfo
        // Notify the active callbacks interface (the activity, if the fragment is attached to
        // one) that an item has been selected.
        mListener?.onListFragmentInteraction(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_codec, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = position.toString()
        holder.mContentView.text = item.name

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
