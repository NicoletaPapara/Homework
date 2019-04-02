package april02.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // list of books
    private List<Book> books = new ArrayList<Book>();

    public void addItem (Book book){
        books.add(book);
    }

    public void removeItem (Book book) {
        books.remove(book);
    }

    public List<Book> getBooks(){
        return books;
    }
}
