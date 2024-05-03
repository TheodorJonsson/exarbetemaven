package ens18trn.cs.umu.se;

import org.openjdk.jmh.annotations.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Warmup(iterations = 1, time = 1000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
@State(Scope.Benchmark)
public class Experiment3JMH {
    private Experiment3 experiment;
    @Param({"100000"})
    public int iterations;
    public float dhloadFactor = 0.5f;
    public float chloadFactor = 0.6f;
    public float defaultloadFactor = 0.75f;

    @Setup(Level.Trial)
    public void setup(){
        experiment = new Experiment3();
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDefaultInsert(Experiment3JMH plan){
        experiment.defaultSetup(plan.iterations, plan.defaultloadFactor);
        experiment.defaultInsertTest(experiment.randomLists.get(0));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testCoalescedInsert(Experiment3JMH plan){
        experiment.chSetup(plan.iterations, plan.chloadFactor);
        experiment.chInsertTest(experiment.randomLists.get(0));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDoubleInsert(Experiment3JMH plan){
        experiment.dhSetup(plan.iterations, plan.dhloadFactor);
        experiment.dhInsertTest(experiment.randomLists.get(0));
    }
}
