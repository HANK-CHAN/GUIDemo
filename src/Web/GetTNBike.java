package Web;

import java.net.URL;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetTNBike {

	public Object[][] getBike() throws Exception{
		
		String url = "https://data.ntpc.gov.tw/api/datasets/010e5b15-3823-4b20-b401-b1cf000550c5/json?size=100";
		
		InputStream is = new URL(url).openStream(); // 抓取資料
		
		Object[][] data = null; // 物件
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));// 轉檔
			int cp;
			StringBuilder sb = new StringBuilder();// 字串容器
			while((cp = br.read()) != -1) {
				sb.append((char)cp);
			}
			
			JSONArray arr = new JSONArray(sb.toString());
			data = new Object[arr.length()][3];
			
			for(int i=0 ; i<arr.length() ; i++) {
				JSONObject obj = arr.getJSONObject(i);
				data[i][0] = obj.getString("sna");
				data[i][1] = obj.getInt("sbi");
				data[i][2] = obj.getInt("act");
			}
			
		}
		finally {
			is.close();
		}
		
		return data;
	}
	
	
}
