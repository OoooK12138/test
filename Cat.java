package petShop;

public class Cat extends Animal implements PetShop{
    private static int count = 0;
    private static final double cost = 190; // 进价
    public Cat(String ID, double price, String age,String sex) {
        super(ID, price, age, sex);
    }
    public static double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        String str1 = (isVaccines)?"已接种":"未接种";
        String str2 = (isForster)?"寄养中":"非寄养";

        return "cat{" +
                "编号:" + ID +
                "，价格：" + price +
                "，名字：" + name +
                "，年龄：" + age +
                "，性别：" + sex +
                "，是否接种：" + str1 +
                "，是否寄养：" + str2 +
                '}';
    }

    @Override
    public void vaccinate() {
        isVaccines = true;
        System.out.println("疫苗接种成功");
    }

    @Override
    public void put() {
        isForster = true;
    }

    @Override
    public void get() {
        isForster = false;
    }

    static void buy(String Sex) {
        String str = String.format("%03d",count+1);
        list.add(new Dog(str,260,"1岁",Sex));
        count++;
    }

    @Override
    public void sell(String id) {
        for (Animal animal : list){
            if(animal.getID().equals(id)){
                list.remove(animal);
                count--;
                soldList.add(animal);
                System.out.println("购买成功");
                return;
            }
        }
    }

}
