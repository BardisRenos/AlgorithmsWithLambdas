import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class algo {

    public static void main(String[] args) {

        int[] array1 = new int[]{9, 2, 3, 4, 5, 5, 7, 8, 1};
        int[] array2 = new int[]{0, 2, 3, 4, 5, 5, 7, 7, 9};

        List<Integer> arr = Arrays.asList(1, 2, 3, 5);
        List<String> stringArr = Arrays.asList("Renos", "Nikos", "George", "Kalipso", "John", "Rena", "Rina");

        String[] arrString = new String[] {"Renos", "Nikos", "George", "Kalipso", "John", "Rena", "Rina"};

        Person alex = new Person("Alex", 23);
        Person john = new Person("John", 40);
        Person peter = new Person("Peter", 32);
        List<Person> people = Arrays.asList(alex, john, peter);

        Person[] arrObj = new Person[]{alex, john, peter};

        sortArrayObj(arrObj);

    }

    private static void sortArrayObj(Person[] arr) {

        Arrays.sort(arr, Person::comparePerson);

        System.out.println(Arrays.toString(arr));
    }
    private static void findElement(int[] arr, int k) {

        int res = Arrays.binarySearch(arr, k);

        if (res >= 0) {
            System.out.println("There is the number");
        }else {
            System.out.println("There is not the number");
        }
    }
    private static<T> void sortArray(T[] arr) {

        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }

    private static void multiple(List<Integer> list) {

        System.out.println(list.stream().reduce(1, (Integer a, Integer b) -> a*b));
    }
    private static void closesToZero(int[] arr) {

        int min = arr[0];
        for(int i=1; i<arr.length; i++) {
            if (Math.abs(arr[i])<=min) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }

    private static void convertToBinary(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    private static void addAllNumbers(int num) {
        int result = IntStream.rangeClosed(1, num).filter(n -> n%2==0).reduce(0, Integer::sum);
        System.out.println(result);
    }

    private static void findFactorial(long num) {

        boolean next = true;
        if (num<=1) {
            next = false;
            System.out.println(1);
        }
        if (next)
            System.out.println(LongStream.rangeClosed(2, num).reduce(1, (long a, long b)-> a*b));
    }

    private static void reverseNumber(int num) {
        String res = Integer.toString(num);
        System.out.println("The number before : " + res);

        res = new StringBuilder(res).reverse().toString();

        System.out.println("The number after : "+ res);
    }

    private static void findTheSecondLargest(int[] arr) {

        Arrays.sort(arr);
        int res = arr[arr.length-2];

        System.out.println(res);
    }

    private static void findTheSmallestNumber(List<Integer> list) {

        System.out.println(list.stream().min(Integer::compareTo).get());
    }

    private static void findMissingNumber(int[] arr1, int[] arr2) {

        System.out.println(Arrays.stream(arr1).sum() - Arrays.stream(arr2).sum());
    }

    private static void countLetter(String text, String letter) {
        long res = Arrays.stream(text.split("")).filter(i -> i.equals(letter)).count();

        System.out.println(res);
    }

    private static void findDuplicates(int[] arr) {

        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> res = arrList.stream().filter(i -> Collections.frequency(arrList, i) > 1).collect(Collectors.toSet());

        System.out.println(res);
    }

    private static void findPrimeNumbers(int num) {

        boolean flag = false;

        if (num<=1) {
            System.out.println("It is not a prime number");
            flag = true;
        }

        for (int i=2; i<num; i++) {
            if(num%i == 0){
                System.out.println("It is not prime number: "+ num + " because it is divided by: "+ i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("It is prime number");
        }
    }

    private static void anagram(String  str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.length() == str2.length()) {

            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            if (Arrays.equals(charArray1, charArray2)) {
                System.out.println("The strings are anagram");
            } else {
                System.out.println("Same length but not anagram");
            }
        }else {
            System.out.println("Not the same length");
        }
    }

    private static void fibonacciNumbers(int num) {

        int num1 = 1;
        int num2 = 1;
        int nextNum;

        for (int i=0; i<num; i++) {
            System.out.println(num1);
            nextNum = num1+num2;
            num1 = num2;
            num2 = nextNum;
        }
    }

    private static int printNthFibonacci(int num) {

        if (num<=1) {
            return num;
        }
        return printNthFibonacci(num-1) + printNthFibonacci(num-2);
    }

    private static void printReverseOrder(int[] arr) {
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Collections.reverse(arrList);

        arrList.forEach(System.out::print);
    }

    private static void compareObjects(List<Person> arrObj) {
        Person personByAge = arrObj.stream().min(Comparator.comparing(Person::getName)).get();
        System.out.println(personByAge.getName() +" : "+ personByAge.getAge());
    }

    private static void findMaxValue(List<Integer> arr) {
//        Integer res = arr.stream().mapToInt(v -> v).max().getAsInt();

        Integer res = arr.stream().min(Integer::compareTo).get();
        System.out.println(res);
    }

    private static void checkString(List<String> givenList) {

        givenList.stream().filter(s -> s.contains("R")).map(String::toLowerCase).forEach(System.out::println);
    }

    private static void returnEvenNumber(List<Integer> arr) {

        arr.stream().filter(number -> number % 2 == 0).map(number -> Math.pow(number, 2)).forEach(System.out::println);
    }

    private static String palindromeString(String givenText) {

        return new StringBuilder(givenText).reverse().toString().equals(givenText) ? "It is palindrome":"it is not a palindrome";
    }

    private static String checkArray(int[] arr) {

        return arr.length <= 0 ? "It is empty the array" : "It is not empty";
    }

    private static boolean findString(String givenText, String[] arr) {

        return Arrays.asList(arr).contains(givenText);
    }
}

    class Person {
        String name;
        Integer age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public static int comparePerson(Person p1, Person p2) {
            return p2.getAge().compareTo(p1.getAge());
        }
    }
