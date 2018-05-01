package Recursion.TowersOfHanoi;

/**
 * Question:
 *      Hanoi towers game.
 *
 * Mistakes:
 *      > call step 2 in every recursive call.
 *      
 * Solution:
 *  Say you have 3 poles S(start), B(buffer), T(Target)
 *  for disks you do:
 *      1) S -> B
 *      2) A -> T
 *      3) B -> T
 * for n disks you do the same but steps are done recursively for n-1 disks!!!
 *
 * algo:
 *  While n>0
 *      1) Recursive call for n-1 disks to move disks from start -> buffer using target as tmp pole
 *      2) Move disk from start to destination
 *      3) Recursive call for n-1 disks to move disks from buffer -> target using buffer as tmp pole
 */
public class Game {
    public static boolean moveDisks(int n){
        Tower[] towers = new Tower[3];

        //initialize towers
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        //add disks to first tower
        for (int i = n-1; i >=0 ; i--) {
            towers[0].addDisk(i);
        }

        return moveDisksHelper(towers[0], towers[1], towers[2], n);
    }

    private static boolean moveDisksHelper(Tower start, Tower buffer, Tower target, int n) {
        if(n>0){
            if(!moveDisksHelper(start, target, buffer, n-1))
                return false;
            if(!start.moveTopTo(target)){
                return false;
            }
            if(!moveDisksHelper(buffer, start, target, n-1))
                return false;
        }
        return true;
    }
}
