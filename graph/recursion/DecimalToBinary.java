public class DecimalToBinary {
    
    public static void main(String[] args) {
        System.out.println(decimalToBinary(10, ""));
    }
    private static String decimalToBinary(int decimal, String result){
        if(decimal == 0){
            return result;
        }

        result =  decimal % 2 + result;
        
        return decimalToBinary(decimal /2 , result);
    }
}
