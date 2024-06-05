package Design_patterns.Creational;



/** the main idea is to provide an interface for creating families of related or dependent objects without specifying
 *  their concrete classes. Each factory implementation is responsible for creating a family of products, ensuring that
 *  the products are compatible and work together.
 *
 *  In summary:
 *
 * Factory Method focuses on creating instances of a single type of object, allowing subclasses to provide the concrete
 * implementation.
 * Abstract Factory focuses on creating families of related objects, providing an interface to create multiple types of
 * related objects without specifying their concrete classes
 * */




public class AbstractFactoryDesignPattern {
Button windowsButton = new WindowsFactory().createButton();
Menu WindowsMenu = new WindowsFactory().createMenu();
Button macosButton = new MacOSFactory().createButton();
Menu macosMenu = new MacOSFactory().createMenu();

}



// Abstract product interface
interface Button {
    void render();
}

// Concrete product for Windows button
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering a Windows button");
    }
}

// Concrete product for macOS button
class MacOSButton implements Button {
    public void render() {
        System.out.println("Rendering a macOS button");
    }
}

// Abstract product interface
interface Menu {
    void display();
}

// Concrete product for Windows menu
class WindowsMenu implements Menu {
    public void display() {
        System.out.println("Displaying a Windows menu");
    }
}

// Concrete product for macOS menu
class MacOSMenu implements Menu {
    public void display() {
        System.out.println("Displaying a macOS menu");
    }
}



// Abstract factory interface
interface GUIFactory {
    Button createButton();
    Menu createMenu();
}

// Concrete factory for Windows
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Menu createMenu() {
        return new WindowsMenu();
    }
}

// Concrete factory for macOS
class MacOSFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }

    public Menu createMenu() {
        return new MacOSMenu();
    }
}



