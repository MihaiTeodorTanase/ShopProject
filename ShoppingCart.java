package codsursa.curs8codsursa;

public class ShoppingCart {
    private Produs[] ListaProduse;
    private Produs produs;
    private int index;


    public ShoppingCart() {
        ListaProduse=new Produs[5];
        index=0;
    }


    public Produs[] getListaProduse() {
        return ListaProduse;
    }

    public void setListaProduse(Produs[] listaProduse) {
        ListaProduse = listaProduse;
    }

    public void addProduct(Produs produs) {
        if (index < 5) {
            ListaProduse[index] = produs;
            index++;
        }
    }

    public void removeProduct(int pozitieelement) {
        if (index > 0) {
            ListaProduse[pozitieelement] = null;
            index--;
        }
    }

    public int valueIndex() {
        return index;
    }
}

