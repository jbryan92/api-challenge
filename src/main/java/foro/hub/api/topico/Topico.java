package foro.hub.api.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean activo;
    private String titulo;
    private String mensaje;
    private String curso;

    public Topico(DatosRegistroTopico datos) {
        this.id = null;
        this.activo = true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.curso = datos.curso();
    }

    public void actualizarIformaciones(@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if(datos.curso() != null){
            this.curso = datos.curso();
        }
    }

    public void eliminar() {
        this.activo = false;
    }
}
