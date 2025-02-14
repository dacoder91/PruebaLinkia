package DataAccess;

/**
 *
 * @author Fran Perez
 */
public class ArrayController {
    
    private final static int numbers [] = new int [5];
    
    //Encapsulación
    public static int [] getNumbers(){
        return numbers;
    }
    
    public static void writeArray (int pos, int value){
        if(0<= pos && pos <numbers.length){
            numbers[pos]=value;
        }else{
            System.out.println("Can not write at " + pos + " because array is " + numbers.length + " length");
        }
    }
    
    public static int[] readArray (int init, int end){
        if(init <= end && 0<=init && end < numbers.length){
            int [] aux = new int[end-init+1];
            for(int i = 0; i < end-init+1; i++){
                aux[i] = numbers[init+i];
            }
            return aux;
        }
        return null;
    }
    
    
    
}
