package codsursa.curs8codsursa;

public class Produs {
    private String NumeProdus;
    private Double PretProdus;
    private int Calorii;
    private boolean Disponibilitate;

    public Produs(String numeProdus, Double pretProdus,boolean disponibilitate) {
        NumeProdus = numeProdus;
        PretProdus = pretProdus;
        Disponibilitate=disponibilitate;
    }

    public Produs(String numeProdus, Double pretProdus,boolean disponibilitate, int calorii) {
        NumeProdus = numeProdus;
        PretProdus = pretProdus;
        Disponibilitate=disponibilitate;
        Calorii = calorii;
    }

    public boolean isDisponibilitate() {
        return Disponibilitate;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        Disponibilitate = disponibilitate;
    }

    public String getNumeProdus() {
        return NumeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        NumeProdus = numeProdus;
    }

    public Double getPretProdus() {
        return PretProdus;
    }

    public void setPretProdus(Double pretProdus) {
        PretProdus = pretProdus;
    }

    public int getCalorii() {
        return Calorii;
    }

    public void setCalorii(int calorii) {
        Calorii = calorii;
    }
}

