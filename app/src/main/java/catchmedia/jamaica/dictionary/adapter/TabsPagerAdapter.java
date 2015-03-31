package catchmedia.jamaica.dictionary.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import catchmedia.jamaica.dictionary.FragmentLesson;
import catchmedia.jamaica.dictionary.FragmentWord;
import catchmedia.jamaica.dictionary.MyPlaceFragment;

public class TabsPagerAdapter  extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:

            return new FragmentWord();
		case 1:
            return new FragmentLesson();
         case 2:
          return new MyPlaceFragment();

		}

		return null;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
