package com.broadcom.android.tv.demo.mediacodeclist

import android.media.MediaCodecList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
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
