package Web;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import DB.TrainSQL;

public class GetTrainStation {

	public static void main(String[] args) throws Exception {

		TrainSQL train = new TrainSQL();
		
		FileInputStream fis = null; 
		BufferedReader br = null;
		String fileName = "train.json";
		
		try {
			
			fis = new FileInputStream(fileName);
			InputStreamReader reader = new  InputStreamReader(fis,"utf-8");
			br = new BufferedReader(reader);
			
			StringBuilder sb = new StringBuilder();// 字串容器
			String data;
			while((data = br.readLine()) != null) {
				sb.append(data);
			}
			
			JSONArray arr = new JSONArray(sb.toString());
			
			String stationname;
			
			for(int i=0 ; i<arr.length() ; i++) {
				JSONObject obj = arr.getJSONObject(i);
				stationname = obj.getString("stationName");
				train.insert(stationname);
				
			}
			
		}
		finally {
			br.close();
		}
		
		
	
	}
	
}
