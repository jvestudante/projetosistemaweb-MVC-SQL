package br.com.musicaapp.musicapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.musicaapp.musicapp.domain.Usuario;
import br.com.musicaapp.musicapp.repository.UsuarioRepository;


@Controller
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }   

    @GetMapping("/cliente/lista")
    public String listar(Model model) {
        List<Usuario> usuarios = usuarioRepository.listagem(); 
        model.addAttribute("clientes", usuarios);
        return "clientes/listagem";
    }

    @GetMapping("/clientes/novo")
    public String novo(Model model) {
        model.addAttribute("cliente",new Usuario());
        return "cliente/formulario";
    }

    @PostMapping("/clientes/novo")
    public String novoCadastro(@ModelAttribute Usuario usuario,Model model) {
        if (usuario.getIdUsuario() == null) {
            usuarioRepository.novoCadastro(usuario);
        } else {
            usuarioRepository.atualizacao(usuario);
        }
        return listar(model);
    }

    @PostMapping("/clientes/excluir/{codigo}")
    public String deletar(@PathVariable("codigo") Integer idUsuario, Model model) {
    Usuario usuario = usuarioRepository.listagemPorId(new Usuario(idUsuario));
    usuarioRepository.deletar(usuario);
    model.addAttribute("mensagem", "Deletado");
    return listar(model);
    }

    
    @GetMapping("/clientes/editar/{codigo}")
    public String atualizacao(@PathVariable("codigo") Integer idUsuario, Model model) {
    Usuario usuario = usuarioRepository.listagemPorId(new Usuario(idUsuario));
    model.addAttribute("cliente", usuario);
    return "cliente/formulario";
    }


    @GetMapping("/clientes/buscar")
    public String listagemPorNome(@RequestParam("nome") String nomeUsuario,Model model) {
        List<Usuario> usuarios = usuarioRepository.listagemPorNome(nomeUsuario);
        if (usuarios.isEmpty()) {
            model.addAttribute("mensagem", 
                                  "Não tem clientes para o nome informado: "+nomeUsuario);    
        }
        model.addAttribute("clientes",usuarios);
        return "cliente/lista";
    }

    
}
