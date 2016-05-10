package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.Constant.EEvent;
import control.CCreateClassControl;
import entity.CSugang;

public class CCreateClassView extends CView {

	@Override
	public EEvent show(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;

		CSugang sugang = new CSugang();
		this.setControl(new CCreateClassControl());

		System.out.println("[강좌개설화면]");
		System.out.print("강좌번호: ");
		sugang.setSugangID(scanner.next());
		System.out.print("강좌명: ");
		sugang.setSugangName(scanner.next());
		System.out.print("교수명: ");
		sugang.setProfID(scanner.next());
		((CCreateClassControl) this.getControl()).addlist(sugang);

		System.out.println("강좌가 개설되었습니다.");
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
