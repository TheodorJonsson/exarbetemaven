package ens18trn.cs.umu.se;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class Main {
    static ArrayList<Integer> randomList1 = new ArrayList<>();
    static ArrayList<Integer> randomList2 = new ArrayList<>();
    static ArrayList<Integer> randomList3 = new ArrayList<>();
    static ArrayList<Integer> randomList4 = new ArrayList<>();

    public static float dhload = 0.6f;
    public static float chload = 0.6f;
    public static float defaultload = 0.6f;
    public static int[] iterationsPrime = {1646237, 3292489, 6584983, 13169977};
    public static int[] iterations = {1000000, 2000000, 3000000, 4000000};
    public static int[] capacity = {11, 10000, 100000, 1000000, 1000000, 10000000, 100000000};
    public static float[] loadFactors = {0.05f, 0.1f, 0.15f, 0.2f, 0.25f, 0.3f, 0.35f, 0.40f, 0.45f, 0.5f, 0.55f, 0.6f, 0.65f, 0.7f, 0.75f, 0.8f, 0.85f, 0.9f, 0.95f, 1f};
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //long dhtime = testJoular.dhInsertTest();
        //System.out.println(TimeUnit.NANOSECONDS.toMillis(dhtime));
        //long chtime = testJoular.chInsertTest();
        //System.out.println(TimeUnit.NANOSECONDS.toMillis(chtime));
        //long defaults = testJoular.defaultInsertTest();
        //System.out.println(TimeUnit.NANOSECONDS.toMillis(defaults));
        /**
         * Experiment 1.
         * For JoularJX
         */
        //runExperiment1();
        runExperiment2();
        //runExperiment3();
        //runExperiment4();
        //runExperiment5();
        /**
         * Load factor testing
         */
        //runExperiment1load();
       // runExperiment4Load();
        //runExperiment5Load();
    }


    /**
     * For each run, initialize the hashmap with a size of 100.000,
     * then insert random generated numbers set with a seed into the hashmap until it reaches a load factor of 1,
     * without any resizing of the table. The runtime, average time for insertions at load factor intervals of 0.05,
     * and the energy consumption of each run will be measured in this experiment
     */
    private static void runExperiment1() {
        int runs = 20, iterationNR = 4, capacities = 4;
        Experiment1 exp1 = new Experiment1();
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp1.chSetup(iterationsPrime[i]);
                exp1.chInsertTest(exp1.randomLists.get(i));
            }
        }
        System.out.println("Done with coalesced");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp1.dhSetup(iterationsPrime[i]);
                exp1.dhInsertTest(exp1.randomLists.get(i));
            }
        }
        System.out.println("Done with double");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp1.defaultSetup(iterationsPrime[i]);
                exp1.defaultInsertTest(exp1.randomLists.get(i));

            }
        }
    }

    /**
     * For each run, initialize the hashmap their default size 11 for double hashing and coalesced and 16 for the default implementation,
     * with a maximum load factor of 0.05 and then insert 100,000 amount of randomly generated numbers.
     * Each run will increase the maximum load factor by 0.05 this will go on until the maximum load factor reaches 1.
     * The best performing load factor will be selected and used in experiment 3.
     * The runtime of each run and the energy consumption of each run will be measured in this experiment
     */
    private static void runExperiment2(){
        int runs = 20, capacities = 4;
        Experiment2Joular exp2 = new Experiment2Joular();
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp2.dhSetup(capacity[i], loadFactors[j]);
                exp2.dhInsertTest(exp2.randomLists.get(0), loadFactors[j]);
                System.out.println("done with " + loadFactors[j]);
            }
        }
        System.out.println("Done with double");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp2.chSetup(capacity[i], loadFactors[j]);
                exp2.chInsertTest(exp2.randomLists.get(0), loadFactors[j]);
                System.out.println("done with " + loadFactors[j]);
            }

        }
        System.out.println("Done with coalesced");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp2.defaultSetup(capacity[i], loadFactors[j]);
                exp2.defaultInsertTest(exp2.randomLists.get(0), loadFactors[j]);

            }
        }
    }

    /**
     * For each run, initialize the hashmap to x size and a set maximum load factor,
     * then insert x amount of random generated numbers set with a seed into the hashmap until the amount of insertions is the same as
     * the original table size. This is repeated for varying table sizes.
     * The runtime of each run and the energy consumption of each run will be measured in this experiment.
     */
    private static void runExperiment3(){
        int runs = 20, capacities = 4;
        Experiment3 exp3 = new Experiment3();
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp3.chSetup(capacity[i], chload);
                exp3.chInsertTest(exp3.randomLists.get(i));
            }
        }
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp3.dhSetup(capacity[i], dhload);
                exp3.dhInsertTest(exp3.randomLists.get(i));
            }
        }
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp3.defaultSetup(iterationsPrime[i], defaultload);
                exp3.defaultInsertTest(exp3.randomLists.get(i));

            }
        }
    }

    /**
     * For each run, initialize the hashmap to x size,
     * then insert y random generated numbers set with a seed into the hashmap and at each interval of 0.05 load factor until 1,
     * do z amount of lookups for values that exist within the hashmap.
     * The average time for a lookup each load factor interval and the energy consumption of z amount of lookups at each load factor will be measured
     */
    private static void runExperiment4(){
        int runs = 20, capacities = 4;
        Experiment4 exp4 = new Experiment4();
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp4.chSetup(iterationsPrime[0], 1f);
                exp4.chLookupTest(exp4.randomLists.get(0));
            }
        }
        System.out.println("Done with coalesced hashing");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp4.dhSetup(iterationsPrime[0], 1f);
                exp4.dhLookupTest(exp4.randomLists.get(0));
            }
        }
        System.out.println("Done with double hashing");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp4.defaultSetup(iterationsPrime[0], 1f);
                exp4.defaultLookupTest(exp4.randomLists.get(0));

            }
        }
    }

    /**
     * For each run, initialize the hashmap to x size (same as 4),
     * then insert random generated numbers set with a seed into the hashmap and at each interval of 0.05 load factor until 1,
     * do z amount of lookups for values that do not exist within the hashmap.
     * The average time for a lookup each load factor interval and the energy consumption of z amount of lookups at each load factor will be measured
     */
    private static void runExperiment5(){
        int runs = 20, capacities = 4;
        Experiment5 exp5 = new Experiment5();
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp5.chSetup(iterationsPrime[i], 1f);
                exp5.chLookupTest(exp5.randomLists.get(0));
            }
        }
        System.out.println("Done with coalesced hashing");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp5.dhSetup(iterationsPrime[i], 1f);
                exp5.dhLookupTest(exp5.randomLists.get(0));
            }
        }
        System.out.println("Done with double hashing");
        for(int i = 0; i < capacities; i++){
            for(int j = 0; j < runs; j++) {
                exp5.defaultSetup(iterationsPrime[i], 1f);
                exp5.defaultLookupTest(exp5.randomLists.get(0));

            }
        }
        System.out.println("Done with Default hashing");
    }

    /************************* Load Factor Tests ******************************************************/

    private static void runExperiment1load(){
        int runs = 20, capacities = 4;
        ArrayList<String[]> sums = new ArrayList<>();
        Experiment1Loadfactor exp1 = new Experiment1Loadfactor();
        //int[] capAndIter = {10000000, 20000000, 30000000, 40000000};
        for(int i = 0; i < capacities; i++){
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp1.chSetup(iterationsPrime[i]);
            sums = (exp1.chInsertTest(exp1.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment1-Coalesced", iterationsPrime[i], capacities, sums);
        }
        for(int i = 0; i < capacities; i++){
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp1.defaultSetup(iterationsPrime[i]);
            sums = (exp1.defaultInsertTest(exp1.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment1-Default: ", iterationsPrime[i], capacities, sums);
        }
        for(int i = 0; i < capacities; i++){
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp1.dhSetup(iterationsPrime[i]);
            sums = (exp1.dhInsertTest(exp1.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment1-Double: ", iterationsPrime[i], capacities, sums);
        }
    }

    /**
     * Runs experiment 4 with time per load factor.
     */
    private static void runExperiment4Load() {
        int runs = 20, capacities = 4;
        ArrayList<String[]> sums = new ArrayList<>();
        Experiment4Loadfactor exp4 = new Experiment4Loadfactor();
        for(int i = 0; i < capacities; i++) {
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp4.chSetup(iterationsPrime[i], 1f);
            sums = (exp4.chLookupTest(exp4.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment4-Coalesced: ", iterationsPrime[i], capacities, sums);
        }
        for(int i = 0; i < capacities; i++){
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp4.dhSetup(iterationsPrime[i], 1f);
            sums = (exp4.dhLookupTest(exp4.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment4-Double: ", iterationsPrime[i], capacities, sums);
        }
        for(int i = 0; i < capacities; i++){
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp4.defaultSetup(iterationsPrime[i], 1f);
            sums = (exp4.defaultLookupTest(exp4.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment4-default: ", iterationsPrime[i], capacities, sums);
        }
    }

    /**
     * Runs experiment 5 with time per load factor.
     */
    private static void runExperiment5Load() {
        int runs = 20, capacities = 1;
        ArrayList<String[]> sums = new ArrayList<>();
        Experiment5LoadFactor exp5 = new Experiment5LoadFactor();
        for(int i = 0; i < capacities; i++) {
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp5.chSetup(iterationsPrime[i], 1f);
            sums = (exp5.chLookupTest(exp5.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment5-Coalesced: ", iterationsPrime[i], capacities, sums);
        }
        for(int i = 0; i < capacities; i++){
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp5.dhSetup(iterationsPrime[i], 1f);
            sums = (exp5.dhLookupTest(exp5.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment5-Double: ", iterationsPrime[i], capacities, sums);
        }
        for(int i = 0; i < capacities; i++){
            System.out.println("Capacity: " + iterationsPrime[i] + " Starting......");
            exp5.defaultSetup(iterationsPrime[i], 1f);
            sums = (exp5.defaultLookupTest(exp5.randomLists.get(i)));
            System.out.println("Capacity: " + iterationsPrime[i] + " done");
            writeToCSVFile("experiment5-default: ", iterationsPrime[i], capacities, sums);
        }
    }


    /********************** Helper methods ********************************************************/
    private static void writeToCSVFile(String name, int iterations, int capacities,ArrayList<String[]> sums) {
        for(int i = 0; i < capacities; i++) {
            String directory = "/home/theodor/IdeaProjects/exarbetemaven/src/main/java/ens18trn/cs/umu/se/loadfactorresults/";
            String fileName = name + " " + iterations + ".csv";
            File file = new File(directory + fileName);
            try {
                FileWriter outPutFile = new FileWriter(file);
                CSVWriter writer = new CSVWriter(outPutFile);
                writer.writeAll(sums);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
