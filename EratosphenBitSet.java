package com.horstmann_chapter_7;
import java.util.*;

public class EratosphenBitSet {
    BitSet bitSet;
    int number;
    EratosphenBitSet(int n){
        number=n;
        bitSet = new BitSet(n+2);
        for(int i=0;i<n-1;i++){
            bitSet.set(2,n,true);
        }
        int s=2,i=0;
        while(s*s<=n){
            while(s*(s+i)<=n){
                bitSet.set(s*(s+i),false);
                i++;
            }
            s++;
        }

    }
    void display(){
        for(int i=2;i<=number;i++){
            if(bitSet.get(i)){
                System.out.print(i+" ");
            }

        }
    }
}
