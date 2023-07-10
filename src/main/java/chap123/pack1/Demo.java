package chap123.pack1;

class Demo {
    public static void main(String[] args) {
        User user = new User("Thuy", "1/3/2001");
        System.out.println(user.validateAddress("ha noi"));// local class

        User.Info info = user.new Info();// inner class
        info.info();

        User.Country country =  new User.Country("VN"); // static inner class
        country.hello();
        User.Country.hi();//static method
    }
}
