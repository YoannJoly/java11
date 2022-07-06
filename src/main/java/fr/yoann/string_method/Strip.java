package fr.yoann.string_method;


public class Strip {

    public static void main(String[] args) {

        String str = "  Hello World !!   ";

        System.out.println(str.strip());      //"Hello World !!"

        System.out.println(str.trim());

        System.out.println(str.stripLeading()); //"Hello World !!   "

        System.out.println(str.stripTrailing());  //"  Hello World !!"

    }
}
