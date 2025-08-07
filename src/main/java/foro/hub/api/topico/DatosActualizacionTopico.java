package foro.hub.api.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String curso
) {
}
