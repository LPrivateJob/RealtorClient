package com.realtor.jx.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.Gravity;

import com.realtor.jx.R;

/**
 * description: 获取验证码的倒计时View
 * autour: Tait
 * created at: 2018/1/12 17:12
 */
public class CountDownView extends android.support.v7.widget.AppCompatButton {
    private CountDownTimer timer;
    private static final int COUNTDOWN_TIMER = 60 * 1000;

    public CountDownView(Context context) {
        this(context, null, 0);
    }

    public CountDownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setGravity(Gravity.CENTER);
        setClickable(true);
        initTimer();
    }

    private void initTimer() {
        timer = new CountDownTimer(COUNTDOWN_TIMER, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                setText(String.format(getResources().getString(R.string
                        .code_cutdown), millisUntilFinished / 1000 + ""));
            }

            @Override
            public void onFinish() {
                setClickable(true);
                setText("重试");

            }
        };
    }

    public void startTimer() {
        if (timer != null) {
            setClickable(false);
            timer.start();
        }
    }

    public void startTimerVoice() {
        if (timer != null) {
            timer.start();
        }
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
