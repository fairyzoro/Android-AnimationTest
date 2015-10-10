package com.example.bob_jiang.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Bob_JIANG on 10/8/2015.
 */

//We use view animation to perform tweened animation. All the animation elements can be defined in
// /res/anim. The big four classes are <alpha>, <scale>, <translate>, <rotate>, if you want animation
// happen at the same time, just include them in one set and use startoff attribute. Also note the
// use of pivotX/ pivotY (50%)

public class ViewAnimation extends Activity {
    private ImageView image = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_animations);
        image = (ImageView) findViewById(R.id.imageview1);
        Animation hyperspaceJump =
                AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        image.startAnimation(hyperspaceJump);
    }

}
