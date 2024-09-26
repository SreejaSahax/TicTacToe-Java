import java.util.Scanner;
class TicTacToe {
    public static void main(String[] args) 
    {
        Scanner sc =new Scanner(System.in);
        char[][] board=new char[3][3];
        for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
        board[i][j]=' ';
    char player='X';
    boolean gameOver=false;
    while(!gameOver)
    {
        printBoard(board);
        boolean d=draw(board);
        if(d)
        {
            System.out.println("Match Draw");
            System.exit(0);
        }
        System.out.print("Player "+player+" enter row coordinates:");
        int row=sc.nextInt();
        System.out.print("Player "+player+" enter column coordinates:");
        int col=sc.nextInt();
        
        if(board[row][col]==' ')
        {
            board[row][col]=player;
            gameOver=haveWon(board,player);
            if(gameOver)
            {
                System.out.println("Player "+player+" has won"); 
            }
            else
            {
                player=(player=='X')?'O':'X';
            }
        }
        else
        System.out.println("Invalid move.Try Again");
    }
       printBoard(board);
    }
    public static boolean draw(char[][] board)
    {
        int f=0;
        for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
        if(board[i][j]!=' ')
        f++;
        if(f==9)
        return true;
        else return false;
    }
    public static boolean haveWon(char[][] board,char player)
       {
           for(int i=0;i<3;i++)
           {
               if(board[i][0]==player && board[i][1]==player && board[i][2]==player)
               return true;
           }
           for(int j=0;j<3;j++)
           {
               if(board[0][j]==player && board[1][j]==player && board[2][j]==player)
               return true;
           }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
        return true;
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
        return true;
        
        return false;
       }
    public static void printBoard(char[][] board)
    {
        for(int i=0;i<3;i++)
        {
        for(int j=0;j<3;j++)
        System.out.print(board[i][j]+"|");
        System.out.println();
        }
    }
    
}