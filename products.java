public class products {

    private String Name;
    private double price;
    private int amount;

    public products(){
        this.Name = "";
        this.price = 0;
        this.amount = 0;
    }

    public products(String name, double price, int amount){
        this.Name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toSqlValue() {
        String sqlValue = "";
        // build string from propeties
        return sqlValue;
    }
}
