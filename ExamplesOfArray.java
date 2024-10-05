public class ExamplesOfArray {

    public static void Trapping_RainWater(int h[],int width) { // time complexity is O(n)
        int n = h.length;
        //left max boundary = LMB
        int LMB[] = new int[n];
        LMB[0] = h[0];
        System.out.print("left max boundary = ");
        for(int i=1; i<n; i++) {
            LMB[i] = Math.max(h[i], LMB[i-1]);
            System.out.print(LMB[i] + " ");
        }
        System.out.println();

        //right max boundary = RMB
        int RMB[] = new int[n];
        RMB[n-1] = h[n-1];
        System.out.print("right max boundary = ");
        for(int i=n-2; i>=0; i--) {
            RMB[i] = Math.max(h[i], RMB[i+1]);
            System.out.print(RMB[i] + " ");
        }
        System.out.println();

        //Water level
        int TrappedWater = 0;
        for(int i=0; i<n; i++) {
            int waterlevel = Math.min(LMB[i], RMB[i]);

            TrappedWater += (waterlevel - h[i]) * width;
        }
        System.out.println("Trapped water = " + TrappedWater);
    }
    
    public static void BuyAndSellStocks(int Prices[]) {
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0; i<Prices.length; i++) {
            if(buyprice < Prices[i]) { 
                int profit = Prices[i] - buyprice;
                maxprofit = Math.max(maxprofit, profit);
            } else {
                buyprice = Prices[i];
            }
        }
        System.out.println("max profit of given prices: " + maxprofit);
    }


    public static void main(String[] args) {
        
        //Trapping rain water
        // int h[] = {4,2,0,6,3,2,5};
        // int h[] = {7,0,4,2,5,0,6,4,0,5};
        // int width = 1;
        // Trapping_RainWater(h,width);

        //buy and sell stocks
        // int Prices[] = {7,1,5,3,6,4};
        // int Prices[] = {7,6,4,3,1};
        // BuyAndSellStocks(Prices);

    }
}
