package april02.library;

public class ArtAlbum extends Book {

    private String paperQuality;
    public ArtAlbum(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality=paperQuality;
    }


}
