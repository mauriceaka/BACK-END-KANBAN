package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.specific.UserDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tag;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/users")
@Produces({"application/json", "application/xml"} )
public class UserResource {
    private final UserDao userDao = new UserDao();

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId")Long userId){
        return userDao.findOne(userId);
    }
    @GET
    @Path("")
    public List<User> getUsers(){

        // return list of pets
        return userDao.findAll();
    }
    @POST
    @Consumes("application/json")
    public Response addUser(
            @Parameter(description = "User object that needs to be added to the store", required = true) User user) {
        // add tag
        userDao.save(user);
        return Response.ok().entity("SUCCESS").build();
    }
    @PUT
    @Consumes("application/json")
    public Response editUser(
            @Parameter(description = "User object that needs to be edited to the store", required = true) User user) {
        // edit user
        User newUser = getUserById(user.getId());
        newUser.setNom(user.getNom());
        newUser.setFiche(user.getFiche());
        newUser.setProfession(user.getProfession());
        newUser.setEmail(user.getEmail());
        userDao.update(newUser);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUserById(@PathParam("userId") Long userId){
        //return user

        userDao.deleteById(userId);
        return Response.ok().entity("DELETE SUCCESSFULLY").build();
    }
}
