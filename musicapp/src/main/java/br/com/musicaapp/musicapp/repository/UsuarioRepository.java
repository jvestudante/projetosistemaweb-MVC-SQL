package br.com.musicaapp.musicapp.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.musicaapp.musicapp.domain.Usuario;

@Repository
public class UsuarioRepository {

    private JdbcTemplate conexaoBanco;

    public UsuarioRepository(JdbcTemplate conexaoBanco){
        this.conexaoBanco = conexaoBanco;
    }

    public List<Usuario> listagem(){
        String sql = """
                select cod_usuario as idUsuario,
                       nome_usuario as nomeUsuario,
                       dt_nasc as dtNascimento,
                       email as email,
                       senha as senha
                from usuario;
                """;
        return conexaoBanco.query(sql, new BeanPropertyRowMapper<>(Usuario.class));
    }
    public void novoCadastro(Usuario usuario) {
        String sql = """
                    insert into usuario(nome_usuario, dt_nasc, email, senha)
                    values(?, ?, ?, ?)
                    """;
        conexaoBanco.update(sql, usuario.getNomeUsuario(), usuario.getDtNascimento(),
        usuario.getEmail(), usuario.getSenha());

    }
    public void atualizacao(Usuario usuario){
        String sql = """
                    update usuario
                    set nome_usuario = ?, dt_nasc = ?, email = ?, senha = ?
                    where cod_usuario = ?;
                """;
        conexaoBanco.update(sql, usuario.getNomeUsuario(), usuario.getIdUsuario());
    }
    public void deletar(Usuario usuario){
        String sql = """
                    delete
                    from usuario
                    where cod_usuario = ?;
                """;
        conexaoBanco.update(sql, usuario.getIdUsuario());
    }
    public Usuario listagemPorId(Usuario usuario){
        String sql = """
                    select cod_usuario as idUsuario,
                       nome_usuario as nomeUsuario,
                       dt_nasc as dtNascimento,
                       email as email,
                       senha as senha
                    from usuario
                    where cod_usuario = ?;
                """;
        return conexaoBanco.queryForObject(sql, new BeanPropertyRowMapper<>(Usuario.class),
                                           usuario.getIdUsuario());
    }
    public List<Usuario> listagemPorNome(String nomeUsuario) {
        String sql = """
                    select cod_usuario as idUsuario,
                           nome_usuario as nomeUsuario,
                           dt_nasc as dtNascimento,
                           email as email,
                           senha as senha
                    from usuario
                    where lower(nome_usuario) like ?;
                """;
        return conexaoBanco.query(sql, new BeanPropertyRowMapper<>(Usuario.class), "%" + nomeUsuario.toLowerCase() + "%");
    }    
}
