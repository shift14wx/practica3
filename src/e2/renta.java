package e2;

import javafx.beans.property.SimpleStringProperty;

public class renta {

    private SimpleStringProperty fechaRenta;
    private SimpleStringProperty id;
    private SimpleStringProperty autoRenta;

    renta(SimpleStringProperty fechaRenta, SimpleStringProperty id, SimpleStringProperty autoRenta) {
        this.fechaRenta = fechaRenta;
        this.id = id;
        this.autoRenta = autoRenta;
    }

    private String getFechaRenta() {
        return fechaRenta.get();
    }

    public SimpleStringProperty fechaRentaProperty() {
        return fechaRenta;
    }

    private void setFechaRenta(String fechaRenta) {
        this.fechaRenta.set(fechaRenta);
    }

    private String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    private void setId(String id) {
        this.id.set(id);
    }

    private String getAutoRenta() {
        return autoRenta.get();
    }

    public SimpleStringProperty autoRentaProperty() {
        return autoRenta;
    }

    private void setAutoRenta(String autoRenta) {
        this.autoRenta.set(autoRenta);
    }
}
