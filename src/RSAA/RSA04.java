package RSAA;

import PowerByModule.PowerBM;
import java.math.BigInteger;
import java.util.Random;
import Test_MR.testMR;
import Mont.MontgomeryReducer;

/**
 * Created by milson on 23.10.16.
 */
public class RSA04 {
    PowerBM a = new PowerBM();


    static class Keys {
        BigInteger n = new BigInteger("9617");
        BigInteger d = new BigInteger("3869");
        BigInteger e = new BigInteger("17");
    }

    public static void main(String[] args) {
        Keys keys = new Keys();

        String message = "Good morning, people!";
        int blockSize = 4;

        RSA04 obj = new RSA04();

        System.out.println("Ключ отправителя:");
        System.out.println("e: " + keys.e);
        System.out.println("d: " + keys.d);
        System.out.println("n: " + keys.n);

        while (message.length() % (blockSize / 2) != 0) {
            message += "-";
        }
        System.out.println(
                "Сообщение отправителя:\n" + message);

        String encodedMsg = obj.encode(message);

        String signature = obj.doRSA(
                encodedMsg, keys.d, keys.n, blockSize);
        System.out.println(
                "Цифровая подпись отправителя\n" + signature);


        String signedMsg = message + "_" + signature;
        System.out.println(
                "Подписанное сообщение отправителя:\n"
                        + signedMsg);

        String extractedMsgText =
                signedMsg.substring(
                        0, signedMsg.indexOf('_'));
        System.out.println(
                "Извлеченный текст адресата:\n" + extractedMsgText);
        String extractedSignature =
                signedMsg.substring(
                        signedMsg.indexOf('_') + 1);
        System.out.println(
                "Полученная цифровая подпись:\n" + extractedSignature);


        String decipheredSignature = obj.doRSA(extractedSignature, keys.e, keys.n, blockSize);

        String decodedSignature = obj.decode(
                decipheredSignature);
        System.out.println(
                "Декодируется цифровая подпись адресата:\n"
                        + decodedSignature);


        if (extractedMsgText.equals(decodedSignature)) {
            System.out.println(
                    "Вывод адресата: подпись действительна");
        } else {
            System.out.println(
                    "Вывод адресата: подпись не действительна");
        }//end else
        System.out.println("Реализация со встроенной функцией modPow заняла " + System.currentTimeMillis()  + " ms.");

    }

    String encode(String message) {
        byte[] textChars = message.getBytes();
        String temp = "";
        String encodedMsg = "";

        for (int cnt = 0; cnt < message.length();
             cnt++) {
            temp = String.valueOf(
                    textChars[cnt] - ' ');

            if (temp.length() < 2) temp = "0" + temp;
            encodedMsg += temp;
        }//end for loop
        return encodedMsg;
    }//end encode

    String decode(String encodedMsg) {
        String temp = "";
        String decodedText = "";
        for (int cnt = 0; cnt < encodedMsg.length();
             cnt += 2) {
            temp = encodedMsg.substring(cnt, cnt + 2);

            int val = Integer.parseInt(temp) + 32;

            decodedText += String.valueOf((char) val);
        }
        return decodedText;
    }//end decode

    String doRSA(String inputString,
                 BigInteger exp,
                 BigInteger n,
                 int blockSize) {

        MontgomeryReducer b = new MontgomeryReducer(n);
        BigInteger block;
        BigInteger output;
        String temp = "";
        String outputString = "";

        for (int cnt = 0; cnt < inputString.length();
             cnt += blockSize) {

            temp = inputString.substring(
                    cnt, cnt + blockSize);

            block = new BigInteger(temp);

            output = block.modPow(exp, n);
            //output = b.pow(block, exp);
            //output = a.PowerByModule(block,exp,n);
            temp = output.toString();
            while (temp.length() < blockSize) {
                temp = "0" + temp;
            }
            outputString += temp;
        }

        return outputString;
    }
}

