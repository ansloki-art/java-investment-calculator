import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("**************************");
        System.out.println("**Investment Calculator**");
        System.out.println("**************************");

        ArrayList<Investment> invests = new ArrayList<>();
        String calAgain;
        do{

            String investmentName = getValidText("Enter your investment name: ");
            double totalInvest = getPositiveDouble("Enter your Total invest (Rp): ");
            double totalCoin = getPositiveDouble("Enter your total coin: ");
             double currentPrice = getPositiveDouble("Enter current price (Rp): ");

             Investment investment = new Investment(investmentName, totalInvest, totalCoin, currentPrice);

          double avgCost = investment.calculateAverageCost();
          System.out.printf("Your average cost is: Rp.%.2f\n", avgCost);

          double priceChange = investment.calculateProfitLoss();
          invests.add(investment);

          if(priceChange > 0){
            System.out.printf("You are profit +%.2f%%", priceChange);
          }
          else if(priceChange < 0){
            System.out.printf("You are loss: %.2f%%", priceChange);
          }
          else {
            System.out.println("You are break even");
          }
            System.out.print("\nCalculate another investment (yes/no/summary): ");
            calAgain = scanner.nextLine().toLowerCase();

            if(calAgain.equals("summary")){
                System.out.println("\n📊 PORTFOLIO SUMMARY");
                System.out.println("Total investments: " + invests.size());

                for(int i = 0; i < invests.size(); i++){
                    Investment currentInvest = invests.get(i);
                    double percentage = currentInvest.calculateProfitLoss();
                    System.out.printf("%d. %s: %.2f%%", i + 1, currentInvest.name, percentage);

                    if(percentage > 0){
                        System.out.print(" 🟢 \n");
                    }
                    else if(percentage < 0){
                        System.out.print(" 🔴 \n");
                    }
                    else{
                        System.out.print(" ⚪ \n");
                    }
                }
                System.out.print("\nCalculate another investment (yes/no/summary): ");
                calAgain = scanner.nextLine().toLowerCase();

            }

        }while(calAgain.equals("yes") || calAgain.equals("y") || calAgain.equals("summary"));

        System.out.println("\nThank you! have a nice day!");
    }
    static double getPositiveDouble(String prompt) {

        double input;

        do {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                scanner.nextLine();

                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Must be positive number");
                }
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("ERROR");
                scanner.nextLine();
            }
        } while (true);
    }
    static String getValidText(String prompt) {

        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine();

            if(input.isEmpty()){
                System.out.println("Investment name cant be empty!");
            }

        } while (input.isEmpty());

        return input;
    }
}
