package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.CMain;
import main.Constant.EEvent;
import control.CGetGradeControl;
import entity.CGrade;

public class CGetGradeSView extends CView {

	@Override
	public EEvent show(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		
		CGrade grade = new CGrade();
		this.setControl(new CGetGradeControl());
		grade = ((CGetGradeControl) this.getControl()).getGrade(grade, CMain.getvUser());
		
		System.out.println("[성적조회화면]");
		for(int i=0; i<grade.getSugangList().size()-1; i++){
			System.out.println(grade.getSugangList());
		}
		do{
			System.out.println("9. 이전메뉴로 이동");
			System.out.println("0. 로그아웃");
			System.out.print("메뉴선택: ");
			try{
				select = scanner.nextInt();
				selection = EEvent.values()[select];
			}catch(InputMismatchException e){
				System.out.println("잘못된 입력. 해당 숫자를 입력하세요.");
				scanner.nextLine();
				continue;
			}if(select != 9 && select != 0){
				System.out.println("잘못된 입력. 해당 숫자를 입력하세요.");
				continue;
			}
			break;
		}while(true);
		
		return selection;
	}

}
