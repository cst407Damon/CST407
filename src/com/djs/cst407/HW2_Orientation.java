package com.djs.cst407;

import java.util.Random;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HW2_Orientation extends Activity {

	private static final String KEY_CHANGE_TEXT = "CHANGE_TEXT";
	private static final String KEY_TEXT_CHANGED = "TEXT_CHANGED";
	private TextView HW2_tv;
	private Button b_changeText;
	private Integer config;
	private Typeface tf_Black;
	private Typeface tf_ThinItalic;
	private String changedText;
	private Integer r_int;
	private Boolean textchanged = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hw2_orientation);

		final Random r = new Random();

		HW2_tv = (TextView) findViewById(R.id.tv_hw2);
		b_changeText = (Button) findViewById(R.id.b1_changeText);

		/* fonts for Portrait and Landscape */
		tf_Black = Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-Black.ttf");
		tf_ThinItalic = Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-ThinItalic.ttf");

		config = getResources().getConfiguration().orientation;

		if (savedInstanceState != null) {
			textchanged = savedInstanceState.getBoolean(KEY_TEXT_CHANGED);
			if (textchanged) {
				String text1 = savedInstanceState.getString(KEY_CHANGE_TEXT);
				HW2_tv.setText(text1);
			}
		}

		b_changeText.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				r_int = r.nextInt();
				changedText = Integer.toHexString(r_int);
				HW2_tv.setText(changedText);
				textchanged = true;
			}
		});
		if (config == 1) { /* ORIENTATION_PORTRAIT */
			HW2_tv.setTypeface(tf_Black);
			HW2_tv.setTextSize(20);
			HW2_tv.setTextColor(getResources().getColor(R.color.RED));

		} else if (config == 2) { /* ORIENTATION_LANDSCAPE */
			HW2_tv.setTypeface(tf_ThinItalic);
			HW2_tv.setTextSize(80);
			HW2_tv.setTextColor(getResources().getColor(R.color.GREEN));

		} else {
			HW2_tv.setText("Landscape or Portrait?");
		}

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		String changeText = HW2_tv.getText().toString();
		outState.putString(KEY_CHANGE_TEXT, changeText);

		outState.putBoolean(KEY_TEXT_CHANGED, textchanged);

		/* ORIENTATION_PORTRAIT */
		// if (config == 1) {
		// Integer textColor = HW2_tv.getCurrentTextColor();
		// outState.putInt(KEY_CHANGE_COLOR, textColor);
		/* ORIENTATION_LANDSCAPE */
		// } else if (config == 2) {
		// Integer textColor = HW2_tv.getCurrentTextColor();
		// outState.putInt(KEY_CHANGE_COLOR_LAND, textColor);

		// } else {
		// }

	}
}
