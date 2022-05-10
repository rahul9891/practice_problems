package Features.stream_API;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    record Employee(int id, String name, String type, int salary) {}

    public static void main(String[] args) {

        List<Integer> list = List.of(23,12,9,47,98,1,33,90,54,42,15,90,12);
        sortNumbers(list);
        findDistinctEven(list);

        var input = new ArrayList<Employee>();
        input.add(new Employee(12,"Rahul","employee",435435));
        input.add(new Employee(23,"Sohan","employee",3249234));
        input.add(new Employee(56,"Gokul","manager",764654));
        input.add(new Employee(45,"Zameer","employee",432423));
        input.add(new Employee(12,"Swati","manager",4232343));
        input.add(new Employee(26,"Rahul Singh","manager",40000));
        input.add(new Employee(78,"Uma","employee",5345435));
        input.add(new Employee(11,"Rohit","manager",1232134));
        input.add(new Employee(10,"Ravi","manager",654645));

        highestPaidManager(input);

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1,"Rahul");
        map.put(3,"fasdfa");
        map.put(7,"dsadas");
        map.put(5,"dsdsfdsf");
        map.put(38,"dsad");
        map.put(23,"dasdas");
        map.put(12,"sada");
        map.put(10,"Rahfdsfsdul");
        map.put(11,"ds");
        map.put(90,"Rahfdsful");

        printMap(map);

    }


    public static void sortNumbers(List<Integer> list) {

        var result = list.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        printList(result);

    }

    public static void findDistinctEven(List<Integer> list) {

        var result = list.stream().filter(a -> a%2 == 0).distinct().collect(Collectors.toList());

        printList(result);
    }

    static void highestPaidManager(List<Employee> emp) {

        Optional<Employee> e= emp.stream().filter(a -> a.type() == "manager")
                                .sorted((a,b) -> b.salary() - a.salary())
                                .findFirst();

        System.out.println(e.get());

    }

    static void printList(List<Integer> list) {
        System.out.println(Arrays.toString(list.toArray()));
    }




    static void printMap(Map<Integer, String> map) {

        map.entrySet().forEach(item -> System.out.println(item.getKey() + " " + item.getValue()));
    }



}
