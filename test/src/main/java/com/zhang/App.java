package com.zhang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String repeatStr = "aaayzzzysssbbdddccclllc";
        System.out.println("=========================begin to solve step1 problem=========================");
        reMoveRepeatCharacterStr(repeatStr);
        System.out.println("=========================begin to solve advanced problem=========================");
        replaceRepeatCharacterStrByBefore(repeatStr);
    }

    private static void reMoveRepeatCharacterStr(String repeatStr){
        String atozRepeatReg = "a{3,}|b{3,}|c{3,}|d{3,}|e{3,}|f{3,}|g{3,}|h{3,}|i{3,}|j{3,}|k{3,}|l{3,}|m{3,}|n{3,}|o{3,}|p{3,}|q{3,}|r{3,}|s{3,}|t{3,}|u{3,}|v{3,}|w{3,}|x{3,}|y{3,}|z{3,}";
        Pattern pattern = Pattern.compile(atozRepeatReg);
        while (pattern.matcher(repeatStr).find()){
            String unRepeated = repeatStr.replaceAll(atozRepeatReg, "");
            System.out.println("->" + unRepeated);
            repeatStr = unRepeated;
        }
    }

    private static void replaceRepeatCharacterStrByBefore(String repeatStr) {
        char z = 'z';
        do{
            String characterReg = z +"{3,}";
            z-=1;
            String beforeCharacterStr = String.valueOf(z);
            Pattern pattern = Pattern.compile(characterReg);
            Matcher matcher = pattern.matcher(repeatStr);
            while (matcher.find()){
                String toBeReplaced = matcher.group(0);
                String unRepeated = repeatStr.replaceAll(characterReg, beforeCharacterStr);
                System.out.println(String.format("->%s, %s is replaced by %s", unRepeated, toBeReplaced, beforeCharacterStr));
                repeatStr = unRepeated;
            }
        }while (z >= 'a');
    }
}
