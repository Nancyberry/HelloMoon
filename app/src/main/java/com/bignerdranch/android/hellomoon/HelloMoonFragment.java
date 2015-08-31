package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
    private AudioPlayer mPlayer = new AudioPlayer();

    private Button mPlayButton;
    private Button mPauseButton;
    private Button mStopButton;

    void updateButtons() {
//        boolean isEnabled = !mPlayer.isPlaying();
//        mPlayButton.setEnabled(isEnabled);
        boolean isPaused = mPlayer.isPaused();
        if (isPaused) {
            mPlayButton.setEnabled(true);
            mPauseButton.setEnabled(false);
        }

        boolean isPlaying = mPlayer.isPlaying();
        if (isPlaying) {
            mPlayButton.setEnabled(false);
            mPauseButton.setEnabled(true);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPlayer.play(getActivity());
                updateButtons();
            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPlayer.pause();
                updateButtons();
            }
        });

        mStopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPlayer.stop();
                updateButtons();
            }
        });

        return v;
    }
}
