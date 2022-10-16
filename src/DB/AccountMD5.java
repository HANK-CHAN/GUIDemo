package DB;
import java.security.MessageDigest;

public class AccountMD5 {

	public static String getMD5(String msg) {
		char[] hexDigits= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(msg.getBytes("UTF-8"));
			
			// 使用 Hash計算方式，來生產128位的長數
			
			byte[] bytes = messageDigest.digest();
			
			StringBuffer sb = new StringBuffer();
			
			for(Byte b: bytes) {
				// 將 b 資料 右移4位，取得char 中前四位轉換
				sb.append(hexDigits[ (b >> 4 & 0x0f)]);
				sb.append(hexDigits[b & 0x0f]);
			}
			
			msg = sb.toString();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return msg;
	}
	
}
