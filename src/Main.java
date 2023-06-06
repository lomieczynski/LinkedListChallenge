import javax.print.DocFlavor;
import javax.swing.text.html.HTMLDocument;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

record Towns (String name, int distance) {

        @Override
        public String toString() {
            return String.format("%d %s",distance, name.toUpperCase());
              }

}
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        var townsList = new LinkedList<Towns>();
        townsList.add(new Towns("Sidney",0));
        townsList.add(new Towns("Adelaide",1374));
        townsList.add(new Towns("Alice Springs",2771));
        townsList.add(new Towns("Brisbane",917));
        townsList.add(new Towns("Darwin",3972));
        townsList.add(new Towns("Melbourne",877));
        townsList.add(new Towns("Perth",3923));

        boolean flag = true;
        int index = 0;
        var iterator = townsList.listIterator(index);
        while (flag) {
           printMenu();
            switch (scanner.nextLine()){
                case "N" -> {
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    } else {System.out.println(townsList.getLast());}
                }
                case "P" -> {
                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    } else {System.out.println(townsList.getFirst());}
                }
                case "Forward", "F" -> forward(townsList);
                case "Backward", "B" -> backward(townsList);
                case "List Places", "L" -> listPlaces(townsList);
                case "Menu", "M" -> printMenu();
                case "Q", "Quit" -> flag = false;
                default -> System.out.println("Try again.");
            }
        }
    }
    public static void printMenu () {
        String textBlock = """
                Available actions (select word or letter):
                (N)ext
                (P)ast
                (F)orward 
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """;
        System.out.println(textBlock + " ");
    }
    public static void forward (LinkedList<Towns> listOfTowns) {
        System.out.println("Add the city: ");
        String nameOfCity = scanner.nextLine();
        System.out.println("Add the distance from Sidney: ");
        int distanceFromSidney = Integer.parseInt(scanner.nextLine());
        var iterator = listOfTowns.iterator();
        boolean addQuestion = false;
        while (iterator.hasNext()) {
            if (iterator.next().name().equals(nameOfCity)) {
                System.out.println(nameOfCity + " was added to the list earlier ");
                addQuestion=true;
                break;
            }
        }
        if(!addQuestion) {
            listOfTowns.addFirst(new Towns(nameOfCity, distanceFromSidney));
            System.out.println(listOfTowns.toString());
        }
        System.out.println("");
    }
    public static void backward (LinkedList<Towns> listOfTowns) {
        System.out.println("Add the city: ");
        String nameOfCity = scanner.nextLine();
        System.out.println("Add the distance from Sidney: ");
        int distanceFromSidney = Integer.parseInt(scanner.nextLine());
        var iterator = listOfTowns.iterator();
        boolean addQuestion = false;
        while (iterator.hasNext()) {
            if (iterator.next().name().equals(nameOfCity)) {
                System.out.println(nameOfCity + " was added to the list earlier ");
                addQuestion=true;
                break;
            }
        }
        if(!addQuestion) {
            listOfTowns.addLast(new Towns(nameOfCity, distanceFromSidney));
            System.out.println(listOfTowns.toString());
        }
        System.out.println("");
    }
    public static void listPlaces (LinkedList<Towns> listOfTowns ) {
        listOfTowns.sort(Comparator.comparing(Towns::distance));
        System.out.println(listOfTowns.toString());
        System.out.println("");
    }

}