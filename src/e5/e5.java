package e5;

import animatefx.animation.FadeInUp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Background;

import java.net.URL;
import java.util.ResourceBundle;

public class e5 implements Initializable {
    private String respuesta;
    @FXML
    private Spinner<Double> spNumerador = new Spinner<Double>();
    @FXML
    private Spinner<Double> spDividendo = new Spinner<Double>();
    @FXML
    private Label lblRespuesta;
    @FXML
    private Button btVerificar;

    @FXML
    void evaluarFraccion(){
        if(this.spDividendo.getValue() > this.spNumerador.getValue()){
            this.respuesta = "FRACCION IMPROPIA";
        }else if (this.spDividendo.getValue() < this.spNumerador.getValue()){
            this.respuesta = "FRACCION PROPIA";
        }else if (this.spNumerador.getValue() == this.spDividendo.getValue()){
            this.respuesta = "Fracciones iguales a la unidad";
        }
        this.lblRespuesta.setText(this.respuesta);
        new FadeInUp(this.lblRespuesta).play();
    };

    void setSpinnersNumeradorYdenominador(){
        this.spNumerador.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-99999999.0,99999999.0,1.0));
        this.spDividendo.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-99999999.0,99999999.0,1.0));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setSpinnersNumeradorYdenominador();
        this.respuesta="";
        this.btVerificar.setText("VERIFICAR");
    }
}
