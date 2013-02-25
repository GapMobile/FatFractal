package com.gap.android.fatfractal.adapter;

import java.util.List;

import com.gap.android.fatfractal.myapp.R;
import com.gap.android.fatfractal.myapp.entity.Movie;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovieListAdapter extends BaseListAdapter{

	public MovieListAdapter(Context context, List<?> items) {
		super(context, items);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		
        ViewHolder holder = new ViewHolder();
        final Movie movie = (Movie) getItem(position);
        
        if (convertView == null) {
        	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        convertView = inflater.inflate(R.layout.movie_cell_list, null);
	        holder.textView1 = (TextView) convertView.findViewById(android.R.id.text1);
	        holder.textView2 = (TextView) convertView.findViewById(android.R.id.text2);
	        convertView.setTag(holder);
        } else {
        	holder = (ViewHolder) convertView.getTag();
        }
        
        holder.textView1.setText(movie.getTitle());
        holder.textView2.setTag("Year: " + movie.getYear());
        
        return convertView;	}
    static class ViewHolder {
        TextView textView1;
        TextView textView2;     
    }
}
