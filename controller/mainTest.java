package controller;

import java.util.HashMap;
import java.util.Map;

public class mainTest {

    
        public static String pangramCheck(String s) {
            s.toLowerCase();
            Map<Character, Boolean> alpha = new HashMap<Character, Boolean>();
            for(char ch = 'a';ch <= 'z'; ch++){
                alpha.put(ch, false);
            }
            for(int i = 0; i < s.length(); i++){
                Character ch = s.charAt(i);
                if(alpha.containsKey(ch)){
                    alpha.replace(ch, true);
                }
            }
            for(Character ch = 'a';ch <= 'z'; ch++){
                if(alpha.get(ch) == false){
                    return "not pangram";
                }
            }
            return "pangram";
    
        }
    
        public static void main(String[] args) {
            System.out.println(pangramCheck("We promptly judged antique ivory buckles for the next prize"));
        }
    }
