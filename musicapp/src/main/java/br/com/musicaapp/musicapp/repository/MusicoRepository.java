package br.com.musicaapp.musicapp.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.musicaapp.musicapp.domain.Musico;

@Repository
public class MusicoRepository {
    private JdbcTemplate conexaoBanco;

    public MusicoRepository(JdbcTemplate conexaoBanco){
        this.conexaoBanco = conexaoBanco;
    }

    public List<Musico> listagem(){
        String sql = """
                    select cod_musico as idMusico,
                           nome_musico as nomeMusico,
                           genero as genero
                    from musico;
                """;
        return conexaoBanco.query(sql, new BeanPropertyRowMapper<>(Musico.class));
    }

    public void novoCadastro(Musico musico){
        String sql = """
                    insert into musico(nome_musico, genero)
                    values(?);
                """;
        conexaoBanco.update(sql, musico.getNomeMusico());
    }
    public void  atualizacao(Musico musico){
        String sql = """
                    update musico
                    set nome_musico = ?, genero = ?
                    where cod_musico = ?;
                """;
        conexaoBanco.update(sql, musico.getIdMusico(), musico.getNomeMusico());
    }
    
    public void deletar(Musico musico){
        String sql = """
                    delete
                    from musico
                    where cod_musico = ?;
                """;
        conexaoBanco.update(sql, musico.getIdMusico());
    }
    public Musico listagemPorId(Musico musico){
        String sql = """
                    select cod_musico as idMusico,
                           nome_musico as nomeMusico,
                           genero as genero
                    from musico
                    where cod_musico = ?;
                """;
        return conexaoBanco.queryForObject(sql, new BeanPropertyRowMapper<>(Musico.class),
                                           musico.getIdMusico());
    }
}
