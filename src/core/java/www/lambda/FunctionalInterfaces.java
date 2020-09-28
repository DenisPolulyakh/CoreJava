package core.java.www.lambda;

import java.util.Scanner;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        //Predicate - для проверки соблюдения условия
        Predicate<Integer> isNegativeOrZero = x -> x < 0;
        System.out.println(isNegativeOrZero.test(5));
        System.out.println(isNegativeOrZero.test(-1));
        //BinaryOperator - бинарная операция с двумя объектами
        BinaryOperator<Integer> multiply=(x,y)->x*y;
        System.out.println(multiply.apply(2,3));
        System.out.println(multiply.apply(3,-1));
        //UnaryOperator - принимает объект делает надо ним действия и возвращает объект
        UnaryOperator<Integer> square = x->x*x;
        System.out.println(square.apply(5));
        //Function - представляет собой функцию переход от объекта а к объекту b
        Function<Integer, String> convert = x->String.valueOf(x)+" баксов";
        System.out.println(convert.apply(100));
        //Consumer - преобразует объект без его возврата
        Consumer<Float> printer = x-> System.out.printf("%.0f долларов", x);
        printer.accept(600f);
        System.out.println();
        //Supplier - yничего не принимает но должен возвращать объект
        Supplier<String> userFactory = ()->{

            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new String("Вы ввели: "+name);
        };

        System.out.println(userFactory.get());
        System.out.println(userFactory.get());


    }
}


