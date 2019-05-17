package codsursa.curs8codsursa;

import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        ShoppingCart shoppingcart = new ShoppingCart();
        Produs[] listaproduseincart = new Produs[5];
        shoppingcart.setListaProduse(listaproduseincart);
        mainMenu(shoppingcart);


    }
    /*_____________________________________________________________________________________________*/
    /*___________________________________________Menus_____________________________________________*/
    /*_____________________________________________________________________________________________*/

    private static void mainMenu(ShoppingCart sc) {
        System.out.println("Bine ati venit la SDA Supermarket!");
        optiuniMenuDefault(sc);
    }

    private static void optiuniMenuDefault(ShoppingCart shoppingcart) {
        System.out.println("Optiuni : Home / Produse / Add / Cart / Plata / Iesire");
        optiuniMenu(shoppingcart);
    }


    private static void optiuniMenu(ShoppingCart shoppingcart) {
        Scanner sc = new Scanner(System.in);
        String optiune = sc.nextLine().toLowerCase();
            switch (optiune) {
                case "home":
                    mainMenu(shoppingcart);
                    break;
                case "produse":
                    viewProduseDisponibile();
                    optiuniMenuDefault(shoppingcart);
                    break;
                case "add":
                    addCart(shoppingcart);
                    break;
                case "plata":
                    casePayment(shoppingcart);
                    break;
                case "iesire":
                    System.out.println("O zi buna! Va mai asteptam!");
                    System.exit(0);
                case "cart":
                    cartView(shoppingcart);
                    System.out.println("Optiuni: Plata / Home / Add / Produse / Iesire  ");
                    optiuniMenu(shoppingcart);
                    break;
                default :
                    System.out.println("Alegeti una din optiunile de mai jos:");
                    optiuniMenuDefault(shoppingcart);
                    break;
            }

    }

    /*_____________________________________________________________________________________________*/
    /*__________________________________________Cart_______________________________________________*/
    /*_____________________________________________________________________________________________*/

    private static void cartView(ShoppingCart shoppingcart) {
        if (shoppingcart.getListaProduse()[0] == null) {
            System.out.println("Cosul dvs este gol!");
            optiuniMenuDefault(shoppingcart);
        } else {
            System.out.println("Produsele din cosul dvs:");
            for (int i = 0; i < shoppingcart.getListaProduse().length; i++) {
                if (shoppingcart.getListaProduse()[i] != null) {
                    System.out.println((i + 1) + ". " + shoppingcart.getListaProduse()[i].getNumeProdus() + " ");
                }
            }
            System.out.println("Pret total: " + getTotalPrice(shoppingcart) + " RON");
        }
    }

    private static void caseFullCart(ShoppingCart shoppingcart) {
        if (shoppingcart.valueIndex() == 5) {
            System.out.println("Cosul dvs este plin! Doriti sa platiti ? \nOptiuni: Plata / Cart / Home / Produse / Iesire  ");
            optiuniMenu(shoppingcart);
        } else {
            optiuniMenuDefault(shoppingcart);
        }
    }

    private static void addCart(ShoppingCart shoppingcart) {
        if (shoppingcart.valueIndex() != 5) {
            viewProduseDisponibile();
            Produs[] arr = listaProduseDisponibile();
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduceti numarul produsului dorit:");
            String str = sc.nextLine();
            if (str.equals("1")||str.equals("2") || str.equals("3") ||str.equals("4") || str.equals("5")) {
                switch (str) {
                    case "1":
                        shoppingcart.addProduct(arr[0]);
                        System.out.println("Produs adaugat! " + shoppingcart.valueIndex() + "/5 Produse in Cart");
                        optiuniMenuDefault(shoppingcart);
                        break;
                    case "2":
                        shoppingcart.addProduct(arr[1]);
                        System.out.println("Produs adaugat! " + shoppingcart.valueIndex() + "/5 Produse in Cart");
                        optiuniMenuDefault(shoppingcart);
                        break;
                    case "3":
                        shoppingcart.addProduct(arr[2]);
                        System.out.println("Produs adaugat! " + shoppingcart.valueIndex() + "/5 Produse in Cart");
                        optiuniMenuDefault(shoppingcart);
                        break;
                    case "4":
                        shoppingcart.addProduct(arr[3]);
                        System.out.println("Produs adaugat! " + shoppingcart.valueIndex() + "/5 Produse in Cart");
                        optiuniMenuDefault(shoppingcart);
                        break;
                    case "5":
                        shoppingcart.addProduct(arr[4]);
                        System.out.println("Produs adaugat! " + shoppingcart.valueIndex() + "/5 Produse in Cart");
                        optiuniMenuDefault(shoppingcart);
                        break;
                }
            } else {
                System.out.println("Alegeti una din optiunile de mai jos:");
                addCart(shoppingcart);
            }
        }
        caseFullCart(shoppingcart);
    }
    //_____________________________________________________________________________________________//
    //___________________________________________Produce___________________________________________//
    //_____________________________________________________________________________________________//

    private static Produs[] listaProduseDisponibile() {
        Produs[] produse = listaProduse();
        int length = produse.length;
        for (int i = 0; i < produse.length; i++) {
            if (!produse[i].isDisponibilitate()) {
                length--;
            }
        }
        int j = 0;
        Produs[] temp = new Produs[length];
        for (int i = 0; i < produse.length; i++) {
            if (produse[i].isDisponibilitate()) {
                temp[j] = produse[i];
            } else {
                j--;
            }
            j++;
        }
        return temp;
    }

    private static void viewProduseDisponibile() {
        Produs[] temp = listaProduseDisponibile();
        for (int i = 0; i < temp.length; i++) {
            System.out.println((i + 1) + ". " + temp[i].getNumeProdus() + " Pret: " + temp[i].getPretProdus() + " RON");
        }
    }

    private static Produs[] listaProduse() {
        Produs prod1 = new Produs("Covrigei", 5.99, true);
        Produs prod2 = new Produs("Pufuleti", 2.75, true);
        Produs prod3 = new Produs("Eugenie ", 1.0, true);
        Produs prod4 = new Produs("Muraturi", 15.99, false);
        Produs prod5 = new Produs("Paine   ", 0.5, true);
        Produs prod6 = new Produs("Cartof  ", 1.0, true);
        Produs[] produse = {prod1, prod2, prod3, prod4, prod5, prod6};
        return produse;
    }
    //_____________________________________________________________________________________________//
    //___________________________________________Payment___________________________________________//
    //_____________________________________________________________________________________________//

    private static void casePayment(ShoppingCart shoppingcart) {
        Scanner sc = new Scanner(System.in);
        if (shoppingcart.getListaProduse()[0] == null) {
            System.out.println("Cosul dvs este gol!");
            optiuniMenuDefault(shoppingcart);
        }
        System.out.println("Pretul total al cumparaturilor este: " + getTotalPrice(shoppingcart) + " RON" + "\nDoriti sa continuati? Da/Nu");
        String choice = sc.nextLine().toLowerCase();
        if (choice.equals("da") || choice.equals("nu")) {
            switch (choice) {
                case "da":
                    System.out.println("Ati platit suma de " + getTotalPrice(shoppingcart) + " RON\nVa multumim si va mai asteptam!");
                    System.exit(0);
                    break;
                case "nu":
                    mainMenu(shoppingcart);
            }
        } else {
            casePayment(shoppingcart);
        }

    }

    private static double getTotalPrice(ShoppingCart shoppingcart) {
        Produs[] arr = shoppingcart.getListaProduse();
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (shoppingcart.getListaProduse()[i] != null) {
                sum += shoppingcart.getListaProduse()[i].getPretProdus();
            }
        }
        return (double) Math.round(sum * 100) / 100;
    }
}

