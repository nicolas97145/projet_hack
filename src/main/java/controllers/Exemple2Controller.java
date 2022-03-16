package controllers;

import dtos.Contrat;
import dtos.Sinistre;
import dtos.User;
import exception.AucunContratExcpetion;
import exception.ContratExpireException;
import exception.SinistreDejaExistant;
import exception.UtilisateurInexistantException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import services.Facade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("courant")
@RequestMapping("/")
public class Exemple2Controller {
    private Facade facade=Facade.getInstance();
    @RequestMapping("")
    public String toLogin(Model model) {
        //ici on doit renvoyer un User du fait traitement avec modelAttribute et path côté jsp
        model.addAttribute(new User());
        return("login");
    }

    @RequestMapping("/sinistre")
    public String toSinsitre(Model model) {
        //ici on doit renvoyer un User du fait traitement avec modelAttribute et path côté jsp
        model.addAttribute(new Sinistre());
        return("sinistre");
    }

    // on passe un objet user en paramètre : mapping automatique des champs du formulaire
    // on jour aussi avec les messages d'erreurs (BindingResult) ...
    @RequestMapping("login")
    public String checkLP(User user, BindingResult result, Model model){
        if (facade.checkLP(user.getMail(),user.getPassword())) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            model.addAttribute("courant",user.getMail());
            model.addAttribute("username",user.getMail());
            return "welcome";
        } else {
            // on crée à la volée un "ObjectError" : erreur globale dans l'objet (ici l'objet c'est l'instance de user où transitent les infos de login)
            result.addError(new ObjectError("user","Les informations saisies ne correspondent pas à un utilisateur connu."));
            System.out.println(result.hasErrors());
            // le user du model est renvoyé tel quel à la jsp, et on préserve les valeurs saisies (comment réinitialiser ?)
            return "login";
        }
    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute String courant,Model model){
        System.out.println(courant);
        model.addAttribute("username",courant);
        return "welcome";
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status,Model model) {
        status.setComplete();
        model.addAttribute(new User());
        return "login";
    }

    @RequestMapping("sinistreDeclare")
    public String sinistre(@SessionAttribute String courant, Sinistre sinistre, BindingResult result ,Model model) throws ContratExpireException, AucunContratExcpetion, SinistreDejaExistant {
        try {
            User user = facade.getUser(courant);
            Contrat contrat = user.getContrats().get(user.getContrats().size()-1);
            if (contrat.getSinistre()==null){
                try {
                    facade.addSinistre(sinistre,courant);
                } catch (UtilisateurInexistantException e) {
                    return "welcome";
                }
                return "sinistre";
            }else{
                return "welcome";
            }
        } catch (UtilisateurInexistantException e) {
            return "welcome";
        }
    }
}
