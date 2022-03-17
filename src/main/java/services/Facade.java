package services;

import dtos.*;
import exceptions.*;

import java.time.LocalDate;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Facade {
    private static Facade instance=null;

    private Map<String, User> users;
    private Map<String, User> usersConnecte;

    private Map<Integer, Integer> tauxReussite;

    private Collection<String> listSpecialitiesBac;

    private List<Taux> lesTaux;

    private Etude etude;

    private Facade(){
        users=new HashMap<>();
        this.usersConnecte=new HashMap<>();
        try {
            User newUser = new User("user", "user", "user", "user",
                    new SimpleDateFormat("dd/MM/yyyy").parse("03/05/1997"), "Femme");
            newUser.getContrats().add(new Contrat("123456789", new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2021"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2022"), 350));
            newUser.getContrats().get(0).setEtude(new Etude(1, "LICENCE", "DROIT", 350));
            users.put("user", newUser);

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

        listSpecialitiesBac = new ArrayList<>();
        listSpecialitiesBac.add("Général");
        listSpecialitiesBac.add("Professionnel");
        listSpecialitiesBac.add("Technologique");
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

    public void creerEtude(int annee, String cycle, String cursus, double prix) {
        etude = new Etude(annee,cycle,cursus,prix);
    }

    public Contrat  creerContrat(String mail, Date dateDebutContrat) throws ContratInvalidException, IdTauxNonTrouveeException, TauxInvalidException, PrixEcoleTropCherException, TauxReussiteTropBasException {
        Date dateFinContrat = new Date();
        dateFinContrat.setYear(dateFinContrat.getYear()+1);
        String numeroContrat = UUID.randomUUID().toString();
        double tranche = getTrancheByTaux(getTauxReussiteById(1));
        if (this.etude.getPrix()<10000d){
            if (getTauxReussiteById(1)>=60) {
                double prixAnnuel = (tranche * etude.getPrix()) * 1 / 3;
                if (!isVideOrNull(mail) || !isVideOrNull(dateDebutContrat) || !isVideOrNull(dateFinContrat)) {
                    Contrat contrat = new Contrat(numeroContrat, dateDebutContrat, dateFinContrat, prixAnnuel);
                    contrat.setEtude(etude);
                    User user = users.get(mail);
                    user.getContrats().add(contrat);
                    return contrat;
                } else {
                    throw new ContratInvalidException();
                }
            }else{
                throw new TauxReussiteTropBasException();
            }
        }else{
            throw new PrixEcoleTropCherException();
        }
    }

    public Boolean isVideOrNull(Object object){
        return Objects.isNull(object)&&object.toString().equals("");
    }

    public User getUser(String mail) throws UtilisateurInexistantException {
        if (users.containsKey(mail)) {
            return users.get(mail);
        }
        throw new UtilisateurInexistantException();
    }

    public List<Contrat> getContrats(String mail) throws UtilisateurInexistantException {
        return getUser(mail).getContrats();
    }


    public Sinistre addSinistre(User user, Sinistre sinistre, String courant, Contrat contrat) throws ContratExpireException{


        if (contrat != null && contrat.getDateFinContrat().before(java.sql.Date.valueOf(String.valueOf(LocalDate.now())))) {
            throw new ContratExpireException();
        }
        String cycle = contrat.getEtude().getCycle();
        double pourcentage= getPourcentage(sinistre.getNoteS1(), sinistre.getNoteS2(),cycle);
        double indemnite = contrat.getEtude().getPrix() *pourcentage;
        Sinistre newSinistre = new Sinistre(java.sql.Date.valueOf(LocalDate.now()),
                pourcentage,
                sinistre.getNoteS1(),
                sinistre.getNoteS2(),
                indemnite);
        user.getContrats().get(user.getContrats().size()-1).setSinistre(newSinistre);
        return newSinistre;
    }

    public double getPourcentage(double note1, double note2,String cycle ) {
        double pourcentage=0;
        if (cycle.equals("MASTER")){
            if (note1 > 4 && note1 <7 && note2 > 4 && note2 <7){
                pourcentage = 0.70;
            }else if (note1 >= 7 && note1 <10 && note2 >= 7 && note2 <10){
                pourcentage =1;
            }
        }else{
            double moyenne = (note1 +note2)/2;
            if (moyenne > 4 && moyenne <7) {
                pourcentage = 0.70;
            }else if (moyenne >= 7 && moyenne <10){
                pourcentage =1;
            }
        }
        return pourcentage;
    }

    public Collection<String> getListSpe(){
        return listSpecialitiesBac;
    }

}
