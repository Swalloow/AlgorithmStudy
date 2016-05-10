package main;

import view.CCreateClassView;
import view.CGetClassView;
import view.CGetGradeSView;
import view.CGetGradeView;
import view.CLoginView;
import view.CMembershipView;
import view.CProfessorView;
import view.CRegisterClassView;
import view.CSetGradeView;
import view.CStudentView;
import view.CView;

public class Constant {
	public enum EEvent {
		eLogout(null),
		eSignIn(new CLoginView()),
		eMembership(new CMembershipView()),
		eCreateClass(new CCreateClassView()), 
		eGetClass(new CGetClassView()),
		eSetGrade(new CSetGradeView()),
		eGetGradeP(new CGetGradeView()),
		eRegisterClass(new CRegisterClassView()),
		eGetGradeS(new CGetGradeSView()),
		eReturn(null),
		eProfessor(new CProfessorView()),
		eStudent(new CStudentView());
		
		private CView view;
		private CView preView;
		private EEvent(CView view) {
			this.setView(view);
		}
		public void add(CView view){
			this.setPreView(view);
		}
		public CView getView() {return view;}
		public void setView(CView view) {this.view = view;}
		public CView getPreView() {return preView;}
		public void setPreView(CView preView) {this.preView = preView;}
	}
}
