package behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        LowercaseStrategy lowercaseStrategy = new LowercaseStrategy();
        UppercaseStrategy uppercaseStrategy = new UppercaseStrategy();
        RandomCaseStrategy randomCaseStrategy = new RandomCaseStrategy();

        String input = "Salamlar! Necəsiniz?";

        Executor executor = new Executor(uppercaseStrategy);

        executor.printString(input);

    }
}
