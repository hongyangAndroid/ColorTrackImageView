package com.zhy.sample.colorTrackImageView;

import java.util.Random;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.zhy.view.ColorTrackImageView;

public class SimpleUseActivity extends Activity
{
	private ColorTrackImageView mColorTrackImageView;

	private ObjectAnimator anim;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_use);

		mColorTrackImageView = (ColorTrackImageView) findViewById(R.id.id_colorview);
		mColorTrackImageView.post(new Runnable()
		{

			@Override
			public void run()
			{
				Log.e("TAG", mColorTrackImageView.getWidth() + "");

				anim = ObjectAnimator.ofFloat(mColorTrackImageView, "progress",
						0, 1);
				anim.setDuration(1000);
				// anim.setRepeatMode(ValueAnimator.REVERSE);
				anim.setRepeatCount(ValueAnimator.INFINITE);
				anim.addListener(new AnimatorListener()
				{

					@Override
					public void onAnimationStart(Animator animation)
					{
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationRepeat(Animator animation)
					{
						mColorTrackImageView.changeDirection();
						if (mColorTrackImageView.getDirection() == ColorTrackImageView.DIRECTION_LEFT)
						{
							mColorTrackImageView.setOriginColor(randomColor());
						} else
						{
							mColorTrackImageView.setChangeColor(randomColor());
						}
					}

					private int randomColor()
					{
						Random ran = new Random();
						return Color.argb(255, ran.nextInt(255),
								ran.nextInt(255), ran.nextInt(255));
					}

					@Override
					public void onAnimationEnd(Animator animation)
					{
						// TODO Auto-generated method stub

					}

					@Override
					public void onAnimationCancel(Animator animation)
					{
						// TODO Auto-generated method stub

					}
				});
				anim.start();
			}

		});

	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		anim.cancel();
	}
}
