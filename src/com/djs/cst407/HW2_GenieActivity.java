package com.djs.cst407;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HW2_GenieActivity extends Activity implements View.OnClickListener {
	public static final String PREFS_NAME = "DamonsPrefsFile";

	private SharedPreferences Prefs;
	private ToggleButton wish1, wish2, wish3;
	private Button reset;
	private Boolean wish1Used, wish2Used, wish3Used;
	private TextView tv1_genie;
	private Integer numGenie;
	private Vibrator v;

	@Override
	public void onCreate(Bundle SavedInstanceState) {
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.hw2_activitygenie);

		v = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

		wish1 = (ToggleButton) findViewById(R.id.tb1_wish);
		wish2 = (ToggleButton) findViewById(R.id.tb2_wish);
		wish3 = (ToggleButton) findViewById(R.id.tb3_wish);

		reset = (Button) findViewById(R.id.b1_reset);

		Prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
		wish1Used = Prefs.getBoolean("wish1Used", false);
		wish2Used = Prefs.getBoolean("wish2Used", false);
		wish3Used = Prefs.getBoolean("wish3Used", false);

		setWishPrefs();
		

		// tv1_genie = (TextView) findViewById(R.id.tv1_numGenies);
		// tv1_genie.setText(tv1_genie.getText().toString() + numGenie);

		wish1.setOnClickListener(this);
		wish2.setOnClickListener(this);
		wish3.setOnClickListener(this);
		reset.setOnClickListener(this);

	}

	private void setWishPrefs() {
		// TODO Auto-generated method stub
		if (wish1Used) {
			wish1.setChecked(true);
			wish1.setEnabled(false);
		}
		if (wish2Used) {
			wish2.setChecked(true);
			wish2.setEnabled(false);
		}
		if (wish3Used) {
			wish3.setChecked(true);
			wish3.setEnabled(false);
		}

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.tb1_wish:
			if (wish1.isChecked()) {
				wish1Used = true;
				wish1.setEnabled(false);
				v.vibrate(100);
			}
			break;
		case R.id.tb2_wish:
			if (wish2.isChecked()) {
				wish2Used = true;
				wish2.setEnabled(false);

				v.vibrate(100);
			}
			break;
		case R.id.tb3_wish:
			if (wish3.isChecked()) {
				wish3Used = true;
				wish3.setEnabled(false);

				v.vibrate(100);
			}
			break;
		case R.id.b1_reset:
			wish1Used = false;
			wish1.setChecked(false);
			wish1.setEnabled(true);
			wish2Used = false;
			wish2.setChecked(false);
			wish2.setEnabled(true);
			wish3Used = false;
			wish3.setChecked(false);
			wish3.setEnabled(true);
			setWishPrefs();

			break;
		}

	}

	@Override
	protected void onPause() {
		super.onPause();

		// SharedPreferences settings = getSharedPreferences(PREFS_NAME,
		// MODE_PRIVATE);
		SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME,
				MODE_PRIVATE).edit();
		editor.putBoolean("wish1Used", wish1Used);
		editor.putBoolean("wish2Used", wish2Used);
		editor.putBoolean("wish3Used", wish3Used);

		editor.commit();
	}

}
