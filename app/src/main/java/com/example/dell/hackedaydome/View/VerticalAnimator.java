package com.example.dell.hackedaydome.View;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by dell on 2016/10/29.
 */

public class VerticalAnimator {

    private int functionViewHeight = 0;
    private View animatorView;
    private Context context;
    private boolean isAnimatorviewShow;

    public VerticalAnimator( View animatorview, Context context) {
        this.animatorView = animatorview;
        this.context = context;
    }

    public void upView() {
        initUpViewHeight();

        if(isAnimatorviewShow) {
            isAnimatorviewShow = false;

            ObjectAnimator animator = ObjectAnimator.ofFloat(animatorView, "translationY", functionViewHeight,0 ).setDuration(600);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setStartDelay(150);
            animator.start();
        }
    }

    public void downView() {
        initUpViewHeight();

        if(!isAnimatorviewShow) {
            isAnimatorviewShow = true;

            ObjectAnimator animator = ObjectAnimator.ofFloat(animatorView, "translationY", 0, functionViewHeight ).setDuration(600);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setStartDelay(150);
            animator.start();
        }
    }

    private void initUpViewHeight() {
        if(functionViewHeight == 0) {
            functionViewHeight = animatorView.getHeight();
        }
    }

}
