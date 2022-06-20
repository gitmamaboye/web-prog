package rest;
        //.jsp.JspControlller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import models.Person;
import org.glassfish.jersey.server.mvc.Template;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("jsp")
public class JspControlller {
    JAXBContext jaxbContext;
    models.Persons persons;

    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("EWord");
        Map<String, String> model = new HashMap<>();
        model.put("hello", "Hello");
        model.put("world", "World");
        return new Viewable("/index", model);
    }
    @GET
    @Produces("text/html")
    @Path("/all")
    @Template(name="/getall")
    public List<Person> getPeronObject(){
        File xmlFile = new File("/tmp/persons.xml");

        try {
            jaxbContext = JAXBContext.newInstance(models.Persons.class);
            Unmarshaller jaxbUnmarshaller;
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            persons = (models.Persons) jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return persons.getPerson();
    }


    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/getName")
    @Template(name="/fname")
    public List<Person> getSingleName(@DefaultValue("") @QueryParam("fname") String name){
        //String name = "Pu";
        ArrayList<Person> singlePerson = new ArrayList<>();
        for(Person p : getPeronObject()){
            if(p.getFirstname().equals(name))
                singlePerson.add(p);
        }
        return  singlePerson;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/resnames")
    @Template(name="/resNames")
    public List<String> getSingleNameResidence(@DefaultValue("") @QueryParam("res") String res){
        ArrayList<String> personNames = new ArrayList<>();
        for(Person p : getPeronObject()){
            if(p.getResidence() != null && p.getResidence().equals(res))
                personNames.add(p.getFirstname());
        }
        return  personNames;
    }

    @GET
    @Produces("text/html")
    @Path("/fnames")
    @Template(name ="/fnames")
    public ArrayList<String> getFnames() {
        ArrayList<String> fNames = new ArrayList<>();
        for (Person p : getPeronObject()) {
            if (p.getFirstname() != null)
                fNames.add(p.getFirstname());
        }
        return fNames;
    }
}
