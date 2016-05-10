package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import control.CGradeControl;
import control.CSugangControl;
import entity.CSugang;
import entity.VSugang;
import entity.VUser;
import main.CMain;
import main.Constant.EEvent;

public class CSetGradeView extends CView {

	@Override
	public EEvent show(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		
		VUser vUser = new VUser();
		CSugang sugang = new CSugang();
		this.setControl(new CSugangControl());
		VSugang vSugang = (VSugang)((CSugangControl) this.getControl()).makelist(CMain.getvUser());
		
		System.out.println("[성적입력화면]");
		for(int i=0; i<vSugang.getSugangList().size()-1; i++){
			System.out.print(vSugang.getSugangList()+": ");
			sugang.setHakjeom(scanner.next());
		}
		this.setControl(new CGradeControl());
		((CGradeControl) this.getControl()).makeGrade(sugang, CMain.getvUser());
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
