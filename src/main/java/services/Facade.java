package services;

import dtos.Taux;
import exceptions.idTauxNonTrouveeException;
import exceptions.tauxInvalidException;

import java.sql.Date;
import java.util.*;

public class Facade {
    private static Facade instance=null;

    private Map<String,String> users;

    private Map<Integer, Integer> tauxReussite;

    private List<Taux> lesTaux;

    private Facade(){
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");

        tauxReussite = new HashMap<>();
        tauxReussite.put(1,65);
        tauxReussite.put(2, 72);
        tauxReussite.put(3, 84);
        tauxReussite.put(4,93);

        lesTaux = new ArrayList<>(Arrays.asList(new Taux(60, 69, 0.6f), new Taux(70, 79, 0.5f),
                new Taux(80, 89, 0.4f), new Taux(90, 100, 0.3f)));

    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
   }

   public int getTauxReussiteById(int id) throws idTauxNonTrouveeException {
        if (tauxReussite.containsKey(id))
            return tauxReussite.get(id);
        throw new idTauxNonTrouveeException();
   }

   public float getTrancheByTaux(int taux) throws tauxInvalidException {
       return lesTaux
               .stream()
               .filter(t -> taux >= t.getMin() && taux <= t.getMax())
               .findFirst()
               .orElseThrow(tauxInvalidException::new)
               .getTranche();
   }


}
