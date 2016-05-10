package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.Constant.EEvent;

public class CStudentView extends CView {

	@Override
	public EEvent show(Scanner scanner) {
		// TODO Auto-generated method stub
		EEvent selection;
		int select;
		do{
			System.out.println("[�л�ȭ��]");
			System.out.println("7. ������û");
			System.out.println("8. ������ȸ");
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
			}if(select != 7 && select != 8 && select != 9 && select != 0){
				System.out.println("�߸��� �Է�. �ش� ���ڸ� �Է��ϼ���.");
				continue;
			}
			break;
		}while(true);

		return selection;
	}

}
