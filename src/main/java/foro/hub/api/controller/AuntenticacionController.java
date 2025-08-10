package foro.hub.api.controller;


import foro.hub.api.infra.security.DatosTokenJWT;
import foro.hub.api.infra.security.TokenService;
import foro.hub.api.domain.usuario.DatosAunteticacion;
import foro.hub.api.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuntenticacionController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAunteticacion datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var autentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) autentication.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));

    }
}
