package ens18trn.cs.umu.se;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static ens18trn.cs.umu.se.Main.iterations;

public class Experiment5LoadFactor {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();

    public Experiment5LoadFactor(){
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
        randomLists.add(randomList1);
        randomLists.add(randomList2);
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
public ArrayList<String[]> chLookupTest(ArrayList<Integer> iterations){
    float x = 0.05f;
    System.out.println("Started test");
    ArrayList<String[]> sums = new ArrayList();
    int j = 0;
    for(Integer i = 0; i < iterations.size(); i++){
        chHash.put(iterations.get(i), "0");
        if(i > iterations.size() * x){
            sums.add(j, lookupTest(i, x, chHash));
            j++;
            x += 0.05f;
        }
    }
    return sums;
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
public ArrayList<String[]> dhLookupTest(ArrayList<Integer> iterations){
    float x = 0.05f;
    System.out.println("Started test");
    ArrayList<String[]> sums = new ArrayList();
    int j = 0;
    for(Integer i = 0; i < iterations.size(); i++){
        dhHash.put(iterations.get(i), "0");
        if(i > iterations.size() * x){
            sums.add(j, lookupTest(i, x, dhHash));
            j++;
            x += 0.05f;
        }
    }
    return sums;
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
public ArrayList<String[]> defaultLookupTest(ArrayList<Integer> iterations){
    float x = 0.05f;
    System.out.println("Started test");
    ArrayList<String[]> sums = new ArrayList();
    int j = 0;
    for(Integer i = 0; i < iterations.size(); i++){
        defaultHash.put(iterations.get(i), "0");
        if(i > iterations.size() * x){
            sums.add(j, lookupTest(i, x, defaultHash));
            j++;
            x += 0.05f;
        }
    }
    return sums;
}

    private String[] lookupTest(Integer i, float x, HashMap hash) {
        long sums = 0;
        for(int j = 0; j < 1000000; j++){
            long startTime = System.nanoTime();
            int random_int = (int)Math.floor(Math.random() * (randomList2.size() - 1));
            hash.get(randomList2.get(random_int));
            long endTime = System.nanoTime();
            sums += endTime - startTime;
        }
        long durationInMS = TimeUnit.NANOSECONDS.toMillis(sums);

        x += 0.05f;
        DecimalFormat df = new DecimalFormat("##.00");
        x = Float.parseFloat(df.format(x));
        System.out.println("Load factor: " + x +" duration: " + durationInMS);
        String[] dataLine = new String[]{Float.toString(x), Long.toString(durationInMS)};
        return dataLine;
    }
}

