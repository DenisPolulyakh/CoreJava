package core.java.www.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author()  default "Denis";
    int dateOfCreation() default 2019;
    String purpose();
}
