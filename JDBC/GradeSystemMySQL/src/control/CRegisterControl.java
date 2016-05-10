package control;

import entity.CGrade;
import entity.VUser;

public class CRegisterControl extends CControl {

	public void register(CGrade grade, VUser getvUser) throws Exception {
		// TODO Auto-generated method stub
		this.getDao().connect("sugang");
		this.getDao().writeGrade(grade);
	}

}
