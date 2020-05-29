import java.io.Serializable;

/**
 *
 * @author LChavez1
 */
public class Product implements Serializable {

    protected Integer sku;
    protected String name_product;
    protected Float price;

    public Product() {
    }

    public Product(Integer sku, String name_product, Float price) {
        this.sku = sku;
        this.name_product = name_product;
        this.price = price;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku=" + sku +
                ", name_product='" + name_product + '\'' +
                ", price=" + price +
                '}';
    }
}
