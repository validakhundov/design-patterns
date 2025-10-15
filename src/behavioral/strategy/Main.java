package behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        LowercaseStrategy str1 = new LowercaseStrategy();
        UppercaseStrategy str2 = new UppercaseStrategy();
        RandomCaseStrategy str3 = new RandomCaseStrategy();
        String input = "Salamlar! Necəsiniz?";

        Executor executor = new Executor(str1);
        executor.printString(input);

        executor.strategy = str2;
        executor.printString(input);

        executor.strategy = str3;
        executor.printString(input);
    }
}
