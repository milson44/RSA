package Evklid;

import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Created by milson on 17.10.16.
 */
public class Solution {
    public static void main(String[] args) {
        // Для считывания воспользуемся классом Scanner
        // Для вывода - классом PrintWriter
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int a;
        a = scanner.nextInt();
        int b;
        b = scanner.nextInt();

        printWriter.println(gcd(a, b));

        // После выполнения программы необходимо закрыть
        // потоки ввода и вывода
        scanner.close();
        printWriter.close();
    }

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }
}
