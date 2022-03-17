package services;

import dtos.Contrat;
import dtos.Etude;
import dtos.Taux;
import dtos.User;
import exceptions.contratInvalidException;
import exceptions.idTauxNonTrouveeException;
import exceptions.tauxInvalidException;

import java.util.*;

public class Facade {
    private static Facade instance=null;

    private Map<String, User> users;

    private Map<Integer, Integer> tauxReussite;

    private List<Taux> lesTaux;

    private Etude etude;

    private Facade(){
        tauxReussite = new HashMap<>();
        tauxReussite.put(1,65);
        tauxReussite.put(2, 72);
        tauxReussite.put(3, 84);
        tauxReussite.put(4,93);
        tauxReussite.put(5,41);

        lesTaux = new ArrayList<>(Arrays.asList(new Taux(60, 69, 0.6f), new Taux(70, 79, 0.5f),
                new Taux(80, 89, 0.4f), new Taux(90, 100, 0.3f)));
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

   public void creerEtude(int annee, String cycle, String cursus, double prix) {
        etude = new Etude(annee,cycle,cursus,prix);
   }

   public Contrat creerContrat(String mail, Date dateDebutContrat, Date dateFinContrat) throws contratInvalidException, idTauxNonTrouveeException, tauxInvalidException {
        String numeroContrat = UUID.randomUUID().toString();
        double tranche = getTrancheByTaux(getTauxReussiteById(1));
        double prixAnnuel = (tranche * etude.getPrix())*1/3;
        if (!isVideOrNull(mail) || !isVideOrNull(dateDebutContrat) || !isVideOrNull(dateFinContrat)){
            Contrat contrat = new Contrat(numeroContrat,dateDebutContrat,dateFinContrat,prixAnnuel);
            contrat.setEtude(etude);
            User user = users.get(mail);
            user.getContrats().add(contrat);
            return contrat;
        } else {
            throw new contratInvalidException();
        }
   }

   public Boolean isVideOrNull(Object object){
        return Objects.isNull(object)&&object.toString().equals("");
   }


}
