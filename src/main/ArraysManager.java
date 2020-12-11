package main;

import java.util.Arrays;

public final class ArraysManager {
    private static final int EMPTY_INDEX = -1;

    private ArraysManager() {
    }

    public static int[] getArrayAfterDigit(int[] array, int digit) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("Array doesn't contain the digit: " + digit);
        }
        int index = EMPTY_INDEX;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == digit) index = i + 1;
        }

        if (index == EMPTY_INDEX) {
            throw new RuntimeException("Array doesn't contain the digit: " + digit);
        }

        return Arrays.copyOfRange(array, index, array.length);
    }

    public static boolean checkDigitsInArray(int[] array, int digit1, int digit2) {
        if (array != null && array.length > 1) {
            boolean isDigit1Contains = false;
            boolean isDigit2Contains = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == digit1) {
                    isDigit1Contains = true;
                } else if (array[i] == digit2) {
                    isDigit2Contains = true;
                } else if (array[i] != digit1 && array[i] != digit2) {
                    return false;
                }
            }
            return isDigit1Contains && isDigit2Contains;
        }
        return false;
    }

}
