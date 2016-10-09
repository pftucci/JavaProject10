
public class PersonalContact extends AbstractContact {

	public String facebookUsername;
	public String whatsAppUsername;

	public PersonalContact(String name, String email, String phoneNumber, String facebookUsername,
			String whatsAppUsername) throws InvalidEmailException2, InvalidPhoneNumberException2 {
		super(name, email, phoneNumber);
		this.facebookUsername = facebookUsername;
		this.whatsAppUsername = whatsAppUsername;
	}

	public String getStringToPrint() {
		String x = "\nName: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nFacebook Username: "
				+ facebookUsername + "\nWhatsApp Username: " + whatsAppUsername;
		return x;
	}

	public String getFacebookUsername() {
		return facebookUsername;
	}

	public void setFacebookUsername(String facebookUsername) {
		this.facebookUsername = facebookUsername;
	}

	public String getWhatsAppUsername() {
		return whatsAppUsername;
	}

	public void setWhatsAppUsername(String whatsAppUsername) {
		this.whatsAppUsername = whatsAppUsername;
	}

}
