package Mont;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by milson on 22.10.16.
 */
public class MontgomeryReducerTest {
  /*  public static void main(String[] args) throws IOException {
        // Prompt user on standard output, parse standard input
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "US-ASCII"));
        System.out.print("Число x: ");
        BigInteger x = new BigInteger(in.readLine());
       // System.out.print("Operation (\"*\" or \"^\"): ");
        //String oper = in.readLine();
        System.out.print("Степень : ");
        BigInteger y = new BigInteger(in.readLine());
        System.out.print("Модуль: ");
        BigInteger mod = new BigInteger(in.readLine());
        System.out.println();

        // Do computation
        MontgomeryReducer red = new MontgomeryReducer(mod);
        BigInteger xm = red.convertIn(x);
        BigInteger zm;
        BigInteger z;
        /*if (oper.equals("*")) {
            zm = red.multiply(xm, red.convertIn(y));
            z = x.multiply(y).mod(mod);
        } else if (oper.equals("^")) {
            zm = red.pow(xm, y);
            z = x.modPow(y, mod);
        } else
            throw new IllegalArgumentException("Неверная операция: " + oper);
        */
        /*zm = red.pow(xm, y);
        z = x.modPow(y, mod);
        if (!red.convertOut(zm).equals(z))
            throw new AssertionError("Self-check failed");
        //System.out.printf("%d%s%d mod %d%n", x, oper.equals("*") ? " * " : "^", y, mod);
        //System.out.println("= " + z);
        System.out.println(z);
    }
*/
}
