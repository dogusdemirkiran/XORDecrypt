
package xordecrypt;

import java.util.Scanner;

public class XORDecrypt {
    static String value = "SampleStringToBeEncrypted";
    static String keyval = "thisIsAKey";
    
   
        public static void main(String args[]) { // test                
        int[] encrypted = encrypt(value,keyval);
        for(int i = 0; i < encrypted.length; i++)
            System.out.printf("%d,", encrypted[i]);
        System.out.println("");
        System.out.println(decrypt(encrypted,keyval));        
    }

    private static int[] encrypt(String str, String key) {
        int[] output = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            int o = (Integer.valueOf(str.charAt(i)) ^ Integer.valueOf(key.charAt(i % (key.length() - 1)))) + '0';
            output[i] = o;
        }
        return output;        
    }

    private static int[] string2Arr(String str) {
        String[] sarr = str.split(",");
        int[] out = new int[sarr.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = Integer.valueOf(sarr[i]);
        }
        return out;
    }

    private static String decrypt(int[] input, String key) {
        String output = "";        
        for(int i = 0; i < input.length; i++) {
            output += (char) ((input[i] - 48) ^ (int) key.charAt(i % (key.length() - 1)));
        }
        return output;
    }
    
}
