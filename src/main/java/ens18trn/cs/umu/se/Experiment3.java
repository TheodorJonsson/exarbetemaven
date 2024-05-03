package ens18trn.cs.umu.se;

import java.util.ArrayList;
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
        while(randomList2.size() < iterations[1]){
            int rand = rand2.nextInt();
            if(!randomList2.contains(rand)){
                randomList2.add(rand);
            }
        }
        randomLists.add(randomList2);
        while(randomList3.size() < iterations[2]){
            int rand = rand3.nextInt();
            if(!randomList3.contains(rand)){
                randomList3.add(rand);
            }

        }
        randomLists.add(randomList3);
        while(randomList4.size() < iterations[3]){
            int rand = rand4.nextInt();
            if(!randomList4.contains(rand)){
                randomList4.add(rand);
            }
        }
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
