package ens18trn.cs.umu.se;

import org.openjdk.jmh.annotations.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Warmup(iterations = 1, time = 10000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
@State(Scope.Benchmark)
public class Experiment3JMH {
    private Experiment3 experiment;
    @Param({"3292489", "6584983", "13169977"})
    public int iterations;
    @Param({"102877", "1646237", "13169977", "26339969"})
    public int tableSize;
    public float dhloadFactor = 0.5f;
    public float chloadFactor = 0.5f;
    public float defaultloadFactor = 0.85f;

    @Setup(Level.Trial)
    public void setup(){
        experiment = new Experiment3();
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDefaultInsert(Experiment3JMH plan){
        switch (iterations) {
            case 1646237:
                experiment.defaultSetup(plan.tableSize, defaultloadFactor);
                experiment.defaultInsertTest(experiment.randomLists.get(0));
                break;
            case 3292489:
                experiment.defaultSetup(plan.tableSize, defaultloadFactor);
                experiment.defaultInsertTest(experiment.randomLists.get(1));
                break;
            case 6584983:
                experiment.defaultSetup(plan.tableSize, defaultloadFactor);
                experiment.defaultInsertTest(experiment.randomLists.get(2));
                break;
            case 13169977:
                experiment.defaultSetup(plan.tableSize, defaultloadFactor);
                experiment.defaultInsertTest(experiment.randomLists.get(3));
                break;
            default:
                throw new IllegalArgumentException("invalid param");
        }
    }

    /*@Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testCoalescedInsert(Experiment3JMH plan){
        switch (iterations) {
            case 1646237:
                experiment.chSetup(plan.tableSize, chloadFactor);
                experiment.chInsertTest(experiment.randomLists.get(0));
                break;
            case 3292489:
                experiment.chSetup(plan.tableSize, chloadFactor);
                experiment.chInsertTest(experiment.randomLists.get(1));
                break;
            case 6584983:
                experiment.chSetup(plan.tableSize, chloadFactor);
                experiment.chInsertTest(experiment.randomLists.get(2));
                break;
            case 13169977:
                experiment.chSetup(plan.tableSize, chloadFactor);
                experiment.chInsertTest(experiment.randomLists.get(3));
                break;
            default:
                throw new IllegalArgumentException("invalid param");
        }

    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDoubleInsert(Experiment3JMH plan){
        switch (iterations) {
            case 1646237:
                experiment.dhSetup(plan.iterations, dhloadFactor);
                experiment.dhInsertTest(experiment.randomLists.get(0));
                break;
            case 3292489:
                experiment.dhSetup(plan.iterations, dhloadFactor);
                experiment.dhInsertTest(experiment.randomLists.get(1));
                break;
            case 6584983:
                experiment.dhSetup(plan.iterations, dhloadFactor);
                experiment.dhInsertTest(experiment.randomLists.get(2));
                break;
            case 13169977:
                experiment.dhSetup(plan.iterations, dhloadFactor);
                experiment.dhInsertTest(experiment.randomLists.get(3));
                break;
            default:
                throw new IllegalArgumentException("invalid param");
    }*/
}
