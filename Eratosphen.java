package com.horstmann_chapter_7;
import java.util.*;

public class Eratosphen {
    Set<Integer> hashSet;
    Eratosphen(int n){
        hashSet = new HashSet<>();
        for(int i=2;i<=n;i++){
            hashSet.add(i);
        }
        int s=2,i=0;
        while(s*s<=n){
            while(s*(s+i)<=n){
                hashSet.remove(s*(s+i));
                i++;
            }
            s++;
        }
    }

    public void display(){
        System.out.println(hashSet.toString());

    }

}
