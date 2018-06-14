package ua.com.juja.core.antkott;

public class LaboratoryWork {

/*

Номинал мелких монет - 1,2,5,10,25,50.
1 копейку можно разменять 1 разным способом - {1}
2 - двумя разными способами {1 + 1; 2}
5 - 4 {1 + 1 + 1 + 1 + 1; 1 + 1 + 1 + 2; 1 + 2 + 2; 5}
........
Сколькими разными способами можно разменятьгривну (100 монет) ?

Реализовать алгоритм подсчета колличества разных разменов для входящего параметра.

*/

private int[] moneyNominals = {1,2,5,10,25,50};
private int counterExhcange = 0;

    public int exchangeAmountOfCoinsBrutForce(int amountForExchange) {
        return amountForExchange;
    }


    private int exchange (int amount){

        for (int j = 0; j <moneyNominals.length ; j++) {
            int moneyNominal = moneyNominals[j];
            if (amount % moneyNominal ==0){
                counterExhcange+=amount / moneyNominal;
            }
        }
return counterExhcange;
    }

}
