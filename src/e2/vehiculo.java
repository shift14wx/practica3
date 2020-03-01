package e2;

import javafx.beans.property.SimpleStringProperty;

public class vehiculo {

public SimpleStringProperty auto;
public SimpleStringProperty año;

    vehiculo(SimpleStringProperty auto, SimpleStringProperty año) {
        this.auto = auto;
        this.año = año;
    }

    private String getAuto() {
        return auto.get();
    }

    public SimpleStringProperty autoProperty() {
        return auto;
    }

    private void setAuto(String auto) {
        this.auto.set(auto);
    }

    private String getAño() {
        return año.get();
    }

    public SimpleStringProperty añoProperty() {
        return año;
    }

    private void setAño(String año) {
        this.año.set(año);
    }
}
