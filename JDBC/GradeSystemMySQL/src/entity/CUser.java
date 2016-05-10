package entity;

import java.io.BufferedWriter;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CUser extends CEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String password;
	private String name;
	private String type;
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	@Override
	public void read(Scanner scanner) {
		ID = scanner.next();
		password = scanner.next();
		name = scanner.next();
	}
	@Override
	public void write(BufferedWriter scanner) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DBRead(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ID = rs.getString("id");
		password = rs.getString("pw");
		name = rs.getString("name");
		type = rs.getString("type");
	}
	@Override
	public void DBWrite(PreparedStatement pstmt) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}






