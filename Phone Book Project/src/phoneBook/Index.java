package phoneBook;

import java.util.Scanner;

public class Index {
	
	static Scanner input = new Scanner(System.in);
	static boolean loop = false;

	public static void main(String[] args) {
		
		PersonInfo p1 = new PersonInfo("Guy", "E", "Man", "8162099202");
		AddressInfo a1 = new AddressInfo("Street", "City", "MO", "65542");
		PersonInfo p2 = new PersonInfo("John", "B", "Smith", "8008001234");
		AddressInfo a2 = new AddressInfo("Road", "Yuma", "AZ", "12345");
		PersonInfo p3 = new PersonInfo("Rusty", "M", "Hinders", "1234567890");
		AddressInfo a3 = new AddressInfo("Highway", "Houston", "TX", "54321");
		PersonInfo p4 = new PersonInfo("Leroy", "C", "Jackson", "1231231234");
		AddressInfo a4 = new AddressInfo("Main", "Saint Louis", "MO", "98765");
		Contact person1 = new Contact(p1, a1);
		Contact.addToArray(person1);
		Contact person2 = new Contact(p2, a2);
		Contact.addToArray(person2);
		Contact person3 = new Contact(p3, a3);
		Contact.addToArray(person3);
		Contact person4 = new Contact(p4, a4);
		Contact.addToArray(person4);

		//Scanner input = new Scanner(System.in);
		loop = false;
		while (!loop) {
			System.out.println("               Phone Book" + "\n*****************************************");
			System.out.println("[1] Search for Contact" + "\n[2] Add Contact" + "\n[3] Edit Contact" + "\n[4] Delete Contact"
					+ "\n[5] Print Entire Database" + "\n[6] Exit");
			System.out.print("Enter a number for an Option: ");
			int a = input.nextInt();
			switch (a) {
			case 1:
				System.out.println("*****************************************");
				System.out.println("[1] Search by Full Name" + "\n[2] Search by First Name"
						+ "\n[3] Search by Last Name" + "\n[4] Search by Telephone Number"
						+ "\n[5] Search by City or State" + "\n[6] Search by Zip Code" + "\n[7] Return to Main Menu");
				System.out.print("\nHow would you like to search: ");
				a = input.nextInt();
				switch (a) {
				case 1:
					System.out.print("*****************************************" + "\nEnter Full Name Name: ");
					Contact.search();
					Contact.returnMenu();
					break;
				case 2:
					System.out.print("*****************************************" + "\nEnter First Name: ");
					Contact.search();
					Contact.returnMenu();
					break;
				case 3:
					System.out.print("*****************************************" + "\nEnter Last Name: ");
					Contact.search();
					Contact.returnMenu();
					break;
				case 4:
					System.out.print("*****************************************" + "\nFormat (xxxxxxxxxx) No '-'"
							+ "\nEnter Telephone Number: ");
					Contact.search();
					Contact.returnMenu();
					break;
				case 5:
					System.out.print("*****************************************" + "\nEnter City or State: ");
					Contact.search();
					Contact.returnMenu();
					break;
				case 6:
					System.out.print("*****************************************" + "\nEnter Zip Code: ");
					Contact.search();
					Contact.returnMenu();
					break;
				case 7:
					System.out.println("Returing.....");
					break;
				default:
					System.out.println("Error: Unreadable Input!");
					break;
				}
				break;
			case 2:
				System.out.println("*****************************************");
				System.out.println("[1] One Entry" + "\n[2] Step by Step" + "\n[3] Return to Main Menu");
				System.out.print("\nHow would you like to add a contact: ");
				int one = input.nextInt();
				switch (one) {
				case 1:
					Contact.addAsOne();
					break;
				case 2:
					Contact.addContact();
					break;
				case 3:
					Contact.returnMenu();
					break;
				default:
					System.out.println("Error: Unreadable Input!");
					break;
				}
				break;
			case 3:
				Contact.editContact();
				break;
			case 4:
				Contact.delete();
				Contact.returnMenu();
				break;
			case 5:
				System.out.println("*****************************************");
				Contact.display();
				Contact.returnMenu();
				break;
			case 6:
				System.out.println("Exiting..... Have a good day!");
				loop = true;
				break;
			default:
				System.out.println("Error: Unreadable Input!");
				Contact.returnMenu();
				break;
			}
		}
		input.close();
	}
}
