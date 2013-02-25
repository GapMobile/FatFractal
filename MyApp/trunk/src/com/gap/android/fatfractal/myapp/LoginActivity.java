/**
 * 
 */
package com.gap.android.fatfractal.myapp;

import com.fatfractal.ffef.FFException;
import com.fatfractal.ffef.FatFractal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Carlos Leon
 *
 */
public class LoginActivity extends Activity implements OnClickListener{
	final FatFractal ff = MyBackend.getFF();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		if(!ff.isLoggedIn()) {
			((Button)findViewById(R.id.buttonLogIn)).setOnClickListener(this);
		} else {
			goMainActivity();
		}
	}

	@Override
	public void onClick(View view) {
		view.setEnabled(false);
		if(!ff.isLoggedIn()) {
			final String user = ((TextView)findViewById(R.id.editTextUser)).getText().toString();
			final String pass = ((TextView)findViewById(R.id.editTextPass)).getText().toString();
			try {
				ff.login(user, pass);
			}
	        catch (FFException e) {
				e.printStackTrace();
			}		
		} else {
			goMainActivity();
		}
		view.setEnabled(true);
	}
	private void goMainActivity() {
		final Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
