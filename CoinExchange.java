import java.util.Random;
import java.util.Scanner;
public class CoinExchange {
    public static void main(String args[]){
        Random random = new Random();
        double max_inflation = .05;
        double min_inflation = -.03;
        double randomInflation_rup = min_inflation + (max_inflation - min_inflation) * random.nextDouble();
        double randomInflation_gil = min_inflation + (max_inflation - min_inflation) * random.nextDouble();
        double randomInflation_gol = min_inflation + (max_inflation - min_inflation) * random.nextDouble();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your $USD balance?");
        double balance = scanner.nextDouble();
        System.out.println("Your rates today are: ");
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("Rupees: " + rupeecalc(balance, randomInflation_rup));
        System.out.println("Gil: " + gilcalc(balance, randomInflation_gil));
        System.out.println("Golden Coins: " + goldencalc(balance, randomInflation_gol));
        scanner.close();

    }
    private static double rupeecalc(double balance, double randomInflation){
        return (balance * .44 * (1+ randomInflation));
    }
    private static double gilcalc(double balance, double randomInflation){
        return (balance * 54.87 * (1+ randomInflation));
    }
    private static double goldencalc(double balance, double randomInflation){
        return (balance * 2.23 * (1+ randomInflation));
    }
}
