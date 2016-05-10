package control;

import entity.CUser;

public class CMembershipControl extends CControl {

	public void membership(CUser user) throws Exception {
		this.getDao().connect("member");
		this.getDao().writeMember(user);
	}

}
