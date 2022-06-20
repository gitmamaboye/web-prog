package rest;

import jakarta.ws.rs.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import models.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Path("persons")
public class PersonController {
    JAXBContext jaxbContext;
    models.Persons persons;


    @Produces("*/*")
    @Path("all")
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
    @Produces("*/*")
    @Path("fnames")
    public ArrayList<String> getFnames(){
        ArrayList<String> fNames = new ArrayList<>();
        for(Person p : getPeronObject()){
            if( p.getFirstname() != null)
                fNames.add(p.getFirstname());
        }
        return  fNames;
    }

    @GET
    @Produces("*/*")
    @Path("lnames")
    public ArrayList<String> getLnames(){
        ArrayList<String> lNames = new ArrayList<>();
        for(Person p : getPeronObject()){
            if( p.getLastname() != null)
                lNames.add(p.getLastname());
        }
        return lNames;
    }

    @GET
    @Produces("*/*")
    @Path("residences")
    public ArrayList<String> getResidenaces(){
        ArrayList<String> res = new ArrayList<>();
        for(Person p : getPeronObject()){
            if( p.getResidence() != null)
                res.add(p.getResidence());
        }
        return  res;
    }

  @GET
    @Produces("*/*")
    @Path("getName")
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
    @Produces("*/*")
    @Path("getnames")
    public List<String> getSingleNameResidence(@DefaultValue("") @QueryParam("res") String res){
        ArrayList<String> personNames = new ArrayList<>();
        for(Person p : getPeronObject()){
            if(p.getResidence() != null && p.getResidence().equals(res))
                personNames.add(p.getFirstname());
        }
        return  personNames;
    }
}
