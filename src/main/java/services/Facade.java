package services;

import dtos.Contrat;
import dtos.Etude;
import dtos.Taux;
import dtos.User;
import exceptions.ContratInvalidException;
import exceptions.IdTauxNonTrouveeException;
import exceptions.TauxInvalidException;
import exceptions.UtilisateurExistantException;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Facade {
    private static Facade instance=null;

    private Map<String, User> users;
    private Map<String, User> usersConnecte;

    private Map<Integer, Integer> tauxReussite;

    private List<Taux> lesTaux;

    private Etude etude;

    private Facade(){
        users=new HashMap<>();
        this.usersConnecte=new HashMap<>();
        try {
            users.put("user", new User("user", "user", "user", "user",
                    new SimpleDateFormat("dd/MM/yyyy").parse("03/05/1997"), "Femme"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tauxReussite = new HashMap<>();
        tauxReussite.put(1,65);
        tauxReussite.put(2, 72);
        tauxReussite.put(3, 84);
        tauxReussite.put(4,93);
        tauxReussite.put(5,41);

        lesTaux = new ArrayList<>(Arrays.asList(new Taux(60, 69, 0.6f), new Taux(70, 79, 0.5f),
                new Taux(80, 89, 0.4f), new Taux(90, 100, 0.3f)));

        etude = new Etude(1,"Licence", "Droit", 425);
    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String mail,String password) throws IdTauxNonTrouveeException {
        User user = users.get(mail);
        if (user == null){
            throw new IdTauxNonTrouveeException();
        }else{
            String pwd= user.getPassword();
            if (((pwd!=null) && (pwd.equals(password)))){
                usersConnecte.put(mail, user);
                return true;
            }else{

            }
            return false;
        }

   }

    public void logout(String login) {
        usersConnecte.remove(login);
    }

    public void inscription(String nom, String prenom, Date dateNaissance, String sexe, String mail, String password) throws UtilisateurExistantException {
        User user = new User(mail, password, nom, prenom, dateNaissance, sexe);
        if (!users.containsKey(mail)) {
            users.put(mail, user);
            usersConnecte.put(mail, user);
        } else {
            throw new UtilisateurExistantException();
        }
    }

    public int getTauxReussiteById(int id) throws IdTauxNonTrouveeException {
        if (tauxReussite.containsKey(id))
            return tauxReussite.get(id);
        throw new IdTauxNonTrouveeException();
    }

    public float getTrancheByTaux(int taux) throws TauxInvalidException {
        return lesTaux
                .stream()
                .filter(t -> taux >= t.getMin() && taux <= t.getMax())
                .findFirst()
                .orElseThrow(TauxInvalidException::new)
                .getTranche();
    }

    public void creerContrat(String mail, String bac, Date dateDebutContrat, Date dateFinContrat) throws ContratInvalidException, IdTauxNonTrouveeException, TauxInvalidException {
        String numeroContrat = UUID.randomUUID().toString();
        double tranche = getTrancheByTaux(getTauxReussiteById(1));
        double prixAnnuel = (tranche * etude.getPrix())*1/3;
        if (!isVideOrNull(mail) || !isVideOrNull(dateDebutContrat) || !isVideOrNull(dateFinContrat)){
            Contrat contrat = new Contrat(numeroContrat,dateDebutContrat,dateFinContrat,prixAnnuel);
            contrat.setEtude(etude);
            User user = users.get(mail);
            user.setBac(bac);
            user.getContrats().add(contrat);
        } else {
            throw new ContratInvalidException();
        }
    }

    public Boolean isVideOrNull(Object object){
        return Objects.isNull(object)&&object.toString().equals("");
    }

}
