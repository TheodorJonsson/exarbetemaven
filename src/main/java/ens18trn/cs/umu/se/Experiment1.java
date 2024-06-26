package ens18trn.cs.umu.se;

import java.util.*;

import static ens18trn.cs.umu.se.Main.iterationsPrime;
/**
 * Experiment 1: insertion only
 *
 * For each run, initialize the hashmap to a set size,
 * then insert random generated numbers set with a seed into the hashmap
 * until it reaches a load factor of 1,
 * without any resizing of the table.
 * This is repeated for varying table sizes
 */

public class Experiment1 {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();

    public Experiment1(){
        setup();
    }

    private void setup() {
/*Random rand1 = new Random();
        rand1.setSeed(1234);
        Random rand2 = new Random();
        rand2.setSeed(3456);
        Random rand3 = new Random();
        rand3.setSeed(6798);
        Random rand4 = new Random();
        rand4.setSeed(6354);*/
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
        Collections.shuffle(randomList3, new Random(6798));
        Collections.shuffle(randomList4, new Random(6354));
        randomLists.add(randomList1);
        randomLists.add(randomList2);
        randomLists.add(randomList3);
        randomLists.add(randomList4);
        /*
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
        randomLists.add(randomList4);*/
    }


    public void chSetup(int capacity){
        chHash = new HashMapCoalesced<Integer, String>(capacity, 1f);
    }
    public void dhSetup(int capacity){
        dhHash = new HashMapDouble<Integer, String>(capacity, 1f);
    }
    public void defaultSetup(int capacity){
        defaultHash = new HashMap<Integer, String>(capacity, 1f);
    }


    public void chInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < iterations.size(); i++){
            chHash.put(iterations.get(i), "0");
        }
    }

    public void defaultInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < iterations.size(); i++){
            defaultHash.put(iterations.get(i), "0");
        }
    }
    public void dhInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < iterations.size(); i++){
            dhHash.put(iterations.get(i), "0");
        }
    }
}