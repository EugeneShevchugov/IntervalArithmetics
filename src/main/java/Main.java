import StandartOperations.*;
import StandartOperations.Minus.Minus;
import StandartOperations.Plus.Plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int a;
    private static int b;
    private static int c;
    private static int d;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter first Interval: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        a = Integer.parseInt(s);
        s = reader.readLine();
        b = Integer.parseInt(s);
        System.out.println("Enter second Interval: ");
        s = reader.readLine();
        c = Integer.parseInt(s);
        s = reader.readLine();
        d = Integer.parseInt(s);
        Interval interval = new Interval(a,b,c,d);
        System.out.println("Sum is : " + new Plus().operation(interval));
        System.out.println("Minus is : " + new Minus().operation(interval));
    }
}
