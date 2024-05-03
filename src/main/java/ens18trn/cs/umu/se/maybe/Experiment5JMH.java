package ens18trn.cs.umu.se.maybe;


import ens18trn.cs.umu.se.Experiment5;
import org.openjdk.jmh.annotations.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Warmup(iterations = 1, time = 10000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
@State(Scope.Benchmark)
public class Experiment5JMH {
    private Experiment5 experiment;
    @Param({"100000", "200000", "300000", "400000"})
    public int iterations;

    @Setup(Level.Trial)
    public void setup() {
        experiment = new Experiment5();
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDefaultInsert(Experiment5JMH plan) {
        experiment.defaultSetup(plan.iterations, 1f);
        experiment.defaultLookupTest(experiment.randomLists.get(0));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testCoalescedInsert(Experiment5JMH plan) {
        experiment.chSetup(plan.iterations, 1f);
        experiment.chLookupTest(experiment.randomLists.get(0));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDoubletInsert(Experiment5JMH plan) {
        experiment.dhSetup(plan.iterations, 1f);
        experiment.dhLookupTest(experiment.randomLists.get(0));
    }
}