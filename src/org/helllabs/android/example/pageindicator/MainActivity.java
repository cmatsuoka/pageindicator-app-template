package org.helllabs.android.example.pageindicator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;


public class MainActivity extends SherlockFragmentActivity {

	private static final String[] titles = new String[] { "Fragment 1", "Fragment 2", "Fragment 3", "Fragment 4" };
	private static final Class<?>[] fragments = new Class[] {
		FirstFragment.class, SecondFragment.class, FirstFragment.class, SecondFragment.class
	}; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// Set the pager with an adapter
		ViewPager pager = (ViewPager)findViewById(R.id.pager);
		pager.setAdapter(new TestAdapter(getSupportFragmentManager()));

		// Bind the title indicator to the adapter
		PageIndicator indicator = (TitlePageIndicator)findViewById(R.id.titles);
		indicator.setViewPager(pager);
	}

	// Menu

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	// Viewpager

	class TestAdapter extends FragmentPagerAdapter {     
		private final int count = titles.length;

		public TestAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			try {
				fragment = (Fragment)fragments[position].newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fragment;    
		}

		@Override
		public int getCount() {
			return count;
		}

		@SuppressLint("DefaultLocale")
		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position].toUpperCase();
		}
	}
}
