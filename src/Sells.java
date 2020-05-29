import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author LChavez1
 */
public class Sells implements Serializable {

    private Integer product;
    private String customer;
    private Date date;

    public Sells(int product, String customer, Date date) {
        this.product = product;
        this.customer = customer;
        this.date = date;
    }

    public int getProduct() {
        return product;
    }

    public void setProducts(int product) {
        this.product = product;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
