package main.personal.jpgTopdf.logic;

import java.io.File;
import java.util.Scanner;

public class JPGReader {
	
	private final String INPUT_PATH = "E://inbound/pdf/"; 
	
	public File[] readJPGs(int jpgs , Scanner scanner) {
		File[] jpgFiles = new File[jpgs];
		
		for(int i = 0 ; i < jpgs ; i++) {
			System.out.println("Enter file name from E://inbound/pdf/");
			if(scanner.hasNext()) {
				jpgFiles[i] = new File(INPUT_PATH + scanner.next());
			}
		}
		
		return jpgFiles;
	}

}
