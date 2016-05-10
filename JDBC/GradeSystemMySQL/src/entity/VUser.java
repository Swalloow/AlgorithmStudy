package entity;

public class VUser {
	// attributes
	public enum EUserType {EProfessor, EStudent};
	private String userID;
	private String name;
	private EUserType eUserType;
	
	public String getUserID() {return userID;}
	public void setUserID(String userID) {this.userID = userID;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public EUserType geteUserType() {return eUserType;}
	public void seteUserType(EUserType eUserType) {this.eUserType = eUserType;}
	
}
