import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // Import this class to create lists

public class gamep1 {
    public static void main(String[]args){

        // create player 1 list
        ArrayList<Integer> lista1 = new ArrayList<Integer>();
        int[] temp1 = new int[25];
        try {
            File cards1 = new File("cards1.txt");
            Scanner myReader = new Scanner(cards1);
            for (int index = 0; index < temp1.length; index++) {
                int data = myReader.nextInt();
                lista1.add(data);
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // create player 2 list
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        int[] temp2 = new int[25];
        try {
            File cards2 = new File("cards2.txt");
            Scanner myReader = new Scanner(cards2);
            for (int index = 0; index < temp2.length; index++) {
                int data = myReader.nextInt();
                lista2.add(data);
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // while loop to play the game
        ArrayList<Integer> winner = new ArrayList<Integer>();
        boolean loop = true;
        while(loop){
            // check player 1 win round
            if(lista1.get(0) > lista2.get(0)){
                lista1.add(lista1.get(0));
                lista1.add(lista2.get(0));
            }

            // check player 2 win round
            if(lista2.get(0) > lista1.get(0)){
                lista2.add(lista2.get(0));
                lista2.add(lista1.get(0));
            }

            // take out played card from front of list
            lista1.remove(0);
            lista2.remove(0);

            // check if list is empty
            if(lista1.isEmpty()){
                loop = false;
                winner = lista2;
            }
            if(lista2.isEmpty()){
                loop = false;
                winner = lista1;
            }
        }
        
        // count winner points
        int sum = 0;
        for(int q = 0; q < winner.size(); q++){
            sum += winner.get(q) * (winner.size()-q);
        }

        // print points
        System.out.println("points: "+sum);
    }
}
