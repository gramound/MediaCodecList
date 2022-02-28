package com.broadcom.android.tv.demo.mediacodeclist

import android.media.MediaCodecList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.broadcom.android.tv.demo.mediacodeclist.databinding.FragmentCodecListBinding

class MediaCodecListFragment : Fragment() {
    private var columnCount = 4
    private var _binding: FragmentCodecListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCodecListBinding.inflate(inflater, container, false)
        val view = binding.root
        with(view) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = MediaCodecListAdapter(MediaCodecList(MediaCodecList.ALL_CODECS).codecInfos)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"
    }
}
