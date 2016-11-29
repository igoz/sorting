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

public class MSDStringTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    private boolean isSorted(String[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1 && isSorted; ++i) {
            isSorted = array[i].compareTo(array[i] + 1) <= 0;
        }
        return isSorted;
    }


    @Test
    public void test01_checkMSDStrings() throws IOException {
        Assert.assertTrue(isSorted(MSDString.sort(Helper.genStrings(10000, 200))));
    }
}