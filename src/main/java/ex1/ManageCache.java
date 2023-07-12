package ex1;

import java.util.*;

public class ManageCache {

    private final int MAX_SIZE = 5;
    Queue<String> searchHistory;
    Map<String, List<Book>> dataHistory;

    public ManageCache() {
        searchHistory = new LinkedList<>();
        dataHistory = new HashMap<>();
    }

    boolean isCacheNull(){
        return searchHistory == null;
    }

    boolean isCacheFull(){
        return searchHistory.size()== MAX_SIZE;
    }

    public void addKeyWord(String keyWord){
        searchHistory.add(keyWord);
    }

    public Optional<String> findKeySimilar(String keyWord){
        return searchHistory.stream().filter(ele -> keyWord.contains(ele))
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
    }

    public void addData(String keyWord, List<Book> books){
        dataHistory.put(keyWord, books);
    }
    List<Book> getDataInCache(String keyWord){
        return dataHistory.get(keyWord);
    }

    public void changeStateKeywordExists(String keyWord){
        searchHistory.remove(keyWord);
        searchHistory.add(keyWord);
    }

    public void clearOneDataForNew(){ //clear one least recently use
        String keyWordDelete = searchHistory.poll();
        dataHistory.remove(keyWordDelete);
    }
    public void controlCacheIfFull(){
        if (isCacheFull()) {
            clearOneDataForNew();
        }
    }
}
