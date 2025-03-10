package br.gov.sp.fatec.springboot3app2025;

// import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app2025.entity.Usuario;
import br.gov.sp.fatec.springboot3app2025.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    @Transactional
    public Usuario novo(Usuario usuario){

        if(usuario == null || 
        usuario.getNome() == null ||
         usuario.getNome().isBlank() ||
         usuario.getSenha() == null ||
          usuario.getSenha().isBlank()) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Inválidos");
           
         }
         return repo.save(usuario);
    }


    public Usuario buscarPorId(Long idUsuario){

        Optional<Usuario> usuarioOp = repo.findById(idUsuario);
        if (usuarioOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        return usuarioOp.get();

    }

}
