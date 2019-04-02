package april02.library;

public class MainClass {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        //add

        final Novel firstNovel = new Novel ("Moara cu noroc", 150, "Sf");
        ArtAlbum firstAlbum = new ArtAlbum("Van Gogh", 200, "HQ");
        Book firstBook = new Book("test", 2);

         myLibrary.addItem(firstNovel);

         //list
        for(Book book : myLibrary.getBooks()){
            System.out.println("Book " +  book);
        }

        //remove
        myLibrary.removeItem(firstNovel);
    }
}
