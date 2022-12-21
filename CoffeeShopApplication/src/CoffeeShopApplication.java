/**
 * [一句话描述该类的功能]
 *
 * @author : [Lenovo]
 * @version : [v1.0]
 * @createTime : [2022/10/28 21:31]
 */

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CoffeeShopApplication {

    private static BufferedReader stdIn =
            new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut =
            new PrintWriter(System.out, true);
    private static PrintWriter stdErr =
            new PrintWriter(System.err, true);

    private CoffeeShop coffeeShop;

    private static final int MIN_NUMBER = 0;

    private static final int MAX_NUMBER = 50;

    private static final double MIN_COST = 2.0;

    private static final double MAX_COST = 50.0;

    public static void main(String[] args) throws IOException {

        CoffeeShopApplication application = new CoffeeShopApplication();

        application.run();
    }

    private void run() throws IOException {

        coffeeShop = new CoffeeShop();

        int choice = getChoice();

        while (choice != 0) {

            if (choice == 1) {

                coffeeShop.addCoffee(readCoffee());
            } else if (choice == 2) {

                stdOut.println(coffeeShop.toString());
            } else if (choice == 3) {

                stdOut.println("Total Cost: " + coffeeShop.getTotalCost());
            } else {
                System.out.println("您输入了错误指令！！！");
            }

            choice = getChoice();
        }
    }

    private int getChoice() throws IOException {
        System.out.println("--------欢迎来到咖啡店进货--------");
        System.out.println("0 终止程序");
        System.out.println("1 添加咖啡");
        System.out.println("2 显示咖啡店所有咖啡的信息");
        System.out.println("3 显示商店中所有咖啡的总成本");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n; //you need to change it.
    }

    private Coffee readCoffee() throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] ch;
        while (true) {
            System.out.println("请输入咖啡信息：");
            String str = sc.nextLine();
            ch = str.split("_");
            if (ch.length == 4&&Integer.parseInt(ch[0]) >= 0&&Double.parseDouble(ch[3]) > 0)
            {
                break;
            } else {
                System.out.println("您输入信息有误，请重新输入！");
            }
        }
        Coffee cf0 = new Coffee(Integer.parseInt(ch[0]), ch[1], ch[2], Double.parseDouble(ch[3]));

        /* PLACE YOUR CODE HERE */
        return cf0; //you need to change it.
    }

}