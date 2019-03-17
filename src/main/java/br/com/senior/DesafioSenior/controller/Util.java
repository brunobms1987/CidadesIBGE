package br.com.senior.DesafioSenior.controller;

public class Util {

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean stringToBoolean(String s) {
        return s.trim().equals("true") ? true : false;
    }
}
