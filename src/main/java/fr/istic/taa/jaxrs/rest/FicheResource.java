package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.specific.FicheDao;
import fr.istic.taa.jaxrs.dao.specific.SectiondDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fiches")
@Produces({"application/json", "application/xml"})
public class FicheResource {

    private final FicheDao ficheDao = new FicheDao();

    @GET
    @Path("/{ficheId}")
    public Fiche getSectionById(@PathParam("ficheId") Long ficheId)  {
        // return fiche
        return ficheDao.findOne(ficheId);
    }

    @GET
    @Path("")
    public List<Fiche> getFiches(){

        // return list of fiches
        return ficheDao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response addFiche(
            @Parameter(description = "Fiche object that needs to be added to the store", required = true) Fiche fiche) {
        // add fiche
        ficheDao.save(fiche);
        return Response.ok().entity("SUCCESS").build();
    }

    @PUT
    @Consumes("application/json")
    public Response editFiche(
            @Parameter(description = "Fiche object that needs to be edited to the store", required = true) Fiche fiche) {
        // edit fiche
        ficheDao.save(fiche);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{ficheId}")
    public Response deleteSectionById(@PathParam("ficheId") Long ficheId)  {
        // return fiche
        ficheDao.deleteById(ficheId);
        return Response.ok().entity("DELETE SUCCESSFUL").build();
    }
}
