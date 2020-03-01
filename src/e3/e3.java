package e3;

import animatefx.animation.FadeInLeft;
import animatefx.animation.FadeOutLeft;
import animatefx.animation.Shake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class e3 implements Initializable {
    /**
     * LOGIN TODO LOGIC
     */
    @FXML private ComboBox<String> cbAlumnos = new ComboBox<String>();
    private ObservableList<Alumno> listAlumnos = FXCollections.observableArrayList();
    private ObservableList<String> listAlumnosNombres = FXCollections.observableArrayList();
    private Integer indexAlumnoSeleccionado=0;
    @FXML private Button btnIniciarSesion;
    @FXML private Pane paneLogin;

    /**
     * MATERIAS A INSCRIBIR TODO LOGIC
     */
    @FXML private TableView<materiasAinscribir> tableMateriasAinscribir = new TableView<materiasAinscribir>();
    @FXML private TableColumn<materiasAinscribir,String> tcId1 = new TableColumn<materiasAinscribir,String>();
    @FXML private TableColumn<materiasAinscribir,String> tcMateria1 = new TableColumn<materiasAinscribir,String>();
    @FXML private TableColumn<materiasAinscribir,String> tcDia1 = new TableColumn<materiasAinscribir,String>();
    @FXML private TableColumn<materiasAinscribir,String> tcHorario1 = new TableColumn<materiasAinscribir,String>();

    @FXML private TableView<materiasAinscribir> tableMateriasInscritas = new TableView<materiasAinscribir>();
    @FXML private TableColumn<materiasAinscribir,String> tcId2 = new TableColumn<materiasAinscribir,String>();
    @FXML private TableColumn<materiasAinscribir,String> tcMateria2 = new TableColumn<materiasAinscribir,String>();
    @FXML private TableColumn<materiasAinscribir,String> tcDia2 = new TableColumn<materiasAinscribir,String>();
    @FXML private TableColumn<materiasAinscribir,String> tcHorario2 = new TableColumn<materiasAinscribir,String>();

    private Integer materiaSeleccionadaAinscribir = -1;
    private Integer getMateriaSeleccionadaEliminar = -1;
    public ObservableList<materiasAinscribir> listMateriasAinscribr = FXCollections.observableArrayList();
    public ObservableList<materiasAinscribir> listMateriasInscritas = FXCollections.observableArrayList();
    public ObservableList<ObservableList[]> tablasAlumnos = FXCollections.observableArrayList();

    /**
     * TODO LOGIC ANYTHING ELSE
     */
    @FXML private Button btnSalir;
    @FXML private Button btnEliminarMateria;
    void setTables(){
        this.tcId1.setCellValueFactory(id->id.getValue().idProperty());
        this.tcMateria1.setCellValueFactory(materia->materia.getValue().materiaProperty());
        this.tcDia1.setCellValueFactory(dia->dia.getValue().diaProperty());
        this.tcHorario1.setCellValueFactory(horario->horario.getValue().horariosProperty());
        this.tableMateriasAinscribir.setItems(this.getMaterias(this.indexAlumnoSeleccionado)[0]);
        this.tcId2.setCellValueFactory(id->id.getValue().idProperty());
        this.tcMateria2.setCellValueFactory(materia->materia.getValue().materiaProperty());
        this.tcDia2.setCellValueFactory(dia->dia.getValue().diaProperty());
        this.tcHorario2.setCellValueFactory(horario->horario.getValue().horariosProperty());
        this.tableMateriasInscritas.setItems(this.getMaterias(this.indexAlumnoSeleccionado)[1]);
    }

    ObservableList[] getMaterias(Integer indexAlumno){
        return this.tablasAlumnos.get(indexAlumno);
    }

    /**
     * BOTONES TODO LOGIC
     */
    @FXML private Button btnAgregarMateria;

    @FXML
    void agregarMateria(){
            if(this.materiaSeleccionadaAinscribir>-1){
                materiasAinscribir materia = this.listMateriasAinscribr.get(this.materiaSeleccionadaAinscribir);
                this.tablasAlumnos.get(this.indexAlumnoSeleccionado)[1].add(materia);
                this.tablasAlumnos.get(this.indexAlumnoSeleccionado)[0].remove(this.tablasAlumnos.get(this.indexAlumnoSeleccionado)[0].get(this.materiaSeleccionadaAinscribir));
                this.materiaSeleccionadaAinscribir =-1;
                this.btnAgregarMateria.setDisable(true);
            }
    }
    @FXML
    void eliminarMateria(){
        if(this.getMateriaSeleccionadaEliminar>-1){

            this.tablasAlumnos.get(this.indexAlumnoSeleccionado)[0].add(this.tablasAlumnos.get(this.indexAlumnoSeleccionado)[1].get(this.getMateriaSeleccionadaEliminar));
            this.tablasAlumnos.get(this.indexAlumnoSeleccionado)[1].remove(this.tablasAlumnos.get(this.indexAlumnoSeleccionado)[1].get(this.getMateriaSeleccionadaEliminar));
            this.getMateriaSeleccionadaEliminar =-1;
            this.btnEliminarMateria.setDisable(true);

        }
    }
    @FXML
    void SelectMateriaFromTablaMateriasInscritas(){
        try {
            this.getMateriaSeleccionadaEliminar =this.tableMateriasInscritas.getSelectionModel().getSelectedIndex();
            System.out.println(this.getMateriaSeleccionadaEliminar);
            this.btnEliminarMateria.setDisable(false);
        }catch (Exception e){

        }
    }

    @FXML
    void SelectMateriaFromTablaMateriasAinscribir(){

        try {
            this.materiaSeleccionadaAinscribir =this.tableMateriasAinscribir.getSelectionModel().getSelectedIndex();
            this.btnAgregarMateria.setDisable(false);
        }catch (Exception e){

        }
    }

    void setAll(){

        this.listMateriasAinscribr.addAll(
                new materiasAinscribir(0,"Teologia","LUNES","02:00 pm - 3:30 pm"),
                new materiasAinscribir(1,"Estadistiscas","MARTES","03:30 pm - 4:45 pm"),
                new materiasAinscribir(2,"Programacion Orientada a Objetos","MIERCOLES","04:45 pm - 5:15 pm"),
                new materiasAinscribir(3,"Matematica #2","JUEVES","04:45 pm - 5:15 pm"),
                new materiasAinscribir(4,"Metodos de Investigación","VIERNES","03:00 pm - 4:30 pm")
        );

        this.listAlumnos.setAll(
                new Alumno("Clarissa",0),
                new Alumno("Fernando",1),
                new Alumno("Monica",2),
                new Alumno("Ramiro",3),
                new Alumno("Nicolle",4),
                new Alumno("Daniela",5)

        );
        this.listAlumnos.forEach(alumno -> {
            this.listAlumnosNombres.add(alumno.name);
            ObservableList<materiasAinscribir> materias = FXCollections.observableArrayList();
            ObservableList<materiasAinscribir> materiasAinscribirAlum = FXCollections.observableArrayList();
            materiasAinscribirAlum.addAll(
                    new materiasAinscribir(0,"Teologia","LUNES","02:00 pm - 3:30 pm"),
                    new materiasAinscribir(1,"Estadistiscas","MARTES","03:30 pm - 4:45 pm"),
                    new materiasAinscribir(2,"Programacion Orientada a Objetos","MIERCOLES","04:45 pm - 5:15 pm"),
                    new materiasAinscribir(3,"Matematica #2","JUEVES","04:45 pm - 5:15 pm"),
                    new materiasAinscribir(4,"Metodos de Investigación","VIERNES","03:00 pm - 4:30 pm")
            );
            ObservableList[] materiass = {materiasAinscribirAlum,materias};
            this.tablasAlumnos.add(materiass);
        });
        this.cbAlumnos.setItems(this.listAlumnosNombres);
    }
    @FXML
    void IniciarSesion(){
        this.indexAlumnoSeleccionado = this.cbAlumnos.getSelectionModel().getSelectedIndex(); // se toma el index del alumno tomado
        System.out.println(this.indexAlumnoSeleccionado);
        if(this.indexAlumnoSeleccionado>-1){
            this.tableMateriasAinscribir.setItems(this.getMaterias(this.indexAlumnoSeleccionado)[0]);
            this.tableMateriasInscritas.setItems(this.getMaterias(this.indexAlumnoSeleccionado)[1]);
            new FadeOutLeft(this.paneLogin).play();
        }else{
            new Shake(this.cbAlumnos).play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btnAgregarMateria.setDisable(true);
        this.btnEliminarMateria.setDisable(true);
        this.setAll();
        this.setTables();
    }

    @FXML
    void salir(){
        new FadeInLeft(this.paneLogin).play();
    }
}
