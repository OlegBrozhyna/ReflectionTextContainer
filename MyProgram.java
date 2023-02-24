package HomeWork2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyProgram {
    public static void main(String[] args) {
        String text = "Hello";
        reflectionSave(text);



    }

    private static void reflectionSave(final String text) {
        try {
            final TextContainer container = new TextContainer("D:\\InfoContainer.txt ");
            final Class<?> cls = container.getClass();
            final SaveTo SaveToAnnotation = cls.getAnnotation(SaveTo.class);
            final Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    method.invoke(container, SaveToAnnotation.path());
                }
            }
        } catch (IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        System.out.println("Can find Annotation 'SaveTo'");

    }
}

