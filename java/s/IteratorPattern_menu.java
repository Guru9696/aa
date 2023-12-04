import java.util.ArrayList;
import java.util.Iterator;

// Item class representing menu items
class MenuItem {
    private String name;
    private String description;

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}

// Iterator interface
interface MenuIterator {
    boolean hasNext();

    MenuItem next();
}

// Concrete Iterator for the menu
class BreakfastMenuIterator implements MenuIterator {
    private ArrayList<MenuItem> items;
    private int position = 0;

    public BreakfastMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }
}

// Menu interface
interface Menu {
    MenuIterator createIterator();
}

// Concrete Menu for breakfast
class BreakfastMenu implements Menu {
    private ArrayList<MenuItem> items;

    public BreakfastMenu() {
        items = new ArrayList<>();
        addItem("Eggs and Bacon", "Scrambled eggs with crispy bacon");
        addItem("Pancakes", "Fluffy pancakes with maple syrup");
    }

    public void addItem(String name, String description) {
        MenuItem menuItem = new MenuItem(name, description);
        items.add(menuItem);
    }

    @Override
    public MenuIterator createIterator() {
        return new BreakfastMenuIterator(items);
    }
}

// Client code
public class IteratorPattern_menu {
    public static void main(String[] args) {
        // Create breakfast menu
        Menu breakfastMenu = new BreakfastMenu();

        // Print breakfast menu items using iterator
        printMenu(breakfastMenu.createIterator());
    }

    private static void printMenu(MenuIterator iterator) {
        System.out.println("Menu Items:");
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem);
        }
    }
}
