package ua.foxminded.countingsymbols;

public class App {

    public static void main(String[] args) {

        SymbolsCounter sc = new SymbolsCounter();
        String text = "hello world!";

        sc.setText(text);
        String str = sc.calculateCounterOfCharacters();

        sc.setText(text);
        str = sc.calculateCounterOfCharacters();

        System.out.println(str);
    }
}
