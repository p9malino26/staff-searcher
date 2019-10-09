package com.patryk.spacecadets.staffsearcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.Scanner;

public class StaffSearcher
{
    private final String urlStart = "https://www.ecs.soton.ac.uk/people/";

    private void printNameFromURL(String url)
    {
        try
        {
            Document doc = Jsoup.connect(url).get();
            String personInfo = doc.title();

            if(personInfo.startsWith("People"))
            {
                System.out.println("No match found.");
            }else{
                System.out.println("Match found:\n" + personInfo);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void findPerson(String code)
    {
        System.out.println("Finding match...");
        String fullUrl = urlStart + code;
        printNameFromURL(fullUrl);
    }

    /*the entry point of the program.
    this creates an instance of StaffSearcher named app.
    the findPerson method of app will find the person with the code and will print their details.
    */
    public static void main(String[] args)
    {
        StaffSearcher app = new StaffSearcher();
        //Toolbox tb = new Toolbox();
        String userChoice = "y";
        Scanner myScanner = new Scanner(System.in);

        do{
            System.out.println("Enter the code:");
            String code = myScanner.nextLine();
            app.findPerson(code);
            System.out.println("Do you wish to enter another name? (Y/n)");
            userChoice = myScanner.nextLine();
            //TODO buffered character gets absorbed by input call, resulting in the loop re-running without
            //user intervention. Fix this.

        }while(!userChoice.equals("n"));
    
    }
}