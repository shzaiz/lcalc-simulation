import java.util.HashMap;

public class SymbolTab {
    private HashMap<String, Variable> cscope = new HashMap<>();
    private SymbolTab prev;

    SymbolTab(SymbolTab prev){
        this.prev = prev;
    }

    // Get if the value has been stored. Returns NULL
    // when undefined.

    Variable find(String name){
        SymbolTab cpy = this;
        while(cpy != null){
            if(!cscope.containsKey(name)){
                cpy = cpy.prev;
            }else{
                break;
            }
        }
        return cscope.getOrDefault(name, null);
    }
    SymbolTab getPrev(){
        return prev;
    }
    void put(String name, Variable type){
        cscope.put(name, type);
    }

}
