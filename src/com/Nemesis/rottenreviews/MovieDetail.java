package com.Nemesis.rottenreviews;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieDetail implements Parcelable{
	
	String title;
	String rating;
	String synopsis;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public MovieDetail(){}
	
	public MovieDetail(Parcel in){
		String[] data = new String[3];
		in.readStringArray(data);
		this.title = data[0];
		this.rating = data[1];
		this.synopsis = data[2];
	}
	
	@Override
	public int describeContents(){
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags){
		dest.writeStringArray(new String[]{this.title, this.rating, this.synopsis});
	}
	public static final Parcelable.Creator<MovieDetail> CREATOR = new Parcelable.Creator<MovieDetail>() {

		@Override
		public MovieDetail createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new MovieDetail(source);
		}

		@Override
		public MovieDetail[] newArray(int size) {
			// TODO Auto-generated method stub
			return new MovieDetail[size];
		}
	};

}
