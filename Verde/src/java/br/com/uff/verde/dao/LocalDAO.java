package br.com.uff.verde.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.uff.verde.model.Local;

/**
 *
 * @author Felipe Vila Chã
 */
public class LocalDAO {
    public ManagerDAO manager = new ManagerDAO();
    public EntityManager managerInstance = manager.criaManager();
    
    public boolean insereLocal(Local local){
        boolean inseriu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.persist(local);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex){
            managerInstance.getTransaction().rollback();
            inseriu = false;
        }
        
        return inseriu;
    }
    
    public Local getLocalById(final int id) {
        managerInstance.getTransaction().begin();
        Local local = managerInstance.find(Local.class, id);
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return local;
    }
    
    public List<Local> getLocals(){
        managerInstance.getTransaction().begin();
        List<Local> localsEncontrados = managerInstance.createNamedQuery("Local.findAll").getResultList();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return localsEncontrados;
    }
    
    public boolean removeLocal(int id){
        boolean removeu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.remove(managerInstance.getReference(Local.class, id));
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            removeu = false;
        }
        
        return removeu;
    }
    
    public boolean updateLocal(Local local){
        boolean atualizou = true;
        
        try {
            managerInstance.getTransaction().begin();        
            managerInstance.merge(local);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            atualizou = false;
        }
        
        return atualizou;
    }
}
