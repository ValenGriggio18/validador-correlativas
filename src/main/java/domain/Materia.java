package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Materia {

    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private String codigo;
    @Getter
    List<Materia> correlativas;

    public Materia(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativas(Materia...materias){
        Collections.addAll(this.correlativas,materias);
    }
}
