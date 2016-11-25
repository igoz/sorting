package ru.mail.polis.bench;

import java.util.concurrent.TimeUnit;

import jdk.nashorn.tools.Shell;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class BubbleSortBench {

    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = Helper.gen(1000);
    }

    @Benchmark
    public void measureBubbleSort(Blackhole bh) {
        bh.consume(BubbleSort.sort(a));
    }

    @Benchmark
    public void measureInsertioneSort(Blackhole bh) {
        bh.consume(InsertionSort.sort(a));
    }

    @Benchmark
    public void measureOptimInsertioneSort(Blackhole bh) {
        bh.consume(OptimInsertionSort.sort(a));
    }

    @Benchmark
    public void measureShellSort(Blackhole bh) {
        bh.consume(ShellSort.sort(a));
    }

    @Benchmark
    public void measureMergeSort(Blackhole bh) {
        bh.consume(MergeSort.sort(a));
    }

    @Benchmark
    public void measureThreeWayQuickSort(Blackhole bh) {
        bh.consume(ThreeWayQuickSort.getSortedArray(a));
    }

    @Benchmark
    public void measureQuickSort(Blackhole bh) {
        bh.consume(QuickSort.getSortedArray(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BubbleSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
