package RSA;

import Test_MR.testMR;

import java.math.*;
import java.util.Random;

/**
 * Created by milson on 17.10.16.
 */
public class RSAKeyGen {
    BigInteger n, e,d;
/*    testMR mr = new testMR();

    public  BigInteger randomBigInteger(BigInteger n) {
        Random rnd = new Random();
        int maxNumBitLength = n.bitLength();
        BigInteger aRandomBigInt;
        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
            // compare random number lessthan ginven number
        } while (aRandomBigInt.compareTo(n) > 0);

        if(mr.MillerRabinTest(aRandomBigInt,10)){
           // aRandomBigInt.equals(aRandomBigInt);
            return aRandomBigInt;

        }
        else
            randomBigInteger(n);
        return aRandomBigInt;

    }
*/

    public RSAKeyGen (){
        BigInteger p =  new BigInteger (1024/2 , 5000 ,
                new java.util.Random ());
        BigInteger q =  new BigInteger (1024/2 , 5000 ,
                new java.util.Random ());
        BigInteger n = p.multiply(q);
        BigInteger fi = p.subtract(BigInteger.ONE).
                multiply(q.subtract(BigInteger.ONE));  //(p-1)*(q-1)

        BigInteger e;

        do{
            e = new BigInteger (1024 / 3, 5000 , new java.util.Random () );
            //System.out.println("Try Number " + e);
        }while (e.gcd(fi).compareTo(BigInteger.ONE) != 0);

        BigInteger d = e.modInverse(fi);

        this.n = n;
        this.e = e;
        this.d = d;
        /*
        BigInteger bigInteger = new BigInteger("9349988899999");
        BigInteger bigInteger1 = bigInteger.subtract(new BigInteger("1"));
        BigInteger p = randomBigInteger(bigInteger1);
        BigInteger q = randomBigInteger(bigInteger1);


        BigInteger n = p.multiply(q);
        BigInteger fi = p.subtract(BigInteger.ONE).
                multiply(q.subtract(BigInteger.ONE));  //(p-1)*(q-1)

        BigInteger e;

        do{
            e = randomBigInteger(bigInteger1);
            //System.out.println("Try Number " + e);
        }while (e.gcd(fi).compareTo(BigInteger.ONE) != 0);

        BigInteger d = e.modInverse(fi);

        this.n = n;
        this.e = e;
        this.d = d;
        */
    }

    public RSAPrivateKey getPrivateKey (){
        return new RSAPrivateKey(d , n);
    }

    public RSAPublicKey getPublicKey (){
        return new RSAPublicKey(e , n);
    }
}
