package com.example.loginpage;

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
		/*switch(v.getId()){
	      case R.id.btn_login: */
	             Intent in = new Intent(MainActivity.this,SignUpActivity.class);
	             startActivity(in);
	        // break;
		
	//}
	}
}
