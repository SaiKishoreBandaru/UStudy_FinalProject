package com.example.ustudy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button bt =(Button)findViewById(R.id.signupbtn);  //OnClick for Sign Up Button
		bt.setOnClickListener(this);
		
		Button bt_login =(Button)findViewById(R.id.btn_login);  //OnClick for Login Button
		bt_login.setOnClickListener(this);
		
		Button bt_guest=(Button)findViewById(R.id.guestbtn);	//OnClick for Guest User
		bt_guest.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
	      case R.id.signupbtn: 
	             Intent in_singup = new Intent(MainActivity.this,SignUpActivity.class);
	             startActivity(in_singup);
	         break;
	      case R.id.btn_login:
	    	  //Intent in_login = new Intent(MainActivity.this,SignUpActivity.class);
	    	  Intent in_login = new Intent(MainActivity.this,Recomendation.class);
	             startActivity(in_login);
	         break;
	      case R.id.guestbtn:
	    	  Intent in_guest = new Intent(MainActivity.this,UStudyHomeActivity.class);
	             startActivity(in_guest);
	         break;
	         
		
	}
	}
}
