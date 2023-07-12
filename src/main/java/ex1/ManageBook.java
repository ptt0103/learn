package ex1;


import java.util.*;
import java.util.stream.Collectors;

public class ManageBook {
    List<Book> books;
    ManageCache manageCache;
    Scanner sc = new Scanner(System.in);

    public ManageBook() {
        manageCache = new ManageCache();
        books = new ArrayList<>();
        books.add(new Book("VN01", "toi thay hoa vang tren co xanh", "Nguyen Nhat Anh"));
        books.add(new Book("VN02", "mat biec", "Nguyen Nhat Anh"));
        books.add(new Book("VN03", "so do", "Vu Trong Phung"));
        books.add(new Book("AB01", "nha gia kim", "Nuoc ngoai"));
        books.add(new Book("AB02", "tam quoc", "La Han Trung"));
        books.add(new Book("BC01", "con cao va chum nho", "Nuoc ngoai"));
        books.add(new Book("AC01", "chien tranh tien te", "Nuoc ngoai"));
        books.add(new Book("ABC01", "Thuy hu", "Khong biet"));
    }

    public Book createBook(){
        System.out.print("enter id: ");
        String bookId = sc.nextLine();
        System.out.print("enter name: ");
        String name = sc.nextLine();
        System.out.print("enter author: ");
        String author = sc.nextLine();
        return new Book(bookId, name, author);
    }

    public void addBook(Book book) throws BlankException, InvalidException {
        System.out.println(book);
        if(validateBook(book)){
            books.add(book);
            System.out.println("Add success");
        }

    }

    public void processAdd() throws BlankException, InvalidException {
        Book bookAdd = this.createBook();
        this.addBook(bookAdd);
    }

    private boolean validateBook(Book book) throws BlankException, InvalidException {
        if(book.getId().isBlank() || book.getName().isBlank() || book.getAuthor().isBlank()) throw new BlankException();
        if(book.getId().length() < 4 || book.getName().length() < 4 || book.getAuthor().length() < 4) throw new InvalidException();
        return true;
    }

    public int count(){
        return books.size();
    }
    public Book getBookByIndex(int i){
        return books.get(i-1);
    }

    public void processChangeInfo(){
        System.out.print("enter index book want to change between 1- " + count()+ ": ");
        int changeSelect = Integer.parseInt(sc.nextLine());
        Book bookChange = getBookByIndex(changeSelect);
        System.out.println("info: " + bookChange);
        System.out.println("Change info: ");
        changeInfoBook(bookChange, changeSelect-1);
    }
    public void changeInfoBook(Book bookChange, int i) {
        System.out.print("enter new name (blank if don't change): ");
        String newName = sc.nextLine();
        System.out.print("enter new author (blank if don't change): ");
        String newAuthor = sc.nextLine();

        if (newName.isBlank() && newAuthor.isBlank()){
            System.out.println("You don't change anything");
        }
        else{
            if(!newName.isBlank()){
                bookChange.setName(newName);
            }
            if(!newAuthor.isBlank()){
                bookChange.setAuthor(newAuthor);
            }
            books.set(i, bookChange);
            System.out.println("Change Info success");
        }
    }

    public void deleteBookByIndex(int i){
        books.remove(i);
        System.out.println("delete success");
    }

    public void processDelete(){
        System.out.print("enter index book want to delete between 1- " + count()+ ": ");
        int deleteSelect = Integer.parseInt(sc.nextLine());
        deleteBookByIndex(deleteSelect-1);
    }
    List<Book> searchResult(List <Book> list, String keyWord){
        return list.stream()
                .filter(ele -> ele.getId().contains(keyWord)|| ele.getName().contains(keyWord) || ele.getAuthor().contains(keyWord))
                .collect(Collectors.toList());
    }
    public void search(String keyWord) throws InterruptedException {
        List<Book> result = new ArrayList<>();
        if(manageCache.isCacheNull()){
            searchInData(keyWord);
        }
        else {
            Optional<String> keySimilar = manageCache.findKeySimilar(keyWord);

            if (keySimilar.isPresent()) {
                System.out.println("Key similar: " + keySimilar);
                result = searchInCache(keySimilar.get(), keyWord);
            } else {
                manageCache.controlCacheIfFull();
                result = searchInData(keyWord);
            }
        }
        System.out.println(manageCache.searchHistory.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(result.isEmpty() ? "No data have keyword" : result);
    }

    private List<Book> searchInCache(String keySimilar, String keyWord){
        if(keySimilar.equals(keyWord)){
            manageCache.changeStateKeywordExists(keyWord);
            return manageCache.getDataInCache(keyWord);
        }
        else{
            manageCache.controlCacheIfFull();
            manageCache.addKeyWord(keyWord);
            List<Book> searchList = searchResult(manageCache.getDataInCache(keySimilar), keyWord);
            manageCache.addData(keyWord, searchList);
            return searchList;
        }
    }

    private List<Book> searchInData(String keyWord) throws InterruptedException {
        Thread.sleep(4000);
        manageCache.addKeyWord(keyWord);
        List <Book> searchList = searchResult(books, keyWord);
        manageCache.addData(keyWord, searchList);
        return searchList;
    }

    public void processSearch() throws InterruptedException {
        System.out.print("Enter the keyWord: " );
        String keyWord= sc.nextLine();
        this.search(keyWord);
    }
}
