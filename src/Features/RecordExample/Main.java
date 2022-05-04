package Features.RecordExample;

public class Main {

    public static void main(String[] args) {


        Vehicle v = new Vehicle("Volvo", "XC90");

        System.out.println(v.toString());

        System.out.println("Make is: " + v.make());

        Vehicle1 v1 = new Vehicle1("Hyundai");

        System.out.println(v1.toString());

        Vehicle2 v2 = new Vehicle2("Kia", "Santos");

        System.out.println(v2.getBrandAsLowercase("Kia"));

        System.out.println(Vehicle2.getBrandAsUppercase(v2));
    }
}
