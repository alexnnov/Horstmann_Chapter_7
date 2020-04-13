package com.horstmann_chapter_7;
import java.util.*;
import java.io.File;



public class Main {

    public static void swap(List<?> list, int i, int j) {
        swapParametr(list, i, j);
    }
    private static <T> void swapParametr(List<T> list, int i, int j) {
        if (list instanceof RandomAccess) {
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        } else {
            list.set(i, list.set(j, list.get(i)));
        }
    }

    public static void main(String[] args) throws Throwable{
        //---------------Excercise 1---------------------
        Eratosphen eratosphen = new Eratosphen(50);
        eratosphen.display();

        EratosphenBitSet eratosphenBitSet = new EratosphenBitSet(100);
        eratosphenBitSet.display();


        //--------------Excercise5------------------------
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        swap(arrayList, 1, 2);
        System.out.println(arrayList);

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        swap(linkedList, 1, 2);
        System.out.println(linkedList);

        //----------Excercise6-------------
        Map<String,Set<Integer>> documentContain = new HashMap<>();
        HashSet<Integer> pages = new HashSet<>();
        pages.add(1);
        pages.add(2);
        pages.add(3);
        documentContain.put("Chapter One",pages);

        //-----------Excercise 7--------------------------
        /*Map<String, Integer> counts = new HashMap<>();
        Scanner scanner = new Scanner(new File("/home/Alex/IdeaProjects/Horstmann_Chapter_7/src/com/horstmann_chapter_7/Catch-22.txt"));
        while (scanner.hasNext()) {
            String word = scanner.next();
            counts.merge(word, 1, Integer::sum);
        }

        counts.forEach((k,v) -> System.out.println(k + ": " + v));*/

        //------------Excercise 8 ---------------------
        /*LineReader lineReader = new LineReader();
        lineReader.work();
        lineReader.display();*/

        //---------Excercise 9-----------------
        City nn = new City("NN");
        City spb = new City("SPB");
        City voron = new City("Voron");
        City saratov = new City("Saratov");
        City samara = new City("Samara");
        City msk = new City("MSK");
        City kazan = new City("Kazan");

        spb.neighbours = new Neighbour[]{new Neighbour(msk,700)};
        msk.neighbours = new Neighbour[]{new Neighbour(voron,600)};
        voron.neighbours = new Neighbour[]{new Neighbour(saratov,470)};
        saratov.neighbours = new Neighbour[]{new Neighbour(samara,650)};
        samara.neighbours = new Neighbour[]{new Neighbour(kazan,405)};
        kazan.neighbours = new Neighbour[]{new Neighbour(nn,420)};
        nn.neighbours = new Neighbour[]{new Neighbour(msk,400)};


        Dijkstra.computePaths(nn); // run Dijkstra
        System.out.println("Distance to " + saratov + ": " + saratov.weight);
        List<City> path = Dijkstra.getShortestPathTo(saratov);
        System.out.println("Path: " + path);




    }
}
