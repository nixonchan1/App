package com.example.nixon;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

public class Foodlist extends ExpandableListActivity implements OnChildClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ExpandableListView expandbleLis = getExpandableListView();
		expandbleLis.setDividerHeight(2);
		expandbleLis.setGroupIndicator(null);
		expandbleLis.setClickable(true);
		
		setGroupData();
		setChildGroupData();
		NewAdapter mNewAdapter = new NewAdapter(groupItem, childItem);
		mNewAdapter.setInflater(
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE),this);
		getExpandableListView().setAdapter(mNewAdapter);
		expandbleLis.setOnChildClickListener(this);
	
	}

	private void setGroupData() {
	groupItem.add("¥D­¹");
	groupItem.add("½­µæ");
	groupItem.add("³½¦×");
	groupItem.add("¤ôªG");
	}
	
	ArrayList<String> groupItem = new ArrayList<String>();
	ArrayList<Object> childItem = new ArrayList<Object>();
	
	private void setChildGroupData() {
		ArrayList<String> child = new ArrayList<String>();
		child.add("¤z¿N¥ìÄÑ	1321 kcal ");
		child.add("°®ª£¤ûªe	1243 kcal ");
		child.add("ÖK½Þ±Æ¶º	1137 kcal ");
		childItem.add(child);
		
		child = new ArrayList<String>();
		child.add("beef");
		child.add("pork");
		child.add("chicken");
		childItem.add(child);
		
		child = new ArrayList<String>();
		child.add("beef");
		child.add("pork");
		child.add("chicken");
		childItem.add(child);
		
		child = new ArrayList<String>();
		child.add("beef");
		child.add("pork");
		child.add("chicken");
		childItem.add(child);
		
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id){
		Toast.makeText(Foodlist.this, "Clicked On Child", Toast.LENGTH_SHORT).show();
		return true;
	}

	public void onboxButtonClicked (View v) {
		
	}
	
	public void onmenuButtonClicked (View v) {
	
	}
}
