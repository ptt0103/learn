package ex;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Queue<String> searchHistory;
    static List <Book> books;

    static Map<String, List<Book>> dataHistory;

    static void init(){
        searchHistory = new LinkedList<>();
        books = new ArrayList<>();
        dataHistory = new HashMap<>();
        books.add(new Book("VN01", "toi thay hoa vang tren co xanh"));
        books.add(new Book("VN02", "mat biec"));
        books.add(new Book("VN03", "so do"));
        books.add(new Book("AB01", "nha gia kim"));
        books.add(new Book("AB02", "tam quoc"));
        books.add(new Book("BC01", "con cao va chum nho"));
        books.add(new Book("AC01", "chien tranh tien te"));
        books.add(new Book("ABC01", "every"));

    }

    static void menu (){
        System.out.println("Menu");
        System.out.println("1. them");
        System.out.println("2. sua");
        System.out.println("3. xoa");
        System.out.println("4. tim kiem");
        System.out.print("lua chon");
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        Scanner sc = new Scanner(System.in);
        while(true){
//            menu();
            System.out.print("enter keyWord: ");
            String keyWord = sc.nextLine();
            search(keyWord);
        }
    }


    static List<Book> getDataInCache(String keyWord){
        searchHistory.remove(keyWord);
        searchHistory.add(keyWord);

        return dataHistory.get(keyWord);
    }

    static boolean isCacheFull(){
        return searchHistory != null && searchHistory.size()== 5;
    }


    static List<Book> searchResult(List <Book> list, String keyWord){
        return list.stream()
                .filter(ele -> ele.getId().contains(keyWord)|| ele.getName().contains(keyWord))
                .collect(Collectors.toList());
    }

    private static void search(String keyWord) throws InterruptedException {
        if(searchHistory == null ){
            Thread.sleep(2000);
            searchHistory.add(keyWord);
            System.out.println("Search history: " + searchHistory);
            List <Book> listSearch = searchResult(books, keyWord);
            dataHistory.put(keyWord, listSearch);
            System.out.println(listSearch);
        }
        else{
            Optional<String> keySimilar = searchHistory.stream().filter(ele -> keyWord.contains(ele)).reduce((word1, word2)
                    -> word1.length() > word2.length()
                    ? word1 : word2);

            if(keySimilar.isPresent()){
                System.out.println("Key similar: " +  keySimilar);
                if(keySimilar.get().equals(keyWord)){
                    System.out.println(getDataInCache(keyWord));
                }
                else{
                    if(isCacheFull()){
                        String keyWordDelete = searchHistory.poll();
                        dataHistory.remove(keyWordDelete);
                    }
                    searchHistory.add(keyWord);
                    List<Book> searchList = searchResult(dataHistory.get(keySimilar.get()), keyWord);
                    dataHistory.put(keyWord, searchList);
                    System.out.println(searchList);
                }
            }
            else {
                Thread.sleep(2000);
                if(isCacheFull()){
                    String keyWordDelete = searchHistory.poll();
                    dataHistory.remove(keyWordDelete);
                }
                searchHistory.add(keyWord);
                List<Book> searchList = searchResult(books, keyWord);
                dataHistory.put(keyWord, searchList);

                System.out.println(searchList);
            }
        }
        System.out.println(searchHistory);
    }
}
