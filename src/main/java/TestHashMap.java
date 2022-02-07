
import static java.util.HashMap.MAXIMUM_CAPACITY;

public class TestHashMap {
    public static void main(String[] args) {

        System.out.println(tableSizeFor(18));
        System.out.println(tableSizeFor(7));
    }
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
