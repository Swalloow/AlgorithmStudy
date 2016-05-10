package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.Constant.EEvent;
import control.CMembershipControl;
import entity.CUser;

public class CMembershipView extends CView {
	
	@Override
	public EEvent show(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		
		CUser user = new CUser();
		this.setControl(new CMembershipControl());
		System.out.println("[회원가입화면]");
		System.out.print("아이디를 입력하세요: ");
		user.setID(scanner.next());
		System.out.print("패스워드를 입력하세요: ");
		user.setPassword(scanner.next());
		System.out.print("이름을 입력하세요: ");
		user.setName(scanner.next());
		do{
			System.out.print("stu/prof 입력하세요: ");
			try{
				user.setType(scanner.next());
			}catch(InputMismatchException e){
				System.out.println("잘못된 입력. 해당 문자를 입력하세요.");
				scanner.nextLine();
				continue;
			}
			if(!user.getType().equals("stu") && !user.getType().equals("prof")){
				scanner.nextLine();
				continue;
			}
			break;
		}while(true);
		((CMembershipControl)this.getControl()).membership(user);
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
