package petShop;

public class Vaccine {
    private String type; //种类（给何种动物接种）
    private double price; // 价格

    public Vaccine(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "疫苗{" +
                "名称：" + type +
                ", 价格：" + price +
                "元}";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
