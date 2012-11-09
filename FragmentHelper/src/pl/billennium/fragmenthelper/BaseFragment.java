package pl.billennium.fragmenthelper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements IFragmentHelper {
	
	public boolean shouldReload=false;
	public boolean isFirstRun=true;
	
	public BaseFragment(boolean shouldReload){
		this.shouldReload=shouldReload;
	}
	
	public abstract View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState);
	
	public void onActivityCreated (Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		System.out.println("onActivityCreated: " +String.valueOf(shouldReload));
		
		if(shouldReload)
		{
			OnPageActive();
			shouldReload=false;
		}
	}
	
	public void OnPageActive(){
		if(isFirstRun){
			OnFirtsShowFragment();
			isFirstRun=false;
		}		
			OnFragmentActive();
		
	}
	
	public void setShouldReloadData(boolean shouldReload){
		this.shouldReload=shouldReload;
	}
}
