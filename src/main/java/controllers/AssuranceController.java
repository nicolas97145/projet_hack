package controllers;

import dtos.Contrat;
import dtos.Etude;
import dtos.Sinistre;
import dtos.User;
import exceptions.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import services.Facade;

import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("courant")
@RequestMapping("/")
public class AssuranceController {
    private Facade facade=Facade.getInstance();

    @RequestMapping("")
    public String toWelcome(Model model) {
        return("welcome");
    }

    @RequestMapping("login")
    public String toLogin(Model model) {
        model.addAttribute(new User());
        return("login");
    }

    @RequestMapping("inscription")
    public String toRegister(Model model) {
        model.addAttribute("listSpecialitiesBac", facade.getListSpe());
        model.addAttribute(new User());
        return("inscription");
    }

    @RequestMapping("goEtude")
    public String toEtude(Model model) {
        model.addAttribute(new Etude());
        return("etude");
    }

    @RequestMapping("etude")
    public String ajouterEtude(Etude etude, Model model) {;
        facade.creerEtude(etude.getAnnee(),etude.getCycle(),etude.getCursus(),etude.getPrix());
        model.addAttribute(new Contrat());
        return "souscription";
    }

    @RequestMapping("souscription")
    public String souscriptionContrat(Contrat contrat, BindingResult result, Model model) {;
        try {
            Contrat monContrat = facade.creerContrat(model.getAttribute("courant").toString(), contrat.getDateDebutContrat());
            model.addAttribute("anneeEtude", monContrat.getEtude().getAnnee());
            model.addAttribute("cycle",monContrat.getEtude().getCycle());
            model.addAttribute("cursus",monContrat.getEtude().getCursus());
            model.addAttribute("prix",monContrat.getEtude().getPrix());
            model.addAttribute("dateDebutContrat", monContrat.getDateDebutContrat());
            model.addAttribute("dateFinContrat", monContrat.getDateFinContrat());
            model.addAttribute("prixContrat", Math.round(monContrat.getPrixAnnuel()*100.0)/100.0);
        } catch (ContratInvalidException | IdTauxNonTrouveeException | TauxInvalidException e) {
            model.addAttribute("erreur", "Le contrat n'est pas valide.");
            return "PageKOSouscription";
        } catch (TauxReussiteTropBasException e) {
            model.addAttribute("erreur", "Le taux de réussite de cette année est trop bas.");
            return "PageKOSouscription";
        } catch (PrixEcoleTropCherException e) {
            model.addAttribute("erreur", "Le prix de votre école est trop important.");
            return "PageKOSouscription";
        }
        return "pageOKSouscription";
    }

    @RequestMapping("sinistre")
    public String toSinsitre(Model model) {
        try {
            User user = facade.getUser(model.getAttribute("courant").toString());
            if (user.getContrats().size()>0){
                model.addAttribute(new Sinistre());
                return("sinistre");
            }else{
                model.addAttribute("erreur", "Pas de contrat pour déclarer un sinitre");
                return "profil";
            }

        } catch (UtilisateurInexistantException e) {
            return "welcome";
        }

    }

    @RequestMapping("sinistreDeclare")
    public String sinistre(@SessionAttribute String courant, Sinistre sinistre, BindingResult result ,Model model) {
        try {
            User user = facade.getUser(courant);
            Contrat contrat = user.getContrats().get(user.getContrats().size()-1);
            if (contrat != null) {
                if (contrat.getSinistre() == null) {
                    Sinistre sinistre1 = facade.addSinistre(user, sinistre,  courant, contrat);
                    model.addAttribute("dateDeclaration", sinistre1.getDateDeclaration() );
                    model.addAttribute("pourcentageRemboursement",sinistre1.getPourcentageRemboursement());
                    model.addAttribute("indemnite",Math.round(sinistre1.getIndemnite()*100.0)/100.0);
                    return "pageOKSinistre";
                } else {
                    model.addAttribute("erreur", "Un sinistre est déjà déclaré pour ce contrat");
                    return "pageKOSinistre";
                }
            }else {
                model.addAttribute("erreur", "Pas de contrat pour déclarer un sinitre");
                return "pageKOSinistre";
            }
        } catch (UtilisateurInexistantException e) {
            return "welcome";
        } catch (ContratExpireException e) {
            model.addAttribute("erreur", "Le contrat n'est plus valide");
            return "pageKOSinistre";
        }
    }


    @RequestMapping("user")
    public String checkLP(User user, BindingResult result, Model model){
        try {
            if (facade.checkLP(user.getMail(),user.getPassword())) {
                // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
                model.addAttribute("courant",user.getMail());
                return "profil";
            } else {
                // on crée à la volée un "ObjectError" : erreur globale dans l'objet (ici l'objet c'est l'instance de user où transitent les infos de login)
                result.addError(new ObjectError("user","Les informations saisies ne correspondent pas à un utilisateur connu."));
                return "login";
            }
        } catch (IdTauxNonTrouveeException e) {
            result.addError(new ObjectError("user","Les informations saisies ne correspondent pas à un utilisateur connu."));
            return "login";
        }
    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute String courant,Model model){
        model.addAttribute("username",courant);
        return "welcome";
    }

    @RequestMapping("inscriptionUser")
    public String inscription(User user, BindingResult result, Model model){
        try {
            facade.inscription(user.getNom(), user.getPrenom(), user.getDateNaissance(), user.getSexe(), user.getMail(), user.getPassword());
            model.addAttribute("courant",user.getMail());
            return "profil";
        } catch (UtilisateurExistantException e) {
            return "inscription";
        }
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status,Model model) {
        status.setComplete();
        facade.logout(model.getAttribute("courant").toString());
        return "welcome";
    }

    @RequestMapping("profil")
    public String profil(Model model) {
        model.getAttribute("courant");
        return("profil");
    }

    @RequestMapping("souscriptionUser")
    public String souscriptionContrat(@SessionAttribute String courant, BindingResult bindingResult, Model model) {

        return "profil";
    }

    @RequestMapping("contrat")
    public String getContrat(Model model) {
        try {
            List<Contrat> contrats = facade.getContrats(model.getAttribute("courant").toString());
           if (contrats.size()>0){
               model.addAttribute("numeroContrat", contrats.get(contrats.size()-1).getNumeroContrat() );
               model.addAttribute("dateDebutContrat",contrats.get(contrats.size()-1).getDateDebutContrat() );
               model.addAttribute("dateFinContrat",contrats.get(contrats.size()-1).getDateFinContrat()) ;
               model.addAttribute("prixAnnuel", contrats.get(contrats.size()-1).getPrixAnnuel() );
               if (contrats.get(contrats.size()-1).getSinistre() != null) {
                   model.addAttribute("sinistreDate", contrats.get(contrats.size()-1).getSinistre().getDateDeclaration());
                   model.addAttribute("sinistrePourcentage", contrats.get(contrats.size()-1).getSinistre().getPourcentageRemboursement());
                   model.addAttribute("sinistreIndemn", contrats.get(contrats.size()-1).getSinistre().getIndemnite());
               }
           }
           return "contrat";
        } catch (UtilisateurInexistantException e) {
            return "welcome";
        }
    }
}
