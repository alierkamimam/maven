package Lessons.ThirdLesson.Section14;


import org.junit.jupiter.api.Test;
import org.testng.Assert;



import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {

    //Count the number of names starting with alphabet A in list
    @Test
    public void regular() {


        ArrayList<String> names = new ArrayList<>();

        names.add("Ali");
        names.add("Hasan");
        names.add("Adil");
        names.add("Adam");
        names.add("Mustafa");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;

            }
        }
        System.out.println(count);


    }

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<>();

        names.add("Ali");
        names.add("Hasan");
        names.add("Adil");
        names.add("Adam");
        names.add("Mustafa");

        Long a = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(a);


        // Long d = Stream.of("Ali", "Hasan", "Adil", "Adam", "Mustafa").filter(s -> s.startsWith("A")).count();
        // System.out.println(d);

        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

    }

    @Test
    public void printAllNames() {
        Stream.of("Ali", "Hasan", "Adil", "Adam", "Mustafa").filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

    }

    @Test
    public void streamMap() {

        Stream.of("Ali", "Hasan", "Adil", "Ada", "Mustafa").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));
        System.out.println("-------------");

        //print names which have first letter as a with uppercase and sorted

        List<String> list = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Rama");
        list.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


    }

    @Test
    public void mergingLists() {
        ArrayList<String> names = new ArrayList<>();
        names.add("man");
        names.add("Don");
        names.add("women");

        List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Rama");

        //Merging 2 different list
        Stream<String> name2 = Stream.concat(names.stream(), names1.stream());
        //  name2.sorted().forEach(s -> System.out.println(s));
        //name2.collect(Collectors.toSet()).forEach(s -> System.out.println(s));

       /* boolean flag=name2.anyMatch(s -> s.equalsIgnoreCase("Adam"));

        System.out.println(flag);
        Assert.assertTrue(flag);

*/

    }

    @Test
    public void streamCollect() {

       /* List<String> ls = Stream.of("Azbhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));
*/

        List<Integer> names1 = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        //print unique number from this array
        //sort the array
        names1.stream().distinct().forEach(s-> System.out.println(s));
        names1.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("----");
        System.out.println(names1.get(3));


    }


}
