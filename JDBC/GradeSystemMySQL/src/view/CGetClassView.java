package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.CMain;
import main.Constant.EEvent;
import control.CSugangControl;
import entity.VSugang;

public class CGetClassView extends CView {

	@Override
	public EEvent show(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		this.setControl(new CSugangControl());
		VSugang vSugang = (VSugang)((CSugangControl) this.getControl()).makelist(CMain.getvUser());
		System.out.println("[강좌조회화면]");
		System.out.println("강좌번호-이름-교수이름");
		for(int i=0; i<vSugang.getSugangList().size()-1; i++){
			System.out.println(vSugang.getSugangList());
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
