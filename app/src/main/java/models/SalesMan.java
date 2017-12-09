package models;

/**
 * Created by Lenovo on 19-Nov-17.
 */

public class SalesMan {
    private int id;
    private int code;
    private String name;
    private int department;
    private int branch;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public SalesMan(int id, int code, String name, int department, int branch) {

        this.id = id;
        this.code = code;
        this.name = name;
        this.department = department;
        this.branch = branch;
    }
}
