/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboard.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import keyboard.db.DBHandler;
import keyboard.model.KeyboardProperty;

/**
 * FXML Controller class
 *
 * 
 */
public class FXMLDataViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<KeyboardProperty> tblKeyboard;

    @FXML
    private TableColumn<KeyboardProperty, String> colMerk;

    @FXML
    private TableColumn<KeyboardProperty, String> colId;

    @FXML
    private TableColumn<KeyboardProperty, String> colNama;

    @FXML
    private TableColumn<KeyboardProperty, String> colPembayaran;

    @FXML
    private TableColumn<KeyboardProperty, String> colTglBeli;

    @FXML
    private MenuItem menuAddData;

    @FXML
    private MenuItem menuDeleteData;
    
     @FXML
    private MenuItem menuEditData;

    @FXML
    void viewAddDataForm(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }
    
     @FXML
    void viewEditDataTv(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLEditForm.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    @FXML
    void deleteDataKeyboard(ActionEvent event) {
        KeyboardProperty key = tblKeyboard.getSelectionModel().getSelectedItem();
        DBHandler dh = new DBHandler("MYSQL");
        dh.deleteKeyboard(key);
        showDataKeyboard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataKeyboard();

        tblKeyboard.getSelectionModel().selectedIndexProperty().addListener(listener -> {
//            JOptionPane.showMessageDialog(null, "Table Diklik!");
            menuDeleteData.setDisable(false);
        });
    }

    public void showDataKeyboard() {
        DBHandler dh = new DBHandler("MYSQL");
        ObservableList<KeyboardProperty> data = dh.getKeyboard();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMerk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colPembayaran.setCellValueFactory(new PropertyValueFactory<>("pembayaran"));
        colTglBeli.setCellValueFactory(new PropertyValueFactory<>("tanggalBeli"));
        tblKeyboard.setItems(null);
        tblKeyboard.setItems(data);
    }
}
