package lesson6.domain;

public class Department {

    private int departmentId;
    private String name;
    private String city;

    public Department() {
    }

    public Department (int departmentId, String name, String city){
        this.departmentId = departmentId;
        this.name = name;
        this.city = city;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public String getName (){
        return name;
    }

    public String city (){
        return  city;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}