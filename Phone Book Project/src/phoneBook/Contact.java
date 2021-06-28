package phoneBook;

import java.util.Arrays;

public class Contact {

	private PersonInfo person;
	private AddressInfo address;

	static Contact[] contactArray = new Contact[100];

	public Contact(PersonInfo person, AddressInfo address) {
		setPerson((PersonInfo) person);
		setAddress((AddressInfo) address);
	}

	public PersonInfo getPerson() {
		return person;
	}

	public void setPerson(PersonInfo person) {
		this.person = person;
	}

	public AddressInfo getAddress() {
		return address;
	}

	public void setAddress(AddressInfo address) {
		this.address = address;
	}

	public static void addAsOne() {
		// Scanner input = new Scanner(System.in);
		System.out.println("*****************************************"
				+ "\nFormat(Full Name, Address, City, State(Abbr only), Zip Code, Phone Number)"
				+ "\nEnter contact using the format as a guide:");
		Index.input.nextLine();
		String fullCont = Index.input.nextLine();

		String[] oneEntry = fullCont.split(",");
		String nameOne = oneEntry[0].trim();
		String addrOne = oneEntry[1].trim();
		String cityOne = oneEntry[2].trim();
		String stateOne = oneEntry[3].trim();
		String zipOne = oneEntry[4].trim();
		String numberOne = oneEntry[5].trim();

		String[] breakName = nameOne.split(" ");
		String fnOne = breakName[0].trim();
		String mnOne = breakName[1].trim();
		String lnOne = breakName[2].trim();

		AddressInfo newAddress = new AddressInfo(addrOne, cityOne, stateOne, zipOne);
		PersonInfo newPerson = new PersonInfo(fnOne, mnOne, lnOne, numberOne);
		Contact newContact = new Contact(newPerson, newAddress);
		addToArray(newContact);
		System.out.println("Account has been added.");
	}

	public static void addContact() {
		Index.input.nextLine();
		System.out.println("*****************************************");
		System.out.print("Enter First Name: ");
		String fn = Index.input.nextLine();
		System.out.print("Enter Middle Initial: ");
		String mn = Index.input.nextLine();
		System.out.print("Enter Last Name: ");
		String ln = Index.input.nextLine();
		System.out.print("Enter Address: ");
		String address = Index.input.nextLine();
		System.out.print("Enter City: ");
		String city = Index.input.nextLine();
		System.out.print("Enter State: ");
		String state = Index.input.nextLine();
		System.out.print("Enter Zip: ");
		String zip = Index.input.nextLine();
		System.out.print("Enter Phone Number: ");
		String number = Index.input.nextLine();
		AddressInfo newAddress = new AddressInfo(address, city, state, zip);
		PersonInfo newPerson = new PersonInfo(fn, mn, ln, number);
		Contact newContact = new Contact(newPerson, newAddress);
		addToArray(newContact);
		System.out.println("Account has been added.");
	}

	public static void addToArray(Contact contact) {
		for (int i = 0; i < contactArray.length; i++) {
			if (contactArray[i] == null) {
				contactArray[i] = contact;
				break;
			}
		}
	}

	public static void display() {
		int counter = 0;
		for (int i = 0; i < contactArray.length; i++) {
			if (contactArray[i] != null) {
				counter++;
			}
		}
		String[] nameArray = new String[counter];
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i] == null) {
				nameArray[i] = contactArray[i].toString();
			}
		}
		if (nameArray.length > 0) {
			Arrays.sort(nameArray);
			for (int i = 0; i < nameArray.length; i++) {
				System.out.println(nameArray[i]);
			}
		}
	}

	public static void search() {
		Index.input.nextLine();
		String newSearch = Index.input.nextLine().toLowerCase();
		System.out.println("*****************************************");
		Contact conArr;
		for (int i = 0; i < contactArray.length; i++) {
			if (contactArray[i] != null) {
				conArr = contactArray[i];
				if (conArr.getPerson().getFullName().toLowerCase().contains(newSearch))
					System.out.println(contactArray[i]);
				if (conArr.getPerson().getPhoneNum().contains(newSearch))
					System.out.println(contactArray[i]);
				if (conArr.getAddress().getCity().toLowerCase().contains(newSearch))
					System.out.println(contactArray[i]);
				if (conArr.getAddress().getState().toLowerCase().contains(newSearch))
					System.out.println(contactArray[i]);
				if (conArr.getAddress().getZip().contains(newSearch))
					System.out.println(contactArray[i]);
			}
		}
	}

	public static void delete() {
		System.out.println("*****************************************" + "\n               Delete Menu");
		System.out.print("Enter Contact Phone Number: ");
		Index.input.nextLine();
		String delete = Index.input.nextLine();
		Contact conDel = contactArray[0];
		System.out.println("*****************************************");
		for (int i = 0; i < contactArray.length; i++) {
			if (contactArray[i] != null) {
				conDel = contactArray[i];
				if (conDel.getPerson().getPhoneNum().equals(delete)) {
					System.out.println(contactArray[i]);
					System.out.println("Confirm deletion of the above contact: Yes or No");
					delete = Index.input.nextLine();
					if (delete.equalsIgnoreCase("yes")) {
						contactArray[i] = null;
						System.out.println("Contact Deleted");
					} else {
						System.out.println("Contact was not deleted.");
					}
				}
			}
		}
	}

	public static void editContact() {
		System.out.println("*****************************************" + "\n                Edit Menu");
		System.out.print("Enter Contact Phone Number: ");
		Index.input.nextLine();
		String update = Index.input.nextLine();
		System.out.println("*****************************************");
		for (int i = 0; i < contactArray.length; i++) {
			if (contactArray[i] != null) {
				if (contactArray[i].getPerson().getPhoneNum().equals(update)) {
					System.out.println("[1] First Name" + "\n[2] Middle Name" + "\n[3] Last Name" + "\n[4] Address"
							+ "\n[5] City" + "\n[6] State" + "\n[7] Zip Code" + "\n[8] Telephone Number"
							+ "\n[9] Return to Main Menu");
					System.out.print(
							"\n" + contactArray[i].toString() + "\nHow would you like to edit the above contact: ");
					int a = Index.input.nextInt();
					switch (a) {
					case 1:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter First Name: ");
						update = Index.input.nextLine();
						contactArray[i].getPerson().setFirstName(update);
						System.out.println("*****************************************");
						break;
					case 2:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter Middle Name: ");
						update = Index.input.nextLine();
						contactArray[i].getPerson().setMiddleName(update);
						System.out.println("*****************************************");
						break;
					case 3:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter Last Name: ");
						update = Index.input.nextLine();
						contactArray[i].getPerson().setLastName(update);
						System.out.println("*****************************************");
						break;
					case 4:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter Address: ");
						update = Index.input.nextLine();
						contactArray[i].getAddress().setAddress(update);
						System.out.println("*****************************************");
						break;
					case 5:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter City: ");
						update = Index.input.nextLine();
						contactArray[i].getAddress().setCity(update);
						System.out.println("*****************************************");
						break;
					case 6:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter State: ");
						update = Index.input.nextLine();
						contactArray[i].getAddress().setState(update);
						System.out.println("*****************************************");
						break;
					case 7:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter State: ");
						update = Index.input.nextLine();
						contactArray[i].getAddress().setZip(update);
						System.out.println("*****************************************");
						break;
					case 8:
						Index.input.nextLine();
						System.out.print("*****************************************" + "\nEnter New Phone Number: ");
						update = Index.input.nextLine();
						contactArray[i].getPerson().setPhoneNum(update);
						System.out.println("*****************************************");
						break;
					case 9:
						System.out.println("Returing.....");
						break;
					default:
						System.out.println("Error: Unreadable Input!");
						break;
					}
					break;
				}
			}
		}
	}
	public static void returnMenu() {
		System.out.println("*****************************************");
		System.out.println("Go back to Main Menu? Yes or No");
		String c = Index.input.next();
		if (c.equalsIgnoreCase("no")) {
			System.out.println("Exiting......");
			Index.loop = true;	
		}
	}

	@Override
	public String toString() {
		return this.getPerson().getFirstName() + " " + this.getPerson().getMiddleName() + " "
				+ this.getPerson().getLastName() + ", " + this.getAddress().getAddress() + ", "
				+ this.getAddress().getCity() + ", " + this.getAddress().getState() + ", " + this.getAddress().getZip()
				+ ", " + this.getPerson().getPhoneNum();
	}
}
