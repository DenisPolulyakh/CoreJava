package core.java.www.lambda;

import java.util.*;
import java.util.stream.Collectors;

interface Executable {
    int execute(int x, int y);
}

class Runner {
    public void run(Executable e) {
        int a = e.execute(10, 15);
        System.out.println(a);
    }
}


public class LambdaTest {

    private static Random random = new Random();
    private static final int SIZE=4;

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Goodbye");
        list.add("a");
        list.add("ab");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        Runner runner = new Runner();

        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                return x + y;
            }
        });
        int a = 1;
        runner.run((x, y) -> x + y + a);

        System.out.println(list);
        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() > s2.length()) return -1;
            else if (s1.length() < s2.length()) return 1;
            else return 0;
        };
        list.sort(comparator);
        System.out.println(list);


        //filter
        List<Integer> listIntegers = new ArrayList<>();
        int[] arrIntegers = new int[SIZE];
        fillList(listIntegers);
        fillArray(arrIntegers);

        //forEach
        arrIntegers = Arrays.stream(arrIntegers).filter(integer -> integer % 2 == 0).toArray();
        listIntegers = listIntegers.stream().filter(integer -> integer % 2 != 0).collect(Collectors.toList());

        Arrays.stream(arrIntegers).forEach(integer -> System.out.print(integer+" "));
        System.out.println();
        listIntegers.stream().forEach(System.out::print);
        System.out.println();

        //reduce
        int[] arrIntegers2 = new int[SIZE];
        fillArray(arrIntegers2);
        System.out.println(Arrays.toString(arrIntegers2));
        System.out.println(listIntegers);
        // [1,2,3] 1) acc=1 b=1 2) acc=2 b=2 3) acc=4 b=3 4) acc=7
        int sum1=Arrays.stream(arrIntegers2).reduce((acc,b)->acc+b).getAsInt();
        int sum2=listIntegers.stream().reduce((acc,b)->acc*b).get();

        System.out.println(sum1);
        System.out.println(sum2);


    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
            list.add(random.nextInt(20));

        }
    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt(10);
        }
    }
}
