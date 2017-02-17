package Test_MR;
import Mont.MontgomeryReducer;
import PowerByModule.PowerBM;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by milson on 22.10.16.
 */
public class testMR {
    PowerBM p = new PowerBM();
    public BigInteger Module(BigInteger FirstNumber, BigInteger SecondNumber) {
        if(FirstNumber.compareTo(BigInteger.ZERO) > 0)
            return FirstNumber.mod(SecondNumber);
        while(FirstNumber.compareTo(BigInteger.ZERO) < 0)
            FirstNumber= FirstNumber.add(SecondNumber);
        return FirstNumber;
    }


    public boolean MillerRabinTest(BigInteger n, int k)
    {
        if (n.compareTo(BigInteger.valueOf(2)) < 0)
            return false;
        if (n.equals(2))
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(0))
            return false;
        int r = 0;
        BigInteger d = n.subtract(BigInteger.ONE);
        while (d.mod(BigInteger.valueOf(2)).equals(0))
        {
            d = d.divide(BigInteger.valueOf(2));
            r++;
        }

        Random ra = new Random(System.currentTimeMillis());
        BigInteger top = n.subtract(BigInteger.ONE);
        for (int i = 0; i < k; i++)
        {
            BigInteger a = new BigInteger(top.bitLength(), ra);
            //int a = rand.nextLong(21l) + 2;
            BigInteger x = p.PowerByModule(a, d, n);
            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE)))
                continue;
            for (int j = 0; j < r - 1; j++)
            {
                x = p.PowerByModule(x, BigInteger.valueOf(2), n);
                if (x.equals(1))
                    return false;
                if (x.equals(n.subtract(BigInteger.ONE)))
                    break;
            }
            if (!x.equals(n.subtract(BigInteger.ONE)))
                return false;
        }
        return true;
    }



    public static class Main{
        public static void main(String[] args) throws IOException {
            {

                BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "US-ASCII"));
                System.out.print("Число x: ");
                BigInteger x = new BigInteger(in.readLine());
                System.out.print("Степень : ");
                BigInteger y = new BigInteger(in.readLine());
                System.out.print("Модуль: ");
                BigInteger mod = new BigInteger(in.readLine());
                System.out.println();

                // Do computation
                MontgomeryReducer red = new MontgomeryReducer(mod);
               // BigInteger xm = red.convertIn(x);
               // BigInteger zm;
                BigInteger z;

                // zm = red.pow(xm, y);
                z = red.pow(x,y);


                PowerBM p = new PowerBM();
                /*System.out.println("Тест Миллера-Рабина: ");
                 testMR s = new testMR();
                BigInteger[] ints = {BigInteger.valueOf(506074893), BigInteger.valueOf(3456781), BigInteger.valueOf(4567499)};
                for (BigInteger m : ints)
                {
                    System.out.println(s.MillerRabinTest(m, 10));
                }

                */

                //1477149328937ms
                System.out.println("Быстое возведение в степень : ");
                System.out.printf("%d%s%d mod %d%n", x, "^", y, mod);
                System.out.println("= " + p.PowerByModule(x, y, mod));
                System.out.println("Реализация заняла " + System.currentTimeMillis()  + " ms.");




                //1477149232191ms
                System.out.println("Алгоритм Монтгомери: " );
                System.out.printf("%d%s%d mod %d%n", x, "^", y, mod);
                System.out.println("= " + z);

                System.out.println("Реализация заняла " + System.currentTimeMillis()  + " ms.");

            }
        }

    }

}
