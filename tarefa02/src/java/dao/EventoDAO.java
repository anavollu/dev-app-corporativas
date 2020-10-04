package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Evento;

/**
 *
 * @author Felipe Vila Chã
 */
public class EventoDAO {
    public ManagerDAO manager = new ManagerDAO();
    public EntityManager managerInstance = manager.criaManager();
    
    public boolean insereEvento(Evento usuario){
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
    
    public Evento getEventoById(final int id) {
        managerInstance.getTransaction().begin();
        Evento evento = managerInstance.find(Evento.class, id);
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return evento;
    }
    
    public Evento getEventoByNome(String nome) {
        managerInstance.getTransaction().begin();
        Evento evento = (Evento) managerInstance.createNamedQuery("Evento.findByNome").setParameter("nome", nome).getSingleResult();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return evento;
    }
    
    public List<Evento> getEventos(){
        managerInstance.getTransaction().begin();
        List<Evento> eventosEncontrados = managerInstance.createNamedQuery("Evento.findAll").getResultList();
        managerInstance.getTransaction().commit();
        manager.fechaConexao(managerInstance);
        
        return eventosEncontrados;
    }
    
    public boolean removeEvento(int id){
        boolean removeu = true;
        try {
            managerInstance.getTransaction().begin();
            managerInstance.remove(managerInstance.getReference(Evento.class, id));
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            removeu = false;
        }
        
        return removeu;
    }
    
    public boolean updateEvento(Evento evento){
        boolean atualizou = true;
        
        try {
            managerInstance.getTransaction().begin();        
            managerInstance.merge(evento);
            managerInstance.getTransaction().commit();
            manager.fechaConexao(managerInstance);
        } catch (Exception ex) {
            managerInstance.getTransaction().rollback();
            atualizou = false;
        }
        
        return atualizou;
    }
}
