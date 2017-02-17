package RSA;

import RSA.RSAPrivateKey;
import RSA.RSAPublicKey;
import PowerByModule.PowerBM;

import java.math.*;

/**
 * Created by milson on 17.10.16.
 */
public class RSASign {
    /**
     * Данный метод служит для шифрования/проверки
     * подписи к некоторому сообщению
     * @param exp — показатель степени для
     * ключа RSA используемого для данного
     * преобразования
     * @param n — показатель модуля для вычислений
     * @param mes — сообщение которое должно быть подписано
     * @return — результат преобразования
     */
    private static BigInteger _sign (BigInteger exp ,
                                     BigInteger n, BigInteger mes){

        int len = n.bitLength();
        PowerBM a = new PowerBM();
        if (len < (mes.bitCount())) throw new
                IllegalArgumentException (
                "Длина сообщения для подписи не должна превышать длину ключа по модулю");

                //BigInteger C = mes.modPow(exp, n);
        BigInteger C = a.PowerByModule(mes, exp, n);
        return C;
    }

    /**
     * В данном методе просто происходит вызов
     * метода _sign и выполняющего всю черновую работу
     */
    public static BigInteger sign (RSAPrivateKey pk , BigInteger mes){
        return _sign(pk.d , pk.n,  mes);
    }

    /**
     * Данный метод практически идентичен ранее приведенному
     * отличается только используемым показателем степени
     */
    public static BigInteger sign (RSAPublicKey pk , BigInteger mes){
        return _sign(pk.e , pk.n,  mes);
    }
}
