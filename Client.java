package codSursa.curs8CodSursa;

public class Client {
    private int ID;
    private ShoppingCart shoppingCart;

    public Client(int ID, ShoppingCart shoppingCart) {
        this.ID = ID;
        this.shoppingCart = shoppingCart;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


}
