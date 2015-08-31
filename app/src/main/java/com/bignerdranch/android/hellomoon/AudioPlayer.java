package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by nan.zhang on 8/7/15.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();  // destroy instance
            mPlayer = null;
        }
    }

    public void play(Context c) {
        stop();     // avoid multiple AudioPlayer instance

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp){
                stop();
            }
        });

        mPlayer.start();
    }

    public boolean isPlaying() {
        return mPlayer != null;
    }

//    public void pause() {
//        if (isPlaying()) {
//            mPlayer.pause();
//        }
//    }
//
//    public boolean isPlaying() {
//        return null == mPlayer ? false : mPlayer.isPlaying();
//    }
//
//    public boolean isPaused() {
//        return null == mPlayer ? false : !mPlayer.isPlaying();
//    }
}
