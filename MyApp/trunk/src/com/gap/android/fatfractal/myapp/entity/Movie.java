/**
 * 
 */
package com.gap.android.fatfractal.myapp.entity;

import java.util.ArrayList;

/**
 * @author Carlos Leon
 *
 */
public class Movie {
	private String mTitle;
	private int mYear;
	private ArrayList<Actors> mActors;
	private String[] mImages;
	private byte[] imageData = null;
	
	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public int getYear() {
		return mYear;
	}
	public void setYear(int mYear) {
		this.mYear = mYear;
	}
	public ArrayList<Actors> getActors() {
		return mActors;
	}
	public void setActors(ArrayList<Actors> mActors) {
		this.mActors = mActors;
	}
	public String[] getImages() {
		return mImages;
	}
	public void setImages(String[] mImages) {
		this.mImages = mImages;
	}
	
	@Override
	public String toString() {
		return mTitle;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
}
