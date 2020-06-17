/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_;

import java.util.Scanner;

/**
 *
 * @author Bea
 */
public class Tictactoe_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Tic Tac Toe Match");
        System.out.println();
         
        Match match=new Match();
        match.initialBoard();
        
        while(match.winner()!=0){
            match.controller();
            UI.clearScreen();
        }
        
        String winner;
        if(match.getTurn() %2 !=0){
            winner="O";
        } else{
            winner="X";
        }
        
        System.out.println("Winner: " + winner);
        
    }
    
}
