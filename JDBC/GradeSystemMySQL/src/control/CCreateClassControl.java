package control;

import entity.CSugang;

public class CCreateClassControl extends CControl {

	public void addlist(CSugang sugang) throws Exception {
		// TODO Auto-generated method stub
		this.getDao().connect("gangjwa");
		this.getDao().writeGangjwa(sugang);
	}
}
