package com.djs.cst407;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActivityMenu extends Activity {

	private List<String> itemList = new ArrayList<String>();
	private ArrayAdapter<String> buildListAdapter = null;
	private ListView itemlist;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_activity);

		ListView listView = (ListView) findViewById(R.id.lv_itemlist);

		buildList();

		buildListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
		listView.setAdapter(buildListAdapter);

		listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> av, View v, int position ,long id) {
					//super.onItemClick(av,v,position,id);
				String menuClass = itemList.get(position);
				try {
					Class myClass = Class.forName("com.djs.cst407." + menuClass);
					Intent myIntent = new Intent(ActivityMenu.this, myClass);
					startActivity(myIntent);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}


			}
		});

	}

	private void buildList() {

		itemList.add("HW1_Camera");
		itemList.add("HW2_Orientation");
		itemList.add("HW2_GenieActivity");
		itemList.add("Empty");
		itemList.add("Empty");
		itemList.add("Empty");

	}

	/*
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String menuClass = itemList.get(position);
		try {
			Class myClass = Class.forName("com.djs.cst407." + menuClass);
			Intent myIntent = new Intent(ActivityMenu.this, myClass);
			startActivity(myIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
*/
}
