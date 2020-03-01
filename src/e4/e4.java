package e4;

import animatefx.animation.FadeInUp;
import animatefx.animation.Shake;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class e4 implements Initializable {

    @FXML private Label lblRespuesta;
    @FXML private Button btConvertir;
    @FXML private Spinner<Double> spDolares = new Spinner<Double>() ;
    @FXML private ComboBox<String> cbMonedas = new ComboBox<String>();
    @FXML private ObservableList<Moneda> listMonedas = FXCollections.observableArrayList();
    @FXML private ObservableList<String> listcbMonedas = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setListas();
        this.cbMonedas.setItems(this.listcbMonedas);
        this.spDolares.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,99999999.0,0.0));
    }

    void setListas(){

        this.listMonedas.setAll(
                new Moneda("ç",8.75),
                new Moneda("₹",72.17),
                new Moneda("₽",66.91),
                new Moneda("圓",108.12),
                new Moneda("¥",6.99),
                new Moneda("€",0.91),
                new Moneda(" øre",9.40),
                new Moneda("Fr",0.96)
        );

        this.listMonedas.forEach(moneda->{
            this.listcbMonedas.add(moneda.simbolo+" "+moneda.tasa);
        });

    }
    @FXML
    void convertir(){
        if(this.spDolares.getValue()>0.0 && this.cbMonedas.getSelectionModel().getSelectedIndex() >-1){
            Double Total = this.spDolares.getValue() * this.listMonedas.get(this.cbMonedas.getSelectionModel().getSelectedIndex()).tasa;
            Double Viceversa = 1.0 / this.listMonedas.get(this.cbMonedas.getSelectionModel().getSelectedIndex()).tasa;
            Double TotalViceversa = Viceversa * this.spDolares.getValue();
            this.lblRespuesta.setText("$ "+this.spDolares.getValue()+" a "+this.cbMonedas.getValue()+": "+Total+"\n"+
                    "y "+this.cbMonedas.getValue().split(" ")[0]+" a $: "+String.format("%.2f",TotalViceversa));
            new FadeInUp(this.lblRespuesta).play();
        }else{
            new Shake(this.spDolares).play();
            new Shake(this.cbMonedas).play();
        }
    }
}
