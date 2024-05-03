package ens18trn.cs.umu.se.maybe;

import ens18trn.cs.umu.se.HashMapCoalesced;
import ens18trn.cs.umu.se.HashMapDouble;

import java.util.HashMap;

/**
 * Experiment 2: insertion, resizing, and load factor
 *
 * For each run, initialize the hashmap to a size of x,
 * with a maximum load factor of 0.05 and then insert z amount of randomly generated numbers.
 * Each run will increase the maximum load factor by 0.05 this will go on until the maximum load factor reaches 1.
 * The best performing load factor will be selected and used in experiment 3.
 * The runtime of each run and the energy consumption of each run will be measured in this experiment
 */

public class Experiment2Joular {
    HashMap defaultHash;
    HashMapDouble dhHash;
    HashMapCoalesced chHash;
    public Experiment2Joular(){}

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
    public void chInsertionTest(int insertions){

    }

    /**
     * Double hashing HashMap setup
     * @param capacity, the initial capacity
     * @param loadFactor, the maximum load factor
     */
    public void dhSetup(int capacity, int loadFactor){
        dhHash = new HashMapDouble(capacity, loadFactor);
    }

    /**
     * Double hashing insertion test.
     * @param insertions, amount of insertions to be done and measured.
     */
    public void dhInsertionTest(int insertions){

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
    public void defaultInsertionTest(int insertions){

    }
}
