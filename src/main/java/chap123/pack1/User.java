package chap123.pack1;

public class User {
    private String name;
    private String dob;

    private static int id = 1;
//    class Address{
//        private String address;
//
//        public Address(String address) {
//            this.address = address;
//        }
//
//        public String getAddress() {
//            return address;
//        }
//    }
    public User(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    static class Country{
        String country;

        public Country(String country) {
            this.country = country;
        }

        public void hello(){
            System.out.println("hello" + id + country );
        }

        public static void hi(){
            System.out.println("hi");
        }
    }

    class Info{
        public void info(){
            System.out.println("hello " + name);
        }
    }

    public boolean validateAddress(String customerAddress){
        class Address{ // local class
            String address;
            Address(String address){
                this.address = address;
            }
            public boolean validate(){
                //body
                System.out.println(name + " " + address);
                return this.address.equals("ha noi");
            }}
            Address address = new Address(customerAddress);
            return address.validate();
        }
}
