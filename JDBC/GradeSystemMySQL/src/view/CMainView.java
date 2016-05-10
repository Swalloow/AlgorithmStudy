package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.Constant.EEvent;

public class CMainView extends CView {

	@Override
	public EEvent show(Scanner scanner) {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		do{
			System.out.println("[�л���� �ý���]");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.println("0. ����");
			System.out.print("�޴�����: ");
			try{
				select = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("�߸��� �Է�. �ش� ���ڸ� �Է��ϼ���.");
				scanner.nextLine();
				continue;
			}if(select != 1 && select != 2 && select != 0){
				System.out.println("�߸��� �Է�. �ش� ���ڸ� �Է��ϼ���.");
				continue;
			}
			selection = EEvent.values()[select];
			break;
		}while(true);

		return selection;
	}
	
}
