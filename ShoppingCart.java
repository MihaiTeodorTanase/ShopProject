package codsursa.curs8codsursa;

public class ShoppingCart {
    private Produs[] ListaProduse;
    private Produs produs;
    private int index;


    ShoppingCart() {
    }

    public ShoppingCart(Produs[] listaProduse) {
        ListaProduse = listaProduse;
    }

    Produs[] getListaProduse() {
        return ListaProduse;
    }

    void setListaProduse(Produs[] listaProduse) {
        ListaProduse = listaProduse;
    }

    void addProduct(Produs produs) {
        if (index < 5) {
            ListaProduse[index] = produs;
            index++;
        }
    }
    void removeProduct(int pozitieelement){
        if(index>0){
            ListaProduse[pozitieelement]= null;
            index--;
        }
    }

    int valueIndex() {
        return index;
    }
}

