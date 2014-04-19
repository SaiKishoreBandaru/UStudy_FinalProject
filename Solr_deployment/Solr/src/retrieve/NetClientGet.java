package retrieve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class NetClientGet {
	
	public static void main(String[] args) {
		
		/*String id ="";
		String response="";
		String title = "";
		String Toefl_s_s="";
		String GRE_s="";
		String fees_s="";
		String FinancialAid_s="";
		JSONObject returnData = new JSONObject();*/
 
	  try {
 
	    String solr = "http://134.193.136.127:8983/solr/collection1_shard1_replica1/select?q=univname_s%3A*&wt=json&indent=true";
		URL url = new URL(solr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			
			
		/*	JSONObject responeObj = new JSONObject(response);
            JSONObject response2 = (JSONObject) responeObj.get("response");
            JSONArray docs= (JSONArray) response2.get("docs");
            if(docs.length()>0){
                JSONObject temp = (JSONObject) docs.get(0);
                title =  temp.getString("title_s");
                Toefl_s = temp.getString("Toefl_s");
                GRE_s = temp.getString("GRE_s");
                fees_s =temp.getString("fees_s");
                FinancialAid_s = temp.getString("FinacialAid_s");
            }*/
			
			/*JSONObject responseData = new JSONObject(response);
           
            JSONArray results = (JSONArray)location.get("results");
            JSONObject array = (JSONObject)results.get(0);
            JSONObject geometry = (JSONObject)arry.get("geometry");
            JSONObject locationValues = (JSONObject)geometry.get("location");
          
        returnData.put("Id", id);
        returnData.put("title", title_s);
        returnData.put("Toefl", Toefl_s);
        returnData.put("GRE", GRE_s);
        returnData.put("Fees", fees_s);
        returnData.put("Financial Aid", FinancialAid_s);*/
		}
 
		conn.disconnect();
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
 
	}
}
 
