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
			System.out.println("[����ȭ��]");
			System.out.println("3. ���°���");
			System.out.println("4. ������ȸ");
			System.out.println("5. �����Է�");
			System.out.println("6. ������ȸ");
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
			}if(select != 3 && select != 4 && select != 5 && select != 6 && select != 9 && select != 0){
				System.out.println("�߸��� �Է�. �ش� ���ڸ� �Է��ϼ���.");
				continue;
			}
			break;
		}while(true);

		return selection;
	}

}
