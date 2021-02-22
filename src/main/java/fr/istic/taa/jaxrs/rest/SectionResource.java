package fr.istic.taa.jaxrs.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.specific.SectiondDao;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Path("/section")
@Produces({"application/json", "application/xml"})
public class SectionResource {

  private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
  private EntityManager manager = factory.createEntityManager();

  private SectiondDao sectiondDao = new SectiondDao(manager);
  @GET
  @Path("/{sectionId}")
  public Section getSectionById(@PathParam("sectionId") Long petId)  {
      // return pet
      return sectiondDao.findOne(petId);
  }

  @GET
  @Path("")
  public List<Section> getSections(){

    // return list of pets
    return sectiondDao.findAll();
  }

  @POST
  @Consumes("application/json")
  public Response addSection(
      @Parameter(description = "Pet object that needs to be added to the store", required = true) Section section) {
    // add section
    sectiondDao.save(section);
    return Response.ok().entity("SUCCESS").build();
  }
}