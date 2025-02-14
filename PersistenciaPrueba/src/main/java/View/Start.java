/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import static DataAccess.ArrayController.readArray;
import static DataAccess.ArrayController.writeArray;
import static DataAccess.FileController.ArrayFileReader;
import static DataAccess.FileController.ArrayFileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fran Perez
 */
public class Start {
    
    private static void menu(){
        System.out.println("[1] Write");
        System.out.println("[2] Read");
        System.out.println("[3] Exit");
        System.out.println("Choose an option: ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int option;
        //read array
        ArrayFileReader();
        do{
            menu();
            try{
                switch(option=sc.nextInt()){
                    case 1 ->{
                        System.out.println("Enter position to write: ");
                        int pos = sc.nextInt();
                        System.out.println("Enter the value to write");
                        writeArray(pos, sc.nextInt());
                    }
                    case 2 ->{
                        System.out.println("Enter initial position: ");
                        int init = sc.nextInt();
                        System.out.println("Enter final position: ");
                        int aux [] = readArray(init, sc.nextInt());
                        System.out.println(Arrays.toString(aux));
                    }
                    case 3 ->{
                        //save array values into a file
                        ArrayFileWriter();
                    }
                    default ->{
                        System.out.println("Wrong option");
                    }
                }
            }catch(java.lang.NumberFormatException ex){
                sc.nextLine();
                System.out.println("This is not a valid argument");
                option = -1;
            }
        }while (option != 3);
    }
    
}
