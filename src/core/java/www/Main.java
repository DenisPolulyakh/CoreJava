package core.java.www;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

   /*     // Проверка Паттерна Наблюдатель
        System.out.println("=== Observer ===");
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);

        com.patterns.java.www.observer.javaimpl.WeatherData weatherData1 = new com.patterns.java.www.observer.javaimpl.WeatherData();
        com.patterns.java.www.observer.javaimpl.CurrentConditionsDisplay currentConditionsDisplay1 = new com.patterns.java.www.observer.javaimpl.CurrentConditionsDisplay(weatherData1);
        weatherData1.setMeasurements(90, 70, 50.4f);

        //Проверка паттерна Декоратор
        System.out.println("=== Decorator ===");
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Mocha(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

        Beverage beverage4 = new HouseBlend();
        beverage4 = new Mocha(beverage4);
        beverage4 = new Mocha(beverage4);
        beverage4 = new Whip(beverage4).setSize(Size.MINI);
        beverage4 = new Soy(beverage4);

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.UK);
        nf.setGroupingUsed(true);
        System.out.println(beverage4.getDescription() + " $" + nf.format(beverage4.cost()));*/


        int m = 10;
        List<BigDecimal> numbers = new ArrayList<>();

        numbers.add(new BigDecimal(10));
        numbers.add(new BigDecimal(7));
        numbers.add(new BigDecimal(1000));
        numbers.add(new BigDecimal(255));
        numbers.add(new BigDecimal(7000));
        numbers.add(new BigDecimal(800));
        numbers.add(new BigDecimal(9500));
        numbers.add(new BigDecimal(5));


        filter(numbers);


    }


    public static void filter(Collection<BigDecimal> numbers) throws MyException {
        Collections.sort((List<BigDecimal>) numbers);
        List<BigDecimal> minArr = new ArrayList<>();
        BigDecimal max = ((List<BigDecimal>) numbers).get(numbers.size() - 1);
        BigDecimal min = ((List<BigDecimal>) numbers).get(0);
        try {
            BigDecimal ch = max.divide(min);
            for(BigDecimal b: numbers){
                if(b.compareTo(ch)<0){
                    minArr.add(b);
                }
            }
            numbers.removeAll(minArr);
            System.out.println("Частное "+ ch);
            for (BigDecimal n : numbers) {
                System.out.print(n + " ");
            }
        } catch (Exception e) {
            throw new MyException("Ошибка в вычислении", e);
        }
    }


}
