package DataAccess;

import static DataAccess.ArrayController.getNumbers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Fran Perez
 */
public class FileController {
    
    final static String PROPATH = System.getProperty("user.dir");
    final static String SEP = File.separator;
    final static String FILEPATH = PROPATH + SEP + "ArrayFile.txt";
    
    public static void ArrayFileWriter(){
        File f = new File (FILEPATH);
        FileWriter fw = null;
        BufferedWriter bw =null;
        
        try{
            if(!f.exists()){
                System.out.println("Creating " + FILEPATH + " archive");
                f.createNewFile();
            }
            if(f.canWrite()){
                fw = new FileWriter(f, false); //no lo abrimos en modo append
                bw = new BufferedWriter(fw);
                String text = "";
                for(int a : getNumbers()){
                    text += a + "\t";
                }
                bw.write(text);
            }
            if(bw != null)
                bw.close();
        }catch (IOException e){
            System.out.println("Something wrong has happened");       
        }
    }
    
    public static void ArrayFileReader(){
        File f = new File (FILEPATH);
        FileReader fr = null;
        BufferedReader br =null;
        
        try{
            if(!f.exists()){
                System.out.println("File " + FILEPATH + " doesn't exist");
                System.out.println("Array filled with default value (0)");
            }
            if(f.canRead()){
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                String linea = br.readLine();
                String aux [] = linea.split("\t");
                for(int i = 0; i < getNumbers().length; i++)
                    getNumbers()[i] = Integer.parseInt(aux[i]);
            }
            if(br != null)
                br.close();    
        }catch (Exception e){
            System.out.println("Something wrong has happened");       
        }
    }
    
}
