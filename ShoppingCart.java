package codsursa.curs8codsursa;

public class ShoppingCart {
    private Produs[] listaProduse;
    private Produs produs;
    private int index;


    public ShoppingCart() {
        listaProduse = new Produs[5];
        index = 0;
    }


    public Produs[] getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(Produs[] listaProduse) {
        this.listaProduse = listaProduse;
    }

    public void addProduct(Produs produs) {
        if (index < 5) {
            listaProduse[index] = produs;
            index++;
        }
    }

    public void removeProduct(int pozitieelement) {
        if (index > 0) {
            listaProduse[pozitieelement] = null;
            index--;
        }
    }

    public int valueIndex() {
        return index;
    }

    public boolean contains(Produs prod) {
        for (Produs currentProduct : listaProduse) {
            if (currentProduct != null) {
                if (currentProduct.getPretProdus() == prod.getPretProdus() && currentProduct.getNumeProdus().equals(prod.getNumeProdus())) {
                    return true;
                }
            }
        }
        return false;
    }
}

