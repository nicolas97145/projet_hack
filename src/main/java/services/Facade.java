package services;

import dtos.Contrat;
import dtos.Sinistre;
import dtos.User;
import exception.*;
import org.springframework.validation.ObjectError;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Facade {
    private static Facade instance = null;

    private Map<String, String> users;

    private Map<String, User> userMap;
    private Map<String, Contrat> contratMap;
    private Map<UUID, Sinistre> sinistreMap;

    private Facade() {
        users = new HashMap<>();
        users.put("alice@alice", "alice");
        users.put("bob@bob", "bob");

        userMap = new HashMap<>();
        contratMap = new HashMap<>();
        sinistreMap = new HashMap<>();

        User alice = new User("alice@alice", "alice", "alice", "alice", "femme");
        Contrat contrat1 = new Contrat("1", Date.valueOf("2022-01-01"), Date.valueOf("2023-01-01"), 15.0);
        List<Contrat> contratsAlice = new ArrayList<>();
        contratsAlice.add(contrat1);
        alice.setContrats(contratsAlice);

        userMap.put("alice@alice", alice);
        contratMap.put("contrat1", contrat1);

    }

    public static synchronized Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public boolean checkLP(String email, String password) {
        String pwd = users.get(email);
        return ((pwd != null) && (pwd.equals(password)));
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


    public void addSinistre(Sinistre sinistre,String courant) throws AucunContratExcpetion, ContratExpireException, SinistreDejaExistant, UtilisateurInexistantException {
        User user = this.getUser(courant);
        List<Contrat> contrats = this.getContrats(user.getMail());
        Contrat contrat;

        if (contrats.isEmpty()) {
            throw new AucunContratExcpetion();
        } else {
            contrat = contrats.get(contrats.size() - 1);
        }
        if (contrat != null && contrat.getDateFinContrat().before(java.sql.Date.valueOf(String.valueOf(LocalDate.now())))) {
            throw new ContratExpireException();
        }

        else {
            if (contrat.getSinistre()!=null) {
                throw new SinistreDejaExistant();
            }
        }
        sinistre.setDateDeclaration(Date.valueOf(LocalDate.now()));
        contrat.setSinistre(sinistre);
        sinistreMap.put(sinistre.getId(),sinistre);
    }

}
