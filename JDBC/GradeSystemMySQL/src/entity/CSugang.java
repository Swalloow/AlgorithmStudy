package entity;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSugang extends CEntity implements Serializable {
	//Attribute
	private static final long serialVersionUID = 1L;
	private String sugangID;
	private String sugangName;
	private String profID;
	private String hakjeom;
	private ArrayList<String> sugangList = new ArrayList<String>();
	
	//Method
	public String getSugangID() {return sugangID;}
	public void setSugangID(String sugangID) {this.sugangID = sugangID;}
	public String getSugangName() {return sugangName;}
	public void setSugangName(String sugangName) {this.sugangName = sugangName;}
	public String getProfID() {return profID;}
	public void setProfID(String profID) {this.profID = profID;}
	public String getHakjeom() {return hakjeom;}
	public void setHakjeom(String hakjeom) {this.hakjeom = hakjeom;}
	public ArrayList<String> getSugangList() {return sugangList;}
	public void setSugangList(ArrayList<String> sugangList) {this.sugangList = sugangList;}
	
	public void read(Scanner scanner){
		String temp = scanner.nextLine();
		String token[] = temp.split(" ");
		this.ID = token[0];
		this.sugangList.clear();
		for(int i=1; i<token.length; i++){
			String s = token[i];
			this.sugangList.add(s);
		}
	}
	@Override
	public void write(BufferedWriter bufferWriter) throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DBRead(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		sugangID = rs.getString("id");
		sugangName = rs.getString("name");
		profID = rs.getString("prof_id");
		this.sugangList.add(sugangID+" "+sugangName+" "+profID);
	}
	@Override
	public void DBWrite(PreparedStatement pstmt) throws SQLException {
		// TODO Auto-generated method stub
	}

}