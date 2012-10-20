package sample01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
	public static void insert(User user) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into user (name, email) values (? , ?)";

		try {
			conn = DBManager.getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.executeUpdate();
		}finally{
			DBManager.close(conn, stmt);
		}
	}
	
	public static List<User> selectAll() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "Select * from user";

		try {
			conn = DBManager.getConn();
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
        	List<User> users = new ArrayList<>();
  
        	while(rs.next()){
        		users.add(rs2user(rs));
         	}
        	return users;
		}finally{
			DBManager.close(conn, stmt);
		}
	}
	
	public static User selectById(int id) throws SQLException{
		return null;
	}
	
	private static User rs2user(ResultSet rs) throws SQLException{
   		int id = rs.getInt("id");
		String name = rs.getString("name");
        String email = rs.getString("email");	
        return new User(id, name, email);
	}
	
}
