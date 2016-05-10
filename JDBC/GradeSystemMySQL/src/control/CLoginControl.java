package control;

import entity.CUser;
import entity.VLogin;
import entity.VUser;
import entity.VUser.EUserType;
import exception.PasswordNotMatchException;
import exception.UserIDNotFoundException;

public class CLoginControl extends CControl {
	public VUser login(VLogin vLogin) throws Exception {
		// TODO Auto-generated method stub
		VUser vUser = new VUser();
		CUser user = new CUser();
		this.getDao().connect("member");
		user = (CUser)this.getDao().read(user, vLogin.getUserID());
		
		if (user==null)
			throw new UserIDNotFoundException();
		if (!user.getPassword().equals(vLogin.getPassword()))
			throw new PasswordNotMatchException();
		
		user.setID(vLogin.getUserID());
		vUser.setName(user.getName());
		vUser.setUserID(user.getID());
		
		if(user.getType().equals("stu")){
			vUser.seteUserType(EUserType.EStudent);
		}else {
			vUser.seteUserType(EUserType.EProfessor);
		}
		
		return vUser;
	}
}
