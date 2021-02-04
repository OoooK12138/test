package petShop;
import java.time.*;
import java.time.format.*;
import java.util.Objects;
import java.util.Scanner;
import java.lang.String;
public class Main {
    static double balance =10000;
    public static void main(String[] args) {
        System.out.println("欢迎使用宠物商店自助管理系统。(店员使用）");
        char choice;
        while((choice=getChoice())!='Q'){
            switch (choice){
                case 'A':
                    buy();
                    break;// 进货
                case 'B':
                    sell();
                    break;// 售卖
                case 'C':
                    vaccinate(); // 接种
                    break;
                case 'D':
                    Foster(); // 寄养
                    break;
                case 'E':
                    get(); // 领养
                    break;
                case 'F':
                    showBalance();
            }
        }
    }

    // 显示当地时间
    static void showLocalTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("当前时间："+dtf.format(LocalDateTime.now()));
    }

    // 显示功能菜单
    static void showFunctionMenu(){
        System.out.println("A:进货");
        System.out.println("B:售卖");
        System.out.println("C:接种");
        System.out.println("D:寄养");
        System.out.println("E:领养");
        System.out.println("F:显示余额");
        System.out.println("Q:退出系统");
    }

    static char getChoice(){
        char choice;
        String option = "ABCDEFQ";
        Scanner scanner = new Scanner(System.in);
        while (true){
            showLocalTime();
            System.out.println("该系统的功能及其对应的选项如下:");
            showFunctionMenu();
            choice = scanner.next().charAt(0);
            if (option.indexOf(choice)>=0){
                break;
            } else{
                System.out.println("选择错误，请重新选择正确的选项......");
                System.out.println("按回车键继续");
            }
        }
        return choice;
    }

    // 显示余额
    static void showBalance(){
        System.out.println("商店余额"+balance);
    }

    // 进货
    static void buy() {
        showBalance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你想购入的宠物的品种：");
        System.out.println("1.狗  2.猫");
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("请输入有效选项！");
            choice = scanner.nextInt();
        }
        System.out.println("请输入你想购买的数量：");
        int n = scanner.nextInt();
        double cost = (choice == 1) ? Dog.getCost() : Cat.getCost();
        while (n * cost > balance) {
            System.out.println("余额不足，请重新输入：");
            n = scanner.nextInt();
        }
        System.out.println("请选择你这批宠物的性别：");
        System.out.println("1.雄  2.雌");
        int choice1 = scanner.nextInt();
        while (choice1 != 1 && choice1 != 2) {
            System.out.println("请输入有效选项！");
            choice1 = scanner.nextInt();
        }
        String sex = (choice == 1) ? "雄" : "雌";
        if (choice == 1) {
            for (int i = 0; i < n; i++) {
                Dog.buy(sex);
            }
        }
        else {
            for (int i=0; i<n; i++){
                Cat.buy(sex);
            }
        }
        showBalance();
    }

    // 出售
    static void sell(){
        Scanner scanner = new Scanner(System.in);
        if (PetShop.list.isEmpty()){
            System.out.println("没宠物卖了。");
            return;
        }
        System.out.println("总览：");
        PetShop.menu();
        System.out.println("是否按套餐购买：");
        System.out.println("1.是 2.否");
        int choice = scanner.nextInt();
        while(choice!=1&&choice!=2){
            System.out.println("请输入有效的选项！");
            choice = scanner.nextInt();
        }
        if (choice==1){
            System.out.println("请输入你想购买的套餐的标号：");
            int choice1 = scanner.nextInt();
            while(choice1!=1&&choice1!=2&&choice1!=3&&choice1!=4){
                System.out.println("请输入有效的选项！");
                choice1 = scanner.nextInt();
            }
            switch (choice1){
                case 1:
                    balance += 300;
                    break;
                case 2:
                    balance += 305;
                    break;
                case 3:
                    balance += 310;
                    break;
                case 4:
                    balance += 315;
                    break;
            }
            System.out.println("我们将为您的宠物接种套餐中的疫苗。");
        }
        PetShop.show();
        System.out.println("请输入你看上的宠物的编号（输入系统中宠物编号以外的符号视为您退出系统）：");
        String str = scanner.next();
        for (int i=0; i<PetShop.list.size(); i++){
            Animal a = PetShop.list.get(i);
            if (Objects.equals(str, a.getSex())){
                System.out.println("给它起个名字吧。");
                String str1 = scanner.next();
                a.setName(str1);
                System.out.println("宠物信息：");
                System.out.println(a);
                a.sell(str);
                PetShop.soldList.add(a); // 加入到已售名单
                if(choice==2){
                    balance+=a.getPrice();
                }
                else{
                    a.vaccinate(); // 接种疫苗
                }
                break;
            }
        }
        System.out.println("欢迎您下次光临");
    }

    // 接种
    static void vaccinate(){
        System.out.println("请输入您想接种的宠物的编号");
        Scanner scanner = new Scanner(System.in);
        String ID = scanner.next();

        for (Animal animal: PetShop.soldList){
            if (Objects.equals(ID, animal.getID())){
                PetShop.showVaccine();
                System.out.println();
                System.out.println("请输入你想接种的疫苗的编号：");
                System.out.println("1.狂犬疫苗 2.乖犬/猫疫苗");
                int c = scanner.nextInt();
                while(c!=1&&c!=2){
                    System.out.println("请输入有效的选项！");
                    c = scanner.nextInt();
                }
                if (c==1) {
                    balance += 80;
                }
                else {
                    balance += 90;
                }
                animal.vaccinate();
            }
        }

    }

    // 寄养
    static void Foster(){
        PetShop.Forster();
    }

    // 领养
    static void get(){
        PetShop.adopt();
    }
}