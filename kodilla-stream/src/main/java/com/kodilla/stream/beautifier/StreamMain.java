package com.kodilla.stream.beautifier;

public class StreamMain {
    public static void main(String[] args) {


        PoemBeautifier poemBeautifier = new PoemBeautifier();

        //Upiększacz doddający na początku i na końcu tekstu "ABC"
        PoemDecorator addABC = tekst -> "ABC" +  tekst + "ABC";
        System.out.println(poemBeautifier.beautify("Ladny obraz", addABC));

        //Upiększacz zmienia tekst na duże litery
        PoemDecorator toUpperCase = String::toUpperCase;
        System.out.println(poemBeautifier.beautify("Ladny obraz", toUpperCase));

        //Własny upiększacz -> będzie to dodanie na początku tekstu liczb: 756 i na końcu liczb: 199
        PoemDecorator add756and199 = tekst -> "756" + tekst + "199";
        System.out.println(poemBeautifier.beautify("Piekna palma", add756and199));

        //Własny upiększacz -> będzie to zmiana tesktu na małe litery
        PoemDecorator toLowerCase = String::toLowerCase;
        System.out.println(poemBeautifier.beautify("PieKnA PaLMA", toLowerCase));
    }
}
