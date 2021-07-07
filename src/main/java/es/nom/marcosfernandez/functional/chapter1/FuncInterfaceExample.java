package es.nom.marcosfernandez.functional.chapter1;

@FunctionalInterface
public interface FuncInterfaceExample {

    // Just one unimplemented method
    boolean test(Long value);

    // It could have static or default methods
    default String returnDefaultString() {
        return "Returning a default String";
    }

    static String returnStringFromStaticMethod() {
        return "Returning String from Static Method";
    }

}
