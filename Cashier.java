package codsursa.curs8codsursa;

public class Cashier {
    private ShoppingCart Total;

    public double getTotal(ShoppingCart shoppingcart) {
        Produs[] arr = shoppingcart.getListaProduse();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (shoppingcart.getListaProduse()[i] != null) {
                sum += shoppingcart.getListaProduse()[i].getPretProdus();
            }
        }
        return (double) Math.round(sum * 100) / 100;
    }

    public void setTotal(ShoppingCart total) {
        Total = total;
    }
}
