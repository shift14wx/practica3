package e2;

import animatefx.animation.*;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class e2 implements Initializable {
        @FXML private Pane tituloAuto;
        @FXML private Pane tituloRenta;
        @FXML private Button btnAgregarAuto;
        @FXML private TextField auto;
        @FXML private Spinner<Integer> año;
        @FXML private Label autoSeleccionado;
        @FXML private TableView<vehiculo> tablaVehiculos = new TableView<vehiculo>();
        @FXML private TableColumn<vehiculo,String> tcAuto;
        @FXML private TableColumn<vehiculo,String> tcAño;
        @FXML private TableView<renta> tablaRenta = new TableView<renta>();
        @FXML private TableColumn<renta,String> tcid;
        @FXML private TableColumn<renta,String> tcfechaRenta;
        @FXML private TableColumn<renta,String> tcautoRenta;
        @FXML private DatePicker fecha;
        @FXML private Button btnAgregarRenta;
        private Integer nRenta;
        private ObservableList<vehiculo> vehiculos = FXCollections.observableArrayList();
        private ObservableList<renta> rentas = FXCollections.observableArrayList();
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            new FadeInLeft(this.tituloAuto).play();
            new FadeInRight(this.tituloRenta).play();
            new RotateInDownRight(this.tablaRenta).play();
            new RotateInDownLeft(this.tablaVehiculos).play();
            new SlideInLeft(this.btnAgregarAuto).play();
            new SlideInRight(this.btnAgregarRenta).play();
            this.nRenta=0;
            this.setTableColumnsAuto();
            this.setTableColumnRenta();
        }

        public void setTableColumnsAuto(){
            this.año.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1000,2021,1000));
            this.tcAuto.setCellValueFactory(new PropertyValueFactory<vehiculo,String>("auto"));
            this.tcAño.setCellValueFactory(new PropertyValueFactory<vehiculo,String>("año"));
            this.tablaVehiculos.setItems(this.getVehiculos());
        }

        public void setTableColumnRenta(){
            this.tcid.setCellValueFactory(new PropertyValueFactory<renta,String>("id"));
            this.tcautoRenta.setCellValueFactory(new PropertyValueFactory<renta,String>("autoRenta"));
            this.tcfechaRenta.setCellValueFactory(new PropertyValueFactory<renta,String>("fechaRenta"));
            this.tablaRenta.setItems(this.getRentas());
        }

        public ObservableList<vehiculo> getVehiculos(){
            return this.vehiculos;
        }
        public ObservableList<renta> getRentas(){
            return this.rentas;
        }
        public void agregarVehiculo(){

            try {
                if(!this.auto.getText().equals("")){
                    this.vehiculos.add(
                            new vehiculo(
                                    new SimpleStringProperty(this.auto.getText().toString()),
                                    new SimpleStringProperty(this.año.getValue().toString())
                            )
                    );
                    new Shake(this.tablaVehiculos).play();
                }
                this.auto.setText("");
            }catch (Exception e){

            }

        }

        public void getSelectedAuto(){
            try {
                ObservableList<Integer> selectedItems = tablaVehiculos.getSelectionModel().getSelectedIndices();
                Integer index = selectedItems.get(0);
                this.autoSeleccionado.setText(this.vehiculos.get(index).auto.getValue().toString());
                new JackInTheBox(this.autoSeleccionado).play();
            }catch (Exception e){

            }
        }

        public void agregarRenta(){

            if(!this.autoSeleccionado.getText().equals("no seleccinado") && !this.fecha.getValue().toString().equals("")){
                this.nRenta +=1;
                this.rentas.add(
                  new renta(
                          new SimpleStringProperty(this.fecha.getValue().toString()),
                          new SimpleStringProperty(this.nRenta+""),
                          new SimpleStringProperty(this.autoSeleccionado.getText())
                  )
                );
                new Shake(this.tablaRenta).play();
            }

        }
}
