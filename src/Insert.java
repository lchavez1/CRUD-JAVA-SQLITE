import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Insert {

    Controller controller = new Controller();
    Calendar calendar = new GregorianCalendar();

    public Button btn_add_product_sell;
    public Button btn_insert_electronic;
    public Button btn_insert_sell;
    public Button btn_insert_customer;
    public Button btn_insert_basic;
    public Button btn_insert_music;
    public Button btn_insert_movie;
    public CheckBox check_product;
    public CheckBox check_music;
    public CheckBox check_electronic;
    public CheckBox check_sells;
    public CheckBox check_customer;
    public CheckBox check_movie;
    public CheckBox check_basic;
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
    public TextField field_product_sell;
    public TextField field_date;

    public void checked_product(ActionEvent actionEvent) {
        if(check_product.isSelected()){
            check_customer.setDisable(true);
            check_sells.setDisable(true);
            check_electronic.setDisable(false);
            check_music.setDisable(false);
            check_movie.setDisable(false);
            check_basic.setDisable(false);
            field_sku.setDisable(false);
            field_name_product.setDisable(false);
            field_price.setDisable(false);
        } else {
            check_customer.setDisable(false);
            check_sells.setDisable(false);
            check_electronic.setSelected(false);
            check_music.setSelected(false);
            check_movie.setSelected(false);
            check_basic.setSelected(false);
            disable_electronic();
            disable_music();
            disable_movie();
            disable_basic();
            check_electronic.setDisable(true);
            check_music.setDisable(true);
            check_movie.setDisable(true);
            check_basic.setDisable(true);
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
            btn_insert_customer.setDisable(false);
        } else {
            check_product.setDisable(false);
            check_sells.setDisable(false);
            field_name_customer.setDisable(true);
            field_email.setDisable(true);
            field_password.setDisable(true);
            btn_insert_customer.setDisable(true);
        }
    }

    public void checked_sells(ActionEvent actionEvent) {
        if(check_sells.isSelected()){
            check_product.setDisable(true);
            check_customer.setDisable(true);
            field_customer_sell.setDisable(false);
            field_product_sell.setDisable(false);
            btn_insert_sell.setDisable(false);
        } else {
            check_product.setDisable(false);
            check_customer.setDisable(false);
            field_customer_sell.setDisable(true);
            field_product_sell.setDisable(true);
            btn_insert_sell.setDisable(true);
        }
    }

    public void checked_electronic(ActionEvent actionEvent) {
        disable_electronic();
    }

    public void checked_music(ActionEvent actionEvent) {
        disable_music();
    }

    public void checked_movie(ActionEvent actionEvent) {
        disable_movie();
    }

    public void checked_basic(ActionEvent actionEvent) {
        disable_basic();
    }

    public void disable_electronic(){
        if(check_electronic.isSelected()){
            field_description.setDisable(false);
            field_assurance.setDisable(false);
            check_music.setDisable(true);
            check_movie.setDisable(true);
            check_basic.setDisable(true);
            btn_insert_electronic.setDisable(false);
        } else {
            field_description.setDisable(true);
            field_assurance.setDisable(true);
            check_music.setDisable(false);
            check_movie.setDisable(false);
            check_basic.setDisable(false);
            btn_insert_electronic.setDisable(true);
        }
    }

    public void disable_movie(){
        if(check_movie.isSelected()){
            field_actors.setDisable(false);
            field_format_movie.setDisable(false);
            field_year_movie.setDisable(false);
            field_region.setDisable(false);
            btn_insert_movie.setDisable(false);
        } else {
            field_actors.setDisable(true);
            field_format_movie.setDisable(true);
            field_year_movie.setDisable(true);
            field_region.setDisable(true);
            btn_insert_movie.setDisable(true);
        }
    }

    public void disable_music(){
        if(check_music.isSelected()){
            field_format_music.setDisable(false);
            field_track_list.setDisable(false);
            field_year_music.setDisable(false);
            field_artist.setDisable(false);
            btn_insert_music.setDisable(false);
        } else {
            field_format_music.setDisable(true);
            field_track_list.setDisable(true);
            field_year_music.setDisable(true);
            field_artist.setDisable(true);
            btn_insert_music.setDisable(true);
        }
    }

    public void disable_basic(){
        if(check_basic.isSelected()){
            field_type.setDisable(false);
            field_brand.setDisable(false);
            field_content.setDisable(false);
            btn_insert_basic.setDisable(false);
        } else {
            field_type.setDisable(true);
            field_brand.setDisable(true);
            field_content.setDisable(true);
            btn_insert_basic.setDisable(true);
        }
    }

    public void btn_insert_electronic(ActionEvent actionEvent) {
        try {
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            String description = field_description.getText();
            String assurance = field_assurance.getText();
            controller.read_electronic(sku, name_product, price, description, assurance);
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_insert_music(ActionEvent actionEvent) {
        try{
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            Integer year = Integer.parseInt(field_year_music.getText());
            String format = field_format_music.getText();
            String track_list = field_track_list.getText();
            String artist = field_artist.getText();
            controller.read_music(sku, name_product, price, year, format, track_list, artist);
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_insert_movie(ActionEvent actionEvent) {
        try{
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            String region = field_region.getText();
            Integer year = Integer.parseInt(field_year_movie.getText());
            String format = field_format_movie.getText();
            String actors = field_actors.getText();
            controller.read_movie(sku, name_product, price, region, year, format, actors);
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_insert_basic(ActionEvent actionEvent) {
        try{
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            String type = field_type.getText();
            String brand = field_brand.getText();
            String content = field_content.getText();
            controller.read_basic(sku, name_product, price, type, brand, content);
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_insert_customer(ActionEvent actionEvent) {
        try{
            String name_customer = field_name_customer.getText();
            String email = field_email.getText();
            String password = field_password.getText();
            controller.read_customer(name_customer, email, password);
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_insert_sell(ActionEvent actionEvent) {
        try{
            String email = field_customer_sell.getText();
            String product = field_product_sell.getText();
            String date = date_converter(new Date(120, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)));
            controller.read_sells(email,product, date);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Venta agregada correctamente");
            alert.show();
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
        clear();
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
        field_customer_sell.clear();
        field_product_sell.clear();
    }
}

