package ens18trn.cs.umu.se;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import static ens18trn.cs.umu.se.Main.iterationsPrime;

public class Experiment3Joular {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();

    public Experiment3Joular(){
        setup();
    }

    private void setup() {
        for(int i = 0; i < iterationsPrime[0]; i++){
            randomList1.add(i);
        }
        for(int i = 0; i < iterationsPrime[1]; i++){
            randomList2.add(i);
        }
        for(int i = 0; i < iterationsPrime[2]; i++){
            randomList3.add(i);
        }
        for(int i = 0; i < iterationsPrime[3]; i++){
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
    public void chInsertTest(ArrayList<Integer> iterations, int capacityNR, int iterNR){
        insertTest(iterations, capacityNR, iterNR, chHash);
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
    public void dhInsertTest(ArrayList<Integer> iterations, int capacityNR, int iterNR){
        insertTest(iterations, capacityNR, iterNR, dhHash);
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
    public void defaultInsertTest(ArrayList<Integer> iterations, int capacityNR, int iterNR){
        insertTest(iterations, capacityNR, iterNR, defaultHash);
    }

    private void insertTest(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        if(capacityNR == 0 && iterNR == 0){
            insertTest00(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 0 && iterNR == 1){
            insertTest01(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 0 && iterNR == 2){
            insertTest02(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 0 && iterNR == 3){
            insertTest03(iterations, capacityNR, iterNR, hash);
        }
        //size index 1
        else if(capacityNR == 1 && iterNR == 0){
            insertTest10(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 1 && iterNR == 1){
            insertTest11(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 1 && iterNR == 2){
            insertTest12(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 1 && iterNR == 3){
            insertTest13(iterations, capacityNR, iterNR, hash);
        }
        //size index 2
        else if(capacityNR == 2 && iterNR == 0){
            insertTest20(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 2 && iterNR == 1){
            insertTest21(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 2 && iterNR == 2){
            insertTest22(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 2 && iterNR == 3){
            insertTest23(iterations, capacityNR, iterNR, hash);
        }
        //size index 3
        else if(capacityNR == 3 && iterNR == 0){
            insertTest30(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 3 && iterNR == 1){
            insertTest31(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 3 && iterNR == 2){
            insertTest32(iterations, capacityNR, iterNR, hash);
        }
        else if(capacityNR == 3 && iterNR == 3){
            insertTest33(iterations, capacityNR, iterNR, hash);
        }
    }
    // size index 0
    private void insertTest00(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest01(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest02(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest03(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    // size index 1
    private void insertTest10(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest11(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest12(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest13(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    //size index 2
    private void insertTest20(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest21(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest22(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest23(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    //size index 3
    private void insertTest30(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest31(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest32(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTest33(ArrayList<Integer> iterations, int capacityNR, int iterNR, HashMap hash){
        for(Integer i = 0; i < iterations.size(); i++){
            hash.put(iterations.get(i), "0");
        }
    }
}
