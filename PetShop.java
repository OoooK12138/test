package petShop;
import java.util.*;
import java.time.*;
import java.time.format.*;
interface PetShop {
    Scanner scanner = new Scanner(System.in);
    List <Animal> list = new ArrayList<>(); // 店中宠物
    List <SetMeal> listM = new ArrayList<>(); // 套餐
    List <Vaccine> listV = new ArrayList<>(); // 疫苗
    List <Animal> soldList = new ArrayList<>(); // 已售名单
    static void setListM(){
        listM.add(new SetMeal("狗+狂犬疫苗套餐",300));
        listM.add(new SetMeal("狗+乖犬疫苗套餐",305));
        listM.add(new SetMeal("猫+狂犬疫苗套餐",310));
        listM.add(new SetMeal("猫+乖猫疫苗套餐",315));
    }
    static void setListV(){
        listV.add(new Vaccine("狂犬疫苗",80));
        listV.add(new Vaccine("乖犬疫苗",90));
    }
    // 打印宠物店中所有宠物的信息
    static void show(){
        for (Animal animal : list){
            System.out.println(animal);
        }
    }
    // 商品总览
    static void menu(){
        for (Vaccine vaccine: listV){
            System.out.println(vaccine);
        }
        for (SetMeal setMeal : listM){
            System.out.println(setMeal);
        }
        System.out.printf("狗狗单价%f\n",Dog.getCost());
        System.out.printf("猫咪单价%f\n",Cat.getCost());
    }
    // 套餐菜单
    static void showSetMeal(){
        for (SetMeal setMeal : listM){
            System.out.println(setMeal);
        }
    }
    // 疫苗菜单
    static void showVaccine(){
        for (Vaccine vaccine: listV){
            System.out.println(vaccine);
        }
    }

    // 寄养
    static void Forster(){
        System.out.println("请输入您购买的宠物的编号：");
        String ID = scanner.next();
        for (Animal animal:soldList){
            if (ID==animal.getID()){
                if(animal.isForster){
                    System.out.println("已在寄养。");
                }
                else{
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    System.out.println("寄养成功！");
                    animal.put();
                    System.out.println("您于"+dtf.format(LocalDateTime.now())+"寄养"+animal.getName()+"，记得来领它哦。");
                }
            }
        }
        System.out.println("非常抱歉，没有在系统中找到这只宠物的编号，安全起见，本店只寄养本店售出的宠物。");
    }
    // 领养
    static void adopt(){
        System.out.println("请输入您想要领养的宠物的ID");
        String ID = scanner.next();
        for (Animal animal:soldList){
            if (ID==animal.getID()){
                if (!animal.isForster){
                    System.out.println("未在寄养");
                }
                else{
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    System.out.println("领养成功！");
                    animal.get();
                    System.out.println("您于"+dtf.format(LocalDateTime.now())+"领养"+animal.getName());
                }
            }
        }
    }

}
