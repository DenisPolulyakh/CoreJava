package core.java.www.reflection;

import core.java.www.annotation.Author;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        Class personClass = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("core.java.www.reflection.Person");

      /*  Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", " + method.getReturnType() + ", " + Arrays.toString(method.getParameterTypes()));
        }*/

        /*Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ", " + field.getType());
        }*/


        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes");
                Class annotationClass = Author.class;
                System.out.println(Arrays.toString(annotationClass.getMethods()));
                System.out.println(((Author) annotation).name());
                System.out.println(((Author) annotation).dateOfBirh());

                for(Field m: annotationClass.getDeclaredFields()){
                    System.out.println(m.getName());
                }
            }
        }

    }
}
