import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }
    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            //scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }
    public String replaceHamlet(String text){
        //instantiating Pattern and making is equal to HAMLET
        Pattern p = Pattern.compile("HAMLET", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);

        //return and replaces all HAMLETS with LEON
        return m.replaceAll("LEON");

    }
    public String replaceHoratio(String text){
        //instantiating Pattern and making is equal to HORATIO
        Pattern p = Pattern.compile("HORATIO");
        Matcher m = p.matcher(text);

        //replaces all HORATIO with TARIQ if checking is true;
        return m.replaceAll("TARIQ");
    }



    public String getHamletData(){
        return hamletData;
    }



}
