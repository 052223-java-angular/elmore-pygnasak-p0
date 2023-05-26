package com.revature.app.services;

import com.revature.app.daos.RoleDAO;
import com.revature.app.daos.UserDAO;
import com.revature.app.models.Session;
import com.revature.app.screens.HomeScreen;
import com.revature.app.screens.LoginScreen;
import com.revature.app.screens.RegisterScreen;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class RouterService {
    private Session session;

    public void navigate (String path, Scanner scanner)
    {
        switch (path){
            case "/home":
                new HomeScreen(this).start(scanner);
                break;
            case "/register":
                // Within the register screen, the user should return the main menu after completing the registration process
                new RegisterScreen(getUserService(), this).start(scanner);
                break;
            case "/login":
                // after a successful login, the user should navigate the browse screen
                new LoginScreen(getUserService(), this, session).start(scanner);
                break;
            case "/browse":
                break;
            case "/checkout":
                break;
            case "/review":
                break;
            case "/orderHistory":
                break;
            default:
                break;
        }
    }

    private UserService getUserService() {
        return new UserService(new UserDAO(), getRoleService());
    }

    private RoleService getRoleService() {
        return new RoleService(new RoleDAO());
    }

}
