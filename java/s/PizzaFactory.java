
 class Pizza  {
   String name;
    
    void prepare() {
        System.out.println("Preparing " + name + " pizza...");
    }

    void bake() {
        System.out.println("Baking " + name + " pizza...");
    }

    void cut() {
        System.out.println("Cutting " + name + " pizza...");
    }

    void box() {
        System.out.println("Boxing " + name + " pizza...");
    }
}


class NyStyleCheesePizza extends Pizza {
    NyStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
    }
}

// PizzaStore class (Creator)
abstract class PizzaStore {
    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

// Concrete PizzaStore classes
class NyPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NyStyleCheesePizza();
        }
        return null;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}

// Main class
public class PizzaFactory {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NyPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        System.out.println();
        
        Pizza nyCheesePizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ordered a " + nyCheesePizza.name);

        System.out.println();

        Pizza chicagoCheesePizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("Ordered a " + chicagoCheesePizza.name);
    }
}

