package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class c = Class.forName("reflection.Employee");

//        Constructor[] constructors =  c.getDeclaredConstructors();
//        System.out.println(constructors.length);
//        for(Constructor constructor : constructors){
//            System.out.println("Name of Constructor : "+constructor);
//
//            System.out.println("Count of constructor parameter : "+constructor.getParameterCount());
//
//            Parameter[] parameters = constructor.getParameters();
//            for(Parameter parameter : parameters) {
//                System.out.println("Constructor's parameter : "+parameter);
//            }
//            System.out.println();
//        }

        Method[] methods = c.getDeclaredMethods();
        System.out.println(methods.length);
//        System.out.println(methods[3].getName());
        Employee employee = new Employee();

//        Method setEsala = Employee.class.getMethod("setEsal", double.class, float.class, String.class);
//        setEsala.invoke(employee, 1.2d, 1f, "Nam");
        for (Method method :
                methods) {
            if (method.getName().equals("setEsal")){
                method.invoke(employee, 1.2d,1.2f,"Nam");
                System.out.println("equals");
            }
            System.out.println(method.getName());
        }

        System.out.println(employee);

//        Class[] classes = c.getDeclaredClasses();
//        System.out.println(classes.length);
//        for(Class class1 : classes) {
//            System.out.println("class: "+class1);
//            System.out.println("Name of class: "+class1.getName());
//        }
//        System.out.println();
////        Annotations
//        Annotation[] anno = c.getDeclaredAnnotations();
//        System.out.println(anno.length);
//        for(Annotation annotation : anno) {
//            System.out.println("Annotation: "+annotation);
//        }

    }
}
