import java.util.Scanner;
import java.util.ArrayList;

public class AddressBookWithContactTypes {
	
	static ArrayList<AbstractContact> contactsInAddressBook = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		
		int menuChoice = 0;
	
		
		do {
			menu();
			menuChoice = input.nextInt();
			input.nextLine();
			
			switch (menuChoice) {
				case 1:
					addNewContact(input);
					break;
				case 2:
					displayAllContacts();
					editAContact(input);
					break;
				case 3: 
					displayAllContacts();
					deleteAContact(input);
					break;
				case 4:
					displayAllContacts();
					break;
			}	
		} while (menuChoice != 5);
		
	}
	
	public static void menu() {
		if (contactsInAddressBook.isEmpty()) {
			System.out.println("There are no contacts stored.");
		} else {
			System.out.println("\nAddress Book: ");
			for (AbstractContact c:contactsInAddressBook){
				if (c instanceof PersonalContact) {
					System.out.println(((PersonalContact) c).getStringToPrint()); 
				} else if (c instanceof BusinessContact) {
					System.out.println(((BusinessContact) c).getStringToPrint());
				}
			}
		}
		
		System.out.println("\nWhat would you like to do? Select an option from the menu.");
		System.out.println("1) Add a new contact");
		System.out.println("2) Edit an existing contact");
		System.out.println("3) Delete an existing contact");
		System.out.println("4) Display all contacts");
		System.out.println("5) Exit");
	}
	
	public static void addNewContact(Scanner input) {
		AbstractContact x = null;
		String contactFacebookUsername = null;
		String contactWhatsAppUsername = null;
		String contactCompanyName = null;
		String contactLinkedInUsername = null;
		
		
		System.out.println("What type of contact would you like to create?");
		System.out.println("1) Personal");
		System.out.println("2) Business");
		int typeOfContact = input.nextInt();
		input.nextLine();
		
		do {
			System.out.println("Enter contact's name.");
			String contactName = input.nextLine();
			
			System.out.println("Enter contact's email.");
			String contactEmail = input.nextLine();
			
			System.out.println("Enter contact's phone number.");
			String contactPhoneNumber = input.nextLine();	
				
			if (typeOfContact == 1) {
				System.out.println("Enter the contact's Facebook username.");
				contactFacebookUsername = input.nextLine();
				
				System.out.println("Enter the contact's WhatsApp username.");
				contactWhatsAppUsername = input.nextLine();
				
				try {
					x = new PersonalContact(contactName, contactEmail, contactPhoneNumber, contactFacebookUsername, contactWhatsAppUsername);
				} catch (InvalidEmailException2 | InvalidPhoneNumberException2 e) {
					System.out.println(e.getMessage());
				}
			} else if (typeOfContact == 2) {
				System.out.println("Enter the contact's Company name.");
				contactCompanyName = input.nextLine();
				
				System.out.println("Enter the contact's LinkedIn username.");
				contactLinkedInUsername = input.nextLine();
				
				try {
					x = new BusinessContact(contactName, contactEmail, contactPhoneNumber, contactCompanyName, contactLinkedInUsername);
				} catch (InvalidEmailException2 | InvalidPhoneNumberException2 e) {
					System.out.println(e.getMessage());
				}
			}	
		
		} while (x == null);
		
		contactsInAddressBook.add(x);
		
	}	
	
	public static void editAContact(Scanner input) {
		int editOption = 0;
	
		System.out.println("\nWhich contact would you like to edit? Enter its index.");
		int contactToEdit = input.nextInt();
		
		AbstractContact selectedContact = contactsInAddressBook.get(contactToEdit);
		
		do {
	
			System.out.println("What would you like to edit about contact?\n");
			System.out.println("1) Edit Name: " + selectedContact.getName());
			System.out.println("2) Edit Email: " + selectedContact.getEmail());
			System.out.println("3) Edit Phone number: " + selectedContact.getPhoneNumber());
			
			if (selectedContact instanceof PersonalContact) {
				System.out.println("4) Edit Facebook Username: " + ((PersonalContact) selectedContact).getFacebookUsername());
				System.out.println("5) Edit WhatsApp Username: " + ((PersonalContact) selectedContact).getWhatsAppUsername());
			} else if (selectedContact instanceof BusinessContact) {
				System.out.println("4) Edit Company Name: " + ((BusinessContact) selectedContact).getCompanyName());
				System.out.println("5) Edit Linkedin Username: " + ((BusinessContact) selectedContact).getLinkedInUsername());
			}	
			
			System.out.println("6) Exit to Main Menu");
			editOption = input.nextInt();
			input.nextLine();
	
			
			switch (editOption) {
				case 1:
					selectedContact.getName();
					System.out.println("Enter new name.");
					String newName = input.nextLine();
					selectedContact.setName(newName);
					break;
				case 2:
					selectedContact.getEmail();
					while (true) {
						try {
							System.out.println("Enter new email.");
							String newEmail = input.nextLine();
							selectedContact.setEmail(newEmail);
							break;
						} catch (InvalidEmailException2 e) {
							System.out.println(e.getMessage());
						}
					}
					break;
				case 3:
					selectedContact.getPhoneNumber();
					while (true) {
						try {
							System.out.println("Enter new phone number.");
							String newPhoneNumber = input.nextLine();
							selectedContact.setPhoneNumber(newPhoneNumber);
							break;
						} catch (InvalidPhoneNumberException2 e) {
							System.out.println(e.getMessage());
						}
					}
					break;
				case 4:
					if (selectedContact instanceof PersonalContact) {
						((PersonalContact) selectedContact).getFacebookUsername();
						System.out.println("Enter new Facebook username.");
						String newFacebookUsername = input.nextLine();
						((PersonalContact) selectedContact).setFacebookUsername(newFacebookUsername);
					} else if (selectedContact instanceof BusinessContact) {
						((BusinessContact) selectedContact).getCompanyName();
						System.out.println("Enter new company name.");
						String newCompanyName = input.nextLine();
						((BusinessContact) selectedContact).setCompanyName(newCompanyName);
					}
					break;
				case 5:
					if (selectedContact instanceof PersonalContact) {
						((PersonalContact) selectedContact).getWhatsAppUsername();
						System.out.println("Enter new whatsApp username.");
						String newWhatsAppUsername = input.nextLine();
						((PersonalContact) selectedContact).setWhatsAppUsername(newWhatsAppUsername);
					} else if (selectedContact instanceof BusinessContact) {
						((BusinessContact) selectedContact).getLinkedInUsername();
						System.out.println("Enter new LinkedIn username.");
						String newLinkedInUsername = input.nextLine();
						((BusinessContact) selectedContact).setLinkedInUsername(newLinkedInUsername);
					}
					break;
			}	
		} while (editOption != 6); 
	
	}
	
	public static void deleteAContact(Scanner input) {
		System.out.println("\nWhich contact would you like to delete? Enter its index.");
		int contactToDelete = input.nextInt();
		
		AbstractContact selectedContact2 = contactsInAddressBook.get(contactToDelete);
		
		if (selectedContact2 instanceof PersonalContact) {
			System.out.println("Are you sure you want to delete the contact below?\n" + ((PersonalContact) selectedContact2).getStringToPrint());
		} else if (selectedContact2 instanceof BusinessContact) {
			System.out.println("Are you sure you want to delete the contact below?\n" + ((BusinessContact) selectedContact2).getStringToPrint());
		}
		System.out.println("1) Yes");
		System.out.println("2) No");
		int deleteConfirmation = input.nextInt();
		input.nextLine();
		
		if (deleteConfirmation == 1) {
			contactsInAddressBook.remove(contactToDelete);
		}		
	}
	
	public static void displayAllContacts() {
		System.out.println("Here are your contacts: ");
		for (AbstractContact c:contactsInAddressBook) {
			if (c instanceof PersonalContact) {
				System.out.println(((PersonalContact) c).getStringToPrint());
			} else if (c instanceof BusinessContact) {
				System.out.println(((BusinessContact) c).getStringToPrint());
			}
		}	
	}

}
