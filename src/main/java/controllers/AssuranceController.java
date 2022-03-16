package controllers;

import dtos.Contrat;
import dtos.User;
import exceptions.IdTauxNonTrouveeException;
import exceptions.UtilisateurExistantException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import services.Facade;

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
        model.addAttribute(new User());
        return("inscription");
    }

    @RequestMapping("souscription")
    public String toSouscription(Model model) {
        model.addAttribute(new Contrat());
        return("souscription");
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
        } catch (UtilisateurExistantException e) {
            return "inscription";
        }
        return "profil";
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

        return "contrat";
    }
}
