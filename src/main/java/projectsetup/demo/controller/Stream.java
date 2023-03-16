package projectsetup.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Stream {
    public static void main(String[] args) {
        stringOperation();
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(3);
        myList.add(6);
        myList.add(2);
        myList.add(0);
        for (Integer i: myList){
            System.out.println(i);
        }
        myList.forEach(x -> System.out.println(x));
        myList.forEach(System.out::println);  //Method Reference
        myList.stream().sorted().forEach(System.out::println);
    }
    static void stringOperation(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Test");
        stringList.add("test1");
        stringList.add("akgdi");
        stringList.add("Ram");
        stringList.add("Tesla");
        stringList.stream().filter( x -> x.startsWith("T"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<String> filterData = stringList.stream().filter( x -> x.startsWith("T"))
                .map(String::toUpperCase).collect(Collectors.toList());
    }
}
