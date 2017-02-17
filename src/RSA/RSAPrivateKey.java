package RSA;

import java.io.*;
import java.math.*;
/**
 * Created by milson on 17.10.16.
 */
public class RSAPrivateKey implements Serializable{

    protected BigInteger d , n;

    public RSAPrivateKey (BigInteger dd , BigInteger nn){
        d = dd;  n =  nn;
    }

    public boolean equals(Object parm1) {
        if (! (parm1 instanceof RSAPrivateKey )) return false;
        return ((RSAPrivateKey)parm1).d.equals(d) &&
                ((RSAPrivateKey)parm1).n.equals(n);
    }

    public String toString() {
        return "RSA.RSAPrivateKey (d="+ d+ ", n="+n + ")";
    }
}
