package com.xw.samlpe.bubbleseekbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xw.repo.BubbleSeekBar;

import java.util.Random;

/**
 * DemoFragment1
 * <p>
 * Created by woxingxiao on 2017-03-11.
 */

public class DemoFragment1 extends Fragment {

    public static DemoFragment1 newInstance() {
        return new DemoFragment1();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_demo_1, container, false);

        final BubbleSeekBar bubbleSeekBar = view.findViewById(R.id.demo_1_seek_bar);
        bubbleSeekBar.setProgress(20);
        bubbleSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        Button button = view.findViewById(R.id.demo_1_button);
        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                int mockAccuracy = new Random().nextInt(100);
                bubbleSeekBar.setProgress(mockAccuracy);
                /*if (mockAccuracy <= 50) {
                    seekbar.progressDrawable =
                            ContextCompat.getDrawable(requireContext(), R.drawable.seekbar_bg_accuracy_poor)
                } else if (mockAccuracy > 50) {
                    seekbar.progressDrawable =
                            ContextCompat.getDrawable(requireContext(), R.drawable.seekbar_bg_accuracy_good)
                }*/
            }

            @Override
            public void onFinish() {

            }
        };

        countDownTimer.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = new Random().nextInt((int) bubbleSeekBar.getMax());
                bubbleSeekBar.setProgress(progress);
                Snackbar.make(v, "set random progress = " + progress, Snackbar.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
