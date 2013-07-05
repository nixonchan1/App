package com.example.nixon;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Setting extends Activity {

	public static final String PREFS = "examplePrefs";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("Error", "onCreate");

		setContentView(R.layout.activity_setting);

		final EditText et = (EditText) findViewById(R.id.editText1);

		SharedPreferences example = getSharedPreferences(PREFS, 0);
		String userString = example.getString("userMessage", "");
		et.setText(userString);

		EditText weightText = (EditText) findViewById(R.id.editText3);
		String userString1 = example.getString("weight", "");
		weightText.setText(userString1);

		EditText heightText = (EditText) findViewById(R.id.editText4);
		String userString2 = example.getString("height", "");
		heightText.setText(userString2);

		EditText ageText = (EditText) findViewById(R.id.editText2);
		String userString3 = example.getString("age", "");
		ageText.setText(userString3);

		final Spinner genderSpinner = (Spinner) findViewById(R.id.Spinner_Gender);
		String userString4 = example.getString("gender", "");
		genderSpinner.setTag(userString4);
		
		final Spinner exerciseSpinner = (Spinner) findViewById(R.id.Spinner_exercise);
		String userString5 = example.getString("exercise", "");
		exerciseSpinner.setTag(userString5);

		Button nextAct = (Button) findViewById(R.id.button1);

		nextAct.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			
				String message = et.getText().toString();
				SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
				Editor editor = examplePrefs.edit();
				editor.putString("userMessage", message);
				editor.commit();
				
				try {
					calculateClickHandler(v);
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent i = new Intent(getApplicationContext(), Main.class);
				startActivity(i);
			}
		});		
	}

		protected void onPause()
		{
			final Spinner genderSpinner = (Spinner) findViewById(R.id.Spinner_Gender);
			final Spinner exerciseSpinner = (Spinner) findViewById(R.id.Spinner_exercise);
			String spinner = genderSpinner.getSelectedItem().toString();
			String spinner1 = exerciseSpinner.getSelectedItem().toString();
			SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
			Editor editor = examplePrefs.edit();
			editor.putString("userSpinner", spinner);
			editor.commit();
			
			super.onPause();
		}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting, menu);
		return true;
	}

	public void onconfirmButtonClick(View V) {
		Intent intent = new Intent(Setting.this, Main.class);
		startActivity(intent);

	}

	public void calculateClickHandler(View view) throws XmlPullParserException,
			IOException {
		if (view.getId() == R.id.button1) {
			EditText weightText = (EditText) findViewById(R.id.editText3);
			EditText heightText = (EditText) findViewById(R.id.editText4);
			EditText ageText = (EditText) findViewById(R.id.editText2);
			Spinner genderSpinner = (Spinner) findViewById(R.id.Spinner_Gender);
			Spinner exerciseSpinner = (Spinner) findViewById(R.id.Spinner_exercise);
			TextView resultText = (TextView) findViewById(R.id.textView7);
			String gender = null;
			String exercise = null;
			double weight = 0;
			double height = 0;
			double age = 0;
			double bmrValue = 0;
			if (!weightText.getText().toString().isEmpty()
					&& !heightText.getText().toString().isEmpty()
					&& !ageText.getText().toString().isEmpty()) {
				weight = Double.parseDouble(weightText.getText().toString());
				height = Double.parseDouble(heightText.getText().toString());
				age = Double.parseDouble(ageText.getText().toString());

				gender = genderSpinner.getSelectedItem().toString();

				exercise = exerciseSpinner.getSelectedItem().toString();

				bmrValue = calculateBMR(weight, height, age, gender, exercise);

			}

			resultText.setText(bmrValue + "");
			SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
			Editor editor = examplePrefs.edit();
			editor.putString("weight", weight + "");
			editor.putString("height", height + "");
			editor.putString("age", age + "");
			editor.putString("gender", gender + "");
			editor.putString("exercise", exercise + "");
			editor.putString("bmrValue", bmrValue + "");
			editor.commit();
		}
	}

	private double calculateBMR(double weight, double height, double age,
			String gender, String exercise) throws XmlPullParserException,
			IOException {
		int bmr = 0;
		XmlResourceParser sex = getResources().getXml(R.xml.gender_list);
		String genderz = processGenders(sex);

		XmlResourceParser sport = getResources().getXml(R.xml.exercise_list);
		String[] fitness = getFitness(sport);

		if (gender.equals(genderz)) {
			// bmr= (float) (weight * 10 + height * 6.25 - 5 * age + 5);
			if (exercise.equals(fitness[0]))
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age + 5) * 1.2)+.5);
			else if (exercise.equals(fitness[1])) {
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age + 5) * 1.375)+.5);
			}

			else if (exercise.equals(fitness[2])) {
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age + 5) * 1.55)+.5);
			}

			else {
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age + 5) * 1.725)+.5);
			}
	

		} else {
			// bmr = (float) (weight * 10 + height * 6.25 - 5 * age - 161);

			if (exercise.equals(fitness[0]))
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age - 161) * 1.2)+.5);

			else if (exercise.equals(fitness[1])) {
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age - 161) * 1.375)+.5);
			}
			else if (exercise.equals(fitness[2])) {
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age - 161) * 1.55)+.5);
			}
			else
				bmr = (int)(((weight * 10 + height * 6.25 - 5 * age - 161) * 1.725)+.5);
		}

		return bmr;

	}

	private String processGenders(XmlResourceParser genders)
			throws XmlPullParserException, IOException {
		int eventType = -1;
		String gender = "";
		while (eventType != XmlResourceParser.END_DOCUMENT) {
			if (eventType == XmlResourceParser.START_TAG) {
				String strName = genders.getName();
				if (strName.equals("genderz")) {
					gender = genders.getAttributeValue(null, "name");
				}
			}
			eventType = genders.next();
		}
		return gender;
	}

	private String[] getFitness(XmlResourceParser exercises)
			throws XmlPullParserException, IOException {
		int eventType = -1;
		String[] exercise = new String[4];
		while (eventType != XmlResourceParser.END_DOCUMENT) {
			if (eventType == XmlResourceParser.START_TAG) {
				String strName = exercises.getName();
				if (strName.equals("exercisez")) {
					exercise[0] = exercises.getAttributeValue(null, "little");
					exercise[1] = exercises.getAttributeValue(null, "light");
					exercise[2] = exercises.getAttributeValue(null, "moderate");
					exercise[3] = exercises.getAttributeValue(null, "heavy");
				}
			}
			eventType = exercises.next();
		}
		return exercise;
	}
}
