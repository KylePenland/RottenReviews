package com.Nemesis.rottenreviews;

import android.app.Activity;
import android.os.Bundle;

public class SingleItem extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singlelistitem);
		
		Bundle inte = getIntent().getExtras();
		MovieDetail pos = inte.getParcelable("position");
		FragmentB detail = (FragmentB) getFragmentManager().findFragmentById(R.id.fragment2);
		if (detail != null)
		detail.changeText(pos);
		
	}
}
