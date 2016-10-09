
public abstract class AbstractContact {

	protected String name;
	protected String email;
	protected String phoneNumber;

	public AbstractContact(String name, String email, String phoneNumber) throws InvalidEmailException2, InvalidPhoneNumberException2 {
		super();
		this.name = name;
		
		if (email.contains("@") && email.contains(".")) {
			this.email = email;
		} else {
			throw new InvalidEmailException2(email);
		}
		
		if (phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidPhoneNumberException2(phoneNumber);
		}

	}

	public abstract String getStringToPrint();
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws InvalidEmailException2 {
		if (email.contains("@") && email.contains(".")) {
			this.email = email;
		} else {
			throw new InvalidEmailException2(email);
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException2{
		if (phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidPhoneNumberException2(phoneNumber);
		}
	}

}
