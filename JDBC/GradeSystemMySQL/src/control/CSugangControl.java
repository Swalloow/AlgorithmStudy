package control;

import entity.CSugang;
import entity.VSugang;
import entity.VUser;

public class CSugangControl extends CControl {
	public VSugang makelist(VUser vUser) throws Exception{
		VSugang vSugang = new VSugang();
		CSugang cSugang = new CSugang();
		cSugang.setID(vUser.getUserID());
		this.getDao().connect("sugang");
		cSugang = (CSugang) this.getDao().readDB(cSugang, vUser.getUserID());
		
		if(cSugang!=null){
			vSugang.setSugangList(cSugang.getSugangList());
			return vSugang;
		}

		return vSugang;
	}

}
