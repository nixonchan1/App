package com.example.nixon;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {

	public static final String PREFS = "examplePrefs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView tv=(TextView)findViewById(R.id.textView6);
        SharedPreferences example= getSharedPreferences(PREFS,0);
        String userString = example.getString("userMessage", "Username");
        tv.setText(userString);
        
        TextView tv1=(TextView)findViewById(R.id.textView7);
        String userString1 = example.getString("bmrValue", "bmr");
        tv1.setText(userString1);
        
        TextView tv2=(TextView)findViewById(R.id.textView8);
        String userString2 = example.getString("bmrValue", "bmr");
        tv2.setText(userString2);
        
  
        
   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}

	public void onsettingButtonClick(View V) {
		Intent intent = new Intent(Main.this, Setting.class);
		startActivity(intent);
	}
		public void onfoodButtonClick(View V) {
			Intent intent = new Intent(Main.this, Foodlist.class);
			startActivity(intent);


	}
		
	
	}
