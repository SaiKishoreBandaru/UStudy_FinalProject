package com.example.ustudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class CollegeDetails extends Activity implements OnClickListener  {
	
	TextView clgdet;
	String clg_data="";
	public static String loc_global;
	public static String gre_global;
	public static String toefl_global;
	public static String fees_global;
	public static String aid_global;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.college_details); 
		clgdet = (TextView)	findViewById(R.id.clgdet);
		Log.i("url response",loc_global);
		Log.i("url response",gre_global);
		
		
		Button bt_logout=(Button)findViewById(R.id.btnlogout);	//OnClick for Logout
		bt_logout.setOnClickListener(this);
		
	}
        
			@Override
			public void onResume() {
				// TODO Auto-generated method stub
				super.onResume();
				new Thread(new Runnable()
				{

				@Override
				public void run() {
					// TODO Auto-generated method stub
					//String url ="http://134.193.136.127:8983/solr/collection1_shard1_replica1/select?q=state_s%3AAL&rows=100&wt=json&indent=true";
					String url ="http://134.193.136.127:8983/solr/collection1_shard1_replica1/select?q=state_s%3A"+loc_global+"&rows=100&wt=json&indent=true";
					BackgroundTask bt=new BackgroundTask();
					bt.doInBackground(url);					
				}
				
				}).start();
			}
			
			public class BackgroundTask extends AsyncTask<String, String, String>{

				
				@Override
			    protected String doInBackground(String... params) {		   
			         String command=params[0]; // URL to call			                 
			         String response="";
			         String univ_name="";
			         String state="";
			         int fees;
			         String gre="";
			         String toefl="";
			         String fina_aid="";       
			         		         
			         
			         try {   	  
			         response = executeCommand(command); 			         
			         JSONObject responeObj = new JSONObject(response);         
			         JSONObject response2 = (JSONObject) responeObj.get("response");         
			         JSONArray docs= (JSONArray) response2.get("docs"); 
			         int fee=10000;
			         if(docs.length()>0)
			         {        	 
			        	 for(int i=0;i<docs.length();i++)
			        	 {
			             JSONObject temp = (JSONObject) docs.get(i);                          
			             univ_name = (String) temp.get("univname_s");
			             state = (String) temp.get("state_s");
			            fees =  (Integer) temp.get("fee_i");
			            // fees =  fee;
			             gre = (String) temp.get("gre_s");
			             toefl = (String) temp.get("toefl_s");
			             fina_aid = (String) temp.get("aid_s");
			             if(fees<20000)
			             
			             clg_data=clg_data+univ_name+"\n"+"State : "+state+"\n"+"Fees : "+fees+"\n"+"Financial Aid : "+fina_aid+"\n\n";
			             //+"Gre : "+gre+"\n"+"Toefl : "+toefl+"\n"
			             else
			            	 clg_data=clg_data;
			                 		             
			             
			         }	
			        	 CollegeDetails.this.runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								 clgdet.setText(clg_data);
								
							}
						});
			        	
			        	 
			         }			         
			             
			         }catch (Exception ex) {
			             System.out.println("error!!");
			             Log.i("url response", "IN Catch");
			             ex.printStackTrace();
			         }
			        
			         return clg_data; 
			    }

				@Override
				protected void onPostExecute(String result) {
					// TODO Auto-generated method stub
					super.onPostExecute(result);
					clgdet.setText(result);
				}
				private String executeCommand(String command) {
				   	 
					StringBuffer output = new StringBuffer();
			 
					String line="";
					try {
						
						 URL url = new URL(command);						
						 HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();         
				         BufferedReader br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
				         while ((line = br.readLine())!= null) {
								output.append(line + "\n");					
							}		
						
			 
					} catch (Exception e) {
						e.printStackTrace();
					}
			 
					return output.toString();
			 
				}
			}

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(v.getId()==R.id.btnlogout)
				{
					Intent in_logout = new Intent(CollegeDetails.this,MainActivity.class);
		            startActivity(in_logout);
				}
				
			}
			
					  
    }
		
		  
