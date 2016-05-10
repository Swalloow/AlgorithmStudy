package DAOs;

import entity.CEntity;
import entity.CGrade;
import entity.CSugang;
import entity.CUser;

public interface IDAO {
	public void connect(String name) throws Exception;
	public void disconnect() throws Exception;
	
	public void createAccount() throws Exception;
	public void createDB() throws Exception;
	public void createTable() throws Exception;
	public void insertData() throws Exception;
	public void dropTable() throws Exception;
	public void dropDB() throws Exception;
	public void dropAccount() throws Exception;
	public void updateData(String tablename, String set, int where) throws Exception;
	
	public CEntity read(CEntity entity, String ID) throws Exception;
	public void writeMember(CUser user) throws Exception;
	public void writeGangjwa(CSugang sugang) throws Exception;
	public void writeSugang(CSugang sugang) throws Exception;
	public void writeGrade(CGrade grade) throws Exception;
	CEntity readDB(CEntity entity, String ID) throws Exception;
	CEntity readSugang(CEntity entity, String ID) throws Exception;
}
