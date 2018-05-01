package Recursion.TowersOfHanoi;

import java.util.Stack;

/**
 * Created by Nicolas on 25/12/2017.
 */
public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int index) {
        this.disks = new Stack<>();
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int removeDisk(){
        return disks.pop();
    }

    public boolean addDisk(int disk){
        if(!disks.empty() && disks.peek()< disk)
            return false;
        disks.push(disk);
        return true;
    }

    public boolean moveTopTo(Tower tower){
        int top = removeDisk();
       return tower.addDisk(top);
    }
}
