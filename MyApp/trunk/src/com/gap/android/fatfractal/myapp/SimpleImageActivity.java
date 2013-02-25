package com.gap.android.fatfractal.myapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class SimpleImageActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		byte[] byteImage = getIntent().getByteArrayExtra("image");
		if (byteImage != null) {
			Bitmap bitmap = BitmapFactory.decodeByteArray(byteImage , 0, byteImage.length);
			ImageView imageView = new ImageView(this);
			imageView.setImageBitmap(bitmap);
			setContentView(imageView);
		}
	}
}
