import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean hasNotes = false; //tracker for previous notes

        System.out.println("=== Welcome to Your Notepad ===");

        try {
            FileReader notesReader = new FileReader("notepad.txt");
            BufferedReader bufferedReader = new BufferedReader(notesReader);
            String lines;

            while ((lines = bufferedReader.readLine()) != null) {
                //below line only works once due to the boolean tracker
                if(!hasNotes){
                    System.out.println("Your current notes: ");
                    hasNotes = true;
                }
                System.out.println(lines);
            }

            //for aesthetics (it only works if the notepad had text from before)
            if(hasNotes){
                System.out.println();
            }

            System.out.print("Please enter your note: ");
            String text = scanner.nextLine();

            FileWriter notepadWriter = new FileWriter("notepad.txt", true);
            PrintWriter printWriter = new PrintWriter(notepadWriter);
            printWriter.println(text);
            System.out.println();
            System.out.println("Your note has been saved. Goodbye...");
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}