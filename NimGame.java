/*
 * This code is part of assignment 3 for Programming and Software Development COMP90041
 * As part of the University of Melbourne. May 2020
 * Written by Rodrigo Naves Vargas Student ID: 1092880
 */



public class NimGame 
{
    private int upperBound;
    public String username1;
    private String username2;
    private String Fname1;
    private String Fname2;
    private String Lname1;
    private String Lname2;
    private int stones;
    private int stonesP1;
    private int stonesP2;
    private NimPlayer PosPlayer1;
    private NimPlayer PosPlayer2;
    private String winner = null;


    
    public void setPlayerNames(String Fname1, String Fname2, String Lname1, String Lname2)
    {
        this.Fname1 = Fname1;
        this.Fname2 = Fname2;
        this.Lname1 = Lname1;
        this.Lname2 = Lname2;
        
    }
    public void getPlayers(NimPlayer one, NimPlayer two)
    {
        PosPlayer1 = one;
        PosPlayer2 = two;
    }
    public String getWinner()
    {
        return winner;
    }

    public void startGame(int stones, int upperBound,String username1,String username2,String Fname1,String Lname1, String Fname2, String Lname2)
    {
        System.out.println("");
        System.out.println("Initial stone count: "+ stones);
        System.out.println("Maximum stone removal: "+ upperBound);
        System.out.println("Player 1: " + Fname1 + " " + Lname1);
        System.out.println("Player 2: " + Fname2 + " " + Lname2);
        System.out.println("");
       // stoneGenerator(stones);
        this.stones = stones;
        this.username1 = username1;
        this.username2 = username2;
        this.upperBound = upperBound;
                
    }  
    public void stoneGenerator(int s)
    {
        
        System.out.print (s +" stones left:");
        int counter3 = s;
        while (counter3 -1 >= 0)
            {
                System.out.print(" *");
                counter3--;
            }
        System.out.println();
    }


    public void gameSequence()
    {
        boolean checkedInput = false;
   
        outer: for ( int i=0; stones >=1; i++) 
        {   
//                Player 1 sequence
            checkedInput = false;
            while (checkedInput == false)
            {
                try
                {
                    stoneGenerator(stones);
                    System.out.println(Fname1+"'s turn - remove how many?");
                    if (PosPlayer1 instanceof NimHumanPlayer)
                    {
                        stonesP1 = PosPlayer1.removeStone();
                        System.out.println("");
                    }
                    else if (PosPlayer1 instanceof NimAIPlayer)
                    {
                        PosPlayer1.setParamRemoveStone(upperBound,stones);
                        stonesP1 = PosPlayer1.removeStone();
                        System.out.println("");
                    }
                    

                   
                    
                    if (stonesP1 > upperBound ) 
                        {
                            throw new stonesTooLarge("Invalid move. You must remove between 1 and " + upperBound + " stones.");     
                        }
                    else if (stonesP1 > stones ) // checking if Input is bigger than stones left in the game, then input  equals stones left in the game.
                        {
                            throw new stonesTooLarge("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                        }


                    else if (stonesP1 < 1 ) // checking if Input is bigger than stones left in the game, then input  equals stones left in the game.
                        {
                            throw new stonesTooSmall("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                        }
                    if (stonesP1 == stones ) // checking if Input is bigger than stones left in the game, then input  equals stones left in the game.
                        {
                            System.out.println("Game Over");
                            System.out.println(Fname2+" "+Lname2+" wins!");
                            System.out.println("");
                            winner = username2;
                            break outer;
                        }
                    else
                        {
                            stones = stones - stonesP1;
                            checkedInput = true;
                        }

                }
                catch(stonesTooLarge a)
                {
                    System.out.println("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    System.out.println("");
                }
                catch (stonesTooSmall b)
                {
                    System.out.println("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    System.out.println("");
                }
                catch (NumberFormatException d)
                {
                    System.out.println("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    System.out.println("");
//                    ScanningInput.reset();
                }
            }

        
        
        

        //                   Player 2 sequence
            checkedInput = false;
            while(checkedInput == false)
            {
                try
                {
                    stoneGenerator(stones);
                    System.out.println(Fname2+"'s turn - remove how many?");
                    if (PosPlayer2 instanceof NimHumanPlayer)
                    {
                        stonesP2 = PosPlayer2.removeStone();
                        System.out.println("");
                    }
                    else if (PosPlayer2 instanceof NimAIPlayer)
                    {
                        PosPlayer2.setParamRemoveStone(upperBound,stones);
                        stonesP2 = PosPlayer2.removeStone();
                        System.out.println("");
                    }

                    
                    if (stonesP2 > upperBound) 
                    {
                        throw new stonesTooLarge("Invalid move. You must remove between 1 and " + upperBound + " stones.");  
                    }
                    if (stonesP2 > stones ) // checking if Input is bigger than stones left in the game, then input  equals stones left in the game.
                    {
                        throw new stonesTooLarge("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    }
                    if (stonesP2 < 1 ) // checking if Input is bigger than stones left in the game, then input  equals stones left in the game.
                    {
                        throw new stonesTooSmall("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    }
                    if (stonesP2 == stones ) // checking if Input is bigger than stones left in the game, then input  equals stones left in the game.
                    {
                        System.out.println("Game Over");
                        System.out.println(Fname1+" "+Lname1+" wins!");
                        System.out.println("");
                        winner = username1;
                        break outer;
                    }
                    stones = stones - stonesP2;
                    checkedInput = true;
                    
                }
                catch(stonesTooLarge a)
                {
                    System.out.println("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    System.out.println("");
                }
                catch (stonesTooSmall b)
                {
                    System.out.println("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    System.out.println("");
                }

                catch (NumberFormatException a)
                {
                    System.out.println("Invalid move. You must remove between 1 and " + upperBound + " stones.");
                    System.out.println("");
//                    ScanningInput.reset();
                }
                
            }
        
        }
  }

    private static class stonesTooLarge extends Exception {

        public stonesTooLarge(String string) {
            super(string);
        }
    }
    private static class stonesTooSmall extends Exception{
        public stonesTooSmall(String string)
        {
            super(string);
        }
    }

}
        
    
    
    
   
