package control;

import java.util.Scanner;

import entity.CSugang;
import entity.VUser;

public class CGradeControl extends CControl {
	
	public void makeGrade(CSugang sugang, VUser user) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		this.getDao().connect("sugang");
		System.out.print("학생번호를 입력: ");
		int number = scanner.nextInt();
		this.getDao().updateData("sugang", sugang.getHakjeom(), number);
	}
}
