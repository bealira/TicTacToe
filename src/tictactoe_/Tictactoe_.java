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
        
        while(match.winner()!=0 && match.draw()!=0){
            match.controller();
        }
        
        String winner;
        if(match.getTurn() %2 !=0){
            winner="O";
        } else{
            winner="X";
        }
        
        if(match.draw()==0 && match.winner()!=0){
            System.out.println("Draw");
        }else
            System.out.println("Winner: " + winner);
        
    }
    
}
