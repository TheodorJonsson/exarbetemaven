package ens18trn.cs.umu.se;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import static ens18trn.cs.umu.se.Main.iterations;

public class Experiment3 {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();

    public Experiment3(){
        setup();
    }

    private void setup() {
        for(int i = 0; i < iterations[0]; i++){
            randomList1.add(i);
        }
        for(int i = 0; i < iterations[1]; i++){
            randomList2.add(i);
        }
        for(int i = 0; i < iterations[2]; i++){
            randomList3.add(i);
        }
        for(int i = 0; i < iterations[3]; i++){
            randomList4.add(i);
        }
        Collections.shuffle(randomList1, new Random(1234));
        Collections.shuffle(randomList2, new Random(3456));
        Collections.shuffle(randomList2, new Random(6798));
        Collections.shuffle(randomList2, new Random(6354));
        randomLists.add(randomList1);
        randomLists.add(randomList2);
        randomLists.add(randomList3);
        randomLists.add(randomList4);
    }
    /**
     * Coalesced hashing HashMap setup
     * @param capacity, the initial capacity
     * @param loadFactor, the maximum laod factor.
     */
    public void chSetup(int capacity, float loadFactor){
        chHash = new HashMapCoalesced<Integer, String>(capacity, loadFactor);
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
        dhHash = new HashMapDouble(capacity, loadFactor);
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
        defaultHash = new HashMap<Integer, String>(capacity, loadFactor);

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
