package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InscripcionTest {

    private Alumno valentin;

    private Materia analisisI;
    private Materia fisicaI;
    private Materia analisisII;
    private Materia algebra;
    private Materia fisicaII;
    private Materia matSuperior;


    @BeforeEach
    public void init(){
        valentin = new Alumno();
        valentin.setNombre("Valentin");
        valentin.setApellido("Griggio");

        analisisI = new Materia("Analisis Matematico I", "1000");
        analisisII = new Materia("Analisis Matematico II", "2000");
        fisicaI = new Materia("Fisica I", "2001");
        fisicaII = new Materia("Fisica II", "3000");
        algebra = new Materia("Algebra y Geometria Analitica", "1001");
        matSuperior = new Materia("Matematica Superior", "3001");

        analisisII.agregarCorrelativas(analisisI, algebra);
        matSuperior.agregarCorrelativas(analisisII);
        fisicaII.agregarCorrelativas(fisicaI);
    }

    @Test
    @DisplayName("El alumno cumple con las correlativas para inscribirse a la materia")
    public void aceptarInscripcion(){
        valentin.aprobarMateria(fisicaI);

        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setAlumno(valentin);
        unaInscripcion.anotarse(fisicaII);

        Assertions.assertTrue(unaInscripcion.estaAprobada());
    }
    @Test
    @DisplayName("El alumno no cumple con las correlativas para inscribirse a la materia")
    public void rechazarInscripcion(){
        valentin.aprobarMateria(analisisI,algebra,fisicaII);

        Inscripcion otraInscripcion = new Inscripcion();
        otraInscripcion.setAlumno(valentin);
        otraInscripcion.anotarse(matSuperior);

        Assertions.assertFalse(otraInscripcion.estaAprobada());
    }

}
