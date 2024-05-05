package ens18trn.cs.umu.se;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import static ens18trn.cs.umu.se.Main.iterationsPrime;

public class Experiment2Joular {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();

    public Experiment2Joular(){
        setup();
    }

    private void setup() {
        for(int i = 0; i < iterationsPrime[0]; i++){
            randomList1.add(i);
        }
        /*for(int i = 0; i < iterationsPrime[1]; i++){
            randomList2.add(i);
        }
        for(int i = 0; i < iterationsPrime[2]; i++){
            randomList3.add(i);
        }
        for(int i = 0; i < iterationsPrime[3]; i++){
            randomList4.add(i);
        }*/
        Collections.shuffle(randomList1, new Random(1234));
       /* Collections.shuffle(randomList2, new Random(3456));
        Collections.shuffle(randomList2, new Random(6798));
        Collections.shuffle(randomList2, new Random(6354));*/
        randomLists.add(randomList1);
       /* randomLists.add(randomList2);
        randomLists.add(randomList3);
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
    public void chInsertTest(ArrayList<Integer> iterations, float loadFactor){
        insertTest(iterations, loadFactor, chHash);
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
    public void dhInsertTest(ArrayList<Integer> iterations, float loadFactor){
        insertTest(iterations, loadFactor, dhHash);
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
    public void defaultInsertTest(ArrayList<Integer> iterations, float loadFactor){
        insertTest(iterations, loadFactor, defaultHash);
    }

    private void insertTest(ArrayList<Integer> iterations, float loadFactor, HashMap hash){
        if(loadFactor == 0.05f){
            insert05(iterations, hash);
        }else if (loadFactor == 0.10f) {
            insert10(iterations, hash);
        } else if (loadFactor == 0.15f) {
            insert15(iterations, hash);
        } else if (loadFactor == 0.20f) {
            insert20(iterations, hash);
        } else if (loadFactor == 0.25f) {
            insert25(iterations, hash);
        } else if (loadFactor == 0.30f) {
            insert30(iterations, hash);
        } else if (loadFactor == 0.35f) {
            insert35(iterations, hash);
        } else if (loadFactor == 0.40f) {
            insert40(iterations, hash);
        } else if (loadFactor == 0.45f) {
            insert45(iterations, hash);
        } else if (loadFactor == 0.50f) {
            insert50(iterations, hash);
        } else if (loadFactor == 0.55f) {
            insert55(iterations, hash);
        } else if (loadFactor == 0.60f) {
            insert60(iterations, hash);
        } else if (loadFactor == 0.65f) {
            insert65(iterations, hash);
        } else if (loadFactor == 0.70f) {
            insert70(iterations, hash);
        } else if (loadFactor == 0.75f) {
            insert75(iterations, hash);
        } else if (loadFactor == 0.80f) {
            insert80(iterations, hash);
        } else if (loadFactor == 0.85f) {
            insert85(iterations, hash);
        } else if (loadFactor == 0.90f) {
            insert90(iterations, hash);
        } else if (loadFactor == 0.95f) {
            insert95(iterations, hash);
        } else if (loadFactor == 1.00f) {
            insert100(iterations, hash);
        } else {
            // Handle invalid load factors
            System.out.println("Invalid load factor.");
        }
    }

    private void insert05(ArrayList<Integer> iterations, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insert10(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert15(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert20(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert25(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert30(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert35(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert40(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert45(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert50(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert55(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert60(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert65(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert70(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert75(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert80(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert85(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert90(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert95(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insert100(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = 0; i < iterations.size(); i++) {
            hash.put(iterations.get(i), "0");
        }
    }
}
