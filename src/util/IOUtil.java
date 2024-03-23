package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IOUtil {

    public static int inputNumber(Integer min, Integer max, String errorMessage) {
        int result;
        while (true) {
            try {
                result = new Scanner(System.in).nextInt();
                if (min != null && result < min) {
                    throw new InputMismatchException();
                }
                if (max != null && result > max) {
                    throw new InputMismatchException();
                }
                return result;
            } catch (InputMismatchException e) {
                System.out.print(errorMessage);
            }
        }
    }


    public static float inputNumber(Float min, Float max, String errorMessage) {
        float result;
        while (true) {
            try {
                result = new Scanner(System.in).nextFloat();
                if (min != null && result < min) {
                    throw new InputMismatchException();
                }
                if (max != null && result > max) {
                    throw new InputMismatchException();
                }
                return result;
            } catch (InputMismatchException e) {
                System.out.print(errorMessage);
            }
        }
    }

}
