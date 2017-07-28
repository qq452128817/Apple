package com.example.apple;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class Banana extends BaseAdapter {
	private List<Apple>apples=new ArrayList<Apple>();
	public Banana(List<Apple>apples){
		this.apples=apples;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return apples==null?0:apples.size();
	}

	@Override
	public Apple getItem(int position) {
		// TODO Auto-generated method stub
		return apples.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Apple apple=apples.get(position);
		ViewHolder viewHolder=null;
		if (convertView==null) {
			viewHolder=new ViewHolder();
			convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent,false);
			viewHolder.textView=(TextView) convertView.findViewById(R.id.t1);
			viewHolder.textView2=(TextView) convertView.findViewById(R.id.t2);
			viewHolder.button=(Button) convertView.findViewById(R.id.b1);
			viewHolder.button2=(Button) convertView.findViewById(R.id.b2);
			convertView.setTag(viewHolder);
		}
		else {
			viewHolder=(ViewHolder) convertView.getTag();
		}
		viewHolder.textView.setText(apple.name);
		viewHolder.textView2.setText(apple.phone);
		
		viewHolder.button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b.phone(apple.phone);
			}
		});
		viewHolder.button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b.note(apple.phone);
			}
		});
		return convertView;
	}
	class ViewHolder{
		TextView textView;
		TextView textView2;
		Button button;
		Button button2;
		
	}
	interface B{
		void phone(String phone);
		void note(String phone);
	}
	public B b;
	public void A(B b){
		this.b=b;
	}
}
