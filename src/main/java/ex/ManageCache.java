package ex;

import java.util.*;

public class ManageCache {

    Queue<String> searchHistory;
    Map<String, List<Book>> dataHistory;

    public ManageCache() {
        searchHistory = new LinkedList<>();
        dataHistory = new HashMap<>();
    }

    boolean isCacheFull(){
        return searchHistory != null && searchHistory.size()== 5;
    }

    public void addKeyWord(String keyWord){
        searchHistory.add(keyWord);
    }

    public Optional<String> findKeySimilar(String keyWord){
        return searchHistory.stream().filter(ele -> keyWord.contains(ele))
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
    }

    List<Book> getDataInCache(String keyWord){
        searchHistory.remove(keyWord);
        searchHistory.add(keyWord);

        return dataHistory.get(keyWord);
    }


}
