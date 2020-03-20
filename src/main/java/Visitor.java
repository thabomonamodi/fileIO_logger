import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Scanner;
public class Visitor
{
    private static final Logger log = LogManager.getLogger(Visitor.class.getName());
    public static String fullname, comments, person_assisted;
    public static LocalDate visitDate;
    public static LocalTime visitTime;
    public static int age;

    public Visitor(String fullname, int age, LocalDate visitDate, LocalTime visitTime, String comments, String person_assisted)
    {
        this.fullname = fullname;
        this.age = age;
        Visitor.visitDate = visitDate;
        this.visitTime = visitTime;
        this.comments = comments;
        this.person_assisted = person_assisted;

    }
    public static void save()throws IOException
    {
        FileWriter writeTo = null;
        try
        {
            if (!fullname.isEmpty())
            {
                File writer = new File("visitor_"+fullname.toLowerCase().replace(" ", "_")+".txt");
                writeTo = new FileWriter(writer.getName());
                writeTo.write(fullname+"\n"+age+"\n"+visitDate.now()+"\n"+visitTime.now()+"\n"+comments+"\n"+person_assisted);
                log.info("File created successfully");
            }
            writeTo.close();
        }
        catch (FileNotFoundException e)
        {
            log.error("experienced an error while creating your file"+e.getMessage());
        }
    }
    public static void load(String fname)throws IOException
    {
        //Scanner scan = new Scanner(new FileReader(fname));
        String line = null;
        FileReader reads = null;
        fname = "visitor_"+fname.toLowerCase().replace(" ","_"+".txt");
        File reader = new File(fname);
        if (reader.exists())
        {
            reads = new FileReader(reader);
            while (line!=null)
            {
                log.info(line);
            }
        }
    }
    public static void main(String[]args)throws IOException
    {
        Scanner scan = new Scanner(System.in);
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        /*System.out.println("Please enter your full name");
        fullname = scan.nextLine();
        System.out.println("Please enter your age");
        age = scan.nextInt();
        System.out.println("Please write any comment");
        comments = scan.next();
        System.out.println("Please enter the name of the person who assisted you with the visit");
        person_assisted = scan.nextLine();
        save();*/
        System.out.println("would yo like to retrieve a file? y/n");
        String ans = scan.nextLine();
        while(ans!="n"||ans!="N")
        {
            System.out.println("Please provide a name to load a file.");
            String name = scan.nextLine();
            load(name);
        }
    }
}
