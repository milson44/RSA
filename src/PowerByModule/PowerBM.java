package PowerByModule;
import java.math.*;
/**
 * Created by milson on 22.10.16.
 */
public class PowerBM {

    /*  public byte Length(BigInteger Number){
          if(Number.compareTo(BigInteger.ZERO) < 0)
              System.out.println("Negative number");
          if(Number == null)
              return 0;
          BigInteger Number_ = BigInteger.valueOf(1);
          byte Length_ = 1;
          while ((Number_.shiftLeft(1)).compareTo(Number)<0)
              ++Length_;
          return Length_;
      }

    /*  public boolean[] getBinary(BigInteger Number){
          byte Length_ = Length(Number);
          boolean[] Figure_= new boolean[Length_];
          long Number_ = 1;
          for (int i = Length_ - 1; i >= 0; --i){
              if((Number & Number_) != 0)
                  Figure_[i] = true;
              Number_ <<= 1;
          }
          return Figure_;
      }
  */
  /*   public void ViewBinary (BigInteger Number){
        ViewBinary(getBinary(Number));
    }
*/
    //возведение числа в степень по модулю
    public BigInteger PowerByModule(BigInteger Number, BigInteger Power, BigInteger Module) {
        if (Power.compareTo(BigInteger.ZERO) < 0)
            return BigInteger.valueOf(-1);
        if (Module.compareTo(BigInteger.ZERO) < 0)
            return BigInteger.valueOf(-1);
        int Length_;
        //boolean[] Figure_ = getBinary((BigInteger) Power);
        char[] Figure_ = Power.toString(2).toCharArray();
        BigInteger[] Power_ = new BigInteger[Length_ = Figure_.length];
        BigInteger Result_ = BigInteger.valueOf(1);
        Power_[Length_ - 1] = Number.mod(Module);
        //Number % Module;
        for (int i = Length_ - 1; i > 0; --i)
            Power_[i - 1] = (Power_[i].multiply(Power_[i])).mod(Module);
        for (int i = Length_; i > 0; )
            if (Figure_[--i] == '1')
                Result_ = (Result_.multiply(Power_[i])).mod(Module);
        return Result_;
    }



    /*public void ViewBinary(boolean[] NumberBinary){
        for (boolean b: NumberBinary) {
            if(b)
                System.out.print(1);
            else
                System.out.print(0);
        }
    }*/

    /*public static class Main {
        public static void main(String[] args) {
            PowerBM a = new PowerBM();
            System.out.println(a.PowerByModule(BigInteger.valueOf(2), BigInteger.valueOf(5), BigInteger.valueOf(10)));
        }
    }*/
}

