package phoneBook;

public class PersonInfo {
	
		private String firstName;
		private String middleName;
		private String lastName;
		private String phoneNum;
		

		public PersonInfo(String firstName, String middleName, String lastName, String phoneNum) {
			setFirstName(firstName);
			setMiddleName(middleName);
			setLastName(lastName);
			setPhoneNum(phoneNum);
		}
		public String getFullName() {
			return getFirstName() + " " + getMiddleName() + " " + getLastName();
		}
		
		public String getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
}
