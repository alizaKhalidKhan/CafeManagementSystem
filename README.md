# CafeManagementSystem

package Cafe_Management;

class Cafe{ //outer-class
abstract class City{ 
//abstract nested inner class
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
