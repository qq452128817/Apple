package com.example.apple;

import java.util.ArrayList;
import java.util.List;

import com.example.apple.Banana.B;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	private List<Apple>apples=new ArrayList<Apple>();
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.lv);
		for (int i = 0; i < 100; i++) {
			Apple apple=new Apple();
			apple.name="美猴王分身"+i;
			apple.phone="159"+i+i+i+"159";
			apples.add(apple);
		}
		Banana banana=new Banana(apples);
		banana.A(new B() {
			
			@Override
			public void phone(String phone) {
				// TODO Auto-generated method stub
				call(phone);
			}
			
			@Override
			public void note(String phone) {
				// TODO Auto-generated method stub
				call("110");
			}
		});
		listView.setAdapter(banana);
	}
	public void call(String phone){
		Intent intent=new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:"+phone));
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
