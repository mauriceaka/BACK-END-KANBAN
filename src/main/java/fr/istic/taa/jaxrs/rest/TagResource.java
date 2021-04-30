package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.RestServer;
import fr.istic.taa.jaxrs.dao.specific.TagDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/tags")
@Produces({"application/json", "application/xml"})
public class TagResource {

    private final TagDao tagDao = new TagDao();
    private static final Logger logger = Logger.getLogger(RestServer.class.getName());

    @GET
    @Path("/{tagId}")
    public Tag getTagById(@PathParam("tagId") Long tagId)  {
        // return tag
        return tagDao.findOne(tagId);
    }

    @GET
    @Path("")
    public List<Tag> getTags(){
        // return list of tags
        return tagDao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response addTag(
            @Parameter(description = "Tag object that needs to be added to the store", required = true) Tag tag) {
        // add tag
        tagDao.save(tag);
        return Response.ok().entity("SUCCESS").build();
    }

    @PUT
    @Consumes("application/json")
    public Response editTag(
            @Parameter(description = "Tag object that needs to be edited to the store", required = true) Tag tag) {
        // edit tag
        Tag newTag = getTagById(tag.getId());
        newTag.setLibelle(tag.getLibelle());
        tagDao.update(newTag);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{tagId}")
    public Response deleteTagById(@PathParam("tagId") Long tagId){
        //return tag
        tagDao.deleteById(tagId);
        return Response.ok().entity("DELETE SUCCESSFULLY").build();
    }


}
