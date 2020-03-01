package e1;
import animatefx.animation.*;
import animatefx.animation.FadeInUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class E1 implements Initializable {
    @FXML private Button btRealizar;
    @FXML private Rectangle rectangulo;
    @FXML private Rectangle cuadrado;
    @FXML private Polygon triangulo;
    @FXML private ComboBox<String> cbFiguras;
    @FXML private Label lblFigura;
    @FXML private ColumnConstraints column2;
    @FXML private ColumnConstraints column3;
    @FXML private Spinner<Double> txt1;
    @FXML private Spinner<Double> txt2;
    @FXML private Spinner<Double> txt3;
    @FXML private Spinner<Double> txt4;
    @FXML private SpinnerValueFactory grade1;
    @FXML private SpinnerValueFactory grade2;
    @FXML private SpinnerValueFactory grade3;
    @FXML private SpinnerValueFactory grade4;
    @FXML private Label lbl3;
    @FXML private Label lbl2;
    @FXML private  Label lbl4;
    @FXML private  Label lblArea;
    @FXML private  Label lblPerimetro;
    @FXML private Pane resultadoPane;
    private ObservableList<String> figurasList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setSpinners();
        this.setVisibleCampo3(false);
        this.setVisibleCampo2(false);
        this.setVisible(false);
        this.setFiguras();
        this.cbFiguras.setItems(figurasList);
    }
    private void setFiguras(){
        this.figurasList.setAll("Triangulo","Rectangulo","Cuadrado");
    }
    void setTimeOut(Runnable runnable, int inteval){
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(inteval),
                ActionEvent-> runnable.run()
        ));
    }
    public void cbCambio(ActionEvent event){
        this.setVisible(false);
        if (!this.cbFiguras.getValue().toString().equals("")){
            switch (this.cbFiguras.getValue().toString()){
                case "Rectangulo":
                    this.rectangulo.setVisible(true);
                    new FadeInUp(this.rectangulo).play();
                    this.setVisibleCampo3(false);
                    this.setVisibleCampo2(true);
                    break;
                case "Triangulo":
                    this.triangulo.setVisible(true);
                    new FadeInUp(this.triangulo).play();
                    this.setVisibleCampo3(true);
                    this.setVisibleCampo2(true);
                    break;
                case "Cuadrado":
                    this.cuadrado.setVisible(true);
                    new FadeInUp(this.cuadrado).play();
                    this.setVisibleCampo3(false);
                    this.setVisibleCampo2(false);
                    break;
            }
            this.lblFigura.setText(this.cbFiguras.getValue().toString());
        }

    }

    public void setVisible(boolean vs){
        this.cuadrado.setVisible(vs);
        this.triangulo.setVisible(vs);
        this.rectangulo.setVisible(vs);
    }

    public void setVisibleCampo3(boolean mostrar){
        double setDouble = 0.0;
        if(mostrar){
            setDouble = 100.0;
        }else{
            setDouble = 0.0;
        }
        this.column3.setPrefWidth(setDouble);
        this.column3.setMaxWidth(setDouble);
        this.txt3.setVisible(mostrar);
        this.txt4.setVisible(mostrar);
        this.lbl3.setVisible(mostrar);
        this.lbl4.setVisible(mostrar);
        if(mostrar){
            new FadeInLeft(this.lbl4).play();
            new FadeInLeft(this.lbl3).play();
            new FadeInRight(this.txt3).play();
            new FadeInRight(this.txt4).play();
        }
    }

    public void setVisibleCampo2(boolean mostrar){
        double setDouble = 0.0;
        if(mostrar){
            setDouble = 150.0;
        }else{
            setDouble = 0.0;
        }
        this.column2.setPrefWidth(setDouble);
        this.column2.setMaxWidth(setDouble);
        this.txt2.setVisible(mostrar);
        this.lbl2.setVisible(mostrar);
        if(mostrar){
            new FadeInLeft(this.lbl2).play();
            new FadeInRight(this.txt2).play();
        }
    }

    public void setSpinners(){
        this.grade1 = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,999999.0,1.0);
        this.grade2 = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,999999.0,1.0);
        this.grade3 = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,999999.0,1.0);
        this.grade4 = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,999999.0,1.0);
        this.txt1.setValueFactory(grade1);
        this.txt2.setValueFactory(grade2);
        this.txt3.setValueFactory(grade3);
        this.txt4.setValueFactory(grade4);
    }

    public void calcular(ActionEvent event){
        double area=0.0;
        double perimetro=0.0;
try {
    switch (this.cbFiguras.getValue().toString()){
        case "Rectangulo":
            area = this.txt1.getValue() * this.txt2.getValue();
            perimetro = ( this.txt1.getValue()*2 ) + ( this.txt2.getValue()*2 );
            break;
        case "Triangulo":
            area = ( this.txt4.getValue() * this.txt2.getValue() ) / 2;
            perimetro = this.txt1.getValue() + this.txt2.getValue() + this.txt3.getValue();
            break;
        case "Cuadrado":
            area = this.txt1.getValue()*4;
            perimetro = Math.pow(this.txt1.getValue(),2);
            break;
    }
} catch (Exception e){
    
}
    this.lblArea.setText(area+"");
        this.lblPerimetro.setText(perimetro+"");
        new JackInTheBox(this.resultadoPane).play();
    }
}
