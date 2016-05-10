package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.CMain;
import main.Constant.EEvent;
import control.CRegisterControl;
import control.CSugangControl;
import entity.CGrade;
import entity.VSugang;

public class CRegisterClassView extends CView {

	@Override
	public EEvent show(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		
		VSugang vSugang = new VSugang();
		this.setControl(new CSugangControl());
		vSugang = (VSugang)((CSugangControl) this.getControl()).makelist(CMain.getvUser());
		System.out.println("[수강신청화면]");
		for(int i=0; i<vSugang.getSugangList().size()-1; i++){
			System.out.println(vSugang.getSugangList());
		}
		CGrade grade = new CGrade();
		System.out.print("수강신청할 강좌번호를 입력: ");
		grade.setGangjwaID(scanner.next());
		grade.setSugangID(CMain.getvUser().getUserID());
		grade.setHakjeom("0");
		
		this.setControl(new CRegisterControl());
		((CRegisterControl) this.getControl()).register(grade, CMain.getvUser());
		System.out.println("수강신청 완료");
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
