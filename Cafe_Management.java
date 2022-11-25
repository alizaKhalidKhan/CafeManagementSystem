
package Cafe_Management;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

class Cafe{ //outer-class
abstract class City{ //abstract nested inner class
    public abstract  double getsetArea();
    public abstract void setSetArea(double SetArea);

}
interface Cafe_Outlet{ //nested interface
    int floor = 2;
    String building_color = "light_blue";
    String gate = "3";
}
class CafeBuilding extends City implements Cafe_Outlet{ //nested class of City implementing interface 
    double SetArea;

    public CafeBuilding(double SetArea) {
        this.SetArea = SetArea;
    }
    public void setSetArea(double SetArea) {
        this.SetArea = SetArea;
    }
    public double getsetArea() {
            return SetArea;
        }
    
}
class Cafe_Interior extends CafeBuilding{ 
    public int tables;
    public int chairs;
    private int menu;

    public Cafe_Interior(int tables, int chairs, int menu) {
        this.tables = tables;
        this.chairs = chairs;
        this.menu = menu;
    }

    public Cafe_Interior(int tables, int chairs, int menu, double SetArea) {
        super(SetArea);
        this.tables = tables;
        this.chairs = chairs;
        this.menu = menu;
    }
  
    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }
    
}}
class MenuItem extends Cafe{
       String[] drink={"Latte","Iced-Latte","Cappucino","Ice-Cappuccino","Espresso"};
       String[] cake={"Coffee Cake","Vanilla Cake","Chocolate","Butter Cake","Pancake"};
       String[][] Menu = new String[5][5];
       
       public void MakeMenu(){
        for(int i=0 ;i>5;i++){
            for(int j=0;j>5;j++){
            Menu[0][i] = drink[i] ;
            Menu[i][0]= cake[i];
        }
    }
       }
}
class MenuPrices extends MenuItem{

    double Cost_Drinks,Cost_Cakes;
    double total;
    int no_of_cakes , no_Drinks;
    String drink,cake;

    public MenuPrices(int no_of_cakes, int no_Drinks, String drink, String cake) {
        this.no_of_cakes = no_of_cakes;
        this.no_Drinks = no_Drinks;
        this.drink = drink;
        this.cake = cake;
    }
    public double CalcDrink(){
        if(drink=="Latte"){
            double Latte=200;
            double tot = no_Drinks* Latte;
            return tot;
        }
        else if(drink=="Iced Latte"){
            double Latte=250;
            double tot = no_Drinks* Latte;
            return tot;
        }
        else if(drink=="Espresso"){
            double Espresso=275;
            double tot = no_Drinks*Espresso;
            return tot;
        }
        else if(drink=="Cappuccino"){
            double Cappuccino=275;
            double tot = no_Drinks* Cappuccino;
            return tot;
        }
        else if(drink=="Ice Cappuccino"){
            double Cappuccino=350;
            double tot = no_Drinks* Cappuccino;
            return tot;
        }
        return 0;
    }
    public double Calc_Cake(){
        if(cake=="Coffee Cake"){
            double Coffee_Cake=150;
            double tot = no_of_cakes* Coffee_Cake;
            return tot;
        }
        else if(cake=="Vanilla Cake"){
            double van=450;
            double tot =  no_of_cakes* van;
            return tot;
        }
        else if(cake=="Chocolate Cake"){
            double choco=350;
            double tot =  no_of_cakes*choco;
            return tot;
        }
        else if(cake=="Pancake"){
            double pan=100;
            double tot =  no_of_cakes*pan;
            return tot;
        }
        else if(cake=="Butter Cake"){
            double butter=450;
            double tot =  no_of_cakes* butter;
            return tot;
        }
        return 0;
    }
    public void calcTotal(){
        total= CalcDrink()+Calc_Cake();
        System.out.println(total);
    }
}
class Cafe_Employee extends Cafe{
    String name,CNIC,WorkShift,DepartmentOfWork,Salary;

    public Cafe_Employee(String name, String CNIC, String WorkShift, String DepartmentOfWork, String Salary) {
        this.name = name;
        this.CNIC = CNIC;
        this.WorkShift = WorkShift;
        this.DepartmentOfWork = DepartmentOfWork;
        this.Salary = Salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getWorkShift() {
        return WorkShift;
    }

    public void setWorkShift(String WorkShift) {
        this.WorkShift = WorkShift;
    }

    public String getDepartmentOfWork() {
        return DepartmentOfWork;
    }

    public void setDepartmentOfWork(String DepartmentOfWork) {
        this.DepartmentOfWork = DepartmentOfWork;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }
    public void fileData() throws IOException{ //saving data of employee working for cafe in file
        try{
            FileOutputStream fos = new FileOutputStream("D:\\Employee.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF("Employee Record Holder");
           dos.writeUTF(name);
           dos.writeUTF(CNIC);
           dos.writeUTF(DepartmentOfWork);
           dos.writeUTF(WorkShift);
           dos.writeUTF(Salary);
           dos.close();
           fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cafe_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

}
class Order extends Cafe{
    static int No_Of_Orders;
  public static void OrderOnline(){ //Method local inner class
        class Order_Online extends MenuItem{
            String orderCake,OrderDrink;

            public Order_Online(String orderCake, String OrderDrink) {
                this.orderCake = orderCake;
                this.OrderDrink = OrderDrink;
    for(int i=0 ;i>5;i++){
            for(int j=0;j>5;j++){
                if(orderCake==Menu[i][j]){
                    if(OrderDrink==Menu[i][j]){
                    System.out.println("Order received");
                }
            }
                }
                }
            No_Of_Orders = No_Of_Orders+1;
            Order_Online o = new Order_Online("Coffee Cake","Latte");
        }
            
        }
  }
    public static void OrdersAtCafe(){ //method local inner class
        class OrderAt_Cafe extends MenuItem{
            String orderCake,OrderDrink;

            public OrderAt_Cafe(String orderCake, String OrderDrink) {//checking if desired item is in the list 
                this.orderCake = orderCake;
                this.OrderDrink = OrderDrink;
                 for(int i=0 ;i>5;i++){
            for(int j=0;j>5;j++){
                if(orderCake==Menu[i][j]){
                    if(OrderDrink==Menu[i][j]){
                    System.out.println("Order placement Successful");
                }
            }
                }
                }
            No_Of_Orders = No_Of_Orders+1;
            OrderAt_Cafe o = new OrderAt_Cafe("Chocolate Cake","Latte");
            }       
        }
    }  
}
class Open_Hours extends Cafe{
    int am=7;
    int pm=9;

    public Open_Hours() {
        System.out.println("Cafe Open From " + am + " AM  to " + pm+" pm");
    }    
}
class Cafe_Stocks extends Cafe{ //stocks of things daily used by cafe
    int No_Of_COFFEE = 29;
    int No_Of_MilkPacks = 45;
    int No_Of_FlourPacks =21;
    int No_Of_Butter = 12;
    int No_of_Mocha = 63;
    int No_Of_eggs = 65;
    int no_of_choco_powder = 100;
    int vanilla_Esscence = 100;
    int vanillaflavourPacks = 35;
    int BakingSODA = 20;
    int ServingPlates = 300;
    int ServingCups = 300;
    int Spoons_Forks = 200;
    int SugarPacks = 100;
    int ToppingMaterials = 79;
}
public class Cafe_Management extends javax.swing.JFrame {
    double[] drinks= new double[5];
    double[] cakes= new double[5];
    String[] cost = new String[3];
    double[] i = new double[10];
    
    public Cafe_Management() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CoffeeCake = new javax.swing.JCheckBox();
        Vanilla = new javax.swing.JCheckBox();
        Chocolate = new javax.swing.JCheckBox();
        butter = new javax.swing.JCheckBox();
        pancake = new javax.swing.JCheckBox();
        jTextCoCake = new javax.swing.JTextField();
        jTextVanilla = new javax.swing.JTextField();
        jTextChoco = new javax.swing.JTextField();
        jTextButter = new javax.swing.JTextField();
        jTextpan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Cappu = new javax.swing.JCheckBox();
        IceCappu = new javax.swing.JCheckBox();
        IcedLatte = new javax.swing.JCheckBox();
        Latte = new javax.swing.JCheckBox();
        Espresso = new javax.swing.JCheckBox();
        jTextLatte = new javax.swing.JTextField();
        jTextIcedLatte = new javax.swing.JTextField();
        jTextEspresso = new javax.swing.JTextField();
        jTextCappu = new javax.swing.JTextField();
        jTextIceCappu = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        TotalButton = new javax.swing.JButton();
        ReceiptGenerator = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CostOfDrinks = new javax.swing.JTextField();
        CostOfCakes = new javax.swing.JTextField();
        Service = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Receipt = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Tax = new javax.swing.JTextField();
        SubTot = new javax.swing.JTextField();
        Total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JAB Cafe");
        setMinimumSize(new java.awt.Dimension(960, 600));
        setPreferredSize(new java.awt.Dimension(1300, 785));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        CoffeeCake.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CoffeeCake.setText("Coffee Cake");

        Vanilla.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Vanilla.setText("Vanilla Cake");
        Vanilla.setToolTipText("");
        Vanilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VanillaMouseClicked(evt);
            }
        });

        Chocolate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Chocolate.setText("Chocolate Cake");
        Chocolate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChocolateMouseClicked(evt);
            }
        });
        Chocolate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChocolateActionPerformed(evt);
            }
        });

        butter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        butter.setText("Butter Cake");
        butter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butterMouseClicked(evt);
            }
        });
        butter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butterActionPerformed(evt);
            }
        });

        pancake.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pancake.setText("Pancake");
        pancake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pancakeMouseClicked(evt);
            }
        });

        jTextCoCake.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextCoCake.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextCoCake.setText("0");
        jTextCoCake.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextCoCake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextCoCakeMouseClicked(evt);
            }
        });

        jTextVanilla.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextVanilla.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextVanilla.setText("0");
        jTextVanilla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextChoco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextChoco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextChoco.setText("0");
        jTextChoco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextButter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextButter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextButter.setText("0");
        jTextButter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextpan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextpan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextpan.setText("0");
        jTextpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Chocolate)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Vanilla)
                                .addComponent(CoffeeCake)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextChoco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCoCake, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextVanilla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butter)
                            .addComponent(pancake))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextButter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCoCake, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CoffeeCake))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextVanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Vanilla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextChoco, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Chocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextButter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextpan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pancake))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 350, 270));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 70)); // NOI18N
        jLabel1.setText("Cafe Management System");

        jLabel2.setFont(new java.awt.Font("Webdings", 0, 48)); // NOI18N
        jLabel2.setToolTipText("🍽");

        jLabel3.setFont(new java.awt.Font("Webdings", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1250, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        Cappu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Cappu.setText("Cappuccino");
        Cappu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CappuMouseClicked(evt);
            }
        });

        IceCappu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        IceCappu.setText("Ice Cappuccino");
        IceCappu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IceCappuMouseClicked(evt);
            }
        });
        IceCappu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IceCappuActionPerformed(evt);
            }
        });

        IcedLatte.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        IcedLatte.setText("Iced Latte");
        IcedLatte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IcedLatteMouseClicked(evt);
            }
        });
        IcedLatte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IcedLatteActionPerformed(evt);
            }
        });

        Latte.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Latte.setText("Latte");
        Latte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LatteMouseClicked(evt);
            }
        });
        Latte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LatteActionPerformed(evt);
            }
        });

        Espresso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Espresso.setText("Espresso");
        Espresso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EspressoMouseClicked(evt);
            }
        });

        jTextLatte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextLatte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLatte.setText("0");
        jTextLatte.setToolTipText("");
        jTextLatte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextIcedLatte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextIcedLatte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextIcedLatte.setText("0");
        jTextIcedLatte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextEspresso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextEspresso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextEspresso.setText("0");
        jTextEspresso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextCappu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextCappu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextCappu.setText("0");
        jTextCappu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextIceCappu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextIceCappu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextIceCappu.setText("0");
        jTextIceCappu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(IceCappu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jTextIceCappu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Latte)
                            .addComponent(IcedLatte)
                            .addComponent(Espresso)
                            .addComponent(Cappu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextLatte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextIcedLatte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextEspresso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCappu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Latte)
                    .addComponent(jTextLatte, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IcedLatte)
                    .addComponent(jTextIcedLatte, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Espresso)
                    .addComponent(jTextEspresso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cappu)
                    .addComponent(jTextCappu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextIceCappu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IceCappu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 400, 270));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        TotalButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalButton.setText("Total");
        TotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalButtonActionPerformed(evt);
            }
        });

        ReceiptGenerator.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ReceiptGenerator.setText("Receipt");
        ReceiptGenerator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptGeneratorActionPerformed(evt);
            }
        });

        Reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(TotalButton)
                .addGap(18, 18, 18)
                .addComponent(ReceiptGenerator)
                .addGap(18, 18, 18)
                .addComponent(Reset)
                .addGap(18, 18, 18)
                .addComponent(Exit)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalButton)
                    .addComponent(ReceiptGenerator)
                    .addComponent(Reset)
                    .addComponent(Exit))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 620, 480, 80));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Cost Of Drinks");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Cost Of Cakes");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Service Charge");

        CostOfDrinks.setEditable(false);
        CostOfDrinks.setBackground(new java.awt.Color(204, 204, 204));
        CostOfDrinks.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CostOfDrinks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CostOfDrinks.setText("0");
        CostOfDrinks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        CostOfDrinks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CostOfDrinks.setOpaque(true);

        CostOfCakes.setEditable(false);
        CostOfCakes.setBackground(new java.awt.Color(204, 204, 204));
        CostOfCakes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CostOfCakes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CostOfCakes.setText("0");
        CostOfCakes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        CostOfCakes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CostOfCakes.setOpaque(true);

        Service.setEditable(false);
        Service.setBackground(new java.awt.Color(204, 204, 204));
        Service.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Service.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Service.setText("1.5");
        Service.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Service.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Service.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(Service, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CostOfDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CostOfCakes, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CostOfDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CostOfCakes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(Service, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 330, 280));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        Receipt.setEditable(false);
        Receipt.setColumns(20);
        Receipt.setRows(5);
        jScrollPane1.setViewportView(Receipt);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, 480, 470));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Tax");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Sub Total");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Total");

        Tax.setEditable(false);
        Tax.setBackground(new java.awt.Color(204, 204, 204));
        Tax.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Tax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Tax.setText("0");
        Tax.setToolTipText("");
        Tax.setAutoscrolls(false);
        Tax.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Tax.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tax.setOpaque(true);

        SubTot.setEditable(false);
        SubTot.setBackground(new java.awt.Color(204, 204, 204));
        SubTot.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SubTot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SubTot.setText("0");
        SubTot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        SubTot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SubTot.setOpaque(true);

        Total.setEditable(false);
        Total.setBackground(new java.awt.Color(204, 204, 204));
        Total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total.setText("0");
        Total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Total.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Total.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tax, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubTot, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tax, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8))
                    .addComponent(SubTot, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 420, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IceCappuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IceCappuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IceCappuActionPerformed

    private void ChocolateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChocolateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChocolateActionPerformed

    private void butterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butterActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        CostOfDrinks.setText("0.00");
        CostOfCakes.setText("0.00");
        Service.setText("1.5");
        Tax.setText("0");
        SubTot.setText("0.00");
        Total.setText("0.00");
        Receipt.setText(null);
        Latte.setSelected(false);
        IcedLatte.setSelected(false);
        Espresso.setSelected(false);
        Cappu.setSelected(false);
        IceCappu.setSelected(false);
        CoffeeCake.setSelected(false);
        Vanilla.setSelected(false);
        Chocolate.setSelected(false);
        butter.setSelected(false);
        pancake.setSelected(false);
        jTextLatte.setText("0");
        jTextIcedLatte.setText("0");
        jTextEspresso.setText("0");
        jTextCappu.setText("0");
        jTextIceCappu.setText("0");
        jTextCoCake.setText("0");
        jTextVanilla.setText("0");
        jTextChoco.setText("0");
        jTextButter.setText("0");
        jTextpan.setText("0");
        
        
    }//GEN-LAST:event_ResetActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void ReceiptGeneratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptGeneratorActionPerformed
       drinks[0]=Double.parseDouble(jTextLatte.getText());
       drinks[1]=Double.parseDouble(jTextIcedLatte.getText());
       drinks[2]=Double.parseDouble(jTextEspresso.getText());
       drinks[3]=Double.parseDouble(jTextCappu.getText());
       drinks[4]=Double.parseDouble(jTextIceCappu.getText());
       
       cakes[0]=Double.parseDouble(jTextCoCake.getText());
       cakes[1]=Double.parseDouble(jTextVanilla.getText());
       cakes[2]=Double.parseDouble(jTextChoco.getText());
       cakes[3]=Double.parseDouble(jTextButter.getText());
       cakes[4]=Double.parseDouble(jTextpan.getText());
       
       cost[0]=(Tax.getText());
       cost[1]=(SubTot.getText());
       cost[2]=(Total.getText());
       
       int refs = 1325 + (int)(Math.random()*4238);
       int ref = (refs);
       Calendar timer = Calendar.getInstance();
       timer.getTime();
       SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
       time.format(timer.getTime());
       SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
       date.format(timer.getTime());
       
       Receipt.append(" \tJAB Cafe Management System \n\n" +
               "Reference : \t\t" + ref + "\n" +
               "===================================================\t" +
               "\nLatte : \t\t" +drinks[0] +"\n" +
               "Iced Latte : \t\t" +drinks[1] +"\n" +
               "Espresso : \t\t" +drinks[2] +"\n" +
               "Cappuccino : \t\t" +drinks[3] +"\n" +
               "Ice Cappuccino : \t" +drinks[4] +"\n" +
               "===================================================\t" +
               "\nCoffee Cake : \t\t" + cakes[0] + "\n" +
               "Vanilla Cake : \t\t" + cakes[1] + "\n" +
               "Chocolate Cake : \t" + cakes[2] + "\n" +
               "Butter Cake : \t\t" + cakes[3] + "\n" +
               "Pancake : \t\t" + cakes[4] + "\n" +
               "===================================================\t\n" +
               "Tax : \t\t" + cost[0] + "\n" +       
               "Sub Total : \t\t" + cost[1] + "\n" +   
               "Total : \t\t" + cost[2] + "\n" +       
               "===================================================\t\n" +
               "Date : \t\t" + date.format(timer.getTime()) + "\n" +
               "Time : \t\t" + time.format(timer.getTime()) + 
               "\n" +"\n\nThank You");
       
    }//GEN-LAST:event_ReceiptGeneratorActionPerformed

    private void LatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LatteActionPerformed

    }//GEN-LAST:event_LatteActionPerformed

    private void IcedLatteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IcedLatteActionPerformed

    }//GEN-LAST:event_IcedLatteActionPerformed

    private void LatteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LatteMouseClicked
        double cLatte = Double.parseDouble(CostOfDrinks.getText());
        double dLatte = Double.parseDouble(jTextLatte.getText());
        double iLatte = 200.00;
        if(Latte.isSelected()){
            i[1]=(dLatte * iLatte)+ cLatte;
            String pDrink = String.format("%.2f", i[1]);
            CostOfDrinks.setText(pDrink);
           
        }
    }//GEN-LAST:event_LatteMouseClicked

    private void IcedLatteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IcedLatteMouseClicked
        double cLatte = Double.parseDouble(CostOfDrinks.getText());
        double IceddLatte = Double.parseDouble(jTextIcedLatte.getText());
        double iLatte = 250.00;
        if(IcedLatte.isSelected()){
            i[2]=(IceddLatte * iLatte)+ cLatte;
            String pDrink = String.format("%.2f", i[2]);
            CostOfDrinks.setText(pDrink);
            
        }
    }//GEN-LAST:event_IcedLatteMouseClicked

    private void EspressoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EspressoMouseClicked
       double c = Double.parseDouble(CostOfDrinks.getText());
        double IEspresso = Double.parseDouble(jTextEspresso.getText());
        double eEspresso = 275.00;
        if(Espresso.isSelected()){
            i[3]=(IEspresso * eEspresso)+ c;
            String pDrink = String.format("%.2f", i[3]);
            CostOfDrinks.setText(pDrink);
            
        }
    }//GEN-LAST:event_EspressoMouseClicked

    private void CappuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CappuMouseClicked
       double c = Double.parseDouble(CostOfDrinks.getText());
        double ICappu = Double.parseDouble(jTextCappu.getText());
        double eCappu = 275.00;
        if(Cappu.isSelected()){
            i[0]=(ICappu * eCappu)+ c;
            String pDrink = String.format("%.2f", i[0]);
            CostOfDrinks.setText(pDrink);
           
        }
    }//GEN-LAST:event_CappuMouseClicked

    private void IceCappuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IceCappuMouseClicked
        double c = Double.parseDouble(CostOfDrinks.getText());
        double IcedCappu = Double.parseDouble(jTextIceCappu.getText());
        double eCappu = 350.00;
        if(IceCappu.isSelected()){
            i[4]=(IcedCappu * eCappu)+ c;
            String pDrink = String.format("%.2f", i[4]);
            CostOfDrinks.setText(pDrink);
            
        }
    }//GEN-LAST:event_IceCappuMouseClicked

    private void jTextCoCakeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextCoCakeMouseClicked
        double c = Double.parseDouble(CostOfCakes.getText());
        double CoffeCake = Double.parseDouble(jTextCoCake.getText());
        double cake = 150.00;
        if(CoffeeCake.isSelected()){
            i[5]=(CoffeCake * cake)+ c;
            String pDrink = String.format("%.2f", i[5]);
            CostOfCakes.setText(pDrink);
            
        }
    }//GEN-LAST:event_jTextCoCakeMouseClicked

    private void VanillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VanillaMouseClicked
       double c = Double.parseDouble(CostOfCakes.getText());
        double Van = Double.parseDouble(jTextVanilla.getText());
        double cake = 450.00;
        if(Vanilla.isSelected()){
            i[6]=(Van * cake)+ c;
            String pDrink = String.format("%.2f", i[6]);
            CostOfCakes.setText(pDrink);
            
        }
    }//GEN-LAST:event_VanillaMouseClicked

    private void ChocolateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChocolateMouseClicked
         double c = Double.parseDouble(CostOfCakes.getText());
        double ch= Double.parseDouble(jTextChoco.getText());
        double ca = 350.00;
        if(Chocolate.isSelected()){
            i[7]=(ch * ca)+ c;
            String pDrink = String.format("%.2f", i[7]);
            CostOfCakes.setText(pDrink);
            
        }
    }//GEN-LAST:event_ChocolateMouseClicked

    private void butterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butterMouseClicked
       double c = Double.parseDouble(CostOfCakes.getText());
        double ch= Double.parseDouble(jTextButter.getText());
        double cl = 450.00;
        if(butter.isSelected()){
            i[8]=(ch * cl)+ c;
            String pDrink = String.format("%.2f", i[8]);
            CostOfCakes.setText(pDrink);
           
        }
    }//GEN-LAST:event_butterMouseClicked

    private void pancakeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pancakeMouseClicked
        double c = Double.parseDouble(CostOfCakes.getText());
        double ch= Double.parseDouble(jTextpan.getText());
        double cake = 100.00;
        if(pancake.isSelected()){
            i[9]=(ch * cake)+ c;
            String pDrink = String.format("%.2f", i[9]);
            CostOfCakes.setText(pDrink);
            
        }
    }//GEN-LAST:event_pancakeMouseClicked

    private void TotalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalButtonActionPerformed
       drinks[0]=Double.parseDouble(CostOfDrinks.getText());
       drinks[1]=Double.parseDouble(CostOfCakes.getText());
       drinks[2]=Double.parseDouble(Service.getText());
       
       double cTotal = (drinks[0]+drinks[1]+drinks[2]);
       String iTaxTotal = String.format("Rs. %.2f", cTotal/100);
       Tax.setText(iTaxTotal);
       
       double subTotal = cTotal;
       String iSubTotal = String.format("Rs. %.2f", subTotal);
       SubTot.setText(iSubTotal);
       
       double allTotal = cTotal;
       String iTotal = String.format("Rs. %.2f", allTotal + (allTotal/100));
       Total.setText(iTotal);
       
       String a = String.format("Rs. %.2f", drinks[0]);
       CostOfDrinks.setText(a);
       
       String b = String.format("Rs. %.2f", drinks[1]);
       CostOfCakes.setText(b);
       
       String c = String.format("Rs. %.2f", drinks[2]);
       Service.setText(c);
       try{
            FileOutputStream fos = new FileOutputStream("D:\\Gains.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeDouble(allTotal);
            dos.close();
            fos.close();
       }
       catch(Exception e){
           
       }
    }//GEN-LAST:event_TotalButtonActionPerformed
    
    public static void main(String args[]) throws IOException {
        Cafe_Employee e = new Cafe_Employee("join" , "0000", "7-8" , "Serving" , "9990");
        e.fileData();
        Open_Hours n = new Open_Hours();
        MenuPrices mp = new MenuPrices(7,8,"Latte","pancake");
        Cafe_Stocks cs = new Cafe_Stocks();
        Order op = new Order();
        MenuItem m = new MenuItem();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cafe_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Cappu;
    private javax.swing.JCheckBox Chocolate;
    private javax.swing.JCheckBox CoffeeCake;
    private javax.swing.JTextField CostOfCakes;
    private javax.swing.JTextField CostOfDrinks;
    private javax.swing.JCheckBox Espresso;
    private javax.swing.JButton Exit;
    private javax.swing.JCheckBox IceCappu;
    private javax.swing.JCheckBox IcedLatte;
    private javax.swing.JCheckBox Latte;
    private javax.swing.JTextArea Receipt;
    private javax.swing.JButton ReceiptGenerator;
    private javax.swing.JButton Reset;
    private javax.swing.JTextField Service;
    private javax.swing.JTextField SubTot;
    private javax.swing.JTextField Tax;
    private javax.swing.JTextField Total;
    private javax.swing.JButton TotalButton;
    private javax.swing.JCheckBox Vanilla;
    private javax.swing.JCheckBox butter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextButter;
    private javax.swing.JTextField jTextCappu;
    private javax.swing.JTextField jTextChoco;
    private javax.swing.JTextField jTextCoCake;
    private javax.swing.JTextField jTextEspresso;
    private javax.swing.JTextField jTextIceCappu;
    private javax.swing.JTextField jTextIcedLatte;
    private javax.swing.JTextField jTextLatte;
    private javax.swing.JTextField jTextVanilla;
    private javax.swing.JTextField jTextpan;
    private javax.swing.JCheckBox pancake;
    // End of variables declaration//GEN-END:variables
}
