package Day2JDBClearn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Employee {

    private int id;
    private String name;
    private int salary;
    private String department;
    private long phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}



public class employeeDAO {

    Connection con;

    public employeeDAO() throws Exception {

        Class.forName("org.postgresql.Driver");

        con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/employeedb",
                "postgres",
                "Shreya29#");
    }
    
    

    public void createTable() throws SQLException {

        String query = "CREATE TABLE employee (" +
                       "id INT PRIMARY KEY, " +
                       "name VARCHAR(50), " +
                       "salary INT, " +
                       "department VARCHAR(50), " +
                       "phone VARCHAR(15))";

        Statement st = con.createStatement();
        st.executeUpdate(query);

        
    }

    
    	public Employee insertEmployee(Employee emp) throws Exception {

    	    String query = "INSERT INTO employee (id,name,salary,department,phone) VALUES (?,?,?,?,?)";

    	    PreparedStatement ps = con.prepareStatement(query);

    	    ps.setInt(1, emp.getId());
    	    ps.setString(2, emp.getName());
    	    ps.setInt(3, emp.getSalary());
    	    ps.setString(4, emp.getDepartment());
    	    ps.setLong(5, emp.getPhone());

    	    ps.executeUpdate();

    	    return emp;
    	}


    public List<Employee> viewEmployees() throws Exception {

        String query = "SELECT * FROM employee";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        List<Employee> list = new ArrayList<>();

        while(rs.next()) {

            Employee emp = new Employee();

            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setSalary(rs.getInt("salary"));
            emp.setDepartment(rs.getString("department"));
            emp.setPhone(rs.getLong("phone"));

            list.add(emp);
        }

        return list;
    }
    

    public Employee viewEmployeeById(int id) throws Exception {

        String query = "SELECT * FROM employee WHERE id=?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Employee emp = null;

        if(rs.next()) {

            emp = new Employee();

            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setSalary(rs.getInt("salary"));
            emp.setDepartment(rs.getString("department"));
            emp.setPhone(rs.getLong("phone"));
        }

        return emp;
    }
    
    
    public Employee updateEmployee(int id, Employee e) throws Exception {

        Employee emp = viewEmployeeById(id);

        if(emp != null) {

            String query = "UPDATE employee SET salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, e.getSalary());
            ps.setInt(2, id);

            ps.executeUpdate();

            emp.setSalary(e.getSalary());
        }

        return emp;
    }

    
    	public Employee deleteEmployee(int id) throws Exception {

    	    Employee emp = viewEmployeeById(id);

    	    if(emp != null) {

    	        String query = "DELETE FROM employee WHERE id=?";

    	        PreparedStatement ps = con.prepareStatement(query);
    	        ps.setInt(1, id);

    	        ps.executeUpdate();
    	    }

    	    return emp;
    	}
}