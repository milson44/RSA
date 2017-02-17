package RSA;

import java.math.*;
/**
 * Created by milson on 17.10.16.
 */
public class genkeys {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        RSAKeyGen kg =  new RSAKeyGen();
        System.out.println("Генерация ключа заняла "
                + (System.currentTimeMillis()  -  now) +
                " ms.");

        RSAPrivateKey privk = kg.getPrivateKey();
        RSAPublicKey publk = kg.getPublicKey();
        BigInteger mes = BigInteger.valueOf(4567890);
        //String message = "Good morning, kolobki";
        //BigInteger mes = new BigInteger(message);
        System.out.println("Сообщение: "+mes);
        System.out.println(privk);
        System.out.println(publk);

        BigInteger res  = RSASign.sign(privk , RSASign.sign(publk ,
                mes));

        System.out.println("After transformation = " + res ) ;
        if(res.equals(mes))
            System.out.println("Подпись действительна!");
        else
            System.out.println("Подпись не действительна!");
    }
}
