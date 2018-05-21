package General.helper;

/**
 * Created by Nicolas on 20/5/2018.
 */
public class Pair implements Cloneable {

    public int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Pair clone(){
        return new Pair(a, b);
    }
}
