package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Edicao;
import model.Evento;

/**
 *
 * @author Felipe Vila Chã
 */
public class EdicaoDAO {
    public ManagerDAO manager = new ManagerDAO();
    public EntityManager managerInstance = manager.criaManager();
    
    public boolean insereEdicao(Edicao edicao){
        boolean inseriu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.persist(edicao);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            inseriu = false;
        }
        return inseriu;
    }
    
    public Edicao getEdicaoById(final int id) {
        return managerInstance.find(Edicao.class, id);
    }
    
    public List<Edicao> getEdicoes(){
        managerInstance.getTransaction().begin();
        List<Edicao> edicoesEncontradas = managerInstance.createNamedQuery("Edicao.findAll").getResultList();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return edicoesEncontradas;
    }
    
    public List<Edicao> getEdicoesDeEvento(Evento evento){
        managerInstance.getTransaction().begin();
        List<Edicao> edicoesEncontradas = managerInstance.createNamedQuery("Edicao.findByEvento").setParameter("evento", evento).getResultList();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return edicoesEncontradas;
    }
    
    public boolean removeEdicao(int id){
        boolean removeu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.remove(managerInstance.getReference(Edicao.class, id));
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            removeu = false;
        }
        return removeu;
    }
    
    public boolean updateEdicao(Edicao edicao){
        boolean atualizou = true;
        
        try {
            managerInstance.getTransaction().begin();        
            managerInstance.merge(edicao);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            atualizou = false;
        }
        
        return atualizou;
    }
}
