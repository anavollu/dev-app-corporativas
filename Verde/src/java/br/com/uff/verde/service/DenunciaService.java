package br.com.uff.verde.service;

import br.com.uff.verde.dao.DenunciaDAO;
import br.com.uff.verde.model.Denuncia;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
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

@Path("denuncia")
public class DenunciaService {
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        JsonArray json = Json.createArrayBuilder(new DenunciaDAO().getDenuncias()).build();
        return json.toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Denuncia getById(@PathParam("id") int id) {
        return new DenunciaDAO().getDenunciaById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Denuncia denuncia)
    {
        try{
            new DenunciaDAO().insereDenuncia(denuncia);
            return Response.status(Response.Status.CREATED).entity(denuncia).build();
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
    public Response put(@PathParam("id") int id, Denuncia denuncia)
    {
        Denuncia d = new DenunciaDAO().getDenunciaById(id);
        if(d == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            denuncia.setId(id);
            new DenunciaDAO().updateDenuncia(denuncia);
            return Response.status(Response.Status.OK).entity(denuncia).build();
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
        Denuncia p = new DenunciaDAO().getDenunciaById(id);
        if(p == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        try{
            new DenunciaDAO().removeDenuncia(id);
            return Response.status(Response.Status.OK).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
