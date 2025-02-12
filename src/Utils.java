import org.antlr.v4.runtime.misc.Pair;

public class Utils {
    public static Pair<Integer, Integer> max(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
        return new Pair<>(
                p1.a > p2.a ? p1.a : p2.a,
                p1.b > p2.b ? p1.b : p2.b
        );
    }

}
