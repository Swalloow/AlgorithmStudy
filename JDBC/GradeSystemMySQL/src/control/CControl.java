package control;

import DAOs.IDAO;
import DAOs.MySQL;

public class CControl {
	// association
	private IDAO dao = new MySQL();
	public IDAO getDao() {return dao;}
	public void setDao(IDAO dao) {this.dao = dao;}
}
