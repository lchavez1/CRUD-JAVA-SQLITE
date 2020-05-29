import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.security.spec.ECField;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Controller {

    public Button btn_insert;
    public Button btn_print;
    public Button btn_delete;
    public Button btn_edit;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    Calendar calendar = new GregorianCalendar();

    public Connection connect() throws SQLException {
        Connection connection = null;
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:" + "src/db.db");
                System.out.println("YESSS");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            }
        }
        return connection;
    }

    public void btn_insert(ActionEvent actionEvent) {
        try {
            URL fxml = getClass().getClassLoader().getResource("Views/Insert.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxml);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.sizeToScene();
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void btn_print(ActionEvent actionEvent) {
        try {
            URL fxml = getClass().getClassLoader().getResource("Views/Print.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxml);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.sizeToScene();
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void btn_delete(ActionEvent actionEvent) {
        try {
            URL fxml = getClass().getClassLoader().getResource("Views/Delete.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxml);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.sizeToScene();
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void btn_edit(ActionEvent actionEvent) {
        try {
            URL fxml = getClass().getClassLoader().getResource("Views/Edit.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxml);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.sizeToScene();
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void read_electronic(Integer sku, String name_product, Float price, String description, String assurance) {
        try {
            Connection connection = connect();
            if (connection != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("insert into Product (sku, name, price) values (?,?,?)");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.setString(2, name_product);
                preparedStatement.setString(3, String.valueOf(price));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("insert into Electronic (sku, description, assurance) values (?,?,?)");
                preparedStatement1.setString(1, String.valueOf(sku));
                preparedStatement1.setString(2, description);
                preparedStatement1.setString(3, assurance);
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto ingresado");
                alert.show();
                connection.close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void read_music(Integer sku, String name_product, Float price, Integer year, String format, String track_list, String artist) {
        try {
            if (connect() != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("insert into Product (sku, name, price) values (?,?,?)");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.setString(2, name_product);
                preparedStatement.setString(3, String.valueOf(price));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("insert into Music (sku, year, format, track_list, artist) values (?,?,?,?,?)");
                preparedStatement1.setString(1, String.valueOf(sku));
                preparedStatement1.setString(2, String.valueOf(year));
                preparedStatement1.setString(3, format);
                preparedStatement1.setString(4, track_list);
                preparedStatement1.setString(5, artist);
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto ingresado");
                alert.show();
                connect().close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void read_movie(Integer sku, String name_product, Float price, String region, Integer year, String format, String actors) {
        try {
            if (connect() != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("insert into Product (sku, name, price) values (?,?,?)");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.setString(2, name_product);
                preparedStatement.setString(3, String.valueOf(price));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("insert into Movies (sku, region, year, format, actors) values (?,?,?,?,?)");
                preparedStatement1.setString(1, String.valueOf(sku));
                preparedStatement1.setString(2, region);
                preparedStatement1.setString(3, String.valueOf(year));
                preparedStatement1.setString(4, format);
                preparedStatement1.setString(5, actors);
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto ingresado");
                alert.show();
                connect().close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void read_basic(Integer sku, String name_product, Float price, String type, String brand, String content) {
        try {
            if (connect() != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("insert into Product (sku, name, price) values (?,?,?)");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.setString(2, name_product);
                preparedStatement.setString(3, String.valueOf(price));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("insert into Basics (sku, type, brand, content) values (?,?,?,?)");
                preparedStatement1.setString(1, String.valueOf(sku));
                preparedStatement1.setString(2, type);
                preparedStatement1.setString(3, brand);
                preparedStatement1.setString(4, content);
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto ingresado");
                alert.show();
                connect().close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void read_customer(String name_customer, String email, String password) {
        try {
            Connection connection = connect();
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into Customer (name, email, password) values (?,?,?)");
                preparedStatement.setString(1, name_customer);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cliente ingresado");
                alert.show();
                connection.close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void read_sells(String email, String product, String date) {
        try{
            Connection connection = connect();
            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into Details (email, product, date) values (?,?,?)");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, product);
                preparedStatement.setString(3, date);
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Venta ingresada");
                alert.show();
                connection.close();
            }
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void edit_electronic(Integer sku, String name_product, Float price, String description, String assurance) {
        try {
            Connection connection = connect();
            if (connection != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("update Product set name = ?, price = ? where sku = ?");
                preparedStatement.setString(1, name_product);
                preparedStatement.setString(2, String.valueOf(price));
                preparedStatement.setString(3, String.valueOf(sku));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("update Electronic set description = ?, assurance = ? where sku = ?");
                preparedStatement1.setString(1, description);
                preparedStatement1.setString(2, assurance);
                preparedStatement1.setString(3, String.valueOf(sku));
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto editado");
                alert.show();
                connection.close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
    }

    public void edit_music(Integer sku, String name_product, Float price, Integer year, String format, String track_list, String artist) {
        try {
            if (connect() != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("update Product set name = ?, price = ? where sku = ?");
                preparedStatement.setString(1, name_product);
                preparedStatement.setString(2, String.valueOf(price));
                preparedStatement.setString(3, String.valueOf(sku));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("update Music set year = ?, format = ?, track_list = ?, artist = ? where sku = ?");
                preparedStatement1.setString(1, String.valueOf(year));
                preparedStatement1.setString(2, format);
                preparedStatement1.setString(3, track_list);
                preparedStatement1.setString(4, artist);
                preparedStatement1.setString(5, String.valueOf(sku));
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto editado");
                alert.show();
                connect().close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
        }
    }

    public void edit_movie(Integer sku, String name_product, Float price, String region, Integer year, String format, String actors) {
        try {
            if (connect() != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("update Product set name = ?, price = ? where sku = ?");
                preparedStatement.setString(1, name_product);
                preparedStatement.setString(2, String.valueOf(price));
                preparedStatement.setString(3, String.valueOf(sku));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("update Movies set region = ?, year = ?, format = ?, actors = ? where sku = ?");
                preparedStatement1.setString(1, String.valueOf(year));
                preparedStatement1.setString(2, String.valueOf(year));
                preparedStatement1.setString(3, format);
                preparedStatement1.setString(4, actors);
                preparedStatement1.setString(5, String.valueOf(sku));
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto editado");
                alert.show();
                connect().close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
        }
    }

    public void edit_basic(Integer sku, String name_product, Float price, String type, String brand, String content) {
        try {
            if (connect() != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("update Product set name = ?, price = ? where sku = ?");
                preparedStatement.setString(1, name_product);
                preparedStatement.setString(2, String.valueOf(price));
                preparedStatement.setString(3, String.valueOf(sku));
                preparedStatement.execute();
                PreparedStatement preparedStatement1 = connect().prepareStatement("update Basics set type = ?, brand = ?, content = ? where sku = ?");
                preparedStatement1.setString(1, type);
                preparedStatement1.setString(2, brand);
                preparedStatement1.setString(3, content);
                preparedStatement1.setString(4, String.valueOf(sku));
                preparedStatement1.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto editado");
                alert.show();
                connect().close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
        }
    }

    public void edit_customer(String email, String name_customer, String password) {
        try {
            if (connect() != null) {
                PreparedStatement preparedStatement = connect().prepareStatement("update Customer set name = ?, password = ? where email = ?");
                preparedStatement.setString(1, name_customer);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto editado");
                alert.show();
                connect().close();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        }
    }

    public void detele_product(int sku) {
        try {
            Connection connection = connect();
            if (connection != null) {
                if (electronic(sku, connection) == 1) {
                    delete_electronic(sku, connection);
                    delete_table_product(sku, connection);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto elimminado");
                    alert.show();
                }
                if(music(sku, connection) == 1){
                    delete_music(sku, connection);
                    delete_table_product(sku, connection);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto elimminado");
                    alert.show();
                }
                if(movie(sku, connection) == 1){
                    delete_movie(sku, connection);
                    delete_table_product(sku, connection);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto elimminado");
                    alert.show();
                }
                if(basic(sku, connection) == 1)
                    delete_basic(sku, connection);
                    delete_table_product(sku, connection);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto elimminado");
                    alert.show();
            }
        } catch (Exception ex) {

        }
    }

    public void delete_electronic(int sku, Connection connection) {
        try {
            if (connection != null) {
                preparedStatement = connect().prepareStatement("delete from Electronic where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        } finally {
            try{
               preparedStatement.close();
            } catch (Exception ex){

            }
        }
    }

    public void delete_music(int sku, Connection connection) {
        try {
            if (connection != null) {
                preparedStatement = connect().prepareStatement("delete from Music where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto elimminado");
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        } finally {
            try{
                preparedStatement.close();
            } catch (Exception ex){

            }
        }
    }

    public void delete_movie(int sku, Connection connection) {
        try {
            if (connection != null) {
                preparedStatement = connect().prepareStatement("delete from Movies where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto elimminado");
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        } finally {
            try{
                preparedStatement.close();
            } catch (Exception ex){

            }
        }
    }

    public void delete_basic(int sku, Connection connection) {
        try {
            if (connection != null) {
                preparedStatement = connect().prepareStatement("delete from Basics where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Producto elimminado");
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        } finally {
            try{
                preparedStatement.close();
            } catch (Exception ex){

            }
        }
    }

    public void delete_table_product(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connect().prepareStatement("delete from Product where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                preparedStatement.execute();
            }
        } catch (Exception ex){

        } finally {
            try{
                preparedStatement.close();
            } catch (Exception ex){

            }
        }
    }

    public void delete_customer(String email) {
        try {
            Connection connection = connect();
            if (connection != null) {
                preparedStatement = connect().prepareStatement("delete from Customer where email = ?");
                preparedStatement.setString(1, email);
                preparedStatement.execute();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cliente elimminado");
                alert.show();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage().toString());
            alert.show();
        } finally {
            try{
                preparedStatement.close();
            } catch (Exception ex){

            }
        }
    }

    public Product get_product(int sku){
        try {
            Connection connection = connect();
            if (connection != null) {
                if (electronic(sku, connection) == 1) {
                    return print_electronic(sku, connection);
                }
                if(music(sku, connection) == 1){
                    return print_music(sku, connection);
                }
                if(movie(sku, connection) == 1){
                    return print_movie(sku, connection);
                }
                if(basic(sku, connection) == 1)
                    return print_basic(sku, connection);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Product print_electronic(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Electronic natural join Product where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Electronic(resultSet.getInt("sku"), resultSet.getString("name"), resultSet.getFloat("price"),
                            resultSet.getString("description"), resultSet.getString("assurance"));
                }
            }
            return null;
        } catch (Exception ex){
            return null;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public Product print_music(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Music natural join Product where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Music(resultSet.getInt("sku"), resultSet.getString("name"), resultSet.getFloat("price"),
                            resultSet.getInt("year"), resultSet.getString("format"), resultSet.getString("track_list"), resultSet.getString("artist"));
                }
            }
            return null;
        } catch (Exception ex){
            return null;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public Product print_movie(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Movies natural join Product where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Movies(resultSet.getInt("sku"), resultSet.getString("name"), resultSet.getFloat("price"),
                            resultSet.getString("region"), resultSet.getInt("year"), resultSet.getString("format"), resultSet.getString("actors"));
                }
            }
            return null;
        } catch (Exception ex){
            return null;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public Product print_basic(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Basics natural join Product where sku = ?");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Basics(resultSet.getInt("sku"), resultSet.getString("name"), resultSet.getFloat("price"),
                            resultSet.getString("type"), resultSet.getString("brand"), resultSet.getString("content"));
                }
            }
            return null;
        } catch (Exception ex){
            return null;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public Customer print_customer(String email){
        try{
            Connection connection = connect();
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Customer where email = ?");
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new Customer(resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"));
                }
                connection.close();
            }
            return null;
        } catch (Exception ex){
            return null;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public LinkedList<Sells> print_sells(){
        try{
            Connection connection = connect();
            LinkedList<Sells> linkedList = new LinkedList<>();
            if(connection != null){
                PreparedStatement preparedStatement = connection.prepareStatement("select email, product, date from Details");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    linkedList.add(new Sells(resultSet.getInt("product"), resultSet.getString("email"), date_converter(resultSet.getString("date"))));
                }
                return linkedList;
            }
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
        return new LinkedList<>();
    }

    public LinkedList<Product> get_products(){
        try{
            Connection connection = connect();
            LinkedList<Product> linkedList = new LinkedList<>();
            if(connection != null){
                PreparedStatement preparedStatement = connection.prepareStatement("select sku, name, price from Product");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    linkedList.add(new Product(resultSet.getInt("sku"), resultSet.getString("name"), resultSet.getFloat("price")));
                }
                return linkedList;
            }
        } catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
        return new LinkedList<>();
    }

    public void alert_error(String err) {
        Alert alert = new Alert(Alert.AlertType.ERROR, err);
        alert.show();
    }

    public int electronic(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Product where sku in (select sku from Electronic where sku = ?)");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception ex){
            return 0;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public int music(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Product where sku in (select sku from Music where sku = ?)");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception ex){
            return 0;
        } finally {
            try{
               preparedStatement.close();
               resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public int movie(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Product where sku in (select sku from Movies where sku = ?)");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception ex){
            return 0;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public int basic(int sku, Connection connection){
        try{
            if(connection != null){
                preparedStatement = connection.prepareStatement("select * from Product where sku in (select sku from Basics where sku = ?)");
                preparedStatement.setString(1, String.valueOf(sku));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return 1;
                }
            }
            return 0;
        } catch (Exception ex){
            return 0;
        } finally {
            try{
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex){

            }
        }
    }

    public Date date_converter(String value){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try{
            Date date = simpleDateFormat.parse(value);
            return  date;
        } catch (Exception ex) {
            return new Date(120, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }
    }

}

