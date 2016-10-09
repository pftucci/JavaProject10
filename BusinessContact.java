
public class BusinessContact extends AbstractContact {

	public String companyName;
	public String linkedInUsername;


	public BusinessContact(String name, String email, String phoneNumber, String companyName, String linkedInUsername)
			throws InvalidEmailException2, InvalidPhoneNumberException2 {
		super(name, email, phoneNumber);
		this.companyName = companyName;
		this.linkedInUsername = linkedInUsername;
	}
	
	public String getStringToPrint() {
		String x = "\nName: " + name + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nCompany Name: "
				+ companyName + "\nLinkedIn Username: " + linkedInUsername;
		return x;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLinkedInUsername() {
		return linkedInUsername;
	}

	public void setLinkedInUsername(String linkedInUsername) {
		this.linkedInUsername = linkedInUsername;
	}

}
