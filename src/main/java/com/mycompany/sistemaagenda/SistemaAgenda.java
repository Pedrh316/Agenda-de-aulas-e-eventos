package com.mycompany.sistemaagenda;

import com.github.weisj.darklaf.DarkLaf;
import com.github.weisj.darklaf.LafManager;
import com.mycompany.sistemaagenda.controller.DatabaseController;
import com.mycompany.sistemaagenda.navigation.Navigator;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class SistemaAgenda {

    public static void main(String[] args) {
        
        LafManager.install(new com.github.weisj.darklaf.theme.OneDarkTheme());
        try {
            UIManager.setLookAndFeel(new DarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {}
                
        EventQueue.invokeLater(() -> {            

            Navigator nav = new Navigator();
            DatabaseController dbCtrl = new DatabaseController(null, nav);
            
            dbCtrl.connect();
        });                               
    }
}
