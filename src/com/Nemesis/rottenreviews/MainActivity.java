package com.Nemesis.rottenreviews;


import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

public class MainActivity extends Activity implements FragmentA.Communicator {

	FragmentManager manager;
	FragmentA fragmentA;
	FragmentB fragmentB;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		manager = getFragmentManager();
		
		fragmentA = (FragmentA) manager.findFragmentById(R.id.fragment1);
		fragmentA.setCommunicator(this);
		
    }

	@Override
	public void changeText(MovieDetail  selectItem) {
		fragmentB = (FragmentB) manager.findFragmentById(R.id.fragment2);
		MovieDetail hal = selectItem;
		if(fragmentB != null){
		fragmentB.changeText(hal);
		}else{
       Intent showIt = new Intent(this, SingleItem.class);
       showIt.putExtra("position", hal);
       startActivity(showIt);
       }
		
	}
	
	

}
