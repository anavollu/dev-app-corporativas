package br.com.uff.verde.service;

import br.com.uff.verde.dao.UsuarioDAO;
import br.com.uff.verde.model.Usuario;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Felipe Vila Chã
 */

@Path("usuario")
public class UsuarioService {
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> get() {
        return new UsuarioDAO().getUsuarios();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getById(@PathParam("id") int id) {
        return new UsuarioDAO().getUsuarioById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Usuario usuario)
    {
        try{
            new UsuarioDAO().insereUsuario(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, Usuario usuario)
    {
        Usuario d = new UsuarioDAO().getUsuarioById(id);
        if(d == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            usuario.setId(id);
            new UsuarioDAO().updateUsuario(usuario);
            return Response.status(Response.Status.OK).entity(usuario).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id)
    {
        Usuario p = new UsuarioDAO().getUsuarioById(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            new UsuarioDAO().removeUsuario(id);
            return Response.status(Response.Status.OK).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
