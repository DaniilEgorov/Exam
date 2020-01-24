package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
    public Connection connection = null;
    public PreparedStatement ps = null;
    Building building;
    @FXML
    DatePicker dp;
    @FXML
    Label label;
    @FXML
    TextField length, width, height, number;
    @FXML
    ComboBox<String> material;
    ObservableList<String> list = FXCollections.observableArrayList("Древесина","Кирпич","Пеноблок");
    @FXML
    void initialize() throws SQLException {
        material.setItems(list);
        connection_database();
    }
    @FXML
    void button_get() throws SQLException {
        double l = Double.parseDouble(length.getText());
        double w = Double.parseDouble(width.getText());
        double h = Double.parseDouble(height.getText());
        int n = Integer.parseInt(number.getText());
        building = new Building(l,w,h,n);
        building.setMaterial(material.getValue());
        building.setDeadline(dp.getValue().toString());
        double p = building.payment();
        insertData(p);
        label.setText("Цена здания:"+p);
    }
    public void connection_database () throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:5432/data";
        String name = "postgres";
        String password = "qwerty";
        connection = DriverManager.getConnection(url, name, password);
    }
    public void insertData(double p) throws SQLException {
        ps = connection.prepareStatement(String.format("INSERT INTO table_name VALUES ('%s','%s',%f)",dp.getValue().toString(),material.getValue(),p));
    }
}
