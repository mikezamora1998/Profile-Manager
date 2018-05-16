import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Skimmer {
	
	private ArrayList<Profile> profile = new ArrayList<Profile>();
	
	private File inputFile = new File("assets/ProfileNames.txt");

	// Url parts.
	public String urlBase = "https://www.csupueblo.edu/profile/";
	public String urlEnd = "/index.html";
	
	public String startStaffInfo = "<!-- START: Staff Info -->";
	public String endStaffInfo = "<!-- END: Staff Info -->";

	// Placeholder images.
	private String noImg1 = "pro-no-image-226x300.jpg";
	private String noImg2 = "pro-female-blank-226x300.jpg";
	private String noImg3 = "pro-male-blank-226x300.jpg";
	private String noImg4 = "pro-profile-contact-us-226x300.jpg";

	// Element strings.
	private String phoneHTML = "<div class=\"phone\">";
	private String emailHTML = "<div class=\"email\">";
	
	public Skimmer() {
		Scanner s = null;
		try {
			ArrayList<String> inFile = new ArrayList<String>();
			s = new Scanner(inputFile);
			
			while(s.hasNextLine()) {
				inFile.add(s.nextLine());
			}
		
		int i = 0;
		while(i < inFile.size()) {
			System.out.println(i);
			Profile pro = webScanner(inFile.get(i));
			//System.out.println(i);
			profile.add(pro);
			System.out.println(pro);
			i++;
		}
		
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
	}
	
	public Profile webScanner(String p)  {
		System.out.println(p);// Prints current profile.
		
		Profile pro = new Profile();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new URL(urlBase + p.toLowerCase() + urlEnd).openConnection().getInputStream()));
			
			boolean staffInfo = false;
			String line;
			while ((line = br.readLine()) != null) {
				
				if(line.contains(startStaffInfo)) {
					staffInfo = true;
				}
				if(line.contains(endStaffInfo)) {
					staffInfo = false;
				}
				
				if(staffInfo) {
					// Begin: Name
					if(p.split("-").length < 3) pro.setName(p.split("-")[0].substring(0, 1).toUpperCase() + p.split("-")[0].substring(1) + " " + 
								p.split("-")[1].substring(0, 1).toUpperCase() + p.split("-")[1].substring(1));
					else pro.setName(p.split("-")[0].substring(0, 1).toUpperCase() + p.split("-")[0].substring(1) + " " + 
							p.split("-")[1].substring(0, 1).toUpperCase() + p.split("-")[1].substring(1) + "-" + p.split("-")[2]);
					// End: Name
					
					// Begin: Phone
					if (line.contains(phoneHTML)) {
						String phone;
						if((phone = line.replaceAll("\\D+", "")).length() <= 20)
							pro.setPhone(phone.substring(0, phone.length() / 2).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1.$2.$3")); // Formats the number to ###.###.####.
						else 
							pro.setPhone(phone.substring(0, (phone.length() / 2)/2).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1.$2.$3") + " OR " + 
										phone.substring((phone.length() / 2)/2, phone.length() / 2).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1.$2.$3")); // Formats the number to ###.###.####.
						pro.setHasPhone(true);
					}// End: Phone

					// Begin: Email
					if (line.contains(emailHTML) && line.contains("@")) {
						pro.setEmail(line.substring(line.indexOf(":") + 1, line.indexOf("\">", line.indexOf(":"))).toLowerCase().replaceAll("\\s+", ""));
						pro.setHasEmail(true);
					}// End: Email
		            
		            // Begin: URL
		            pro.setUrl(urlBase + p + urlEnd);
		            pro.setHasURL(true);
		            // End: URL
		            
		            // Begin: Picture
		            if(line.contains("<div class=\"col3 staff-img\">")) {
		            	String line2 = br.readLine();
		            	pro.setHasPicture(!(line2.contains(noImg1) || line2.contains(noImg2) || line2.contains(noImg3) || line2.contains(noImg4)));
		            }// End: Picture
				}
			}
			return pro;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			pro.setHasURL(false);
        } catch (IOException e) {
			e.printStackTrace();
		}
		pro.setName(p.split("-")[0].substring(0, 1).toUpperCase() + p.split("-")[0].substring(1) + " " + 
					p.split("-")[1].substring(0, 1).toUpperCase() + p.split("-")[1].substring(1));
		return pro;
	}

	public ArrayList<Profile> getInfoList() {
		return profile;
	}
}
