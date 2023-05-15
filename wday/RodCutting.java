package wday;


import java.io.*;
import java.util.*;


class RodCutting {

    /*
     * Complete the 'maxProfit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER costPerCut
     *  2. INTEGER salePrice
     *  3. INTEGER_ARRAY lengths
     */

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        // Write your code here
        int maxProfit = 0, maxLength = 0;

        //find maxRodLize rename it to max
        for (int rodLength : lengths) {
            maxLength = Math.max(rodLength, maxLength);
        }

        for (int saleLength = 1; saleLength <= maxLength; saleLength++) { //saleLength is increased by lengths 1 , 25, 50, 75, 100, 125, 150, 175, 200
            int totalProfit = 0;

            for (int length : lengths) {

                int cuts = 0, numberOfSalableRods = 0;

                numberOfSalableRods = length / saleLength;

                if (length % saleLength == 0) { //30/10 = 3 cut 3-1 = 2
                    cuts = numberOfSalableRods - 1;
                    if(cuts<0) {
                        cuts = 0; //cuts can't be negative
                    }

                } else {
                    cuts = numberOfSalableRods;
                }

                totalProfit += numberOfSalableRods * saleLength * salePrice - cuts * costPerCut;
            }

            //System.out.println("totalProfit : " + totalProfit);

            maxProfit = Math.max(maxProfit, totalProfit);
        }
        return maxProfit;
    }


    public static void main(String[] args) throws IOException {

        System.out.println(maxProfit(200, 10, Arrays.asList(8, 25, 50, 75, 100, 125, 150, 175, 200)));
        System.out.println(maxProfit(20, 10, Arrays.asList(8, 25, 50, 75, 100, 125, 150, 175, 200)));


    }
}



/*abstract
length = {30, 59, 110}
costPerCut = 1
salePrice = 10/unit

Optimize totalUniformRods profit is highest

totalProfit = totalUniformRods* x saleLength x salePrice - totalCuts* x costPerCut


min 1 to max in the array


int maxProfit;
//int mostProfitableCut


for saleLength 1 to maxRodSize{

    int totalProfit = 0;
    for(int l: length){
        int cuts = l/saleLength;
        totalProfit+ = cut* x saleLength x salePrice - cut* x costPerCut;
    }
    maxProfit = maxProfit < totalProfit: totalProfit: maxProfit;
    //mostProfitableCut = saleLength;
}

return maxProfit;

200, 10,
{8, 25, 50, 75, 100, 125, 150, 175, 200}

*/