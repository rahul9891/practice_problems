package Features.RecordExample;


// can have multiple contructors
public record Vehicle1(String make, String model) {

    Vehicle1(String make) {
        this(make, null);
    }
}
