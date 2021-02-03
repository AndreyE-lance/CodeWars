package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
///Что-то не так с тестом. До лучших времен.
public class Dinglemouse {

    public static int kings = 0;
    public static int moves = 0;

    public static void main(String[] args) {
        //String[] cards = new String[]{"7", "6", "K", "2", "3", "J", "10", "2", "J", "10", "Q", "7", "9", "9", "Q", "3", "8", "8", "Q", "K", "6", "6", "2", "9", "A", "2", "4", "8", "8", "3", "4", "5", "K", "7", "5", "5", "A", "J", "4", "K", "A", "J", "5", "7", "3", "9", "10", "6", "10", "4", "Q", "A"};
        //String[] cards = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
         String suit[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
         List<String> cards = new ArrayList<String>() {{
            addAll(Arrays.asList(suit));
            addAll(Arrays.asList(suit));
            addAll(Arrays.asList(suit));
            addAll(Arrays.asList(suit));
        }};
        System.out.println(patience(cards.toArray(new String[0])));
    }

    public static int patience(String[] cards) {
        // Your code here!
        String[][] clock = new String[4][26];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                clock[i][j] = cards[index];
                index++;
            }
        }

        showArray(clock);
        System.out.println();
        play(12, clock);
        showArray(clock);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 52-moves;
    }

    public static void play(int startPos, String[][] clock) {
        moves++;
        int i = 0;
        int newPos = 0;
        while (clock[i][startPos].equals("-")) {
            i++;
        }
        String card = clock[i][startPos];
        clock[i][startPos] = "-";
        int j = 0;
        int nextPos = 0;
        switch (card) {
            case "A":
                newPos = 0;
                nextPos = 13;
                break;
            case "2":
                newPos = 1;
                nextPos = 14;
                break;
            case "3":
                newPos = 2;
                nextPos = 15;
                break;
            case "4":
                newPos = 3;
                nextPos = 16;
                break;
            case "5":
                newPos = 4;
                nextPos = 17;
                break;
            case "6":
                newPos = 5;
                nextPos = 18;
                break;
            case "7":
                newPos = 6;
                nextPos = 19;
                break;
            case "8":
                newPos = 7;
                nextPos = 20;
                break;
            case "9":
                newPos = 8;
                nextPos = 21;
                break;
            case "10":
                newPos = 9;
                nextPos = 22;
                break;
            case "J":
                newPos = 10;
                nextPos = 23;
                break;
            case "Q":
                newPos = 11;
                nextPos = 24;
                break;
            case "K":
                kings++;
                newPos = 12;
                nextPos = 25;
                break;
        }

        while (clock[j][nextPos] != null) {
            j++;
        }

        clock[j][nextPos] = card;
        if (kings != 4&&moves!=52) {
            showArray(clock);
            System.out.println();
            play(newPos, clock);
        }
    }

    public static void showArray(String[][] clock) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.print(clock[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
