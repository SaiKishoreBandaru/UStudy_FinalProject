package com.example.ustudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class UStudyHomeActivity extends Activity implements OnClickListener,OnItemSelectedListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ustudyhome);		
				
		Button bt_searchclg=(Button)findViewById(R.id.searchbtn);	//OnClick for Searching college
		bt_searchclg.setOnClickListener(this);		
		
	}

	@Override
	public void onClick(View v) {
		
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
		Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
		Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
		
				
		if(String.valueOf(spinner1.getSelectedItem()).equals("Choose a Location"))
		{
			Toast.makeText(getApplicationContext(), "Choose Your Location", Toast.LENGTH_LONG).show(); 
			return; 
		}
		else if(String.valueOf(spinner2.getSelectedItem()).equals("Choose your GRE score"))
		{
			Toast.makeText(getApplicationContext(), "Choose Your GRE Score", Toast.LENGTH_LONG).show(); 
			return; 
		}
		else if(String.valueOf(spinner3.getSelectedItem()).equals("Choose your Toefl score"))
		{
			Toast.makeText(getApplicationContext(), "Choose Your Toefl Score", Toast.LENGTH_LONG).show(); 
			return; 
		}
		else if(String.valueOf(spinner4.getSelectedItem()).equals("Choose your fees range"))
		{
			Toast.makeText(getApplicationContext(), "Choose Your Fees Range", Toast.LENGTH_LONG).show(); 
			return; 
		}
		
		else
		{
			Intent in_searchclg = new Intent(UStudyHomeActivity.this,GuestCollegeDetails.class);
			Bundle bundle = new Bundle();
			GuestCollegeDetails.loc_global = String.valueOf(spinner1.getSelectedItem()).substring(0, 2);
			GuestCollegeDetails.gre_global = String.valueOf(spinner2.getSelectedItem());
			GuestCollegeDetails.toefl_global = String.valueOf(spinner3.getSelectedItem());
			GuestCollegeDetails.fees_global = String.valueOf(spinner4.getSelectedItem());
			in_searchclg.putExtras(bundle);
            startActivity(in_searchclg);
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
		
		
		
	
