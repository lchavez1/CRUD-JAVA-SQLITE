/**
 *
 * @author LChavez1
 */
public class Movies extends Product {

    private String region;
    private Integer year;
    private String format;
    private String actors;

    public Movies(Integer sku, String nombre, Float price, String region, Integer year, String format, String actors) {
        super(sku, nombre, price);
        this.region = region;
        this.year = year;
        this.format = format;
        this.actors = actors;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "region='" + region + '\'' +
                ", year=" + year +
                ", format='" + format + '\'' +
                ", actors='" + actors + '\'' +
                ", sku=" + sku +
                ", nombre='" + name_product + '\'' +
                ", price=" + price +
                '}';
    }
}
