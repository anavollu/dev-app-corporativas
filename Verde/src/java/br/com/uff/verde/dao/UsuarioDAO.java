package br.com.uff.verde.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.uff.verde.model.Usuario;

/**
 *
 * @author Felipe Vila Chã
 */
public class UsuarioDAO {
    public ManagerDAO manager = new ManagerDAO();
    public EntityManager managerInstance = manager.criaManager();
    
    public boolean insereUsuario(Usuario usuario){
        boolean inseriu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.persist(usuario);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex){
            managerInstance.getTransaction().rollback();
            inseriu = false;
        }
        
        return inseriu;
    }
    
    public Usuario getUsuarioById(final int id) {
        managerInstance.getTransaction().begin();
        Usuario usuario = managerInstance.find(Usuario.class, id);
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return usuario;
    }
    
    public Usuario getUsuarioByNome(String username) {
        
        Usuario usuario = new Usuario();
        
        try {
            managerInstance.getTransaction().begin();
            usuario = (Usuario) managerInstance.createNamedQuery("Usuario.findByUsername").setParameter("username", username).getSingleResult();
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            usuario = new Usuario();
            usuario.setId(0);
        }
        
        return usuario;
    }
    
    public List<Usuario> getUsuarios(){
        managerInstance.getTransaction().begin();
        List<Usuario> usuariosEncontrados = managerInstance.createNamedQuery("Usuario.findAll").getResultList();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return usuariosEncontrados;
    }
    
    public boolean removeUsuario(int id){
        boolean removeu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.remove(managerInstance.getReference(Usuario.class, id));
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            removeu = false;
        }
        
        return removeu;
    }
    
    public boolean updateUsuario(Usuario usuario){
        boolean atualizou = true;
        
        try {
            managerInstance.getTransaction().begin();        
            managerInstance.merge(usuario);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            atualizou = false;
        }
        
        return atualizou;
    }
}
