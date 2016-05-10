package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import control.CLoginControl;
import main.CMain;
import main.Constant.EEvent;
import entity.VLogin;
import entity.VUser;
import entity.VUser.EUserType;
import exception.PasswordNotMatchException;
import exception.UserIDNotFoundException;

public class CLoginView extends CView {
	
	public EEvent show(Scanner scanner) throws Exception {
		// input from keyboard using scanner
		EEvent selection = null;
		do{
			VLogin vLogin = new VLogin();
			this.setControl(new CLoginControl());
			System.out.print("아이디입력: ");
			String userId = scanner.next();
			System.out.print("비밀번호입력: ");
			String password = scanner.next();
			vLogin.setUserID(userId);
			vLogin.setPassword(password);

			VUser vUser = new VUser();

			try {
				vUser = ((CLoginControl)this.getControl()).login(vLogin);
			}catch (UserIDNotFoundException | PasswordNotMatchException | IOException | SQLException e) {
				if (e instanceof UserIDNotFoundException) {
					System.out.println("해당 하는 ID가 없습니다");
					continue;
				}else if (e instanceof PasswordNotMatchException) {
					System.out.println("비밀번호가 틀렸습니다");
					continue;
				}else e.printStackTrace();
			}


			System.out.println(vUser.getName()+"님 로그인 되었습니다");
			CMain.setvUser(vUser);

			if(vUser.geteUserType().equals(EUserType.EStudent)){
				selection = EEvent.eStudent;
			}else {
				selection = EEvent.eProfessor;
			}
			break;
		}while(true);
		
		return selection;
	}

}
