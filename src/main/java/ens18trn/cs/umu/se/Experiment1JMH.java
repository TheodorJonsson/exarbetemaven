package ens18trn.cs.umu.se;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Experiment 1: insertion only
 *
 * For each run, initialize the hashmap to a set size,
 * then insert random generated numbers set with a seed into the hashmap
 * until it reaches a load factor of 1,
 * without any resizing of the table.
 * This is repeated for varying table sizes
 */
@Warmup(iterations = 1, time = 10000, timeUnit = MILLISECONDS)
@Measurement(iterations = 10, time = 2000, timeUnit = MILLISECONDS)
@State(Scope.Benchmark)
public class Experiment1JMH {
   private Experiment1 experiment;
    @Param({"1646237", "3292489", "6584983", "13169977"})
    public int iterations;
   @Setup(Level.Trial)
    public void setup(){
       experiment = new Experiment1();
   }

   @Benchmark
   @BenchmarkMode({Mode.AverageTime})
    public void testDefaultInsert(Experiment1JMH plan) {
       switch (iterations) {
           case 1646237:
               experiment.defaultSetup(plan.iterations);
               experiment.defaultInsertTest(experiment.randomLists.get(0));
               break;
           case 3292489:
               experiment.defaultSetup(plan.iterations);
               experiment.defaultInsertTest(experiment.randomLists.get(1));
               break;
           case 6584983:
               experiment.defaultSetup(plan.iterations);
               experiment.defaultInsertTest(experiment.randomLists.get(2));
               break;
           case 13169977:
               experiment.defaultSetup(plan.iterations);
               experiment.defaultInsertTest(experiment.randomLists.get(3));
               break;
           default:
               throw new IllegalArgumentException("invalid param");
       }
   }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testCoalescedInsert(Experiment1JMH plan){
        switch (iterations) {
            case 1646237:
                experiment.chSetup(plan.iterations);
                experiment.chInsertTest(experiment.randomLists.get(0));
                break;
            case 3292489:
                experiment.chSetup(plan.iterations);
                experiment.chInsertTest(experiment.randomLists.get(1));
                break;
            case 6584983:
                experiment.chSetup(plan.iterations);
                experiment.chInsertTest(experiment.randomLists.get(2));
                break;
            case 13169977:
                experiment.chSetup(plan.iterations);
                experiment.chInsertTest(experiment.randomLists.get(3));
                break;
            default:
                throw new IllegalArgumentException("invalid param");
        }
   }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime})
    public void testDoubletInsert(Experiment1JMH plan) {
        switch (iterations) {
            case 1646237:
                experiment.dhSetup(plan.iterations);
                experiment.dhInsertTest(experiment.randomLists.get(0));
                break;
            case 3292489:
                experiment.dhSetup(plan.iterations);
                experiment.dhInsertTest(experiment.randomLists.get(1));
                break;
            case 6584983:
                experiment.dhSetup(plan.iterations);
                experiment.dhInsertTest(experiment.randomLists.get(2));
                break;
            case 13169977:
                experiment.dhSetup(plan.iterations);
                experiment.dhInsertTest(experiment.randomLists.get(3));
                break;
            default:
                throw new IllegalArgumentException("invalid param");
        }
    }
}