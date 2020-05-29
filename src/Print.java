import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Print {

    int position = 0;

    Controller controller = new Controller();
    LinkedList<Sells> linkedList_sells = new LinkedList<>();
    LinkedList<Product> linkedList_products = new LinkedList<>();

    public CheckBox check_product;
    public CheckBox check_sells;
    public CheckBox check_customer;
    public TextField field_sku;
    public TextField field_name_product;
    public TextField field_price;
    public TextField field_description;
    public TextField field_assurance;
    public TextField field_track_list;
    public TextField field_format_music;
    public TextField field_year_music;
    public TextField field_artist;
    public TextField field_actors;
    public TextField field_region;
    public TextField field_year_movie;
    public TextField field_format_movie;
    public TextField field_type;
    public TextField field_brand;
    public TextField field_content;
    public TextField field_password;
    public TextField field_email;
    public TextField field_name_customer;
    public TextField field_customer_sell;
    public TextField field_date;
    public TextField field_product_sell;


    public void checked_product(ActionEvent actionEvent) {
        if(check_product.isSelected()){
            check_customer.setDisable(true);
            check_sells.setDisable(true);
            field_sku.setDisable(false);
            field_name_product.setDisable(false);
            field_price.setDisable(false);
        } else {
            check_customer.setDisable(false);
            check_sells.setDisable(false);
            field_sku.setDisable(true);
            field_name_product.setDisable(true);
            field_price.setDisable(true);
        }
    }

    public void checked_customer(ActionEvent actionEvent) {
        if(check_customer.isSelected()){
            check_product.setDisable(true);
            check_sells.setDisable(true);
            field_name_customer.setDisable(false);
            field_email.setDisable(false);
            field_password.setDisable(false);
        } else {
            check_product.setDisable(false);
            check_sells.setDisable(false);
            field_name_customer.setDisable(true);
            field_email.setDisable(true);
            field_password.setDisable(true);
        }
    }

    public void checked_sells(ActionEvent actionEvent) {
        if(check_sells.isSelected()){
            check_product.setDisable(true);
            check_customer.setDisable(true);
            field_product_sell.setDisable(false);
            field_customer_sell.setDisable(false);
            field_date.setDisable(false);
        } else {
            check_product.setDisable(false);
            check_customer.setDisable(false);
            field_product_sell.setDisable(true);
            field_customer_sell.setDisable(true);
            field_date.setDisable(true);
        }
    }

    public void btn_search_customer(ActionEvent actionEvent) {
        try{
            String email = field_email.getText();
            clear();
            Customer customer = controller.print_customer(email);
            if(customer != null){
                field_email.setText(customer.getEmail());
                field_name_customer.setText(customer.getName());
                field_password.setText(customer.getPassword());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "No existe un cliente registrado con ese email");
                alert.show();
            }
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
    }

    public void btn_search_sell(ActionEvent actionEvent) {
        try{
            position = 0;
            linkedList_sells.clear();
            linkedList_products.clear();
            linkedList_sells = controller.print_sells();
            linkedList_products = controller.get_products();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "ventas cargadas");
            alert.show();
            field_product_sell.setText(name_product(linkedList_sells.get(position).getProduct()));
            field_customer_sell.setText(linkedList_sells.get(position).getCustomer());
            field_date.setText(date_converter(linkedList_sells.get(position).getDate()));
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void btn_search_product(ActionEvent actionEvent) {
        try {
            int sku = Integer.parseInt(field_sku.getText());
            clear();
            Product product = controller.get_product(sku);
            if(product != null){
                field_sku.setText(String.valueOf(sku));
                field_name_product.setText(product.name_product);
                field_price.setText(String.valueOf(product.price));
                if(product instanceof Electronic){
                    disable_electronic();
                    field_description.setText(((Electronic) product).getDescription());
                    field_assurance.setText(((Electronic) product).getAssurance());
                } else if(product instanceof Music){
                    disable_music();
                    field_year_music.setText(String.valueOf((((Music) product).getYear())));
                    field_format_music.setText(((Music) product).getFormat());
                    field_track_list.setText(((Music) product).getTrack_list());
                    field_artist.setText(((Music) product).getArtist());
                } else if(product instanceof Movies){
                    disable_movie();
                    field_region.setText(((Movies) product).getRegion());
                    field_year_movie.setText(String.valueOf(((Movies) product).getYear()));
                    field_format_movie.setText(((Movies) product).getFormat());
                    field_actors.setText(((Movies) product).getActors());
                } else {
                    disable_basic();
                    field_type.setText(((Basics) product).getType());
                    field_brand.setText(((Basics) product).getBrand());
                    field_content.setText(((Basics) product).getContent());
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "No existe un producto registrado con ese sku");
                alert.show();
            }

        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
    }

    public String date_converter(Date value){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try{
            String date = simpleDateFormat.format(value);
            return  date;
        } catch (Exception ex) {
            return "fecha vacia";
        }
    }

    public String name_product(int sku){
        try{
            int position = position_product(sku);
            return linkedList_products.get(position).getName_product();
        } catch (Exception ex){
            return "vacio";
        }
    }

    public void disable_electronic(){
        field_description.setDisable(false);
        field_assurance.setDisable(false);
    }

    public void disable_movie(){
        field_actors.setDisable(false);
        field_format_movie.setDisable(false);
        field_year_movie.setDisable(false);
        field_region.setDisable(false);
    }

    public void disable_music(){
        field_format_music.setDisable(false);
        field_track_list.setDisable(false);
        field_year_music.setDisable(false);
        field_artist.setDisable(false);
    }

    public void disable_basic(){
        field_type.setDisable(false);
        field_brand.setDisable(false);
        field_content.setDisable(false);
    }

    public void clear(){
        field_sku.clear();
        field_name_product.clear();
        field_price.clear();
        field_description.clear();
        field_assurance.clear();
        field_track_list.clear();
        field_format_music.clear();
        field_year_music.clear();
        field_artist.clear();
        field_actors.clear();
        field_region.clear();
        field_year_movie.clear();
        field_format_movie.clear();
        field_type.clear();
        field_brand.clear();
        field_content.clear();
        field_password.clear();
        field_email.clear();
        field_name_customer.clear();
        field_date.clear();
    }

    public void btn_left(ActionEvent actionEvent) {
        try{
            position--;
            if(position < 0){
                position = linkedList_sells.size()-1;
            }
            linkedList_sells.clear();
            linkedList_products.clear();
            linkedList_sells = controller.print_sells();
            linkedList_products = controller.get_products();
            field_product_sell.setText(name_product(linkedList_sells.get(position).getProduct()));
            field_customer_sell.setText(linkedList_sells.get(position).getCustomer());
            field_date.setText(date_converter(linkedList_sells.get(position).getDate()));
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void btn_right(ActionEvent actionEvent) {
        try{
            position++;
            if(position >= linkedList_sells.size()){
                position = 0;
            }
            linkedList_sells.clear();
            linkedList_products.clear();
            linkedList_sells = controller.print_sells();
            linkedList_products = controller.get_products();
            field_product_sell.setText(name_product(linkedList_sells.get(position).getProduct()));
            field_customer_sell.setText(linkedList_sells.get(position).getCustomer());
            field_date.setText(date_converter(linkedList_sells.get(position).getDate()));
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public int position_product(int sku){
        linkedList_products.clear();
        linkedList_products = controller.get_products();
        for(int i = 0; i < linkedList_products.size(); i++){
            if(linkedList_products.get(i).sku.equals(sku))
                return i;
        }
        return -1;
    }
}
