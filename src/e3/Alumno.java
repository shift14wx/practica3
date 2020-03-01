package e3;

public class Alumno {

    public String name;
    private Integer id;

    Alumno(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    private String getName() {
        return name;
    }

    private Integer getId() {
        return id;
    }
}
