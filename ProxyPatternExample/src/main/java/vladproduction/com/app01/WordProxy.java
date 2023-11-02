package vladproduction.com.app01;

import java.util.HashMap;
import java.util.Map;

public class WordProxy implements Vocabulary{

    private final Vocabulary target;
    private final Map<String, String> cache;

    public WordProxy(Vocabulary target){
        this.target = target;
        cache = new HashMap<>();
    }

    @Override
    public String getWord(String w) {
        String word;
        if(cache.containsKey(w)){
            word = cache.get(w);
            word = "from cache: " + word;
        } else {
            word = target.getWord(w);
            cache.put(w, word);
        }
        return word;
    }
}
