package com.br.minigame;

import java.util.Random;

public class MiniGame {
    
    private static final String[] computerChoices = {"Pedra", "Papel", "Tesoura"};
    
    //Cria o método que retorna a variavel de escolha do computador
    public String getComputerChoice() {
        return computerChoice;
    }

    //Cria o método que retorna a variavel da pontuação do computador
    public int getComputerScore() {
        return computerScore;
    }

    //Cria o método que retorna a variavel da pontuação do jogador 
    public int getPlayerScore() {
        return playerScore;
    }    
    
    private String computerChoice;
    
    private int computerScore, playerScore;
    
    private Random random;
    
    //Cria um metodo que instancia um objeto 
    public MiniGame(){
        random = new Random();
    }
    
    public String playMiniGame(String playerChoice){
        
        //Objeto que gera um número aleatório entre 0 e o tamanho do array ComputerChoices 
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
    
        //Variavel de resultado
        String result;
        
        //Realiza as verificações das disputas
        //Quando o player ganha, a pontuaçã dele sobe 1 ponto
        //Quando o computador ganha a potuação dele sobe um ponto
        if(computerChoice.equals("Pedra")){
            if(playerChoice.equals("Papel")){
                result = "Jogador ganhou";
                playerScore++;
            }else if(playerChoice.equals("Tesoura")){
                result = "COmputador ganhou";
                computerScore++;
            }else{
                result = "Empate";
            }
        }else if(computerChoice.equals("Papel")){
            if(playerChoice.equals("Tesoura")){
                result = "Jogador ganhou";
                playerScore++;
            }else if(playerChoice.equals("Pedra")){
                result = "Computador ganhou";
                computerScore++;
            }else{
                result = "Empate";
            }
        }else{
           // computer chooses scissors
            if(playerChoice.equals("Pedra")){
                result = "Jogador ganhou";
                playerScore++;
            }else if(playerChoice.equals("Papel")){
                result = "Computador ganhou";
                computerScore++;
            }else{
                result = "Empate";
            }
        }
        
        //Retorna quem ganhou a disputa subindo um ponto para o vencedor
        return result;
    }

    
}