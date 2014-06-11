package com.Nemesis.rottenreviews;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentA extends Fragment {

	ListView listView;
	Communicator communicator;
	private static String url ="http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?limit=5&country=us&apikey=tyes5qr3nrapyss8rfuwqfpv";
	private static final String TAG_MOVIES = "movies";
	private static final String TAG_TITLE = "title";
	private static final String TAG_MPAA_RATING = "mpaa_rating";
	private static final String TAG_SYNOPSIS = "synopsis";
	
	private JSONArray movies = null;
	private JSONObject film;
	private JSONParser parser;
	private ArrayList<MovieDetail> movieList = new ArrayList<MovieDetail>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_a, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		new MovieListDL().execute();
		/*for(int k=0;k<10;k++){
			MovieDetail move = new MovieDetail();
			move.setTitle("title"+k);
			move.setRating(Integer.toString(k));
			move.setSynopsis(TAG_SYNOPSIS);
			movieList.add(move);
		}*/
		listView = (ListView) getActivity().findViewById(R.id.listView);
		
		final ArrayList<String> titles = new ArrayList<String>();
	   for(int i = 0; i<movieList.size();i++){
		   titles.add(movieList.get(i).getTitle());
	   }

	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,android.R.id.text1, titles);
	    listView.setAdapter(adapter);

	    listView.setOnItemClickListener(new OnItemClickListener() {
 			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				communicator.changeText(movieList.get(position));
			}
		});
	}
	
	
	
	public void setCommunicator(Communicator comm) {
		this.communicator = comm;
	}

	public interface Communicator {
		public void changeText(MovieDetail itemSelect);
	}
	private void createList(){
    	
    	try{
    		movies = film.getJSONArray(TAG_MOVIES);
    		for(int i = 0; i<movies.length();i++){
    			JSONObject pete = movies.getJSONObject(i);
    			MovieDetail move = new MovieDetail();
    			move.setTitle(pete.getString(TAG_TITLE));
    			move.setRating(pete.getString(TAG_MPAA_RATING));
    			if(pete.getString(TAG_SYNOPSIS).length() >= 500){
    			move.setSynopsis(pete.getString(TAG_SYNOPSIS).substring(0, 500));
    			}else{
    				move.setSynopsis(pete.getString(TAG_SYNOPSIS));
    			}
    			movieList.add(move);
    			
    		}
    		} catch (JSONException e){
    			e.printStackTrace();
    		}
    	
    }
class MovieListDL extends AsyncTask<Void, Void, Void>{
    	
		@Override
		protected Void doInBackground(Void... params) {
			parser = new JSONParser();
			film = parser.getJSONFromUrl(url);
		
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result){
			createList();
			
		}
    	
    }
	
}
