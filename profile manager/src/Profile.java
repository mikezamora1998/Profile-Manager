import java.io.File;

public class Profile{
	
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
	
	public Profile(){
		name = "FirstName LastName";
		phone = "###.###.####";
		email = "xx.xxxxx@csupueblu.edu";
		url = urlBase + "firstName-lastName" + urlEnd; 
		hasPhone = false;
		hasEmail = false;
		hasURL = false;
	}
	
	public String toString(){
		return "[ Name: " + name + ", Phone: " + phone + ", Email: " + email + ", URL: " + url + ", HasPhone: " + hasPhone + ", HasEmail: " + hasEmail + ", hasURL: " + hasURL + ", hasPicture: " + hasPicture + "]";
	}
	
	private String name;
	private String phone;
	private String email;
	private String url;
	private boolean hasPhone;
	private boolean hasEmail;
	private boolean hasURL;
	private boolean hasPicture;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isHasPhone() {
		return hasPhone;
	}
	public void setHasPhone(boolean hasPhone) {
		this.hasPhone = hasPhone;
	}
	public boolean isHasEmail() {
		return hasEmail;
	}
	public void setHasEmail(boolean hasEmail) {
		this.hasEmail = hasEmail;
	}
	public boolean isHasURL() {
		return hasURL;
	}
	public void setHasURL(boolean hasURL) {
		this.hasURL = hasURL;
	}
	public boolean isHasPicture() {
		return hasPicture;
	}
	public void setHasPicture(boolean hasPicture) {
		this.hasPicture = hasPicture;
	}
}
