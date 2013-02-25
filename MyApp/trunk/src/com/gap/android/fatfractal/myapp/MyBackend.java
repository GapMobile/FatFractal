/**
 * 
 */
package com.gap.android.fatfractal.myapp;

import java.net.URI;
import java.net.URISyntaxException;

import com.fatfractal.ffef.FatFractal;
import com.fatfractal.ffef.impl.FatFractalHttpImpl;
import com.fatfractal.ffef.json.FFObjectMapper;
import com.gap.android.fatfractal.myapp.entity.Actors;
import com.gap.android.fatfractal.myapp.entity.Movie;

import android.app.Application;

/**
 * @author Carlos Leon
 * The MyBackend class provides provides shared settings and methods for the application.
 */
public class MyBackend extends Application {
	public static FatFractal ff = null;
	/**
	 * This method calls {@link #getFF()}to create the first instance of the FatFractal class when the application starts.
	 * <p>
	 * @see FatFractal
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		if (ff == null) {
			ff = MyBackend.getFF();
		}
	}
	
	/**
	 * This method initializes and returns an instance of the FatFractal class.
	 * It also registers the object classes that will be used by the application when communicating with the FFEF back-end.
	 * <p>
	 * @see FatFractal
	 */
	public static FatFractal getFF() {
		if (ff == null) {
			String baseUrl = "https://gapmobile.fatfractal.com/MyBackend";
			String sslUrl = "http://gapmobile.fatfractal.com/MyBackend";
			try {
				ff = FatFractal.getInstance(new URI(baseUrl), new URI(sslUrl));
				FatFractalHttpImpl.addTrustedHost("gapmobile.fatfractal.com");
				FFObjectMapper.registerClassNameForClazz(Actors.class.getName(), "Person");
				FFObjectMapper.registerClassNameForClazz(Movie.class.getName(), "Movie");
			}
            catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return ff;
	}	
}
