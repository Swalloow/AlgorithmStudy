package control;

import entity.CGrade;
import entity.VUser;

public class CGetGradeControl extends CControl {

	public CGrade getGrade(CGrade grade, VUser getvUser) throws Exception {
		// TODO Auto-generated method stub
		this.getDao().connect("sugang");
		grade = (CGrade) this.getDao().readSugang(grade, getvUser.getUserID());
		
		if(grade!=null){
			grade.setSugangList(grade.getSugangList());
			return grade;
		}
		return grade;
	}
}
