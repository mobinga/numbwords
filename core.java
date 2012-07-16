package numbwords;

public class core {

     static String dec [] = " zero, one, two, three, four, five, six, seven, eight, nine".split(",");
     static String teens[] = ", eleven, twelve, thirteen, fourteen, fifteen, sixteen , seventeen, eighteen, nineteen".split(",");
     static String tens[] = ", ten, twenty, thirty, fourty, fifty, sixty, seventy, eighty, ninety".split(",");
     static String sands[] = ", hundred, thousand".split(",");

public static String parse(String s){
    
    s = s.trim();
    s = s.replaceAll(",", "");
    s = s.replaceAll(" ", "");

    try {
        Integer.parseInt(s);
    } catch (NumberFormatException ex) {
        return "Not a valid integer";
    }

    switch(s.length()){
        
         case 1:
             return ( upperCase(dec[intRep(s)].trim()) );
             
         case 2:
             return ( upperCase(twoDigits(s).trim()) );
             
         case 3:
             return ( upperCase(threeDigits(s).trim()) );
             
         case 4:
             return ( upperCase(fourDigits(s).trim()) );
             
         case 5:
             return ( upperCase(fiveDigits(s).trim()) );
             
         case 6:
             return ( upperCase(sixDigits(s).trim()) );
             
         default:
             return "Invalid String";
             
     }
     
    }

    public static String twoDigits(String s){
        
        if( s.startsWith("1") && (Character.toString(s.charAt(1)).equals("0")) ){
             return tens[intRep(Character.toString(s.charAt(0)))];
        }
        
        else if ( !s.startsWith("1") && (Character.toString(s.charAt(1)).equals("0")) ) {
            return tens[intRep(Character.toString(s.charAt(0)))];
        }
        
        else if (s.startsWith("1") && !(Character.toString(s.charAt(1)).equals("0"))){
               return teens[intRep(Character.toString(s.charAt(1)))];
            }
        
        else {
                String twos = tens[intRep(Character.toString(s.charAt(0)))];
                String ones = dec[intRep(Character.toString(s.charAt(1)))];
            return twos + ones;
        }
    }

    public static String threeDigits(String s){
        
        if(s.equals("000")){
            return "";
        }
        
        else if(s.charAt(0) == '0' && s.charAt(1) == '0' ){
            return dec[intRep(Character.toString(s.charAt(2)))];
        }
        
        else if(s.charAt(1) == '0' && s.charAt(2) != '0') {
            return dec[intRep(Character.toString(s.charAt(0)))] + sands[1] + " and" + dec[intRep(Character.toString(s.charAt(2)))] ;
        }
        
        else if (s.charAt(1) == '0' && s.charAt(2) == '0'){
            return dec[intRep(Character.toString(s.charAt(0)))] + sands[1];
        }
        
        else{
            return intRep(Character.toString(s.charAt(0))) != 0 ? dec[intRep(Character.toString(s.charAt(0)))] + sands[1] + " and" + twoDigits(s.substring(1)) : " and" + twoDigits(s.substring(1));
        }
        
    }

    public static String fourDigits(String s){
        return dec[intRep(Character.toString(s.charAt(0)))] + sands[2] + threeDigits(s.substring(1));
    }

    public static String fiveDigits(String s){
        
            if(s.substring(1).equals("0000")){
                return tens[intRep(Character.toString(s.charAt(0)))] + sands[2];
            }
            
            else if(s.charAt(0) == '1' && s.charAt(1) >= 1){
                return twoDigits(s.substring(0, 2)) + sands[2] + threeDigits(s.substring(2, 5));
            }
            
            else if(s.charAt(1) == '0'){
                return tens[intRep(Character.toString(s.charAt(0)))] + sands[2] + threeDigits(s.substring(2));
            }
            
        return tens[intRep(Character.toString(s.charAt(0)))] + dec[intRep(Character.toString(s.charAt(1)))] + sands[2] + threeDigits(s.substring(2));
    }

    public static String sixDigits(String s) {
        return dec[intRep(Character.toString(s.charAt(0)))] + sands[1] + fiveDigits(s.substring(1));
    }

    public static int intRep(String s){
        return Integer.parseInt(s);
    }

    public static String upperCase(String s){
        return s.equals("") ? "Null String" : Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
    }

}