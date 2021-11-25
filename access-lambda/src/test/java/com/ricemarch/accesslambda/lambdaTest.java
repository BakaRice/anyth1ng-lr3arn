package com.ricemarch.accesslambda;

import com.ricemarch.accesslambda.dto.Track;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author tanwentao
 * @since 2021/11/23
 */
@Slf4j
public class lambdaTest {

    //指定lambda表达式的最小的类型

    private interface IntegerBiFunction extends BinaryOperator<Integer> {
    }

    private interface NanoIntegerBiFunction extends IntegerBiFunction {

    }

    private void overloadedMethod(BinaryOperator<Integer> lambda) {
        System.out.println("BinaryOperator");
    }

    private void overloadedMethod(NanoIntegerBiFunction lambda) {
        System.out.println("NanoIntegerBiFunction");
    }

    private void overloadedMethod(IntegerBiFunction lambda) {
        System.out.println("IntegerBinaryOperator");
    }

    @Test
    public void overloadTest() {
        //Lambda can be replaced with method reference
        overloadedMethod((x, y) -> x + y);
    }

    //重载方法导致的编译错误

    private interface IntPredicate {
        public boolean test(int value);
    }

    private void overloadMethod2(Predicate<Integer> predicate) {
        System.out.println("Predicate");
    }

    private void overloadMethod2(IntPredicate predicate) {
        System.out.println("IntPredicate");
    }

    @Test
    public void overloadErrTest() {
        overloadMethod2(((Predicate<Integer>) (x) -> x > 10));
        overloadMethod2((IntPredicate) (x) -> x > 10);
        //error
        // overloadMethod2((x) -> x > 10);
    }


    @Test
    public void flatMap() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4)).flatMap(Collection::stream).collect(Collectors.toList());

        long reduce = together.stream().mapToLong(Integer::longValue).reduce(0, Long::sum);
        assert asList(1, 2, 3, 4).equals(together);
    }

    @Test
    public void MaxMin() {
        List<Track> tracks = asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378), new Track("Time Was", 451));
        Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
        //Lambda can be replaced with method reference
    }


    @Test
    public void Logger() {
        MyLogger myLogger = new MyLogger();
        myLogger.debug(() -> "HI12221");


    }
}
