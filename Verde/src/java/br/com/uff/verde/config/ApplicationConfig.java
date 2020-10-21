package br.com.uff.verde.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Felipe Vila Chã
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.uff.verde.service.DenunciaService.class);
        resources.add(br.com.uff.verde.service.DoacoesService.class);
        resources.add(br.com.uff.verde.service.UsuarioService.class);
    }
    
}
