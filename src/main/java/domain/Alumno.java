package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Alumno {

    @Setter
    private String nombre;
    @Setter
    private String apellido;

    List<Materia> materiasAprobadas;

    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }

    public void aprobarMateria(Materia...materias){
        Collections.addAll(this.materiasAprobadas, materias);
    }

    public boolean poseeCorrelativas(Materia unaMateria){
        return this.materiasAprobadas.containsAll(unaMateria.correlativas);
    }
}
