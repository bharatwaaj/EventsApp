package com.oolatina.android.eventsapp.Others;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Bharatwaaj on 20-05-2016.
 */
public class AnimationUtils {
    public static void recyclerViewAnimation(RecyclerView.ViewHolder holder){
        ObjectAnimator imageViewObjectAnimator1 = ObjectAnimator.ofFloat(holder.itemView,"TranslationX",200,0);
        imageViewObjectAnimator1.setDuration(300);
        imageViewObjectAnimator1.start();
    }
}