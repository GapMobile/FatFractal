package com.gap.android.fatfractal.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Common base class implementation to be used in a ListView
 * @author GAP
 *
 */
public abstract class BaseListAdapter  extends BaseAdapter {


	protected Context context;
	protected List<?> items;

	/**
	 * 
	 * @param context - Activity context
	 * @param items - List of items
	 */
	public BaseListAdapter(Context context, List<?> items) {
		this.context = context;
		this.items = items;
	}

	/**
	 * 
	 * @param items - Sets the objects represented by this adapter
	 */
	public void setData(List<?> items){
		this.items = items;
	}

	/**
	 * How many items are in the data set represented by this Adapter.
	 * @return Count of items.
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return items.size();
	}

	/**
	 * Get the data item associated with the specified position in the data set.
	 * @param position - Position of the item whose data we want within the adapter's data set.
	 * @return The data at the specified position.
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	/**
	 * Get the row id associated with the specified position in the list.
	 * @return The id of the item at the specified position.
	 * @see android.widget.Adapter#getItemId(int)
	 */ 
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * Returns true if the item at the specified position is not a separator.
	 * @throws  ArrayIndexOutOfBoundsException should be thrown in that case for fast failure.
	 * @return True if the item is not a separator
	 */
	@Override
	public boolean isEnabled(int position) {
		return super.isEnabled(position);
	}

	/**
	 * Get a View that displays the data at the specified position in the data set.
	 * 
	 * @param position - The position of the item within the adapter's data set of the item whose view we want.
	 * @param convertView - The old view to reuse, if possible. Note: You should check that this view is non-null 
	 * 	and of an appropriate type before using. If it is not possible to convert this view to display the correct 
	 * 	data, this method can create a new view. Heterogeneous lists can specify their number of view types, so that 
	 * 	this View is always of the right type (see getViewTypeCount() and getItemViewType(int)).
	 * @param viewGroup - The parent that this view will eventually be attached to
	 */
	public abstract View getView(int position, View convertView, ViewGroup viewGroup);
}
