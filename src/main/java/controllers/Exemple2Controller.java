package controllers;

import dtos.Contrat;
import dtos.Sinistre;
import dtos.User;
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

    @RequestMapping("sinistre")
    public String sinistre(@SessionAttribute String courant,Model model) throws UtilisateurInexistantException {
        model.addAttribute("username",courant);

        User user = facade.getUser(courant);
        List<Contrat> contrats = facade.getContrats(courant);
        Sinistre sinisitre = new Sinistre();

        model.addAttribute("noteS1",sinisitre.getNoteS1());
        model.addAttribute("noteS2",sinisitre.getNoteS2());
        return "sinistre";
    }
}
