package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.specific.SectiondDao;
import fr.istic.taa.jaxrs.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sections")
@Produces({"application/json", "application/xml"})
public class SectionResource {

  private final SectiondDao sectiondDao = new SectiondDao();

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