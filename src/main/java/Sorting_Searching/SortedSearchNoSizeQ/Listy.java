package Sorting_Searching.SortedSearchNoSizeQ;

/**
 * Created by Nicolas on 3/1/2018.
 */
public class Listy {
    private int[] array;

    public Listy(int size) {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i*2;
        }
    }

    public int getElementAt(int position){
        if(position >= array.length || position<0)
            return -1;
        return array[position];

    }

}
