package petShop;

public class SetMeal {
        private String name; // 套餐名
        private double price; // 套餐价格

    public SetMeal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "套餐{" +
                "套餐名称：" + name +
                ", 价格" + price +
                "元}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
