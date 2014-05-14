package com.example.ustudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Recomendation extends Activity implements OnClickListener {
	
	private static String gre_global;
	private static String toefl_global;
	private static String fees_global;
	private static String loc_global;
	TextView clgdet;
	String clg_data="";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recomendation);
		
		Button bt_searchclg=(Button)findViewById(R.id.searchbtn);	//OnClick for Searching college
		bt_searchclg.setOnClickListener(this);
		
		Button bt_logout=(Button)findViewById(R.id.btnlogout);	//OnClick for Logout
		bt_logout.setOnClickListener(this);
}
	
	
	@Override
	public void onClick(View v) {
		
		Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
		Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
		Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
		Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
		
		if(v.getId()==R.id.btnlogout)
		{
			Intent in_logout = new Intent(Recomendation.this,MainActivity.class);
            startActivity(in_logout);
		}
		
		else
		{
		
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
			Intent in_searchclg = new Intent(Recomendation.this,CollegeDetails.class);
			Bundle bundle = new Bundle();
			CollegeDetails.loc_global = String.valueOf(spinner1.getSelectedItem()).substring(0, 2);
			CollegeDetails.gre_global = String.valueOf(spinner2.getSelectedItem());
			CollegeDetails.toefl_global = String.valueOf(spinner3.getSelectedItem());
			CollegeDetails.fees_global = String.valueOf(spinner4.getSelectedItem());
			in_searchclg.putExtras(bundle);
            startActivity(in_searchclg);
		}
		
		}
		}
	}

	

