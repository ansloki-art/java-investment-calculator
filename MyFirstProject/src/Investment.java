public class Investment {

    String name;
    double totalInvest;
    double totalCoin;
    double currentPrice;

    Investment(String name, double totalInvest, double totalCoin, double currentPrice){
        this.name = name;
        this.totalInvest = totalInvest;
        this.totalCoin = totalCoin;
        this.currentPrice = currentPrice;
    }

    double calculateAverageCost(){

        return this.totalInvest / this.totalCoin;
    }

    double calculateProfitLoss(){

        double avgCost = this.totalInvest / this.totalCoin;

        return (this.currentPrice - avgCost) / avgCost * 100;
    }

}
