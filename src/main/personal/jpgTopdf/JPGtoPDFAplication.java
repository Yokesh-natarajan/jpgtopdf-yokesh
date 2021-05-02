package main.personal.jpgTopdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import main.personal.jpgTopdf.logic.JPGReader;

public class JPGtoPDFAplication {

	public static void main(String[] args) {
		Scanner scanner = null;
		JPGReader jpgReader = new JPGReader();
		Document doc = new Document();
		try {
		System.out.println("Enter the amount of jpgs to be converted to pdfs");
		int jpgs = 0;
		scanner = new Scanner(System.in);
		if(scanner.hasNext()) {
			jpgs = Integer.parseInt(scanner.next());
		}
		
		if(jpgs == 0) {
			System.out.println("No files to convert");
			return;
		}
		
		File[] file = jpgReader.readJPGs(jpgs, scanner);
		
		System.out.println("Enter destn. file name without .pdf ");
		File destnFile = null;
		if(scanner.hasNext()) {
			destnFile = new File("E://outbound/pdf/" + scanner.next() + ".pdf");
		}
		if(destnFile == null) {
			throw new Exception("No destn. file given or invalid destn. file");
		}
		
		
		PdfWriter.getInstance(doc, new FileOutputStream(destnFile));
		doc.open();
		
		for(int i = 0 ; i < jpgs ; i++) {
			Image image = Image.getInstance(file[i].getAbsolutePath());
			doc.add(image);
		}
		
		System.out.println("pdf created I guess");
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		scanner.close();
		if(doc.isOpen()) {
			doc.close();
		}
		}
	}

}
