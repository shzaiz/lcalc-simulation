import java.util.Optional;

public class CheckRewrite {
    public Optional<String> checkRewrite(Term t){

        if(get_number(t).isPresent()){
            return get_number(t);
        }

        return Optional.empty();
    }

    private Optional<String> get_number(Term t){
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
            if(a.left != ab1.var) return Optional.empty();
            n+=1;
            loopterm = a.right;
        }
        if(loopterm == ab2.var) return (String.valueOf(n)).describeConstable();

        return Optional.empty();
    }

}
