package com.example.unitconverter2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends Activity {
	
	public double kilometerToMile = 0.621371;
	public double gramToPound = 0.00220462;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void convert(View v) {
		EditText unitText1 = (EditText)findViewById(R.id.editText1);
		EditText unitText2 = (EditText)findViewById(R.id.editText2);
		Spinner unit1Selection = (Spinner)findViewById(R.id.spinner1);
		Spinner unit2Selection = (Spinner)findViewById(R.id.spinner2);
		
		String unitText1String = unitText1.getText().toString();
		if (unitText1String.equals("")){
			unitText2.setText("ERROR");
			return;
		}
		double unitText1Val = Double.valueOf(unitText1String);

		String unit1 = String.valueOf(unit1Selection.getSelectedItem());
		String unit2 = String.valueOf(unit2Selection.getSelectedItem());
		
		if(unit1.equals("miles")){
			if(unit2.equals("miles")){
				unitText2.setText(""+unitText1Val);
			}
			else if(unit2.equals("kilometers")){
				unitText2.setText(""+unitText1Val/kilometerToMile);
			}
			else{
				unitText2.setText("ERROR");
			}
		}
		else if(unit1.equals("kilometers")){
			if(unit2.equals("kilometers")){
				unitText2.setText(""+unitText1Val);
			}
			else if(unit2.equals("miles")){
				unitText2.setText(""+unitText1Val*kilometerToMile);
			}
			else{
				unitText2.setText("ERROR");
			}
		}
		else if(unit1.equals("grams")){
			if(unit2.equals("grams")){
				unitText2.setText(""+unitText1Val);
			}
			else if(unit2.equals("pounds")){
				unitText2.setText(""+unitText1Val*gramToPound);
			}
			else{
				unitText2.setText("ERROR");
			}
		}
		else if(unit1.equals("pounds")){
			if(unit2.equals("pounds")){
				unitText2.setText(""+unitText1Val);
			}
			else if(unit2.equals("grams")){
				unitText2.setText(""+unitText1Val/gramToPound);
			}
			else{
				unitText2.setText("ERROR");
			}
		}
		else if(unit1.equals("Celsius")){
			if(unit2.equals("Celsius")){
				unitText2.setText(""+unitText1Val);
			}
			else if(unit2.equals("Fahrenheit")){
				unitText2.setText(""+(((unitText1Val*9)/5)+32));
			}
			else{
				unitText2.setText("ERROR");
			}
		}
		else{
			if(unit2.equals("Fahrenheit")){
				unitText2.setText(""+unitText1Val);
			}
			else if(unit2.equals("Celsius")){
				unitText2.setText(""+((unitText1Val-32)*5)/9);
			}
			else{
				unitText2.setText("ERROR");
			}
		}
		
	}

	public void swap(View v) {
		EditText unitText1 = (EditText)findViewById(R.id.editText1);
		EditText unitText2 = (EditText)findViewById(R.id.editText2);
		Spinner unit1Selection = (Spinner)findViewById(R.id.spinner1);
		Spinner unit2Selection = (Spinner)findViewById(R.id.spinner2);
		
		String tempString = unitText1.getText().toString();
		unitText1.setText(unitText2.getText().toString());
		unitText2.setText(tempString);

		int tempInt = unit1Selection.getSelectedItemPosition();
		unit1Selection.setSelection(unit2Selection.getSelectedItemPosition());
		unit2Selection.setSelection(tempInt);		
		
	}
}
