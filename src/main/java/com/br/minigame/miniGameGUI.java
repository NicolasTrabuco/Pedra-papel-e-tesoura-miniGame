package com.br.minigame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class miniGameGUI extends JFrame implements ActionListener{

    //Cria os botões da pedra, do papel e da tesoura
    JButton rockButton, paperButton, scissorButton;
    
    //Cria a variavel de escolha do computador
    JLabel computerChoice;

    //Cria as pontuações
    JLabel computerScoreLabel, playerScoreLabel;

    // Objeto que guarda a parte lógica
    MiniGame miniGame;
    
    public miniGameGUI() {
        
        //Cria a GUI com um titulo
        super("MiniGame");

        //Define o tamanho da tela utilizada
        setSize(450, 574);

        //Desabilita o layout padrão do JFrame
        setLayout(null);

        //Faz com que quando o usuario feche o app, toda operação é desligada
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Desabilita a posição relativa com algo
        setLocationRelativeTo(null);

        //Instancia o objeto miniGame
        miniGame = new MiniGame(); 
        
        //chama a função que adiciona os componentes do app
        addGUIComponents();

    }

    private void addGUIComponents() {
        
        //Define o estilo da label que contem o score do computador
        computerScoreLabel = new JLabel("Computador: 0");
        computerScoreLabel.setBounds(0, 43, 450, 30);
        computerScoreLabel.setFont(new Font("DIalog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        //Define o estilo da label que contem a escolha do computador
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        //Define o estilo da label que contém o score do jogador
        playerScoreLabel = new JLabel("Joagdor: 0");
        playerScoreLabel.setBounds(0, 317, 450, 30);
        playerScoreLabel.setFont(new Font("DIalog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //Define o estilo do botão de escolha "Pedra"
        rockButton = new JButton("Pedra");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener((ActionListener) this);
        add(rockButton);

        //Define o estilo do botão de escolha "Papel"
        paperButton = new JButton("Papel");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener((ActionListener) this);
        add(paperButton);

        //Define o estilo do botão de escolha "Tesoura"
        scissorButton = new JButton("Tesoura");
        scissorButton.setBounds(290, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener((ActionListener) this);
        add(scissorButton);
    }

    //Função que mostra a caixa de dialogo que contém quem ganhou, e se quiser tentar denovo
    private void showDialog(String message){
        
        //Cria e instancia o objeto que contém a caixa de dialogo
        JDialog resultDialog = new JDialog(this, "Resultado", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //Cria e instancia o objeto que contém o resultado da disputa
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        //Cria e instancia o objeto que possui a opção de tentar novamente
        JButton tryAgainButton = new JButton("Tentar novamente?");

        //Adiciona um evento no botãode tentar novamente
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reseta a escolha do computador
                computerChoice.setText("?");

                //Fecha a ciaxa de dialogo
                resultDialog.dispose();
            }
        });
        
        //Adiciona o botão de tentar novamente, e define seu layout
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    //Reescreve a função actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        //Salva a escolha do jogador
        String playerChoice = e.getActionCommand().toString();

        //Inicia a função que realiza a disputa
        String result = miniGame.playMiniGame(playerChoice);

        //Mostra a opção escolhida pelo computador
        computerChoice.setText(miniGame.getComputerChoice());

        //Mostra as escolhas 
        computerScoreLabel.setText("Computador: " + miniGame.getComputerScore());
        playerScoreLabel.setText("Jogador: " + miniGame.getPlayerScore());
        
        //Exibe na caixa de dialogo o resultado da disputa
        showDialog(result);
    }
}


