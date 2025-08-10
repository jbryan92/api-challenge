package foro.hub.api.controller;

import foro.hub.api.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void register(@RequestBody @Valid DatosRegistroTopico datos){
      repository.save(new Topico(datos));
    }

    @GetMapping
    public Page<DatosListaTopico> listar(@PageableDefault(size=10, sort={"curso"}) Pageable paginacion){
        return repository.findAllByActivoTrue(paginacion).map(DatosListaTopico::new);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionTopico datos){
        var topico = repository.getReferenceById(datos.id());
        topico.actualizarIformaciones(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
       var topico = repository.getReferenceById(id);
       topico.eliminar();
    }

    @GetMapping("/{id}")
    public List<DatosListaTopico> detallar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        return repository.findAll().stream().map(DatosListaTopico::new).toList();
    }


}
