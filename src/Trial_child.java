

import com.example.nixon.R;
import com.example.nixon.R.layout;
import com.example.nixon.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Trial_child extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trial_child);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trial_child, menu);
		return true;
	}

}
