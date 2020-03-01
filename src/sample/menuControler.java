package sample;


import animatefx.animation.BounceIn;
import animatefx.animation.FadeInDown;
import animatefx.animation.FadeInLeft;
import animatefx.animation.FadeInRight;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class menuControler implements Initializable {

    @FXML private HBox titleBar;
    @FXML private Button b1;
    @FXML private Button b2;
    @FXML private Button b3;
    @FXML private Button b4;
    @FXML private Button b5;
    @FXML private Button b6;
    @FXML private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /* ;*/

        this.setVisibleAllParButtons(false);
        this.setVisibleAllOddsButtons(false);
        this.delayTo(()-> this.setVisibleAllOddsButtons(true),500);
        this.delayTo(()->new FadeInLeft(b1).play(),500);
        this.delayTo(()->new FadeInLeft(b3).play(),500);
        this.delayTo(()->new FadeInLeft(b5).play(),500);
        this.delayTo(()-> this.setVisibleAllParButtons(true),1000);
        this.delayTo(()->new FadeInRight(b2).play(),1000);
        this.delayTo(()->new FadeInRight(b4).play(),1000);
        this.delayTo(()->new FadeInRight(b6).play(),1000);
        new FadeInDown(titleBar).play();
    }

    private void setVisibleAllOddsButtons(boolean pSetTo){
        b1.setVisible(pSetTo);
        b3.setVisible(pSetTo);
        b5.setVisible(pSetTo);
    }
    private void setVisibleAllParButtons(boolean pSetTo){
        b2.setVisible(pSetTo);
        b4.setVisible(pSetTo);
        b6.setVisible(pSetTo);
    }

    private void delayTo(Runnable runnable, int delay){
        Timeline timeline =  new Timeline(new KeyFrame(
                Duration.millis(delay),
                actionEvent -> runnable.run()
        ));
        timeline.play();
    }

    double x,y;

    @FXML
    void pressed(MouseEvent event){
        x = event.getSceneX();
        y=event.getSceneY();
    }
    @FXML
    void dragged(MouseEvent  event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }
    @FXML
    void close(MouseEvent event){
        Stage stage = (Stage)  ((Node)  event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void min(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void openE1(javafx.event.ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../e1/e1.fxml"));
        Parent e1 = null;
        try {
            e1 = (Parent) fxmlLoader.load();
            e1.getStylesheets().add(getClass().getResource("../sample/stylos.css").toString());
            Stage stage = new Stage();
            stage.setTitle("ejercicio 1");
            stage.setScene(new Scene(e1));

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void openE2(javafx.event.ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../e2/e2.fxml"));
        Parent e2 = null;
        try {
            e2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ejercicio 2");
            stage.setScene(new Scene(e2));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openE3(javafx.event.ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../e3/e3.fxml"));
        Parent e3 = null;
        try {
            e3 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ejercicio 3");
            stage.setScene(new Scene(e3));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void openE4(javafx.event.ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../e4/e4.fxml"));
        Parent e4 = null;
        try {
            e4 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ejercicio 4");
            stage.setScene(new Scene(e4));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openE5(javafx.event.ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../e5/e5.fxml"));
        Parent e5 = null;
        try {
            e5 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ejercicio 5");
            stage.setScene(new Scene(e5));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
