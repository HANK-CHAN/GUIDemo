package DB;

import java.sql.*;


public class TrainSQL {

	private Connection conn = null;
	private Statement stem = null;
	
	public TrainSQL() throws SQLException {
		
		conn = DriverManager.getConnection(DbConfig.url,DbConfig.user,DbConfig.pwd);
	
	}
	
	public void insert(String station) throws SQLException {
		String sql = "insert into twtrain(name) values('"+station+"')";
		stem = conn.createStatement();
		stem.execute(sql);
	}
	
	public void update(int id,String station) throws SQLException {
		String sql = "update twtrain set name='"+station+"' where id =" + id;
		stem = conn.createStatement();
		stem.execute(sql);
	}
	
	public void delete(int id) throws SQLException {
		String sql = "delete from twtrain where id =" + id;
		stem = conn.createStatement();
		stem.execute(sql);
	}
	public ResultSet queryAll() throws SQLException {
		String sql = "select * from twtrain";
		stem = conn.createStatement();
		stem.execute(sql);
		ResultSet rs = stem.getResultSet();
		return rs;
	}
	
	public boolean Login(String acc,String pwd) throws SQLException {
		
		pwd = AccountMD5.getMD5(pwd);
		String sql = "select * from auth where account = '" + acc + "' and password='" + pwd + "'";
		
		System.out.println(sql);
		
		stem = conn.createStatement();
		stem.executeQuery(sql);
		ResultSet rs = stem.getResultSet();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void UpdatePwd(String acc,String pwd) throws SQLException{
		pwd = AccountMD5.getMD5(pwd);
		
		String sql = "update auth set password='"+ pwd +"' where account= '"+ acc +"'";
		stem = conn.createStatement();
		stem.executeUpdate(sql);
	}
	
	public void AddUser(String acc,String pwd) throws SQLException{
		
		pwd = AccountMD5.getMD5(pwd);
		String sql = "select * from auth where account='"+ acc +"'";
		
		stem = conn.createStatement();
		stem.execute(sql);
		ResultSet rs = stem.getResultSet();
		if(!rs.next()) {
			sql = "insert into auth(account,password) values('"+acc+"','"+pwd+"')";
			System.out.println(sql);
			
			stem = conn.createStatement();
			stem.execute(sql);
			
		}
	}
	
}
