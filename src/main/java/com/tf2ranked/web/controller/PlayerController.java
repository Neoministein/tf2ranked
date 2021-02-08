package com.tf2ranked.web.controller;

import com.tf2ranked.web.entity.Player;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.*;
import java.util.List;


@Named(value = "playerController")
@RequestScoped
public class PlayerController implements Serializable {
       
    @EJB
    private PlayerFacade itemFacade;
    private Player player;
    
    /**
     * Creates a new instance of PlayerController
     */
    public PlayerController() {
         player = new Player();
    }

    public Player getPlayer() {
        return player;
    }

    public void savePlayer(){
        itemFacade.create(player);
    }


    //Here for testing propose
    public String getDataBaseVerson() {
        String url = "jdbc:postgresql://localhost:5432/M152TESTDB";
        String user = "DBACC";
        String password = "DBACC";

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT VERSION()")) {

            if (rs.next()) {
               return (rs.getString(1));
            }

        } catch (SQLException ex) {

        }
        return "No Connection";
    }

    public List<Player> getPlayerList() {
        return itemFacade.findAll();
    }

}
