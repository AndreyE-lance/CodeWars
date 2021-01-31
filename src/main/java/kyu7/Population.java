package kyu7;

/*
In a small town the population is p0=1000at the beginning of a year.
The population regularly increases by 2percent per year and moreover 50 new
inhabitants per year come to live in the town.How many years does the town need
        to see its population greater or equal to p=1200inhabitants?
*/

public class Population {
    public static void main(String[] args) {
        System.out.println(nbYear(1500, 5, 100, 5000));
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000));
        System.out.println(nbYear(1500000, 0.25, 1000, 2000000));

    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        // your code
        int inhabitants = p0;
        int result = 0;
        while (inhabitants < p) {
            inhabitants = inhabitants + (int) (inhabitants/100 * percent) + aug;
            result++;
        }
        return result;
    }
}
