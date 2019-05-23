package codSursa.curs8CodSursa;

import codSursa.curs11CodSursa.QueueFifo;

public class ClientsQueueExample {
    public static void main(String[] args) {
        ShoppingCart shoppingCart1 = new ShoppingCart();
        Produs prod1 = new Produs("Covrigei", 5.99, true);
        Produs prod2 = new Produs("Pufuleti", 2.75, true);
        Produs prod3 = new Produs("Eugenie ", 1.0, true);
        shoppingCart1.addProduct(prod1);
        shoppingCart1.addProduct(prod2);
        shoppingCart1.addProduct(prod3);
        Client client1=new Client(1,shoppingCart1);
        Client client2=new Client(2,shoppingCart1);
        Client client3=new Client(3,shoppingCart1);
        Client[] ClientList={client1,client2,client3};
        QueueFifo queueFifo = new QueueFifo(3);
        queueFifo.enQueue(client1.getID());
        queueFifo.enQueue(client3.getID());
        queueFifo.enQueue(client2.getID());
        for(int i=0;i<queueFifo.getQueue().length;i++){
            for(int j=0;j<queueFifo.getQueue().length;j++){
                if (queueFifo.getQueue()[0]==ClientList[j].getID()){
                    System.out.println("Primul client din queue a platit suma de: "+Shop.getTotalPrice(ClientList[j].getShoppingCart())+" si a plecat fericit :)");
                    queueFifo.deQueue();
                }
                if(queueFifo.isEmpty()){
                    System.out.println("Queue este gol!");
                    break;
                }
            }
        }

        }

    }

