package General.helper;

/**
 * Created by Nicolas on 20/5/2018.
 */
public class Pair implements Cloneable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (a != pair.a) return false;
        return b == pair.b;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }

    public int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Pair clone(){
        return new Pair(a, b);
    }
}
