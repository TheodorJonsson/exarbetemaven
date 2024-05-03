package ens18trn.cs.umu.se;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Experiment 2: insertion, resizing, and load factor
 *
 * For each run, initialize the hashmap to a size of x,
 * with a maximum load factor of 0.05 and then insert z amount of randomly generated numbers.
 * Each run will increase the maximum load factor by 0.05 this will go on until the maximum load factor reaches 1.
 * The best performing load factor will be selected and used in experiment 3.
 * The runtime of each run and the energy consumption of each run will be measured in this experiment
 */
import static ens18trn.cs.umu.se.Main.iterations;
public class Experiment2 {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>(iterations[0]);
    //public ArrayList<Integer> randomList2 = new ArrayList<>(capAndIter[1]);
    //public ArrayList<Integer> randomList3 = new ArrayList<>(capAndIter[2]);
    //public ArrayList<Integer> randomList4 = new ArrayList<>(capAndIter[3]);

    public Experiment2(){
        setup();
    }

    private void setup() {
        Random rand1 = new Random();
        rand1.setSeed(1234);
        Random rand2 = new Random();
        rand2.setSeed(3456);
        Random rand3 = new Random();
        rand3.setSeed(6798);
        Random rand4 = new Random();
        rand4.setSeed(6354);
        while(randomList1.size() < iterations[0]){
            int rand = rand1.nextInt();
            if(!randomList1.contains(rand)){
                randomList1.add(rand);
            }
        }
        randomLists.add(randomList1);
        // Removed for JMH tests
        /*while(randomList2.size() < capAndIter[1]){
            int rand = rand2.nextInt();
            if(!randomList2.contains(rand)){
                randomList2.add(rand);
            }
        }
        randomLists.add(randomList2);
        while(randomList3.size() < capAndIter[2]){
            int rand = rand3.nextInt();
            if(!randomList3.contains(rand)){
                randomList3.add(rand);
            }

        }
        randomLists.add(randomList3);
        while(randomList4.size() < capAndIter[3]){
            int rand = rand4.nextInt();
            if(!randomList4.contains(rand)){
                randomList4.add(rand);
            }
        }
        randomLists.add(randomList4);*/
    }
    /**
     * Coalesced hashing HashMap setup
     * @param capacity, the initial capacity
     * @param loadFactor, the maximum laod factor.
     */
    public void chSetup(int capacity, float loadFactor){
        chHash = new HashMapCoalesced<Integer, String>(11, loadFactor);
    }

    /**
     * Coalesced hashing insertion test
     */
    public void chInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < iterations.size(); i++){
            chHash.put(iterations.get(i), "0");
        }
    }

    /**
     * Double hashing HashMap setup
     * @param capacity, the initial capacity
     * @param loadFactor, the maximum load factor
     */
    public void dhSetup(int capacity, float loadFactor){
        dhHash = new HashMapDouble(11, loadFactor);
    }

    /**
     * Double hashing insertion test.
     * @param insertions, amount of insertions to be done and measured.
     */
    public void dhInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < iterations.size(); i++){
            dhHash.put(iterations.get(i), "0");
        }
    }

    /**
     * Default HashMap implementation setup
     * @param capacity, the initial capacity
     * @param loadFactor, the maximum load factor
     */
    public void defaultSetup(int capacity, float loadFactor){
        defaultHash = new HashMap<Integer, String>(16, loadFactor);

    }

    /**
     * Default HashMap insertion test.
     * @return
     */
    public void defaultInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < iterations.size(); i++){
            defaultHash.put(iterations.get(i), "0");
        }
    }
}
