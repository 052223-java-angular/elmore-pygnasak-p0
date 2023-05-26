package com.revature.app;

import java.util.Scanner;

import com.revature.app.models.Session;
import com.revature.app.services.RouterService;

public class App {
  public static void main(String args[]) {
    System.out.println("Welcome to eCommerce App!");

    Scanner scan = new Scanner(System.in);
    RouterService router = new RouterService(new Session());
    router.navigate("/home",scan);
  }
}