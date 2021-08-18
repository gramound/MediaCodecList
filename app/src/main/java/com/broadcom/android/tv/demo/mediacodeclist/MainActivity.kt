package com.broadcom.android.tv.demo.mediacodeclist

import android.media.MediaCodecInfo
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import android.media.MediaCodecList

import android.util.Log

class MainActivity : FragmentActivity(), MediaCodecListFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: MediaCodecInfo?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for ((i, mediaCodecInfo) in MediaCodecList(MediaCodecList.ALL_CODECS).codecInfos.withIndex()) {
            Log.d(TAG, "$i - ${mediaCodecInfo.name}")
        }
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, MediaCodecListFragment())
            .commit()
    }

    companion object {
        const val TAG = "MCL"
    }
}
