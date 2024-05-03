package ens18trn.cs.umu.se;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Experiment 2: insertion, resizing, and load factor
 *
 * For each run, initialize the hashmap to a size of x,
 * with a maximum load factor of 0.05 and then insert z amount of randomly generated numbers.
 * Each run will increase the maximum load factor by 0.05 this will go on until the maximum load factor reaches 1.
 * The best performing load factor will be selected and used in experiment 3.
 * The runtime of each run and the energy consumption of each run will be measured in this experiment
 */
@Warmup(iterations = 1, time = 1000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
@State(Scope.Benchmark)
public class Experiment2JMH {
    private Experiment2 experiment;
    @Param({"100000"})
    public int iterations;
    @Param({"0.05", "0.1", "0.15", "0.2", "0.25", "0.3", "0.35", "0.40", "0.45", "0.5", "0.55", "0.6", "0.65", "0.7", "0.75", "0.8", "0.85", "0.9", "0.95", "1"})
    public float loadFactor;

    @Setup(Level.Trial)
    public void setup(){
        experiment = new Experiment2();
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDefaultInsert(Experiment2JMH plan){
        experiment.defaultSetup(plan.iterations, plan.loadFactor);
        experiment.defaultInsertTest(experiment.randomLists.get(0));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testCoalescedInsert(Experiment2JMH plan){
        experiment.chSetup(plan.iterations, plan.loadFactor);
        experiment.chInsertTest(experiment.randomLists.get(0));
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDoubletInsert(Experiment2JMH plan){
        experiment.dhSetup(plan.iterations, plan.loadFactor);
        experiment.dhInsertTest(experiment.randomLists.get(0));
    }

}
