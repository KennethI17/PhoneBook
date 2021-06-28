package phoneBook;

public class AddressInfo {

		private String address;
		private String city;
		private String state;
		private String zip;
		
		public AddressInfo(String address, String city, String state, String zip) {
			setAddress(address);
			setCity(city);
			setState(state);
			setZip(zip);
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

}
