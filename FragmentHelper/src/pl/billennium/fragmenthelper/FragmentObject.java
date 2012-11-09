package pl.billennium.fragmenthelper;

import android.os.Bundle;

public class FragmentObject {
	private String title;
	private BaseFragment fragment;
	
	
	public FragmentObject(BaseFragment fragment, String title, Bundle bundle){
		setTitle(title);
		fragment.setArguments(bundle);
		setFragment(fragment);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BaseFragment getFragment() {
		return fragment;
	}
	public void setFragment(BaseFragment fragment) {
		this.fragment = fragment;
	}
}
