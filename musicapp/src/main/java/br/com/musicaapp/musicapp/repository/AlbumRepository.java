package br.com.musicaapp.musicapp.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.musicaapp.musicapp.domain.Album;
import br.com.musicaapp.musicapp.domain.Musico;

@Repository
public class AlbumRepository {
    
    private JdbcTemplate conexaoBanco;

    public AlbumRepository(JdbcTemplate conexaoBanco){
        this.conexaoBanco = conexaoBanco;
    }

    public List<Album> listagem(){
        String sql = """
                    select a.cod_album,
                           a.nome_album,
                           a.dt_lanc,
                           a.editora,
                           a.descricao,
                           a.cod_musico,
                           m.nome_musico,   
                           m.genero
                    from album a, musico m;
                    where a.cod_musico = m.cod_musico
                    and lower (nome_album) like ?;
                """;
        return conexaoBanco.query(sql, (rs, rowNum) -> {
            Album album = new Album();
            album.setIdAlbum(rs.getInt("cod_album"));
            album.setNomeAlbum(rs.getString("nome_album"));
            album.setDtLancamento(rs.getDate("dt_lanc"));
            album.setEditora(rs.getString("editora"));
            album.setDescricao(rs.getString("descricao"));

            Musico musico = new Musico();
            musico.setIdMusico(rs.getInt("cod_musico"));
            musico.setNomeMusico(rs.getString("nome_musico"));
            musico.setGenero(rs.getString("genero"));

            album.setMusico(musico);
            return album;
        }
        );
    }
    public void novoCadastro(Album album){
        String sql = """
                    insert into album(nome_album, dt_lanc, editora, descricao, cod_musico)
                    values(?,?,?,?,?);
                """;
        conexaoBanco.update(sql, album.getNomeAlbum(), album.getDtLancamento(), album.getEditora(),
                            album.getDescricao(), album.getMusico().getIdMusico());
    }
    public void atualizacao(Album album){
        String sql = """
                    update album
                    set nome_album = ?, dt_lanc = ?, editora = ?, descricao = ?, cod_musico = ?
                    where cod_album = ?;
                """;
        conexaoBanco.update(sql, album.getIdAlbum(), album.getNomeAlbum(), album.getDtLancamento(),
                            album.getEditora(), album.getDescricao(), album.getMusico().getIdMusico());
    }
    public void deletar(Album album){
        String sql = """
                    delete
                    from album
                    where cod_album = ?;
                """;
        conexaoBanco.update(sql, album.getIdAlbum());
    }
    public Album listagemPorId(Album album){
        String sql = """
                    select a.cod_album,
                           a.nome_album,
                           a.dt_lanc,
                           a.editora,
                           a.descricao,
                           a.cod_musico,
                           m.nome_musico,
                           m.genero
                    from album a, musico m;
                    where a.cod_musico = m.cod_musico
                    and cod_album = ?;
                """;
                return conexaoBanco.queryForObject(sql, (rs, rowNum) -> {
                    Album albumRes = new Album();
                    albumRes.setIdAlbum(rs.getInt("cod_album"));
                    albumRes.setNomeAlbum(rs.getString("nome_album"));
                    albumRes.setDtLancamento(rs.getDate("dt_lanc"));
                    albumRes.setEditora(rs.getString("editora"));
                    albumRes.setDescricao(rs.getString("descricao"));
        
                    Musico musico = new Musico();
                    musico.setIdMusico(rs.getInt("cod_musico"));
                    musico.setNomeMusico(rs.getString("nome_musico"));
                    musico.setGenero(rs.getString("genero"));
        
                    album.setMusico(musico);
                    return albumRes;
                }, album.getIdAlbum());
    }

    public Album listagemPorNome(Album album){
        String sql = """
                    select a.cod_album,
                           a.nome_album,
                           a.dt_lanc,
                           a.editora,
                           a.descricao,
                           a.cod_musico,
                           m.nome_musico,
                           m.genero
                    from album a, musico m;
                    where a.cod_musico = m.cod_musico
                    and lower(nome_album) like ?;
                """;
                return conexaoBanco.queryForObject(sql, (rs, rowNum) -> {
                    Album albumRes = new Album();
                    albumRes.setIdAlbum(rs.getInt("cod_album"));
                    albumRes.setNomeAlbum(rs.getString("nome_album"));
                    albumRes.setDtLancamento(rs.getDate("dt_lanc"));
                    albumRes.setEditora(rs.getString("editora"));
                    albumRes.setDescricao(rs.getString("descricao"));
        
                    Musico musico = new Musico();
                    musico.setIdMusico(rs.getInt("cod_musico"));
                    musico.setNomeMusico(rs.getString("nome_musico"));
                    musico.setGenero(rs.getString("genero"));
        
                    album.setMusico(musico);
                    return albumRes;
                }, "%"+album.getNomeAlbum().toLowerCase()+"%");
    }
}
