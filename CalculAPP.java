package Lambda;

public class CalculAPP {

    public static void main(String[] args) {
        MyCalculator add = (a,b) -> a+b;
        MyCalculator sub = (a,b) -> a-b;

        System.out.println(add.calculate(4, 5));
        System.out.println(sub.calculate(5, 4));

    }
    
}
