public class Cart {

    products[] Product;

    // makes the initial empty cart
    public Cart() {
        // initialize the product array
    }

    public void addItem(products item) {
        // take the item and add it to the product array
    }

    public void delteItem(String name) {
        // look through array for the same name and delete if you found a match
    }

    public float getPrice() {
        float price = 0;
        // go through all the items in the cart and add up the prices
        return price;
    }
}

/*
products product = new products("Banana", 5.00, 69);
Cart cart = new Cart();
cart.addItem(product);
cart.delteItem(product.getName());
*/