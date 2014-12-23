package catchmedia.jamaica.dictionary.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import catchmedia.jamaica.dictionary.FragmentCulture;
import catchmedia.jamaica.dictionary.FragmentLesson;
import catchmedia.jamaica.dictionary.FragmentWord;

public class TabsPagerAdapter  extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new FragmentLesson();
		case 1:
			// Games fragment activity
			return new FragmentWord();
		case 2:
			// Movies fragment activity
			return new FragmentCulture();
		}

		return null;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
