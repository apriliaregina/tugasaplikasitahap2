/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import keyboard.db.DBHandler;
import keyboard.model.Keyboard;

/**
 *
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<?> cbPembayaran;

    @FXML
    private DatePicker dpTanggalBeli;

    @FXML
    private ToggleGroup merk;

    @FXML
    private Label label;

    @FXML
    private RadioButton rdLogi;

    @FXML
    private RadioButton rdRobot;

    @FXML
    private TextField Id;

    @FXML
    private TextField tfNama;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        System.out.println(Id.getText());
        System.out.println(tfNama.getText());
        System.out.println(dpTanggalBeli.getValue().toString());
        String merk="";
        if (rdLogi.isSelected())
           merk=rdLogi.getText();
        if (rdRobot.isSelected())
           merk=rdRobot.getText();
        
        System.out.println(merk);
        System.out.println(cbPembayaran.getValue().toString());
        Keyboard key = new Keyboard(Id.getText(),tfNama.getText(),dpTanggalBeli.getValue().toString(),
            merk,cbPembayaran.getValue().toString());
        DBHandler dh = new DBHandler("MYSQL");
        dh.addKeyboard(key);
        FXMLDataViewController view = new FXMLDataViewController();
        view.showDataKeyboard();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ArrayList <String> list = new ArrayList<String>();
        list.add("Cash");
        list.add("Kredit");
        ObservableList items = FXCollections.observableArrayList(list);
        cbPembayaran.setItems(items);
    }    
    
}