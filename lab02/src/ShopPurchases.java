public class ShopPurchases {


    /**
     * @param hasEggs
     * @param hasBread
     * @return
     */
    public String doPurchases(boolean hasEggs, boolean hasBread) {
        String products = "";

        if (hasBread && hasEggs) {
            products = "bread, eggs";
        } else if (hasBread && !hasEggs) {
            products = "bread";
        } else if (!hasBread && hasEggs) {
            products = "eggs";
        }
        return products;

    }


}
