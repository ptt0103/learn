package ex;


import java.util.ArrayList;
import java.util.List;

public class ManageSearch {
    List<Book> books;
    ManageCache manageCache;

    public ManageSearch() {
        manageCache = new ManageCache();
        books = new ArrayList<>();
        books.add(new Book("VN01", "toi thay hoa vang tren co xanh"));
        books.add(new Book("VN02", "mat biec"));
        books.add(new Book("VN03", "so do"));
        books.add(new Book("AB01", "nha gia kim"));
        books.add(new Book("AB02", "tam quoc"));
        books.add(new Book("BC01", "con cao va chum nho"));
        books.add(new Book("AC01", "chien tranh tien te"));
        books.add(new Book("ABC01", "every"));

    }
}
