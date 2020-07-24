package domain.entities;

import domain.commands.HistorySavingConvertCommand;

import java.math.BigDecimal;

public class Wallet extends HistorySavingConvertCommand {

    private BigDecimal totalAmount;
    private BigDecimal totalIncomeMoney;
    private BigDecimal totalSpentMoney;

    public BigDecimal getTotalAmount() {
        if(totalAmount == null){
            return BigDecimal.ZERO;
        }
        return totalAmount;
    }

    public BigDecimal getTotalIncomeMoney() {
        if(totalIncomeMoney == null){
            return BigDecimal.ZERO;
        }
        return totalIncomeMoney;
    }

    public BigDecimal getTotalSpentMoney() {
        if(totalSpentMoney == null){
            return BigDecimal.ZERO;
        }
        return totalSpentMoney;
    }

    public void setTotalIncomeMoney(BigDecimal totalIncomeMoney) {
        this.totalIncomeMoney = totalIncomeMoney;
    }

    public void setTotalSpentMoney(BigDecimal totalSpentMoney) {
        this.totalSpentMoney = totalSpentMoney;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        String output = String.format("Total Income money: " + this.getTotalIncomeMoney() + " euro." +
                "%nTotal Spent money: " + this.getTotalSpentMoney() + " euro." +
                "%nCurrent amount: " + this.getTotalAmount()) + " euro.";
        return output;
    }
}
