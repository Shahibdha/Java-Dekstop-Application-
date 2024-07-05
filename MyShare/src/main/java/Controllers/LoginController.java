package Controllers;

import Models.User;

import java.util.ArrayList;

public class LoginController {
    ArrayList<User> userDB;
    public LoginController()
    {
        userDB=new ArrayList<>();
        CreateDB();
    }
    private void CreateDB()
    {
        userDB.add(new User("AD1000", "ake@gmail.com","Akeshi","1234"));
        userDB.add(new User("AD1001", "shahi@gmail.com","Shahibdha","1234"));
        userDB.add(new User("AD1002", "lio@gmail.com","Lio","1234"));
        userDB.add(new User("AD1003", "imasha@gmail.com","Imasha","1234"));
        userDB.add(new User("AD1004", "geeth@gmail.com","Geeth","1234"));
        userDB.add(new User("AD1005", "sandaru@gmail.com","Sandaru","1234"));
        userDB.add(new User("AD1006", "dineth@gmail.com","Dineth","1234"));
        userDB.add(new User("AD1007", "malaka@gmail.com","Malaka","1234"));
    }

    public User validateUser(User currentU)
    {
        for(User i:userDB)
        {
            if(i.getUserName().equalsIgnoreCase(currentU.getUserName()) && i.getPassword().equalsIgnoreCase(currentU.getPassword()))
            {
                return i;
            }
        }
        return null;
    }
}
