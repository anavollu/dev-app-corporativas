package br.com.uff.verde.service;

import br.com.uff.verde.dao.DoacoesDAO;
import br.com.uff.verde.model.Doacoes;
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

@Path("doacoes")
public class DoacoesService {
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doacoes> get() {
        return new DoacoesDAO().getDoacoes();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Doacoes getById(@PathParam("id") int id) {
        return new DoacoesDAO().getDoacoesById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Doacoes doacoes)
    {
        try{
            new DoacoesDAO().insereDoacoes(doacoes);
            return Response.status(Response.Status.CREATED).entity(doacoes).build();
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
    public Response put(@PathParam("id") int id, Doacoes doacoes)
    {
        Doacoes d = new DoacoesDAO().getDoacoesById(id);
        if(d == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            doacoes.setId(id);
            new DoacoesDAO().updateDoacoes(doacoes);
            return Response.status(Response.Status.OK).entity(doacoes).build();
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
        Doacoes p = new DoacoesDAO().getDoacoesById(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            new DoacoesDAO().removeDoacoes(id);
            return Response.status(Response.Status.OK).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
