package petShop;

public abstract class Animal{
    protected String ID; // 编号
    protected double price; // 价格
    protected String name = "null"; // 名字
    protected String age; // 年龄
    protected String sex; // 性别
    protected boolean isVaccines = false; // 是否接种疫苗
    protected boolean isForster = false; // 是否寄养
    public static double balance = 10000; // 余额
    public Animal(String ID,double price,String age,String sex) {
        this.ID = ID;
        this.price = price;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ID='" + ID + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    // 起名
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public abstract void vaccinate(); // 接种疫苗
    public abstract void put(); // 寄养
    public abstract void sell(String id); // 出售
    public abstract void get(); // 领回宠物
}
