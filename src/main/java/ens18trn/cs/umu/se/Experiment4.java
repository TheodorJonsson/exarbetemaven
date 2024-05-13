package ens18trn.cs.umu.se;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static ens18trn.cs.umu.se.Main.iterationsPrime;

public class Experiment4 {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();
    public DecimalFormat df = new DecimalFormat("##.00");

    public Experiment4(){
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
        Collections.shuffle(randomList1, new Random(2342));
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
    public void chLookupTest(ArrayList<Integer> iterations){
        float x = 0.05f;
        for(Integer i = 0; i < iterations.size(); i++){
            chHash.put(iterations.get(i), "0");
            if(i > iterations.size() * x){
                lookupTest(iterations, i, x, chHash);
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
                lookupTest(iterations, i, x, dhHash);
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
        for(Integer i = 0; i < iterations.size(); i++){
            defaultHash.put(iterations.get(i), "0");
            if(i > iterations.size() * x){
                lookupTest(iterations, i, x, defaultHash);
                x += 0.05f;
                x = Float.parseFloat(df.format(x));
            }

        }
    }

    private void lookupTest(ArrayList<Integer> iterations, Integer i, float x, HashMap hash) {
        if (x <= 0.05f && x > 0.0f) {
            lookup05(iterations, i, x, hash);
        } else if (x > 0.05f && x <= 0.1f) {
            lookup10(iterations, i, x, hash);
        } else if (x >= 0.1f && x <= 0.15f) {
            lookup15(iterations, i, x, hash);
        } else if (x >= 0.15f && x <= 0.2f) {
            lookup20(iterations, i, x, hash);
        } else if (x >= 0.2f && x <= 0.25f) {
            lookup25(iterations, i, x, hash);
        } else if (x >= 0.25f && x <= 0.3f) {
            lookup30(iterations, i, x, hash);
        } else if (x >= 0.3f && x <= 0.35f) {
            lookup35(iterations, i, x, hash);
        } else if (x >= 0.35f && x <= 0.4f) {
            lookup40(iterations, i, x, hash);
        } else if (x >= 0.4f && x <= 0.45f) {
            lookup45(iterations, i, x, hash);
        } else if (x >= 0.45f && x <= 0.5f) {
            lookup50(iterations, i, x, hash);
        } else if (x >= 0.5f && x <= 0.55f) {
            lookup55(iterations, i, x, hash);
        } else if (x >= 0.55f && x <= 0.6f) {
            lookup60(iterations, i, x, hash);
        } else if (x >= 0.6f && x <= 0.65f) {
            lookup65(iterations, i, x, hash);
        } else if (x >= 0.65f && x <= 0.7f) {
            lookup70(iterations, i, x, hash);
        } else if (x >= 0.7f && x <= 0.75f) {
            lookup75(iterations, i, x, hash);
        } else if (x >= 0.75f && x <= 0.8f) {
            lookup80(iterations, i, x, hash);
        } else if (x >= 0.8f && x <= 0.85f) {
            lookup85(iterations, i, x, hash);
        } else if (x >= 0.85f && x <= 0.9f) {
            lookup90(iterations, i, x, hash);
        } else if (x >= 0.9f && x <= 0.95f) {
            lookup95(iterations, i, x, hash);
        } else if (x >= 0.95f && x <= 1f) {
            lookup100(iterations, i, x, hash);
        }
    }

    private void lookup05(ArrayList<Integer> iterations, Integer i, float x, HashMap hash){
        for(int j = 0; j < 1000000; j++){
            int random_int = (int)Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }
    // Define methods for each load factor
    private void lookup10(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup15(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup20(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup25(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup30(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup35(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup40(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup45(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup50(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup55(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup60(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup65(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup70(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup75(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup80(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup85(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup90(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup95(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

    private void lookup100(ArrayList<Integer> iterations, Integer i, float x, HashMap<Integer, String> hash) {
        for (int j = 0; j < 1000000; j++) {
            int random_int = (int) Math.floor(Math.random() * (i - 1));
            hash.get(iterations.get(random_int));
        }
    }

}
