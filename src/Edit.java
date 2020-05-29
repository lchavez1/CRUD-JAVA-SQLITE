import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Edit {

    int counter_product_sell = 0;
    int array[] = new int[3];

    Controller controller = new Controller();
    Insert insert = new Insert();
    Calendar calendar = new GregorianCalendar();

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
    public Button btn_edit_customer;
    public Button btn_edit_basic;
    public Button btn_edit_movie;
    public Button btn_edit_music;
    public Button btn_edit_electronic;
    public TextField field_name_customer;

    public void btn_edit_electronic(ActionEvent actionEvent) {
        try {
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            String description = field_description.getText();
            String assurance = field_assurance.getText();
            controller.edit_electronic(sku, name_product, price, description, assurance);
            Alert alert = new Alert(Alert.AlertType.WARNING, "Producto editado con exito");
            alert.show();
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_edit_music(ActionEvent actionEvent) {
        try {
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            Integer year = Integer.parseInt(field_year_music.getText());
            String format = field_format_music.getText();
            String track_list = field_track_list.getText();
            String artist = field_artist.getText();
            controller.edit_music(sku, name_product, price, year, format, track_list, artist);
            Alert alert = new Alert(Alert.AlertType.WARNING, "Producto editado con exito");
            alert.show();
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_edit_movie(ActionEvent actionEvent) {
        try {
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            String region = field_region.getText();
            Integer year = Integer.parseInt(field_year_movie.getText());
            String format = field_format_movie.getText();
            String actors = field_actors.getText();
            controller.edit_movie(sku, name_product, price, region, year, format, actors);
            Alert alert = new Alert(Alert.AlertType.WARNING, "Producto editado con exito");
            alert.show();
        } catch (Exception ex) {
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_edit_basic(ActionEvent actionEvent) {
        try {
            Integer sku = Integer.parseInt(field_sku.getText());
            String name_product = field_name_product.getText();
            Float price = Float.valueOf(field_price.getText());
            String type = field_type.getText();
            String brand = field_brand.getText();
            String content = field_content.getText();
            controller.edit_basic(sku, name_product, price, type, brand, content);
            Alert alert = new Alert(Alert.AlertType.WARNING, "Producto editado con exito");
            alert.show();
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_edit_customer(ActionEvent actionEvent) {
        try{
            String email = field_email.getText();
            String name_customer = field_name_customer.getText();
            String password = field_password.getText();
            controller.edit_customer(email, name_customer, password);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Editado con exito");
            alert.show();
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();
    }

    public void btn_edit_sell(ActionEvent actionEvent) {
        /*try{
            Integer ns = Integer.parseInt(field_ns_sell.getText());
            int i = controller.position_sell(ns);
            if(i == -1){
                Alert alert = new Alert(Alert.AlertType.WARNING, "No existe una venta registrada con ese número");
                alert.show();
                insert.array_in_zero();
            } else {
                Date date = date_converter(field_date.getText());
                controller.edit_sells(i, array, date);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Venta actualizada correctamente");
                alert.show();
                insert.array_in_zero();
            }
        } catch (Exception ex){
            controller.alert_error(ex.getMessage());
        }
        clear();*/
    }

    public void btn_search(ActionEvent actionEvent) {
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
}
