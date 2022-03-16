package services;

import dtos.Contrat;
import dtos.Sinistre;
import dtos.User;
import exception.ContratInexistantException;
import exception.UtilisateurInexistantException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facade {
    private static Facade instance=null;

    private Map<String,String> users;

    private Map<String, User> userMap;
    private Map<String, Contrat> contratMap;
    private Map<String, Sinistre> sinistreMap;

    private Facade(){
        users=new HashMap<>();
        users.put("alice@alice","alice");
        users.put("bob@bob","bob");
    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String email,String password) {
        String pwd=users.get(email);
        return ((pwd!=null) && (pwd.equals(password)));
   }

   public User getUser(String mail) throws UtilisateurInexistantException {
        if (userMap.containsKey(mail)) {
            return userMap.get(mail);
        }
        throw new UtilisateurInexistantException();
   }

    public List<Contrat> getContrats(String mail) throws UtilisateurInexistantException {
       return getUser(mail).getContrats();
    }


}
