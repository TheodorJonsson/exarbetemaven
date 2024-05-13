package ens18trn.cs.umu.se;

import java.util.ArrayList;
import java.util.Collections;
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

public class Experiment1Joular {
    public HashMap defaultHash;
    public HashMapCoalesced chHash;
    public HashMapDouble dhHash;
    public ArrayList<ArrayList<Integer>> randomLists = new ArrayList<>();
    public ArrayList<Integer> randomList1 = new ArrayList<>();
    public ArrayList<Integer> randomList2 = new ArrayList<>();
    public ArrayList<Integer> randomList3 = new ArrayList<>();
    public ArrayList<Integer> randomList4 = new ArrayList<>();

    public Experiment1Joular(){
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
        System.out.println("First list done");
        Collections.shuffle(randomList2, new Random(3456));
        System.out.println("second list done");
        Collections.shuffle(randomList3, new Random(6798));
        System.out.println("third list done");
        Collections.shuffle(randomList4, new Random(6354));
        System.out.println("fourth list done");
        randomLists.add(0, randomList1);
        randomLists.add(1, randomList2);
        randomLists.add(2, randomList3);
        randomLists.add(3, randomList4);
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
            insertTest(iterations, chHash, i);
        }
    }

    public void defaultInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < iterations.size(); i++){
            insertTest(iterations, defaultHash, i);
        }
    }
    public void dhInsertTest(ArrayList<Integer> iterations){
        for(Integer i = 0; i < 20; i++){
            insertTest(iterations, dhHash, i);
        }
    }

    private void insertTest(ArrayList<Integer> iterations, HashMap hash, int i){
        switch(i){
            case 0:
                insertTo05(iterations, hash);
                break;
            case 1:
                insertTo10(iterations, hash);
                break;
            case 2:
                insertTo15(iterations, hash);
                break;
            case 3:
                insertTo20(iterations, hash);
                break;
            case 4:
                insertTo25(iterations, hash);
                break;
            case 5:
                insertTo30(iterations, hash);
                break;
            case 6:
                insertTo35(iterations, hash);
                break;
            case 7:
                insertTo40(iterations, hash);
                break;
            case 8:
                insertTo45(iterations, hash);
                break;
            case 9:
                insertTo50(iterations, hash);
                break;
            case 10:
                insertTo55(iterations, hash);
                break;
            case 11:
                insertTo60(iterations, hash);
                break;
            case 12:
                insertTo65(iterations, hash);
                break;
            case 13:
                insertTo70(iterations, hash);
                break;
            case 14:
                insertTo75(iterations, hash);
                break;
            case 15:
                insertTo80(iterations, hash);
                break;
            case 16:
                insertTo85(iterations, hash);
                break;
            case 17:
                insertTo90(iterations, hash);
                break;
            case 18:
                insertTo95(iterations, hash);
                break;
            case 19:
                insertTo100(iterations, hash);
                break;
            default:
                // Handle default case if necessary

        }
    }

    private void insertTo05(ArrayList<Integer> iterations, HashMap hash){
        for(Integer i = 0; i < iterations.size() * 0.05f; i++){
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTo10(ArrayList<Integer> iterations, HashMap hash){
        for(Integer i = hash.size(); i < iterations.size() * 0.1f; i++){
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo15(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.15f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTo20(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.2f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo25(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.25f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo30(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.3f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }
    private void insertTo35(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.35f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo40(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.4f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo45(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.45f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo50(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.5f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo55(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.55f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo60(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.6f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo65(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.65f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo70(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.7f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo75(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.75f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo80(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.8f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo85(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.85f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo90(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.9f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo95(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() * 0.95f; i++) {
            hash.put(iterations.get(i), "0");
        }
    }

    private void insertTo100(ArrayList<Integer> iterations, HashMap<Integer, String> hash) {
        for (Integer i = hash.size(); i < iterations.size() - 1; i++) {
            hash.put(iterations.get(i), "0");
        }
    }
}