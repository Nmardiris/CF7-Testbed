package gr.aueb.cf.ch7;

public class IndexOfSubStringApp {

    public static void main(String[] args) {
        String cf = "Coding Factory ";

        int positionOfo = cf.indexOf("o"); // παιρνει απο την θέση 1
        int positionOfSecondo = cf.indexOf("0", 2); //
        int lastPositionOfo = cf.lastIndexOf("o");

        String cf2 = cf.substring(0); // "coding factory"
        String slice = cf.substring(1,3); // θα έφερνε το od
    }
}
