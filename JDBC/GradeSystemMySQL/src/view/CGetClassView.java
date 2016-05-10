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
		System.out.println("[������ȸȭ��]");
		System.out.println("���¹�ȣ-�̸�-�����̸�");
		for(int i=0; i<vSugang.getSugangList().size()-1; i++){
			System.out.println(vSugang.getSugangList());
		}
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
