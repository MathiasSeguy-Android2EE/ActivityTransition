package com.android2ee.formation.animation.activitytransition;

import android.app.Activity;
import android.os.Bundle;

public class SlidingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sliding);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#finish()
	 */
	@Override
	public void finish() {		
		super.finish();
		//this work for all version superior to level 5
		overridePendingTransition(R.anim.anim_push_right_in_a2ee, R.anim.anim_push_right_out_a2ee);
	}
	
	
}
