/**
 *
 * @author LChavez1
 */
public class Basics extends Product {

    private String type;
    private String brand;
    private String content;

    public Basics(Integer sku, String nombre, Float price, String type, String brand, String content) {
        super(sku, nombre, price);
        this.type = type;
        this.brand = brand;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Basics{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", content='" + content + '\'' +
                ", sku=" + sku +
                ", name_product='" + name_product + '\'' +
                ", price=" + price +
                '}';
    }
}
