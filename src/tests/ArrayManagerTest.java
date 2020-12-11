
import main.ArraysManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;


public class ArrayManagerTest {

    @ParameterizedTest
    @MethodSource("expectedParametersProviderForGetArrayAfterDigit")
    void getArrayAfterDigitGoodResult(int[] parameters, int[] expected) {
        Assertions.assertArrayEquals(expected, ArraysManager.getArrayAfterDigit(parameters, 4));
    }

    private static Stream<Arguments> expectedParametersProviderForGetArrayAfterDigit() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, new int[]{5}),
                Arguments.arguments(new int[]{4, 3, 4, 2}, new int[]{2}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4}, new int[]{}),
                Arguments.arguments(new int[]{4, 1, 1, 1, 1}, new int[]{1, 1, 1, 1}),
                Arguments.arguments(new int[]{-1, -2, 4, -1, -5}, new int[]{-1, -5})
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("wrongParametersProviderForGetArrayAfterDigit")
    void getArrayAfterDigitThrowException(int[] parameters) {
        RuntimeException e = Assertions.assertThrows(RuntimeException.class,
                () -> ArraysManager.getArrayAfterDigit(parameters, 4));
        Assertions.assertNotNull(e);
    }

    private static Stream<int[]> wrongParametersProviderForGetArrayAfterDigit() {
        return Stream.of(
                new int[]{0, -1, 0, 0},
                new int[]{},
                null
        );
    }

    @ParameterizedTest
    @MethodSource("expectedParametersProviderForCheckDigitsInArray")
    void shouldReturnTrueCheckDigitsInArray(int[] parameters) {
        Assertions.assertTrue(ArraysManager.checkDigitsInArray(parameters, 1, 4));
    }

    private static Stream<int[]> expectedParametersProviderForCheckDigitsInArray() {
        return Stream.of(
                new int[]{1, 4, 1, 4},
                new int[]{4, 1, 4, 1},
                new int[]{1, 1, 4, 4, 1},
                new int[]{4, 4, 1, 1}
        );
    }

    @ParameterizedTest
    @MethodSource("wrongParametersProviderForCheckDigitsInArray")
    void shouldReturnFalseCheckDigitsInArray(int[] parameters) {
        Assertions.assertFalse(ArraysManager.checkDigitsInArray(parameters, 1, 4));
    }

    private static Stream<int[]> wrongParametersProviderForCheckDigitsInArray() {
        return Stream.of(
                new int[]{1, 4, 1, 5},
                new int[]{4, 4, 4, 4},
                new int[]{1, 1, 1, 1, 1},
                new int[]{5,2,1,3},
                new int[]{1},
                new int[]{4},
                new int[]{},
                null
        );
    }


}
