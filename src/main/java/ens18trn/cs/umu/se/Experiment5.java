package ens18trn.cs.umu.se;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import static ens18trn.cs.umu.se.Main.iterations;

public class Experiment5 {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();
    public DecimalFormat df = new DecimalFormat("##.00");

    public Experiment5(){
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
        for(int i = 0; i < iterations[0]; i++){
            randomList1.add(i);
        }
        for(int i = iterations[0]; i < iterations[1]; i++){
            randomList2.add(i);
        }
        Collections.shuffle(randomList1, new Random(1234));
        Collections.shuffle(randomList2, new Random(3456));
        System.out.println("Starting Experiment 5");
        /*while(randomList1.size() < iterations[0]){
            int rand = rand1.nextInt();
            if(!randomList1.contains(rand)){
                randomList1.add(rand);
            }
        }
        randomLists.add(randomList1);
        System.out.println("1");
        // Opposite list
        while(randomList2.size() < iterations[0]){
            int rand = rand2.nextInt();
            if(!randomList2.contains(rand) && !randomList1.contains(rand)){
                randomList2.add(rand);
            }
        }*/
        System.out.println("2");
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
    public void chLookupTest(ArrayList<Integer> iterations){
        float x = 0.05f;
        for(Integer i = 0; i < iterations.size(); i++){
            chHash.put(iterations.get(i), "0");
            if(i > iterations.size() * x){
                lookupTest(i, x, chHash);
                x += 0.05f;
                x = Float.parseFloat(df.format(x));
            }
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
    public void dhLookupTest(ArrayList<Integer> iterations){
        float x = 0.05f;
        for(Integer i = 0; i < iterations.size(); i++){
            dhHash.put(iterations.get(i), "0");
            if(i > iterations.size() * x){
                lookupTest(i, x, dhHash);
                x += 0.05f;
                x = Float.parseFloat(df.format(x));
            }
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
    public void defaultLookupTest(ArrayList<Integer> iterations){
        float x = 0.05f;
        System.out.println("Started test");
        for(Integer i = 0; i < iterations.size(); i++){
            defaultHash.put(iterations.get(i), "0");
            if(i > iterations.size() * x){
                lookupTest(i, x, defaultHash);
                x += 0.05f;
                x = Float.parseFloat(df.format(x));
            }

        }
    }

    private void lookupTest(Integer i, float x, HashMap hash) {
        if (x <= 0.05f && x > 0.0f) {
            lookup05(i, x, hash);
        } else if (x > 0.05f && x < 0.1f) {
            lookup10(i, x, hash);
        } else if (x >= 0.1f && x <= 0.15f) {
            lookup15(i, x, hash);
        } else if (x >= 0.15f && x <= 0.2f) {
            lookup20(i, x, hash);
        } else if (x >= 0.2f && x <= 0.25f) {
            lookup25(i, x, hash);
        } else if (x >= 0.25f && x <= 0.3f) {
            lookup30(i, x, hash);
        } else if (x >= 0.3f && x <= 0.35f) {
            lookup35(i, x, hash);
        } else if (x >= 0.35f && x <= 0.4f) {
            lookup40(i, x, hash);
        } else if (x >= 0.4f && x <= 0.45f) {
            lookup45(i, x, hash);
        } else if (x >= 0.45f && x <= 0.5f) {
            lookup50(i, x, hash);
        } else if (x >= 0.5f && x <= 0.55f) {
            lookup55(i, x, hash);
        } else if (x >= 0.55f && x <= 0.6f) {
            lookup60(i, x, hash);
        } else if (x >= 0.6f && x <= 0.65f) {
            lookup65(i, x, hash);
        } else if (x >= 0.65f && x <= 0.7f) {
            lookup70(i, x, hash);
        } else if (x >= 0.7f && x <= 0.75f) {
            lookup75(i, x, hash);
        } else if (x >= 0.75f && x <= 0.8f) {
            lookup80(i, x, hash);
        } else if (x >= 0.8f && x <= 0.85f) {
            lookup85(i, x, hash);
        } else if (x >= 0.85f && x <= 0.9f) {
            lookup90(i, x, hash);
        } else if (x >= 0.9f && x <= 0.95f) {
            lookup95(i, x, hash);
        } else if (x >= 0.95f && x <= 1f) {
            lookup100(i, x, hash);
        }
    }

    private void lookup05(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup10(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }

    }
    private void lookup15(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }

    }
    private void lookup20(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }

    }
    private void lookup25(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }

    }
    private void lookup30(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }

    }
    private void lookup35(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }

    }
    private void lookup40(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }

    }
    private void lookup45(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }private void lookup50(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup55(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup60(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));;
        }
    }
    private void lookup65(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup70(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup75(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));;
        }
    }
    private void lookup80(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup85(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup90(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup95(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }
    private void lookup100(Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
        }
    }



}
