package pl.billennium.fragmenthelper;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class FragmentAdapter extends FragmentPagerAdapter {

	protected ArrayList<FragmentObject> fragments = new ArrayList<FragmentObject>();

	// protected int startIndex;
	// protected boolean shouldReload=false;

	public FragmentAdapter(FragmentManager fm,
			ArrayList<FragmentObject> fragments, int startIndex) {
		super(fm);
		this.fragments = fragments;
		// this.startIndex=startIndex;
		// this.shouldReload=true;
	}

	@Override
	public Fragment getItem(int i) {

		FragmentObject fragmentObject = fragments.get(i);
		// if(fragmentObject.getFragment()!=null){
		//
		// if(startIndex==i) shouldReload=true;
		//
		// fragmentObject.getFragment().shouldReload=shouldReload;
		//
		// }
		// shouldReload=false;
		return fragmentObject.getFragment();
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public int getItemPosition(Object object) {
		return FragmentPagerAdapter.POSITION_NONE;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		FragmentObject fo = fragments.get(position);
		if (fo != null) {
			return fo.getTitle();
		}
		return "";
	}

	public void OnPageChanged(int index) {
		Fragment fragment = fragments.get(index).getFragment();
		IFragmentHelper f = (IFragmentHelper) fragment;
		if (f != null) {
			f.OnPageActive();
		}
	}

	public void addFragment(FragmentObject newFragment) {
		fragments.add(newFragment);
		this.notifyDataSetChanged();
	}

	public void removeFragment(int fragmentIndex) {
		fragments.remove(fragmentIndex);
		this.notifyDataSetChanged();
	}

	@Override
	public void destroyItem(View collection, int position, Object view) {
		((ViewPager) collection).removeView((View) view);
	}

}
