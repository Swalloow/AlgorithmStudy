package main;

import java.util.Scanner;

import entity.VUser;
import DAOs.IDAO;
import DAOs.MySQL;
import main.Constant.EEvent;
import view.CMainView;
import view.CProfessorView;
import view.CStudentView;
import view.CView;

public class CMain {
	
	private static VUser vuser;
	public static VUser getvUser() {return vuser;}
	public static void setvUser(VUser vUser) {vuser = vUser;}

	public static void main(String[] args) {
		
		try {
			IDAO dao = new MySQL();
			dao.createAccount();
			dao.createDB();
			dao.createTable();
			dao.insertData();
			
			Scanner scanner = new Scanner(System.in);
			CMainView mainView = new CMainView();
			EEvent selection = mainView.show(scanner);

			CProfessorView professorView = new CProfessorView();
			CStudentView studentView = new CStudentView();

			EEvent.eProfessor.setPreView(mainView);
			EEvent.eStudent.setPreView(mainView);
			EEvent.eMembership.setPreView(mainView);
			EEvent.eReturn.setPreView(mainView);
			EEvent.eCreateClass.setPreView(professorView);
			EEvent.eGetClass.setPreView(professorView);
			EEvent.eSetGrade.setPreView(professorView);
			EEvent.eGetGradeP.setPreView(professorView);
			EEvent.eRegisterClass.setPreView(studentView);
			EEvent.eGetGradeS.setPreView(studentView);

			EEvent temp = null;
			while(selection!=EEvent.eLogout){
				if(selection==EEvent.eReturn){
					CView view = temp.getPreView();
					temp = view.show(scanner);
					selection = temp;
				}else if(selection==EEvent.eLogout){
					break;
				}else {
					temp = selection;
					CView view = selection.getView();
					selection = view.show(scanner);
				}
			}
			scanner.close();
			
			dao.dropTable();
			dao.dropDB();
			dao.dropAccount();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}