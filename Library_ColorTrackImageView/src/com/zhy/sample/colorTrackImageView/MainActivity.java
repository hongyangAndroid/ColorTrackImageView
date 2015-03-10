package com.zhy.sample.colorTrackImageView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity
{
	private String[] mTitles = { "Simple Use", "ViewPagerUse" };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getListView().setAdapter(
				new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, mTitles));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{

		Intent intent = null;
		switch (position)
		{
		case 0:
			intent = new Intent(this, SimpleUseActivity.class);
			break;
		case 1:

			break;

		}

		if (intent != null)
			startActivity(intent);
	}

}
