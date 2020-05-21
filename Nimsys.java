/*
 * Written by Rodrigo Naves Vargas
 */


public class Nimsys 
{
    public  NimPlayer playersInSystem [] = new NimPlayer[100];
    private NimGame game = new NimGame();
    public FileIO fileIO = new FileIO();
    private String commandInput1;
    private String[] inputText = new String [100];
    private boolean bool1 = false;
    private boolean bool2 = false;

    public static void main(String[] args) 
    {
        Nimsys nimsys = new Nimsys ();
        nimsys.Nimsys();
    }
    
    public void Nimsys()
    {
        System.out.println ("Welcome to Nim");
        System.out.println();
        fileIO.loader();
        playersInSystem = fileIO.transferArray();
        int i = 0;
        int exit = 0;

        while (exit == 0){
            System.out.print("$");
            commandInput1 = ScanningInput.nextLine();
            inputText = commandInput1.split(" |,");
            try{
                
            switch(inputText[0]){
            
                case "addaiplayer":
                    bool1=false;

                    for (int e = 0; e < playersInSystem.length ;e++)
                    {
                        if(playersInSystem[e] != null){
                            if (playersInSystem[e].getuserName().equals(inputText[1])){
                                        System.out.println("The player already exists.");
                                        System.out.println("");
                                        bool1=true;
                                        break;
                            }
                        }
                    }
                    if(bool1 == false)
                    {
                        for(i =0; i < playersInSystem.length ; i++)
                        {
                            if(playersInSystem[i] == null)
                            {
                                playersInSystem[i] = new NimAIPlayer(inputText[1],inputText[2],inputText[3]);
                                System.out.println("");
                                break;  
                            }
                        }
                    }
                    break;
                    
                case "addplayer":

                    bool1=false;

                    for (int e = 0;e < playersInSystem.length;e++)
                    {
                        if(playersInSystem[e] != null){
                            if (playersInSystem[e].getuserName().equals(inputText[1])){
                                        System.out.println("The player already exists.");
                                        System.out.println("");
                                        bool1=true;
                                        break;
                            }
                        }
                    }   

                    if(bool1 == false)
                    {
                        for(i =0; i < playersInSystem.length; i++)
                        {
                            if(playersInSystem[i] == null)
                            {
                                playersInSystem[i] = new NimHumanPlayer(inputText[1],inputText[2],inputText[3]);
                                System.out.println("");
                                break;  
                            }
                        }
                    }
                    break;

                case "removeplayer":
                    bool1 = false;
                    if (inputText.length > 1){
                        if (inputText[1] != null){
                            for (i=0 ;i < playersInSystem.length;i++) {
                                if(playersInSystem[i] != null)
                                {
                                    if (inputText[1].equals(playersInSystem[i].getuserName()))
                                    {
                                        playersInSystem[i] = null;
                                        bool1=true;
                                        System.out.println("");
                                        break;
                                    }
                                }
                            }
                            if(bool1 == false){
                                System.out.println("The player does not exist.");
                                System.out.println("");
                            }
                        }    
                    }
                    if (inputText.length <= 1){
                        String confirmation;
                        System.out.println("Are you sure you want to remove all players? (y/n)");
                        confirmation = ScanningInput.nextLine();
                        if(confirmation.equals("y")){
                            for (i=0;i < playersInSystem.length;i++){
                                playersInSystem[i] = null;
                            }
                            System.out.println("");
                        }
                        else{
                            System.out.println("");
                        }
                    }
                    break;                

                case "editplayer":
                    bool1 = false;
                    if (inputText.length > 1){
                        if (inputText[1] != null){
                            for(i=0; i < playersInSystem.length; i++){
                                if(playersInSystem[i] != null){
                                    if(inputText[1].equals(playersInSystem[i].getuserName())){
                                    playersInSystem[i].editPlayer(inputText[2],inputText[3]);
                                    System.out.println("");
                                    bool1 = true;
                                    }
                                }

                            }
                            if (bool1 == false ){
                                System.out.println("The player does not exist.");
                                System.out.println("");
                            }
                        }
                    }

                    break;

                case "resetstats":
                    bool1 = false;
                    if (inputText.length > 1){
                        if (inputText[1] != null){
                            for (i=0 ;i < playersInSystem.length;i++) {
                                if(playersInSystem[i] != null){
                                    if (playersInSystem[i].getuserName().equals(inputText[1])){
                                    playersInSystem[i].resetStatistics();
                                    System.out.println("");
                                    bool1 = true;
                                    break;
                                    }
                                }
                            }
                        }
                        if (bool1 == false){
                            System.out.println("The player does not exist.");
                            System.out.println("");
                        }
                    }
                    if (inputText.length <= 1){
                        String confirmation;
                        System.out.println("Are you sure you want to reset all players statistics? (y/n)");
                        confirmation = ScanningInput.nextLine();
                        if(confirmation.equals("y")){
                            for (i=0;i < playersInSystem.length;i++){
                                if(playersInSystem[i] != null){
                                    playersInSystem[i].resetStatistics();
                                } 
                            }
                            System.out.println("");
                        }
                        else{
                            System.out.println("");
                        }
                    }
                    break;
                case "displayplayer":
                    bool1 = false;
                    if (inputText.length > 1){
                        if (inputText[1] != null){

                            for (i=0 ;i < playersInSystem.length;i++) {
                                if(playersInSystem[i] != null){
                                    if (inputText[1].equals(playersInSystem[i].getuserName())){
                                        System.out.println(playersInSystem[i].displayPlayer());
                                        System.out.println("");
                                        bool1 = true;

                                    }
                                }
                            }
                            if (bool1 == false ){
                                System.out.println("The player does not exist.");
                                System.out.println("");
                            }
                        }    
                    }
                    if (inputText.length <= 1){
                        arraySortDesc(playersInSystem);
                        for (i=0;i < playersInSystem.length;i++){
                            if(playersInSystem[i] != null){
                                System.out.println(playersInSystem[i].displayPlayer());
                            } 
                        }
                        System.out.println(""); 
                    }
                    break;
                case "rankings":
                    if (inputText.length > 1){
                        if (inputText[1] != null){
                            if (inputText[1].equals("desc")){

                                arraySortDesc(playersInSystem);
                                for(i=0;i<playersInSystem.length;i++){
                                    if(playersInSystem[i] != null){
                                        if(playersInSystem[i].getRanking()>= 100)
                                                {
                                                 System.out.printf("%-1.0f%%%3s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName());
                                                }
                                        else if(playersInSystem[i].getRanking()>= 10 && playersInSystem[i].getRanking()<=99)
                                                {
                                                  System.out.printf("%-1.0f%%%4s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName());  
                                                }
                                        else if(playersInSystem[i].getRanking()< 10)
                                                {
                                                   System.out.printf("%-1.0f%%%5s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName()); 
                                                }  
                                    }    
                                }
                                System.out.println("");
                            }
                            else if(inputText[1].equals("asc")){
                                arraySortDesc(playersInSystem);
                                for(i=0;i<playersInSystem.length;i++){
                                    if(playersInSystem[i] != null){
                                       if(playersInSystem[i].getRanking()>= 100)
                                                {
                                                 System.out.printf("%-1.0f%%%3s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName());
                                                }
                                        else if(playersInSystem[i].getRanking()>= 10 && playersInSystem[i].getRanking()<=99)
                                                {
                                                  System.out.printf("%-1.0f%%%4s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName());  
                                                }
                                        else if(playersInSystem[i].getRanking()< 10)
                                                {
                                                   System.out.printf("%-1.0f%%%5s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName()); 
                                                }
                                    }    
                                }
                                System.out.println("");

                            } 
                        }
                    }
                    if (inputText.length <= 1){
                        arraySortDesc(playersInSystem);
                        for(i=0;i<playersInSystem.length;i++){
                           if(playersInSystem[i] != null){
                                if(playersInSystem[i].getRanking()>= 100)
                                        {
                                         System.out.printf("%-1.0f%%%3s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName());
                                        }
                                else if(playersInSystem[i].getRanking()>= 10 && playersInSystem[i].getRanking()<=99)
                                        {
                                          System.out.printf("%-1.0f%%%4s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName());  
                                        }
                                else if(playersInSystem[i].getRanking()< 10)
                                        {
                                           System.out.printf("%-1.0f%%%5s%02d%-8s%n",playersInSystem[i].getRanking(),"| ",playersInSystem[i].getGamesPlayed()," games | "+playersInSystem[i].getFirstName()+" "+playersInSystem[i].getLastName()); 
                                        }
                           } 
                        }
                        System.out.println("");
                    }
                    break;
                case "startgame":
                    bool1 = false;
                    bool2 = false;
                    int arrayPos1 =0;
                    int arrayPos2 = 0;
                    int initialStones =0;
                    int upperBound =0;
                    String username1 = null;
                    String username2 = null;
                    String Fname1 = null;
                    String Fname2 = null;
                    String Lname1 = null;
                    String Lname2 = null;
                    if (inputText.length == 5){
                        
                        if (inputText[3] != null){//checking username for player 1 is valid
                           for(i=0;i < playersInSystem.length;i++){
                                if(playersInSystem[i] != null){
                                    if (inputText[3].equals(playersInSystem[i].getuserName())){
                                        arrayPos1 = i;
                                        username1 = playersInSystem[i].getuserName();
                                        Fname1 = playersInSystem[i].getFirstName();
                                        Lname1 = playersInSystem[i].getLastName();
                                        bool1 = true;
                                        break;
                                    }
                                }
                            }
                            if (bool1 == false){
                                System.out.println("One of the players does not exist.");
                                System.out.println("\n");
                            }   

                        }
                        if (inputText[4] != null){ //checking username for player 2 is valid
                           for(i=0;i<playersInSystem.length;i++)
                           {
                                if(playersInSystem[i] != null){
                                    if (inputText[4].equals(playersInSystem[i].getuserName())){
                                        arrayPos2 = i;
                                        username2 = playersInSystem[i].getuserName();
                                        Fname2 = playersInSystem[i].getFirstName();
                                        Lname2 = playersInSystem[i].getLastName();
                                        bool2 = true;
                                        initialStones = Integer.parseInt(inputText[1]);
                                        upperBound = Integer.parseInt(inputText[2]);
                                        break;
                                    }
                                }
                            }
                            if(bool2 == false){
                            System.out.println("One of the players does not exist.");
                            System.out.println("");
                            }

                        } 
                    }
                    if(bool1 ==true && bool2 == true){
                        game.startGame(initialStones,upperBound, username1, username2,Fname1,Lname1,Fname2,Lname2);
                        game.setPlayerNames(Fname1, Fname2, Lname1, Lname2);
                        game.getPlayers(playersInSystem[arrayPos1], playersInSystem[arrayPos2]);
                        playersInSystem[arrayPos1].addGamesPlayed();
                        playersInSystem[arrayPos2].addGamesPlayed();
                        game.gameSequence();
                        if (game.getWinner().equals(playersInSystem[arrayPos1].getuserName()))
                        {
                            playersInSystem[arrayPos1].addScore();
                        }
                        else if (game.getWinner().equals(playersInSystem[arrayPos2].getuserName()))
                        {
                            playersInSystem[arrayPos2].addScore();
                        }
                        ScanningInput.reset();
                    }

                    break;
                case "exit":
                    fileIO.saver(playersInSystem);
                    System.out.println("");
                    System.exit(0);
                     break; 

                default:
                      throw new notValidCommandException ("'"+inputText[0]+"'"+" is not a valid command.");
//                  break;
//                System.out.println("'"+inputText[0]+"'"+" is not a valid command.");
//                System.out.println(" ");

            }

        }
        catch (notValidCommandException e)
        {
            System.out.println("'"+inputText[0]+"'"+" is not a valid command.");
            System.out.println(" ");        
        }
        catch(Exception tooManyArgs)
        {
            System.out.println("Incorrect number of arguments supplied to command.");
            System.out.println("");
        }

        }
    }
    

    
    public void arraySortAsc(NimPlayer [] A)
    {
        NimPlayer temp;
        for (int i=0; i < A.length; i++)
        {
            for(int j=i+1; j < A.length; j++)
            {
                if (A[j] != null && A[i] != null)
                {
                    if (A[i].getRanking() > A[j].getRanking())
                            {
                                temp = A [i];
                                A [i] = A [j];
                                A [j] = temp;
                            }
                    if(A[i].getRanking() == A[j].getRanking())
                    {
                        if(A[i].getuserName().compareTo(A[j].getuserName()) == -1)
                            {
                                temp = A [i];
                                A [i] = A [j];
                                A [j] = temp;
                            }
                    }
                }
            }
        }
    }
    public void arraySortDesc(NimPlayer [] A)
    {
        NimPlayer temp;
        for (int i=0; i < A.length; i++)
        {
            for(int j=i+1; j < A.length; j++)
            {
                if (A[j] != null && A[i] != null)
                {
                    if (A[i].getRanking() < A[j].getRanking())
                            {
                                temp = A [i];
                                A [i] = A [j];
                                A [j] = temp;
                            }
                    if(A[i].getRanking() == A[j].getRanking())
                    {
                        if(A[i].getuserName().compareTo(A[j].getuserName()) == -1)
                            {
                                temp = A [i];
                                A [i] = A [j];
                                A [j] = temp;
                            }
                    }
                    
                    
                }
            }
        }
    }
    
    public class notValidCommandException extends Exception {

    public notValidCommandException(String string) {
        super(string);
    }

}
}
        
        
        
    
               

    
