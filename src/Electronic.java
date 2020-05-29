/**
 *
 * @author LChavez1
 */
public class Electronic extends Product {

    private String description;
    private String assurance;

    public Electronic(Integer sku, String nombre, Float price, String description, String assurance) {
        super(sku, nombre, price);
        this.description = description;
        this.assurance = assurance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "description='" + description + '\'' +
                ", assurance='" + assurance + '\'' +
                ", sku=" + sku +
                ", nombre='" + name_product + '\'' +
                ", price=" + price +
                '}';
    }
}

