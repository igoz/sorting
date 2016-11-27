package ru.mail.polis.sort.valid;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.mail.polis.sort.*;

@RunWith(value = Parameterized.class)
public class LSDTest {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public long[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<long[]> data() {
        return Arrays.asList(new long[][]{
                {0L},
                {0L, 0L, 0L, 0L},
                {4L, 3L, 2L, 1L},
                {0L, 1L, 1L, 0L},
                {1L},
                {Long.MAX_VALUE, 0L, 0L, Long.MIN_VALUE},
                Helper.genLongs(1),
                Helper.genLongs(10),
                Helper.genLongs(100),
                Helper.genLongs(1000),
                Helper.genLongs(10000),
        });
    }

    private boolean isSorted(long[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkLSDLong() throws IOException {
        Assert.assertTrue(isSorted(LSDLong.sort(array)));
    }
}