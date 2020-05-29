import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.LinkedList;

public class Delete {

    public TextField field_sku_search_delete;
    public TextField field_name_product_delete;
    public TextField field_name_customer_delete;
    public TextField field_email_search_delete;

    Controller controller = new Controller();

    public void btn_search_email_delete(ActionEvent actionEvent) {
        try{
            String email = field_email_search_delete.getText();
            Customer customer = controller.print_customer(email);
            if(customer != null){
                field_name_customer_delete.setText(customer.getName());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No existe un cliente registrado con ese email");
                alert.show();
            }
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
    }

    public void btn_delete_customer(ActionEvent actionEvent) {
        try{
            String email = field_email_search_delete.getText();
            controller.delete_customer(email);
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
        clear();
    }

    public void btn_delete_product(ActionEvent actionEvent) {
        try{
            int sku = Integer.parseInt(field_sku_search_delete.getText());
            controller.detele_product(sku);
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
        clear();
    }

    public void btn_search_sku_delete(ActionEvent actionEvent) {
        try{
            int sku = Integer.parseInt(field_sku_search_delete.getText());
            Product product = controller.get_product(sku);
            if(product != null) {
                field_name_product_delete.setText(product.name_product);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No existe ese producto");
                alert.show();
            }
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
    }

    public void clear(){
        field_sku_search_delete.clear();
        field_name_product_delete.clear();
        field_name_customer_delete.clear();
        field_email_search_delete.clear();
    }

}
