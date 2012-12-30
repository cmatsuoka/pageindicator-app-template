package org.helllabs.android.example.pageindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;


public class MainActivity extends SherlockFragmentActivity {

	private static final String[] titles = new String[] { "Fragment 1", "Fragment 2", "Fragment 3", "Fragment 4" };
	private static final Class<?>[] fragments = new Class[] {
		FirstFragment.class, SecondFragment.class, SecondFragment.class, SecondFragment.class
	}; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// Set the pager with an adapter
		ViewPager pager = (ViewPager)findViewById(R.id.pager);
		pager.setAdapter(new TestAdapter(getSupportFragmentManager()));

		// Bind the title indicator to the adapter
		PageIndicator indicator = (TabPageIndicator)findViewById(R.id.titles);
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
			return new FirstFragment();
			/*Fragment fragment = null;
			try {
				//fragment = (Fragment)fragments[position].newInstance();
				fragment = new SecondFragment();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fragment;*/    
		}

		@Override
		public int getCount() {
			return count;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}
	}
}
