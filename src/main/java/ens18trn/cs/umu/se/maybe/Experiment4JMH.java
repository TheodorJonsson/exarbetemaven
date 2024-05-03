package ens18trn.cs.umu.se.maybe;

import ens18trn.cs.umu.se.Experiment4;
import org.openjdk.jmh.annotations.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Warmup(iterations = 1, time = 10000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
@State(Scope.Benchmark)
public class Experiment4JMH {
    private Experiment4 experiment;
    @Param({"100000", "200000", "300000", "400000"})
    public int iterations;

    @Setup(Level.Trial)
    public void setup() {
        experiment = new Experiment4();
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDefaultInsert(Experiment4JMH plan) {
        experiment.defaultSetup(plan.iterations, 1f);
        experiment.defaultLookupTest(experiment.randomLists.get(plan.iterations / 100000));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testCoalescedInsert(Experiment4JMH plan) {
        experiment.chSetup(plan.iterations, 1f);
        experiment.chLookupTest(experiment.randomLists.get(plan.iterations / 100000));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDoubletInsert(Experiment4JMH plan) {
        experiment.dhSetup(plan.iterations, 1f);
        experiment.dhLookupTest(experiment.randomLists.get(plan.iterations / 100000));
    }
}