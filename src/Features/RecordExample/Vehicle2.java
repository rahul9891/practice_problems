package Features.RecordExample;


import java.util.Locale;

// can have instance methods or static methods
public record Vehicle2(String make, String model) {

    public String getBrandAsLowercase(String brand) {
        return make().toLowerCase();
    }

    public static String getBrandAsUppercase(Vehicle2 v) {
        return v.make.toUpperCase();
    }
}
