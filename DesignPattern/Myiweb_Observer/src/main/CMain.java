package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import display.ConsoleDisplay;
import display.PanelDisplay;
import subject.ClassData;
import subject.SubjectData;

public class CMain {

	public static void main(String[] args) {

		SubjectManager subjectManager = new SubjectManager();
		ClassData classData = new ClassData();
//		ConsoleDisplay consoleDisplay = new ConsoleDisplay(classData);
		PanelDisplay panelDisplay = new PanelDisplay(classData);

		BufferedReader br = null;        
		InputStreamReader isr = null;    
		FileInputStream fis = null;        
		Scanner scan = new Scanner(System.in);
		File file = new File("subject");
		String temp = "";

		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "euc-kr");
			br = new BufferedReader(isr);

			while( (temp = br.readLine()) != null) {
				subjectManager.addSubject(temp);
			}

			System.out.println("================== MyoungJi Myiweb System ==================");
			subjectManager.showsubjectList();
			System.out.println("================== subjectList ==================");
			temp = scan.nextLine();
			SubjectData subject = subjectManager.getsubject(temp);
			if(subject == null) {
				System.out.println("There has no subject.");
			}
			else {
				while(true) {
					System.out.println("Create new class? (Y/N)");
					if(scan.nextLine().toUpperCase().equals("Y")) {
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
		}
	}
}