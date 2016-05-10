package DAOs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.CEntity;
import entity.CGrade;
import entity.CSugang;
import entity.CUser;

public class MySQL implements IDAO{

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/javalms";
	private final static String ID = "java";
	private final static String PASSWORD = "mju12345";
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	private String tableName;
	
	public MySQL() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void createAccount() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306", "root", "mju12345");
		String sql = "grant all privileges on *.* to java@localhost "
				+ "identified by 'mju12345' with grant option;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.close();
	}
	
	@Override
	public void createDB() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", ID, PASSWORD);
		String sql = "create database javalms;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
		statement.close();
	}

	@Override
	public void createTable() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		statement = connection.createStatement();
		String sql = "CREATE TABLE MEMBER"
				+ "(NO INT(11) NOT NULL AUTO_INCREMENT primary key,"
				+ "ID VARCHAR(10),"
				+ "PW VARCHAR(10),"
				+ "NAME VARCHAR(10),"
				+ "TYPE VARCHAR(10));";
		statement.executeUpdate(sql);
		sql = "CREATE TABLE GANGJWA"
				+ "(NO INT(11) NOT NULL AUTO_INCREMENT primary key,"
				+ "ID VARCHAR(10),"
				+ "NAME VARCHAR(30),"
				+ "PROF_ID VARCHAR(10));";
		statement.executeUpdate(sql);
		sql = "CREATE TABLE SUGANG"
				+ "(NO INT(11) NOT NULL AUTO_INCREMENT primary key,"
				+ "ID VARCHAR(10),"
				+ "GANGJWA_ID VARCHAR(10),"
				+ "HAKJEOM VARCHAR(10));";
		
		statement.executeUpdate(sql);
		connection.close();
		statement.close();
	}

	@Override
	public void insertData() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, TYPE) "
				+ "values (?, ?, ?, ?);";
		pStatement = (PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1,  "prof1");
		pStatement.setString(2,  "profpw1");
		pStatement.setString(3,  "kim1");
		pStatement.setString(4,  "prof");
		pStatement.executeUpdate();
		pStatement.setString(1,  "stu1");
		pStatement.setString(2,  "stupw1");
		pStatement.setString(3,  "kim2");
		pStatement.setString(4,  "stu");
		pStatement.executeUpdate();
		
		sql = "INSERT INTO GANGJWA (ID, NAME, PROF_ID) "
				+ "values (?, ?, ?);";
		pStatement = (PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1,  "1");
		pStatement.setString(2,  "객체지향프로그래밍2 A반");
		pStatement.setString(3,  "prof1");
		pStatement.executeUpdate();
		pStatement.setString(1,  "2");
		pStatement.setString(2,  "소프트웨어공학 A반");
		pStatement.setString(3,  "prof1");
		pStatement.executeUpdate();
		
		sql = "INSERT INTO SUGANG (ID, GANGJWA_ID, HAKJEOM) "
				+ "values (?, ?, ?);";
		pStatement = (PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1,  "stu1");
		pStatement.setString(2,  "1");
		pStatement.setString(3,  "0");
		pStatement.executeUpdate();
		
		connection.close();
		statement.close();
	}

	@Override
	public void dropTable() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "drop table member;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
		statement.close();
	}
	
	@Override
	public void dropDB() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "drop database javalms;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
		statement.close();
	}
	
	@Override
	public void dropAccount() throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/", "root", "mju12345");
		String sql = "drop user java@localhost;";
		statement = connection.createStatement();
		statement.executeUpdate(sql);
		connection.close();
		statement.close();
	}
	
	public void updateData(String tableName, String set, int where) throws Exception {
		if (connection != null) {
			String sql = "UPDATE "+tableName; 
			if(set != null){
				sql += " SET HAKJEOM="+"'"+set+"'"+" WHERE "+"NO="+"'"+where+"';";
			}
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} else {
			connection = DriverManager.getConnection(URL, ID, PASSWORD);
			updateData(tableName, set, where);
		}
	}
	
	@Override
	public void connect(String name) throws IOException, SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		this.tableName = name;
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select* from "+ this.tableName);
	}

	@Override
	public void disconnect() throws IOException, SQLException {
		// TODO Auto-generated method stub
		if(connection==null){
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}

	@Override
	public CEntity read(CEntity entity, String ID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM member";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()){
			entity.DBRead(resultSet);
			if(entity.getID().equals(ID)){
				return entity;
			}
		}
		return null;
	}
	
	@Override
	public CEntity readDB(CEntity entity, String ID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM gangjwa";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()){
			entity.DBRead(resultSet);
		}
		return entity;
	}
	
	@Override
	public CEntity readSugang(CEntity entity, String ID) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM sugang";
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()){
			entity.DBRead(resultSet);
		}
		return entity;
	}

	@Override
	public void writeMember(CUser user) throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, TYPE) "
				+ "values (?, ?, ?, ?);";
		pStatement = (PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, user.getID());
		pStatement.setString(2, user.getPassword());
		pStatement.setString(3, user.getName());
		pStatement.setString(4, user.getType());
		pStatement.executeUpdate();
	}
	
	public void writeGangjwa(CSugang sugang) throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "INSERT INTO GANGJWA (ID, NAME, PROF_ID) "
				+ "values (?, ?, ?);";
		pStatement = (PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, sugang.getSugangID());
		pStatement.setString(2, sugang.getSugangName());
		pStatement.setString(3, sugang.getProfID());
		pStatement.executeUpdate();
	}
	
	public void writeSugang(CSugang sugang) throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "INSERT INTO SUGANG (ID, GANGJWA_ID, HAKJEOM) "
				+ "values (?, ?, ?);";
		pStatement = (PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, sugang.getID());
		pStatement.setString(2, sugang.getSugangID());
		pStatement.setString(3, sugang.getHakjeom());
		pStatement.executeUpdate();
	}
	
	public void writeGrade(CGrade grade) throws SQLException {
		// TODO Auto-generated method stub
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String sql = "INSERT INTO SUGANG (ID, GANGJWA_ID, HAKJEOM) "
				+ "values (?, ?, ?);";
		pStatement = (PreparedStatement) connection.prepareStatement(sql);
		pStatement.setString(1, grade.getSugangID());
		pStatement.setString(2, grade.getGangjwaID());
		pStatement.setString(3, grade.getHakjeom());
		pStatement.executeUpdate();
	}

}
