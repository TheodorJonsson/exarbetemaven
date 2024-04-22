package ens18trn.cs.umu.se;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import java.util.HashMap;

public class TestJoular {
    public TestJoular(){
        int i;
        i = 0;
    }

    public void runTest(){
        Integer i;
        for(i =0; i < 1000000000; i++){
            int j = i;
        }
        testerRun();
    }
    @Benchmark
    @BenchmarkMode({Mode.AverageTime, Mode.Throughput})
    public void testerRun(){
        int i;
        HashMap<Integer, String> hashMap = new HashMap<>();
        for(i =0; i < 10000; i++){
            hashMap.put(i, "Integer.toString(i)");
        }
        for(i =0; i < 100000; i++){
            hashMap.get(i);
        }
        HashMapDouble<Integer, String> hmapDouble = new HashMapDouble<>();
        for(i =0; i < 10000; i++){
            hmapDouble.put(i, "Integer.toString(i)");
        }
        for(i =0; i < 100000; i++){
            hmapDouble.get(i);
        }
    }

    public int getDoublePrime(int size){
        if((Integer.MAX_VALUE / 2) < size){
            return -1;
        }
        size = size << 1;
        boolean prime = isPrime(size);
        while(!prime){
            size++;
            prime = isPrime(size);
            if(prime){
                return size;
            }
        }
        return 1;
    }

    public boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}