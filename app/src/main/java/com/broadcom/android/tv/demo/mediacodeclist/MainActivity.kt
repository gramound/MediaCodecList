package com.broadcom.android.tv.demo.mediacodeclist

import android.media.MediaCodecInfo
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), MediaCodecListFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: MediaCodecInfo?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, MediaCodecListFragment())
            .commit()
    }
}
