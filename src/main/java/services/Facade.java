package services;

import dtos.User;
import exceptions.utilisateurExistantException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Facade {
    private static Facade instance=null;

    private Map<String, User> users;
    private Collection<String> listSpecialitiesBac;

    private Facade()  {
        users=new HashMap<>();
        try {
            users.put("Soumia", new User("soum.brh@gmail.com", "soumbrh", "Brahmi", "Soumia",
                    new SimpleDateFormat("dd/MM/yyyy").parse("03/05/1997"), "Femme"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        listSpecialitiesBac = new ArrayList<>();
        listSpecialitiesBac.add("Générale");
        listSpecialitiesBac.add("Professionnelle");
        listSpecialitiesBac.add("Technologique");
    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String mail, User user) {
        String pwd=users.get(mail).getPassword();
        return ((pwd!=null) && (pwd.equals(user.getPassword())));
   }


   public void inscription(String nom, String prenom, Date dateNaissance, String sexe, String mail, String password) throws utilisateurExistantException {
       User user = new User(mail, password, nom, prenom, dateNaissance, sexe);
       if (!users.containsKey(mail)) {
           users.put(mail, user);
       }
       else{
           throw new utilisateurExistantException();
       }



   }
    public Collection<String> getListSpe(){
        return listSpecialitiesBac;
    }

   public Boolean isVideOrNull (Object object){
       return Objects.isNull(object)&&object.toString().equals("");
       }
   }



