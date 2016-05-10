package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.Constant.EEvent;

public class CProfessorView extends CView {

	@Override
	public EEvent show(Scanner scanner) {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		do{
			System.out.println("[교수화면]");
			System.out.println("3. 강좌개설");
			System.out.println("4. 강좌조회");
			System.out.println("5. 성적입력");
			System.out.println("6. 성적조회");
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
			}if(select != 3 && select != 4 && select != 5 && select != 6 && select != 9 && select != 0){
				System.out.println("잘못된 입력. 해당 숫자를 입력하세요.");
				continue;
			}
			break;
		}while(true);

		return selection;
	}

}
