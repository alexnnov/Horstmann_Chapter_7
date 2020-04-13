package com.horstmann_chapter_7;
import java.io.File;
import java.util.*;

public class LineReader {
    Map<String,Set<Integer>> words = new HashMap<>();
    int linenum = 1;
    public void work() throws Throwable{
        Scanner scanner = new Scanner(new File("/home/Alex/IdeaProjects/Horstmann_Chapter_7/src/com/horstmann_chapter_7/Catch-22.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (String word: line.split(" ")) {
                word = word.toUpperCase();
                if (!words.containsKey(word)) {
                    Set<Integer> lines = new TreeSet<>();
                    lines.add(linenum);
                    words.put(word, lines);
                } else {
                    words.get(word).add(linenum);
                }
            }
            linenum++;
        }
    }
    public void display(){
        words.forEach((k,v) -> {
            System.out.println("word: " + k);
            String sep = "";
            for (int line: v) {
                System.out.printf("%s%d",sep,line);
                sep = ", ";
            }
            System.out.println();
        });
    }

}
