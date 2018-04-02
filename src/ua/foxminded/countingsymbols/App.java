package ua.foxminded.countingsymbols;

public class App {

    public static void main(String[] args) {

        SymbolsCounter sc = new SymbolsCounter();
        sc.countChars("hello world!");
        sc.countChars("hello world!");
        System.out.println(sc.countChars("hello world!"));
    }
}
