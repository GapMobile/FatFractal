package com.gap.android.fatfractal.myapp;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.fatfractal.ffef.FFException;
import com.fatfractal.ffef.FatFractal;
import com.gap.android.fatfractal.myapp.entity.Actors;
import com.gap.android.fatfractal.myapp.entity.Movie;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private FatFractal ff = MyBackend.getFF();	
	private ProgressDialog mProgressDialog;
	private List<Movie> movieArray;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		try {
			movieArray = ff.getArrayFromUri("/ff/resources/Movies");
			for (Movie movie : movieArray) {
				ff.deleteObj(movie);
			}
			
		} catch (FFException e) {
			e.printStackTrace();
		}*/
		new LoadData().execute();		
	}
	
	private void populateListView() {
		ListView list = (ListView)findViewById(android.R.id.list);
		ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movieArray);
		list.setAdapter(adapter);	
	}
	
	private class LoadData extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			showProgressDialog();
		}
		@Override
		protected void onPostExecute(Void result) {
			dismissProgressDialog();
			populateListView();
		}
	
		@Override
		protected Void doInBackground(Void... params) {
			//Loading Actors
			List<Actors> actorArray = null;
			try {
				actorArray = ff.getArrayFromUri("/ff/resources/Actors");
			} catch (FFException e) {
				e.printStackTrace();
			}
			if (actorArray == null || actorArray.size() == 0) {
				final int MAX = 50;
				for (int count = 0; count < MAX; count++) {
					Actors actor = new Actors();
					actor.setFirstName("Actor" + count);
					actor.setLastName("Last Name");	
					try {
						ff.createObjAtUri(actor, "/Actors");	
						actorArray.add(actor);
					} catch (FFException e) {
						e.printStackTrace();
					}					
				}
			}
			//Loading movies
			movieArray = null;
			try {
				movieArray = ff.getArrayFromUri("/ff/resources/Movies");
			} catch (FFException e) {
				e.printStackTrace();
			}
			if (movieArray == null || movieArray.size() == 0) {
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fat_logo);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();  
				bitmap.compress(Bitmap.CompressFormat.PNG, 100 , baos);    
		        byte[] byteImage = baos.toByteArray();
		        
				final int MAX = 50;
				for (int count = 0; count < MAX; count++) {
					Movie movie = new Movie();
					movie.setTitle("Movie title " + count);
					movie.setImages(new String[] {"http://ia.media-imdb.com/images/M/MV5BMTc3NjM4MTY3MV5BMl5BanBnXkFtZTcwODk4Mzg3OA@@._V1_SY317_CR4,0,214,317_.jpg",
							"http://3.bp.blogspot.com/-rtWisgw5h1w/T5XvTzC8BRI/AAAAAAAABIU/fs-DhwhD9gI/s1600/The-Shawshank-Redemption1.jpg",
							"http://3.bp.blogspot.com/-l3H3NIGjcu8/T01gAqH_o5I/AAAAAAAAAzQ/YEpZwJhiaZU/s1600/wall2.jpg"});
					movie.setYear(1994);
					movie.setImageData(byteImage);
					movieArray.add(movie);				
				}				
				Movie moview1 = new Movie();
				moview1.setTitle("The Shawshank Redemption");
				moview1.setImages(new String[] {"http://ia.media-imdb.com/images/M/MV5BMTc3NjM4MTY3MV5BMl5BanBnXkFtZTcwODk4Mzg3OA@@._V1_SY317_CR4,0,214,317_.jpg",
						"http://3.bp.blogspot.com/-rtWisgw5h1w/T5XvTzC8BRI/AAAAAAAABIU/fs-DhwhD9gI/s1600/The-Shawshank-Redemption1.jpg",
						"http://3.bp.blogspot.com/-l3H3NIGjcu8/T01gAqH_o5I/AAAAAAAAAzQ/YEpZwJhiaZU/s1600/wall2.jpg"});
				moview1.setYear(1994);
				Movie moview2 = new Movie();
				moview2.setTitle("The Godfather");
				moview2.setImages(new String[] {"http://www.topangafilmfestival.com/wp-content/uploads/2011/05/Godfather001.jpg",
						"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQ38DodI-exfp7IC7H0FyR6l-Bu6kzmdkgK1pHR3k6NMme3okA4",
						"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTeGdW2l42ePfT6CUYazfp7lJH7-Aabgpa1axGWFp1hi3Lllen_HQ"});
				moview2.setYear(1994);				
				Movie moview3 = new Movie();
				moview3.setTitle("The Godfather II");
				moview3.setImages(new String[] {"http://24.media.tumblr.com/tumblr_m7ssnrgRoe1qbkta6o3_1280.jpg",
						"http://3.bp.blogspot.com/_aDMP04riy1U/TR76SBoZirI/AAAAAAAAAB4/F9ifAdd01YU/s1600/godfather-part-2-afis.jpg",
						"http://3.bp.blogspot.com/-7bC3w0uSZY0/TnlVrCgDOAI/AAAAAAAACuE/mx9Ne5QnsDI/s1600/Godfather2.jpg"});
				moview3.setYear(1974);					

				Movie moview4 = new Movie();
				moview4.setTitle("The Lord of the Rings: The Return of the King");
				moview4.setImages(new String[] {"http://ia.media-imdb.com/images/M/MV5BMjE4MjA1NTAyMV5BMl5BanBnXkFtZTcwNzM1NDQyMQ@@._V1_SX214_.jpg",
						"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThKhUyQGwzaBmKAalE50RIRqWysYDAiFeSwBBa5Xk8AZFfexIk",
						"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTbvjA6ToC1n5epWAuV7l41H5nY5nZa3XQfZoKzRNZOBrKoTXlxtA"});
				moview4.setYear(2003);
				movieArray.add(0,moview1);
				movieArray.add(0,moview2);
				movieArray.add(0,moview3);
				movieArray.add(0,moview4);
				try {
					for (Movie movie : movieArray) {
						ff.createObjAtUri(movie, "/Movies");
					}				
				} catch (FFException e) {
					e.printStackTrace();
				}				
			}			
			return null;
		}
		
	}

	public void showProgressDialog() {
		if (this.mProgressDialog == null) {
			this.mProgressDialog = new ProgressDialog(this);
			this.mProgressDialog.setIndeterminate(true);
			this.mProgressDialog.setCancelable(false);
		}

		this.mProgressDialog.setMessage("Loading...");
		this.mProgressDialog.show();
	}

	public void dismissProgressDialog() {
		if (this.mProgressDialog != null) {
			this.mProgressDialog.dismiss();
		}
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
