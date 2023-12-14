package com.br.minigame;

import com.br.minigame.miniGameGUI;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Instancia o objeto da classe miniGameGUi
                miniGameGUI miniGameGUI = new miniGameGUI();

                //Exibe o app
                miniGameGUI.setVisible(true);
            }
        });
    }
}