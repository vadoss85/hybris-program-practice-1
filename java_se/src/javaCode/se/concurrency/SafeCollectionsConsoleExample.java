package javaCode.se.concurrency;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeCollectionsConsoleExample extends AbstractConsoleExample {
    public SafeCollectionsConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("--------------------------------------------");
        printer.printString("--- CONCURRENCY SAFE COLLECTIONS EXAMPLE ---");
        printer.printString("--------------------------------------------");
    }

    @Override
    public void printBody() {
        InventoryManager manager = new InventoryManager(printer);

        Thread fillThread = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.fillSoldProductsArray();
            }
        });

        Thread displayThread = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.displaySoldProducts();
            }
        });

        fillThread.start();
        await();
//        join(fillThread);
        displayThread.start();
    }

    // workaround
    private void await() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // fake multi thread
    private void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class InventoryManager {
    ConsolePrinter printer;
//    List<Product> soldProducts = new ArrayList<>();
    List<Product> soldProducts = new CopyOnWriteArrayList<>();
    List<Product> purchasedProducts = new ArrayList<>();


    public InventoryManager(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void fillSoldProductsArray() {
        for (int i = 0; i < 10; i++) {
            Product product = new Product(i, "product_" + i);
            soldProducts.add(product);
            printer.printString("Added: " + product.getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for (Product product: soldProducts) {
            printer.printString("Sold: " + product.getName());
        }
    }
}

class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}