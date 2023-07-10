package reflection;

public class Employee {
    private int eid;
    private double esal;
    private String ename;

    enum Week{
        SUN,TUE,WED
    }

    interface MyAnno{}

    public int getEid(){
        return eid;
    }
    public void setEid(int eid,int num, char ch){
        this.eid = eid;
    }

    public double getEsal(){
        return esal;
    }
    public void setEsal(double esal,float data, String name){
        this.esal = esal;
    }

    public String getEname(){
        return ename;
    }
    public void setEname(String ename){
        this.ename = ename;
    }

    // constructor
    public Employee(){
    }
    public Employee(int eid, double esal, String ename){
        super();
        this.eid = eid;
        this.esal = esal;
        this.ename = ename;
    }

    class A{
    }
    class B{
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", esal=" + esal +
                ", ename='" + ename + '\'' +
                '}';
    }
}
