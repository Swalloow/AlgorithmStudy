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

		System.out.println("[���°���ȭ��]");
		System.out.print("���¹�ȣ: ");
		sugang.setSugangID(scanner.next());
		System.out.print("���¸�: ");
		sugang.setSugangName(scanner.next());
		System.out.print("������: ");
		sugang.setProfID(scanner.next());
		((CCreateClassControl) this.getControl()).addlist(sugang);

		System.out.println("���°� �����Ǿ����ϴ�.");
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
