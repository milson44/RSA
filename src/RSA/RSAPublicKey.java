package RSA;

import java.math.*;
/**
 * Created by milson on 17.10.16.
 */
public class RSAPublicKey {
    protected BigInteger e , n;

    public RSAPublicKey (BigInteger ee , BigInteger nn){
        e = ee;  n =  nn;
    }

    public boolean equals(Object parm1) {

        if (! (parm1 instanceof RSAPublicKey )) return false;
        return ((RSAPublicKey)parm1).e.equals(e) &&
                ((RSAPrivateKey)parm1).n.equals(n);
    }

    public String toString() {

        return "RSA.RSAPublicKey (e="+ e+ ", n="+n + ")";
    }
}
