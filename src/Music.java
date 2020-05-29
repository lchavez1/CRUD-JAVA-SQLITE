/**
 *
 * @author LChavez1
 */
public class Music extends Product {

    private Integer year;
    private String format;
    private String track_list;
    private String artist;

    public Music(Integer sku, String nombre, Float price, Integer year, String format, String track_list, String artist) {
        super(sku, nombre, price);
        this.year = year;
        this.format = format;
        this.track_list = track_list;
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTrack_list() {
        return track_list;
    }

    public void setTrack_list(String track_list) {
        this.track_list = track_list;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Music{" +
                "year=" + year +
                ", format='" + format + '\'' +
                ", track_list='" + track_list + '\'' +
                ", artist='" + artist + '\'' +
                ", sku=" + sku +
                ", nombre='" + name_product + '\'' +
                ", price=" + price +
                '}';
    }
}
