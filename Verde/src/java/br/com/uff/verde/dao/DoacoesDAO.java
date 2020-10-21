package br.com.uff.verde.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.uff.verde.model.Doacoes;

/**
 *
 * @author Felipe Vila Chã
 */
public class DoacoesDAO {
    public ManagerDAO manager = new ManagerDAO();
    public EntityManager managerInstance = manager.criaManager();
    
    public boolean insereDoacoes(Doacoes doacoes){
        boolean inseriu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.persist(doacoes);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex){
            managerInstance.getTransaction().rollback();
            inseriu = false;
        }
        
        return inseriu;
    }
    
    public Doacoes getDoacoesById(final int id) {
        managerInstance.getTransaction().begin();
        Doacoes doacoes = managerInstance.find(Doacoes.class, id);
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return doacoes;
    }
    
    public List<Doacoes> getDoacoes(){
        managerInstance.getTransaction().begin();
        List<Doacoes> doacoessEncontrados = managerInstance.createNamedQuery("Doacoes.findAll").getResultList();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return doacoessEncontrados;
    }
    
    public boolean removeDoacoes(int id){
        boolean removeu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.remove(managerInstance.getReference(Doacoes.class, id));
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            removeu = false;
        }
        
        return removeu;
    }
    
    public boolean updateDoacoes(Doacoes doacoes){
        boolean atualizou = true;
        
        try {
            managerInstance.getTransaction().begin();        
            managerInstance.merge(doacoes);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            atualizou = false;
        }
        
        return atualizou;
    }
}