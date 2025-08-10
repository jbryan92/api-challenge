package foro.hub.api.domain.topico;

public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        String curso
) {
    public DatosListaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCurso());
    }
}
