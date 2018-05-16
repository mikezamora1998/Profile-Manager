import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Formatter {
	
	public static void main(String[] args) {
		ArrayList<String> name = new ArrayList<String>();
		
		
		
		File file = new File("assets/Updated-Names.txt");
		try {
			Scanner s = new Scanner(file);
			
			while(s.hasNextLine()){
				String line = s.nextLine();
				
				String[] splitString = line.split("-");
				String first = splitString[0];
				String last = splitString[1];
				if(splitString.length>2) {
					last = last + "-" + splitString[2];
				}
				name.add(first + " " + last);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			File output = new File("assets/output.txt");
			int currentLine = 0;
			if(output.exists()) {
				output.delete();
			}
			output.createNewFile();
			
			PrintWriter printWriter = new PrintWriter(output);
			Collections.sort(name);
			for(int i = 0; i < name.size(); i++) {
				printWriter.println(name.get(i));
				currentLine++;
			}
			printWriter.close();
		}catch(java.io.IOException e) {
			e.printStackTrace();
		}
	}

}
