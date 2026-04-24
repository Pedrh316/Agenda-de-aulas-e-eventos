package com.mycompany.sistemaagenda;

import com.github.weisj.darklaf.DarkLaf;
import com.github.weisj.darklaf.LafManager;
import com.mycompany.sistemaagenda.controller.DatabaseController;
import com.mycompany.sistemaagenda.view.DbConnection;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class SistemaAgenda {

    public static void main(String[] args) {
        
        LafManager.install(new com.github.weisj.darklaf.theme.OneDarkTheme());
        try {
            UIManager.setLookAndFeel(new DarkLaf());
        }
        catch (UnsupportedLookAndFeelException e) {}
        
        
        DatabaseController dbCtrl = new DatabaseController();               
        
        if(dbCtrl.connect()){
            //janela login            
        }
        else{            
            DbConnection dbConWindow = new DbConnection();
            dbConWindow.setVisible(true);
        }
    }
}
