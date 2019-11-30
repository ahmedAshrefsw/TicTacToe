
package game;
import java.util.Scanner;
// this fiile is a sample work to run xo game 
public class Game {
    public static char[][] Board = new char[3][3];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // U NEED TO ASK FOR A PLACE 1-9
        // U NEED TO ASK FOR A MOVE X OR O
        printBoard();
        int place;
        char symbol;
        for(int i = 0 ; i<8;i++){
            System.out.println("enter the place you want to play in *from 1-9* ");
            place = input.nextInt();
            System.out.println("enter your move *x or o* ");
            symbol= input.next().charAt(0);
            playerMove(place,symbol);
            showUpdate(Board);
            if (cheackForWin(Board)==1){
                System.out.println("X wins");
            }
            if (cheackForWin(Board)==0){
                System.out.println("O wins");
            }
        }

        
       }
    
    
public static void playerMove(int place , char move){
    switch (place){
        case 1:
            Board[0][0] = move;
            break;
        case 2:
            Board[0][1] = move;
            break;
        case 3:
            Board[0][2] = move;
            break;
        case 4:
            Board[1][0] = move;
            break;
        case 5:
            Board[1][1] = move;
            break;
        case 6:
            Board[1][2] = move;
            break;
        case 7:
            Board[2][0] = move;
            break;
        case 8:
            Board[2][1] = move;
            break;
        case 9:
            Board[2][2] = move;
            break;
    }
}
public static void printBoard(){ 
    for(int row = 0 ; row<3; row++){
        System.out.print("|");
        for(int col = 0 ; col<3;col++){
            Board[row][col]='_';
            System.out.print(Board[row][col]+"|");
            
        }
        System.out.println();
    }
}
public static void showUpdate(char[][] board){
    for(int row = 0 ; row<3; row++){
        System.out.print("|");
        for(int col = 0 ; col<3;col++){
            System.out.print(Board[row][col]+"|");    
        }
        System.out.println();
    }
}
public static int cheackForWin(char[][] board){
    int resultx = 0; 
    int resulto = 0;
    
    // cheak for diagonal first 
    for(int row = 0 ; row<3;row++){
        for(int col=0;col<3;col++ ){
            if (row==col && Board[row][col]=='x'){
                resultx+=1;
            }else if (row==col && Board[row][col]=='o'){
                resulto+=1;
            }
        }
        if(resultx==3){
            return 1;
            }
        if(resulto==3){
            return 0;
            }
    }
    resultx = 0; resulto=0;
    // cheack on onther diagonal
    if(Board[0][2]==Board[1][1] && Board[1][1]==Board[2][0] && Board[2][0]=='x' ){
        return 1;
    }
    if(Board[0][2]==Board[1][1] && Board[1][1]==Board[2][0] && Board[2][0]=='o' ){
        return 0;
    }
// cheack for 2 diagonal completed 

    // cheack ver 
    for(int row = 0 ; row<3;row++){
        for(int col = 0 ;col<3;col++){
            if(Board[row][col]=='x'){
                resultx+=1;
            }else if (Board[row][col]=='o'){
                resulto+=1;
            }
        }
        if(resultx==3) return 1;
        else if (resulto==3) return 0 ;
        else resultx = 0; resulto=0;
    }
// ver cheack ends 
    // chaeck for hirzontal 
    for (int col = 0 ; col<3;col++){
        int temp = 0;
        if(Board[temp][col] == Board[temp+1][col] && Board[temp+1][col]== Board[temp+2][col] && Board[temp+2][col]== 'x'){
            return 1;
        }
        if(Board[temp][col] == Board[temp+1][col] && Board[temp+1][col]== Board[temp+2][col] && Board[temp+2][col]== 'o'){
            return 0;
        }
        
    }

    
    return 5 ;
        
    
    
        
        
        
        
}
}
