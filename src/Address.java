public class Address {


        private String street;
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setCity() {
            this.city = city;
        }

        public String toString() {
            return street + ", " + city;
        }


    }

