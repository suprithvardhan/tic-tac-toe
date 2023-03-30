import java.util.Scanner;
import java.util.*;
public class TicTacToe
{
	public static void main(String[] args) {
		char panel[][] = new char[3][3];
		char player='x';
		boolean gameOver= false;
		int r=0,c=0,count=0;
		for(int i=0; i<3;i++)
		{
		    for(int j=0;j<3;j++)
		    {
		        panel[i][j] = ' ';
		    }
		}
		Scanner input = new Scanner(System.in);
		while(!gameOver)
		{
		    displayPanel(panel);
		    count = check(panel);
		    if(count == 9)
		    {
		        System.out.println("********** GAME OVER **********");
		        break;
		    }
		    else{
               try {
                    System.out.println("enter player " + player);
                    r = input.nextInt();
                    c = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter integers only!");
                    input.next();
                    continue;
                }
		    }
		    if(panel[r][c] == ' ')
		    {
		        panel[r][c] = player;
		       gameOver = checkWin(panel,player);
		       if(gameOver)
		       {
		           displayPanel(panel);
		          System.out.println("player "+player+" has won");
		       }
		       else{
		           player = (player=='x') ?'o':'x';
		       }
		    }
		    else
		    {
		       System.out.print("enter valid position");
		    }
		}
	}
	public static void displayPanel(char panel[][])
	{
	    for(int i=0;i<3;i++)
	    {
	        for(int j=0;j<3;j++)
	        {
	            System.out.print(panel[i][j]+"| ");
	        }
	        System.out.println();
	    }
	}
	public static boolean checkWin(char panel[][],char player)
	{
	    for(int i=0;i<3;i++)
	    {
	        if(panel[i][0] == player && panel[i][1]==player && panel[i][2]==player)
	            return true;
	    }
	     for(int i=0;i<3;i++)
	    {
	        if(panel[0][i]==player && panel[1][i]==player && panel[2][i]==player)
	             return true;
	    }
	    if(panel[0][0]==player && panel[1][1]==player && panel[2][2]==player)
	            return true;
	   if(panel[2][0]==player && panel[1][1]==player && panel[0][2]==player)
	            return true;
	   return false;
	}
	public static int check(char panel[][])
	{
	    int count=0;
	    for(int i=0; i<3;i++)
		{
		    for(int j=0;j<3;j++)
		    {
		        if(panel[i][j] != ' ')
		        count++;
		    }
		}
		return count;
	}
}