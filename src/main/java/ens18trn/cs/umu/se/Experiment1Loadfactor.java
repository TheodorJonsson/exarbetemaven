package ens18trn.cs.umu.se;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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

public class Experiment1Loadfactor {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();

    public Experiment1Loadfactor(){
        setup();
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


    private void setup() {
        System.out.println("Setting up arraylists");
        Random rand1 = new Random();
        rand1.setSeed(1234);
        Random rand2 = new Random();
        rand2.setSeed(3456);
        Random rand3 = new Random();
        rand3.setSeed(6798);
        Random rand4 = new Random();
        rand4.setSeed(6354);
        while(randomList1.size() < iterationsPrime[0]){
            int rand = rand1.nextInt(1000000000);
            if(!randomList1.contains(rand)){
                randomList1.add(rand);
            }
        }
        System.out.println("first arraylist done");
        randomLists.add(randomList1);
        while(randomList2.size() < iterationsPrime[1]){
            int rand = rand2.nextInt(1000000000);

            if(!randomList2.contains(rand)){
                randomList2.add(rand);
            }
        }
        System.out.println("second arraylist done");
        randomLists.add(randomList2);
        while(randomList3.size() < iterationsPrime[2]){
            int rand = rand3.nextInt(1000000000);
            if(!randomList3.contains(rand)){
                randomList3.add(rand);
            }

        }
        System.out.println("third arraylist done");
        randomLists.add(randomList3);
        while(randomList4.size() < iterationsPrime[3]){
            int rand = rand4.nextInt(1000000000);
            if(!randomList4.contains(rand)){
                randomList4.add(rand);
            }
        }
        randomLists.add(randomList4);
        System.out.println("Done with arraylists");
    }

    public ArrayList<String[]> chInsertTest(ArrayList<Integer> iterations){
        ArrayList<String[]> sums = new ArrayList();
        int totalOperations = 0;
        double lastLoadFactor = 0.0;
        double currentLoadfactor = 0;
        long sum = 0;
        for(Integer i = 0; i < iterations.size(); i++){
            long startTime = System.nanoTime();
            chHash.put(i, "0");
            long endTime = System.nanoTime();
            sum += endTime - startTime;
            totalOperations++;
            currentLoadfactor = (double)i/iterations.size();
            if(currentLoadfactor >= lastLoadFactor + 0.05f){
                long averageTime = sum/totalOperations;
                DecimalFormat f = new DecimalFormat("##.00");
                Double load = Double.valueOf(f.format(currentLoadfactor));
                String[] dataLine = new String[]{load.toString(), Long.toString(averageTime)};
                sums.add(dataLine);

                sum = 0;
                totalOperations = 0;
                lastLoadFactor = currentLoadfactor;
            }
        }
        long averageTime = sum/totalOperations;
        DecimalFormat f = new DecimalFormat("##.00");
        Double load = Double.valueOf(f.format(currentLoadfactor));
        String[] dataLine = new String[]{load.toString(), Long.toString(averageTime)};
        sums.add(dataLine);
        sum = 0;
        totalOperations = 0;
        lastLoadFactor = currentLoadfactor;
        return sums;
    }

    public ArrayList<String[]> defaultInsertTest(ArrayList<Integer> iterations){
        ArrayList<String[]> sums = new ArrayList();
        int totalOperations = 0;
        double lastLoadFactor = 0.0;
        double currentLoadfactor = 0;
        long sum = 0;
        for(Integer i = 0; i < iterations.size(); i++){
            long startTime = System.nanoTime();
            defaultHash.put(i, "0");
            long endTime = System.nanoTime();
            sum += endTime - startTime;
            totalOperations++;
            currentLoadfactor = (double)i/iterations.size();
            if(currentLoadfactor >= lastLoadFactor + 0.05f){
                long averageTime = sum/totalOperations;
                DecimalFormat f = new DecimalFormat("##.00");
                Double load = Double.valueOf(f.format(currentLoadfactor));
                String[] dataLine = new String[]{load.toString(), Long.toString(averageTime)};
                sums.add(dataLine);

                sum = 0;
                totalOperations = 0;
                lastLoadFactor = currentLoadfactor;
            }
        }
        long averageTime = sum/totalOperations;
        DecimalFormat f = new DecimalFormat("##.00");
        Double load = Double.valueOf(f.format(currentLoadfactor));
        String[] dataLine = new String[]{load.toString(), Long.toString(averageTime)};
        sums.add(dataLine);
        sum = 0;
        totalOperations = 0;
        lastLoadFactor = currentLoadfactor;
        return sums;
    }
    public ArrayList<String[]> dhInsertTest(ArrayList<Integer> iterations){
        ArrayList<String[]> sums = new ArrayList();
        int totalOperations = 0;
        double lastLoadFactor = 0.0;
        double currentLoadfactor = 0;
        long sum = 0;
        for(Integer i = 0; i < iterations.size(); i++){
            long startTime = System.nanoTime();
            dhHash.put(i, "0");
            long endTime = System.nanoTime();
            sum += endTime - startTime;
            totalOperations++;
            currentLoadfactor = (double)i/iterations.size();
            if(currentLoadfactor >= lastLoadFactor + 0.05f){
                long averageTime = sum/totalOperations;
                DecimalFormat f = new DecimalFormat("##.00");
                Double load = Double.valueOf(f.format(currentLoadfactor));
                String[] dataLine = new String[]{load.toString(), Long.toString(averageTime)};
                sums.add(dataLine);

                sum = 0;
                totalOperations = 0;
                lastLoadFactor = currentLoadfactor;
            }
        }
        long averageTime = sum/totalOperations;
        DecimalFormat f = new DecimalFormat("##.00");
        Double load = Double.valueOf(f.format(currentLoadfactor));
        String[] dataLine = new String[]{load.toString(), Long.toString(averageTime)};
        sums.add(dataLine);
        sum = 0;
        totalOperations = 0;
        lastLoadFactor = currentLoadfactor;
        return sums;
    }
}