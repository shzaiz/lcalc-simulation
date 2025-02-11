import java.util.Objects;
import java.util.Optional;

public class CheckRewrite {
    public static Optional<String> checkRewrite(Term t){

        if(get_number(t).isPresent()){
            return get_number(t);
        }

        return Optional.empty();
    }

    private static Optional<String> get_number(Term t){
        // lambda f.
        if(t.type != Term.TermType.ABSTRACT) return Optional.empty();
        Abstract ab1 = (Abstract) t;
        // lambda x.
        Term t_right = ab1.body;
        if (t_right.type != Term.TermType.ABSTRACT) return Optional.empty();
        Abstract ab2 = (Abstract) t_right;
        int n = 0;
        Term loopterm = ab2.body;
        while(loopterm instanceof Apply a){
            if(!Objects.equals(a.left.toString(), ab1.var.toString())) return Optional.empty();
            n+=1;
            loopterm = a.right;
        }
        if(Objects.equals(loopterm.toString(), ab2.var.toString())) return (String.valueOf(n)).describeConstable();

        return Optional.empty();
    }

}
