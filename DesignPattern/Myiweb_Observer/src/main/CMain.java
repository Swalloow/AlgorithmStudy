package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CMain {

	public static void main(String[] args) {

		CSubjectManager cSubjectManager = new CSubjectManager();
		CClassData classData = new CClassData();
		CConsoleDisplay consoleDisplay = new CConsoleDisplay(classData);
//		CPanelDisplay cPanelDisplay = new CPanelDisplay(cClassData);

		BufferedReader br = null;
		InputStreamReader isr = null;    
		FileInputStream fis = null;        
		Scanner scan = new Scanner(System.in);
		File file = new File("subject");
		String temp = "";

		// read subject list
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "euc-kr");
			br = new BufferedReader(isr);

			while( (temp = br.readLine()) != null) {
				cSubjectManager.addSubject(temp);
			}

			// start Myiweb System
			System.out.println("================== MyoungJi Myiweb System ==================");
			cSubjectManager.showsubjectList();
			System.out.println("================== subjectList ==================");
			temp = scan.nextLine();
			CSubjectData subject = cSubjectManager.getsubject(temp);
			if(subject == null) {
				System.out.println("There has no subject.");
			}
			else {
				while(true) {
					System.out.println("Create new class? (Y/N)");
					if(scan.nextLine().toUpperCase().equals("Y")) {
						// class information input
						String classNumber, gyosuName, time, room, studentNumber;
						System.out.println(subject.getName());
						System.out.print("Please write classNumber : ");
						classNumber = scan.nextLine();
						System.out.print("Please write gyosuName : ");
						gyosuName = scan.nextLine();
						System.out.print("Please write studentNumber: ");
						studentNumber = scan.nextLine();
						System.out.print("Please write time : ");
						time = scan.nextLine();
						System.out.print("Please write room : ");
						room = scan.nextLine();
						System.out.println("Are you sure make class? (Y/N)");
						if(scan.nextLine().toUpperCase().equals("Y")) {
							classData.setData(subject.getName(), classNumber, gyosuName, studentNumber, time, room);
						}
					} else {
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			scan.close();
		}
	}
}