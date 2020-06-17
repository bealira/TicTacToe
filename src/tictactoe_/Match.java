/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_;

import java.util.Scanner;
import static tictactoe_.UI.ANSI_BLUE;
import static tictactoe_.UI.ANSI_RED;
import static tictactoe_.UI.ANSI_RESET;

/**
 *
 * @author Bea
 */
public class Match {
    
    private final int rows=3;
    private final int columns=3;
    private int turn=1;
    private Scanner sc=new Scanner(System.in);
    private String position;
    private String[] plays=new String[9];
    
    public Match(){
        
        for(int h=0;h<9;h++){
            plays[h]="a";
        }
        
    }
    
    public void initialBoard(){
        
        if(turn==0){
            for(int h=0;h<9;h++){
                plays[h]="a";
            }
        }
        
        for(int i=0;i<rows;i++){
            System.out.print(3-i + " ");
            for(int j=0;j<columns;j++){
                System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println("  a b c");
        //setTurn();
    }
    
    public int getTurn(){
        return turn;
    }

    public void setTurn() {
        this.turn = turn+1;
    }
    
    public void printTurn(){
        System.out.println("Turn: " + turn);
    }
    
    public int convertPosition(String position){
        
        switch(position){
            case "a3":
                return 0;
            case "b3":
                return 1;
            case "c3":
                return 2;
            case "a2":
                return 3;
            case "b2":
                return 4;
            case "c2":
                return 5;
            case "a1":
                return 6;
            case "b1":
                return 7;
            case "c1":
                return 8;
            default:
                return -1;
        }
    }        
    
    public void playX() throws positionException{
        
        int x;
        
        do{
            
            System.out.println("Position: ");
            position=sc.nextLine();
            x=convertPosition(position);
            System.out.println();
            if(x==-1){
                printPlays();
                throw new positionException("Invalid Position");
            }
            
            if(occupiedPosition(x)==-1){
                printPlays();
                throw new positionException("Invalid Position");
            }
        }while(occupiedPosition(x)==-1);
        
        plays[x]="x ";
        
        printPlays();
        setTurn();
    }
    
    public void playO() throws positionException{
        
        int x;
        
        do{
            
            System.out.println("Position: ");
            position=sc.nextLine();
            x=convertPosition(position);
            System.out.println();
            if(x==-1){
                printPlays();
                throw new positionException("Invalid Position");
            }
            
            if(occupiedPosition(x)==-1){
                printPlays();
                throw new positionException("Choose a free position");
            }
        }while(occupiedPosition(x)==-1);
        
        plays[x]="o ";
        
        
        printPlays();
        setTurn();
        
    }
    
    public void printPlays(){
        
        System.out.print("3 ");
        for(int i=0;i<3;i++){
            if("a".equals(plays[i])){
                System.out.print("- ");
            }else{
                if("x ".equals(plays[i]))
                    System.out.print(ANSI_RED + plays[i] + ANSI_RESET);
                else
                    System.out.print(ANSI_BLUE + plays[i] + ANSI_RESET);
            }
                
        }
        System.out.println();
        System.out.print("2 ");
        for(int i=3;i<6;i++){
            if("a".equals(plays[i])){
                System.out.print("- ");
            }else
                if("x ".equals(plays[i]))
                    System.out.print(ANSI_RED + plays[i] + ANSI_RESET);
                else
                    System.out.print(ANSI_BLUE + plays[i] + ANSI_RESET);
        }
        System.out.println();
        System.out.print("1 ");
        for(int i=6;i<9;i++){
            if("a".equals(plays[i])){
                System.out.print("- ");
            }else
                if("x ".equals(plays[i]))
                    System.out.print(ANSI_RED + plays[i] + ANSI_RESET);
                else
                    System.out.print(ANSI_BLUE + plays[i] + ANSI_RESET);
        }
        System.out.println();
        System.out.println("  a b c");
        System.out.println();
        
    }
    
    public int winner(){
        
       if(plays[0].equals(plays[1]) && plays[1].equals(plays[2]) && plays[0].equals("x ")){
           return 0;
       }
        
       if(plays[3].equals(plays[4]) && plays[4].equals(plays[5]) && plays[3].equals("x ")){
           return 0;
       }
       
       if(plays[6].equals(plays[7]) && plays[7].equals(plays[8])  && plays[6].equals("x ")){
           return 0;
       }
       
       if(plays[0].equals(plays[3]) && plays[3].equals(plays[6]) && plays[0].equals("x ")){
           return 0;
       }
       
       if(plays[1].equals(plays[4]) && plays[4].equals(plays[7])  && plays[1].equals("x ")){
           return 0;
       }
       
       if(plays[2].equals(plays[5]) && plays[5].equals(plays[8]) && plays[2].equals("x ")){
           return 0;
       }
       
       if(plays[0].equals(plays[4]) && plays[4].equals(plays[8]) && plays[0].equals("x ")){
           return 0;
       }
       
       if(plays[2].equals(plays[4]) && plays[4].equals(plays[6]) && plays[2].equals("x ")){
           return 0;
       }
       
       if(plays[0].equals(plays[1]) && plays[1].equals(plays[2]) && plays[0].equals("o ")){
           return 0;
       }
        
       if(plays[3].equals(plays[4]) && plays[4].equals(plays[5]) && plays[3].equals("o ")){
           return 0;
       }
       
       if(plays[6].equals(plays[7]) && plays[7].equals(plays[8])  && plays[6].equals("o ")){
           return 0;
       }
       
       if(plays[0].equals(plays[3]) && plays[3].equals(plays[6]) && plays[0].equals("o ")){
           return 0;
       }
       
       if(plays[1].equals(plays[4]) && plays[4].equals(plays[7])  && plays[1].equals("o ")){
           return 0;
       }
       
       if(plays[2].equals(plays[5]) && plays[5].equals(plays[8])  && plays[2].equals("o ")){
           return 0;
       }
       
       if(plays[0].equals(plays[4]) && plays[4].equals(plays[8])  && plays[0].equals("o ")){
           return 0;
       }
       
       if(plays[2].equals(plays[4]) && plays[4].equals(plays[6])  && plays[2].equals("o ")){
           return 0;
       }
       
       return 1;
       
    }
    
    public void controller(){
        
        if(turn!=0)
            UI.clearScreen();
        
        printPlays();
        
        if(turn%2!=0){
            System.out.println("Turn X");
            try{
                playX();
            }catch(positionException e){
                System.out.println("Invalid Position");
            }
            
        } else{
            System.out.println("Turn O");
            try{
                playO();
            }catch(positionException e){
                System.out.println("Invalid Position");
            }
        }
        
    }
    
    public int occupiedPosition(int position){
        
        if(!"a".equals(plays[position])){
            return -1;
        }
        return position;
    }
    
    public int draw(){
        int soma=0;
        
        for(int i=0;i<9;i++){
            if(plays[i]!="a"){
                soma+=1;
            }
        }
        
        if(soma==9){
            return 0;
        } else{
            return 1;
        }
        
    }
    
    
}
