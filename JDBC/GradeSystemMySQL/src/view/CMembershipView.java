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
		System.out.println("[ȸ������ȭ��]");
		System.out.print("���̵� �Է��ϼ���: ");
		user.setID(scanner.next());
		System.out.print("�н����带 �Է��ϼ���: ");
		user.setPassword(scanner.next());
		System.out.print("�̸��� �Է��ϼ���: ");
		user.setName(scanner.next());
		do{
			System.out.print("stu/prof �Է��ϼ���: ");
			try{
				user.setType(scanner.next());
			}catch(InputMismatchException e){
				System.out.println("�߸��� �Է�. �ش� ���ڸ� �Է��ϼ���.");
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
			System.out.println("9. �����޴��� �̵�");
			System.out.println("0. �α׾ƿ�");
			System.out.print("�޴�����: ");
			try{
				select = scanner.nextInt();
				selection = EEvent.values()[select];
			}catch(InputMismatchException e){
				System.out.println("�߸��� �Է�. �ش� ���ڸ� �Է��ϼ���.");
				scanner.nextLine();
				continue;
			}if(select != 9 && select != 0){
				System.out.println("�߸��� �Է�. �ش� ���ڸ� �Է��ϼ���.");
				continue;
			}
			break;
		}while(true);
		
		return selection;
	}

}
