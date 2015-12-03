
package br.ifsul.edu.controle;



import br.ifsul.edu.dao.UsuarioDao;
import br.ifsul.edu.dao.EstadoDao;
import br.ifsul.edu.model.Usuario;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleUsuario")
@ViewScoped
public class ControleUsuario implements Serializable{
    
    private UsuarioDao dao;
    private Usuario objeto;
    
    public ControleUsuario(){
        dao = new UsuarioDao();
    }
    
    public String listar(){
        return "/privado/usuario/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Usuario();
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persistir(objeto);
            }else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
        } catch (Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }
    
    public void editar(Integer id){
        try {
            objeto = dao.getObjectById(id);
        } catch(Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }
    
    public void remover(Integer id){
        try {
            dao.remover(id);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro(e.getMessage());
        }
    }

    public UsuarioDao getDao() {
        return dao;
    }

    public void setDao(UsuarioDao dao) {
        this.dao = dao;
    }

    public Usuario getObjeto() {
        return objeto;
    }

    public void setObjeto(Usuario objeto) {
        this.objeto = objeto;
    }
}
