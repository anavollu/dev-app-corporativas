package br.com.uff.verde.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.uff.verde.model.Denuncia;

/**
 *
 * @author Felipe Vila Chã
 */
public class DenunciaDAO {
    public ManagerDAO manager = new ManagerDAO();
    public EntityManager managerInstance = manager.criaManager();
    
    public boolean insereDenuncia(Denuncia denuncia){
        boolean inseriu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.persist(denuncia);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex){
            managerInstance.getTransaction().rollback();
            inseriu = false;
        }
        
        return inseriu;
    }
    
    public Denuncia getDenunciaById(final int id) {
        managerInstance.getTransaction().begin();
        Denuncia denuncia = managerInstance.find(Denuncia.class, id);
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return denuncia;
    }
    
    public List<Denuncia> getDenuncias(){
        managerInstance.getTransaction().begin();
        List<Denuncia> denunciasEncontrados = managerInstance.createNamedQuery("Denuncia.findAll").getResultList();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return denunciasEncontrados;
    }
    
    public boolean removeDenuncia(int id){
        boolean removeu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.remove(managerInstance.getReference(Denuncia.class, id));
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            removeu = false;
        }
        
        return removeu;
    }
    
    public boolean updateDenuncia(Denuncia denuncia){
        boolean atualizou = true;
        
        try {
            managerInstance.getTransaction().begin();        
            managerInstance.merge(denuncia);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            atualizou = false;
        }
        
        return atualizou;
    }
}
