package services;

import java.util.HashMap;
import java.util.Map;

public class Facade {
    private static Facade instance=null;

    private Map<String,String> users;

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

}
