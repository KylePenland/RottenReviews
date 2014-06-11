package com.Nemesis.rottenreviews;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
	
	TextView text1,text2,text3;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_b, container , false);

	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	
	}
	/*
	 * 
	 * this method changes the textviews on fragmentb layout
	 */
	public void changeText(MovieDetail selection){
		MovieDetail select = selection;

		text1 = (TextView) getActivity().findViewById(R.id.textView1);
		text2 = (TextView) getActivity().findViewById(R.id.textView2);
		text3 = (TextView) getActivity().findViewById(R.id.textView3);

		text1.setText(select.getTitle());
		text2.setText(select.getRating());
		text3.setText(select.getSynopsis());
		
	}
}
