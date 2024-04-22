package ens18trn.cs.umu.se;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TestDoubleHashing {
    @Test
    public void testHashMapDefault() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(12, "0");
        assertEquals("0", hashMap.get(12));
    }

    @Test
    public void testDefaultIterations(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        for(int i = 0; i < 1000000; i++){
            hashMap.put(i, Integer.toString(i));
            assertEquals(Integer.toString(i), hashMap.get(i));
        }
    }

   @Test
    public void testHashMapDouble(){
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>();
        hashMap.put(212, "0");
        assertEquals("0", hashMap.get(212));
    }

    @Test
    public void testDoubleIterationsNoParam() {
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>();
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, Integer.toString(i));
            assertEquals(Integer.toString(i), hashMap.get(i));
        }
    }

   @Test
    public void testDoubleIterationsInitCapParamSmall() {
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>(11);
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, Integer.toString(i));
            assertEquals(Integer.toString(i), hashMap.get(i));
        }
    }

    @Test
    public void testDoubleIterationsInitCapParamLarge() {
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>(12312);
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, Integer.toString(i));
            assertEquals(Integer.toString(i), hashMap.get(i));
        }
    }


    @Test
    public void testDoubleIterationsBothParamSmall() {
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>(11, 0.75f);
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, Integer.toString(i));
            assertEquals(Integer.toString(i), hashMap.get(i));
        }
    }


    @Test
    public void testDoubleIterationsBothParamLarge() {
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>(12312, 0.75f);
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, Integer.toString(i));
            assertEquals(Integer.toString(i), hashMap.get(i));
        }
    }

    @Test
    public void testDoubleRandomInserts(){
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>();
        ArrayList<Integer> randlist = new ArrayList<>();
        int j = 0;
        while(j < 100000){
            int rand = (int)(Math.random() * (10000000 - (1)) + 0);
            if(!randlist.contains(rand)){
                randlist.add(rand);
                j++;
            }
        }
        System.out.println("Done with arraylist inserts");
        for(int i = 0; i < 100000; i++){
            if(hashMap.put(randlist.get(i), Integer.toString(i)) == null){
                assertEquals(Integer.toString(i), hashMap.get(randlist.get(i)));
            }

        }
    }
    @Test
    public void testRandomInserts(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        ArrayList<Integer> randlist = new ArrayList<>();
        int j = 0;
        while(j < 100000){
            int rand = (int)(Math.random() * (10000000 - (1)) + 0);
            if(!randlist.contains(rand)){
                randlist.add(rand);
                j++;
            }
        }
        System.out.println("Done with arraylist inserts");
        for(int i = 0; i < 100000; i++){
            if(hashMap.put(randlist.get(i), Integer.toString(i)) == null){
                assertEquals(Integer.toString(i), hashMap.get(randlist.get(i)));
            }

        }
    }
    @Test
    public void testUnsuccessfulLookups(){
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>(11);
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, Integer.toString(i));
            assertEquals(Integer.toString(i), hashMap.get(i));
            assertNull(hashMap.get(i + 1000000));
        }
    }
    @Test
    public void testDoubleSameElement(){
        HashMapDouble<Integer, String> hashMap = new HashMapDouble<>();
        hashMap.put(212, "0");
        assertEquals("0", hashMap.get(212));
        String returned = hashMap.put(212, "123");
        assertEquals("0", returned);
        assertEquals("0", hashMap.get(212));
    }

    /*@Test
    public void testDoubleIterationsIterate(){
        for(int i = 0; i < 10; i++){
            testDoubleRandomInserts();
        }
    }*/
}