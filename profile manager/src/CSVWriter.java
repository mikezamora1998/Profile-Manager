import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVWriter {
	public CSVWriter(ArrayList<Profile> profile) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("assets/output.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        StringBuilder sb = new StringBuilder();
        sb.append("Name");
        sb.append(',');
        sb.append("Phone");
        sb.append(',');
        sb.append("Email");
        sb.append(',');
        sb.append("Has Picture");
        sb.append(',');
        sb.append("Has Phone");
        sb.append(',');
        sb.append("Has Email");
        sb.append(',');
        sb.append("404 Error");
        sb.append(',');
        sb.append("URL");
        sb.append('\n');

        int i = 0;
        while(profile.size() > i) {
	        sb.append(profile.get(i).getName());
	        sb.append(',');
	        sb.append(profile.get(i).getPhone());
	        sb.append(',');
	        sb.append(profile.get(i).getEmail());
	        sb.append(',');
	        sb.append(profile.get(i).isHasPicture());
	        sb.append(',');
	        sb.append(profile.get(i).isHasPhone());
	        sb.append(',');
	        sb.append(profile.get(i).isHasEmail());
	        sb.append(',');
	        sb.append(profile.get(i).isHasURL());
	        sb.append(',');
	        sb.append(profile.get(i).getUrl());
	        sb.append('\n');
	        i++;
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
	}
}
