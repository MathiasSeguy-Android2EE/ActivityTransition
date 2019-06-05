package com.android2ee.formation.animation.activitytransition;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to show how to animate activity translation
 *        You use the support-v4 library contained in extra/android/v7
 *        And don't forget to add the jar as exported jar in the buildPath
 *         It seems to work only with tween Animation. Can not use ObjectAnimator|ValueAnimator
 */
public class MainActivity extends Activity {

	Button btnSliding;
	Button btnScaling;
	Button btnOthers;
	ImageView imvSmiley;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSliding = (Button) findViewById(R.id.btn_sliding);
		btnSliding.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				launchSlidingAnimation();
			}
		});
		btnScaling = (Button) findViewById(R.id.btn_scaling);
		btnScaling.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				launchScalingAnimation();
			}
		});
		btnOthers = (Button) findViewById(R.id.btn_specific);
		btnOthers.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				launchDrawableAnimation();
			}
		});
		imvSmiley= (ImageView) findViewById(R.id.imv_specific);
		imvSmiley.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				launchDrawableAnimation();
			}
		});
	}

	private void launchSlidingAnimation() {
		// Define the Intent
		Intent slidingActivity = new Intent(this, SlidingActivity.class);
		// Define the animation within a Bundle
		Bundle translationBundle = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.anim_push_left_in_a2ee,
				R.anim.anim_push_left_out_a2ee).toBundle();
		// And Launch with the bundle
		// Only possible for level 16
		// Need to use the support lib v4, else the native classes are created postJB (>=level 16)
		// You expect the animation is done on preJellyBean but in fact it's not :)
		ActivityCompat.startActivity(this, slidingActivity, translationBundle);
		// The support library do this for you, and only this:
//		if (getResources().getBoolean(R.bool.postJB)) {
//			Bundle translationBundle = ActivityOptions.makeCustomAnimation(this, R.anim.anim_push_left_in_a2ee,
//					R.anim.anim_push_left_out_a2ee).toBundle();
//			startActivity(slidingActivity, translationBundle);
//		} else {
//			startActivity(slidingActivity);
//		}

		// but if you do only that when you press back within SlidingActivity there is no animation
		// you have to define the exit animation of SlidingActivity within Sliding Activity
	}
	
	private void launchScalingAnimation() {
		// Define the Intent
		Intent slidingActivity = new Intent(this, SlidingActivity.class);
		// Define the animation within a Bundle
		
		View activityView=getWindow().getDecorView();
		//But cannot manage animation speed (too fast from my point of view)
		//You also don't define the reverse animation
		//makeScaleUpAnimation(source, startX, startY, startWidth, startHeight) start are relative to the source
		Bundle translationBundle = ActivityOptionsCompat.makeScaleUpAnimation(btnScaling,0,0,btnScaling.getWidth(),btnScaling.getHeight() ).toBundle();
		// And Launch with the bundle
		// Only possible for level 16
		// Need to use the support lib v4, else the native classes are created postJB (>=level 16)
		// You expect the animation is done on preJellyBean but in fact it's not :)
		ActivityCompat.startActivity(this, slidingActivity, translationBundle);
		// The support library do this for you, and only this:
		// if (getResources().getBoolean(R.bool.postJB)) {
		// startActivity(slidingActivity, translationBundle);
		// } else {
		// startActivity(slidingActivity);
		// }

		// but if you do only that when you press back within SlidingActivity there is no animation
		// you have to define the exit animation of SlidingActivity within Sliding Activity
	}
	
	private void launchDrawableAnimation() {
		// Define the Intent
		Intent slidingActivity = new Intent(this, ThumbActivity.class);
		// Define the animation within a Bundle
		//makeScaleUpAnimation(source, startX, startY, startWidth, startHeight)
		View activityView=getWindow().getDecorView();
		BitmapDrawable drawable=(BitmapDrawable) imvSmiley.getDrawable();
		Bitmap bitmap=drawable.getBitmap();
		//But cannot manage animation speed (too fast from my point of view)
		//You also don't 
		//makeThumbnailScaleUpAnimation(View source,Bitmap thumbnail,int startX,int startY)
		Bundle translationBundle = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(imvSmiley,bitmap,0,0).toBundle();
		// And Launch with the bundle
		// Only possible for level 16
		// Need to use the support lib v4, else the native classes are created postJB (>=level 16)
		// You expect the animation is done on preJellyBean but in fact it's not :)
		ActivityCompat.startActivity(this, slidingActivity, translationBundle);
		// The support library do this for you, and only this:
		// if (getResources().getBoolean(R.bool.postJB)) {
		// startActivity(slidingActivity, translationBundle);
		// } else {
		// startActivity(slidingActivity);
		// }

		// but if you do only that when you press back within SlidingActivity there is no animation
		// you have to define the exit animation of SlidingActivity within Sliding Activity
	}
}
