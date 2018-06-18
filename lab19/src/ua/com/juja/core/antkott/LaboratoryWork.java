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

    private int[] moneyNominals = {1, 2, 5, 10, 25, 50};


    public int exchangeAmountOfCoinsBrutForce(int amountForExchange) {
        for (int i = moneyNominals.length - 1; i >= 0; i--) {
            if (amountForExchange / moneyNominals[i] >= 1) {
                return exchange(amountForExchange, i);
            }
        }
        return 0;
    }


    private int exchange(int amount, int moneyNominalsIndex) {
        if (amount == 0 || moneyNominalsIndex == 0) {
            return 1;
        }
        if (amount >= moneyNominals[moneyNominalsIndex]) {
            return exchange(amount, moneyNominalsIndex - 1) + exchange(amount - moneyNominals[moneyNominalsIndex], moneyNominalsIndex);
        }
        return exchange(amount, moneyNominalsIndex - 1);
    }

}
