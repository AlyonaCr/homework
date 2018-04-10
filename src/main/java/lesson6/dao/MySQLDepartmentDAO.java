package lesson6.dao;
import lesson6.Configuration;
import lesson6.PropertiesJDBCConfiguration;
import lesson6.domain.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class MySQLDepartmentDAO implements DepartmentDao {

    private Connection connection;

    public Department create( int departmentId, String name, String city) {
        try {
            connection = getConfiguredConnection();
            String sql = "insert into department values ( " + departmentId + ", "+ name + ", " +city + ")";

            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Row affected: " + result);


        } catch (SQLException e) {
        e.printStackTrace();
    }
    Department dep = findById(departmentId);

        return dep;
    }

    public Department update(int departmentId, String name, String city) {

        try {
            connection = getConfiguredConnection();
            String sql = "insert into department values (" + departmentId + ", " + name + ", " +city + ")";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Row affected: " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Department dep = findById(departmentId);

        return dep;
    }

    public void delete(int departmentId) {
        try {
            connection = getConfiguredConnection();
        String sql = "delete from department where id = " + departmentId;
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Row affected: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Collection<Department> findAll() {

        ArrayList<Department> departments = new ArrayList<>();
        try {
            connection = getConfiguredConnection();

            String sql = "select * from department";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int departmentId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                Department department = new Department(departmentId, name , city);
                departments.add(department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    public Department findById(int departmentId) {
        Department department = new Department();

        try {

            connection = getConfiguredConnection();

            String sql = "select * from department where id = " + departmentId;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                department.setDepartmentId(resultSet.getInt("id"));
                department.setName(resultSet.getString("name"));
                department.setCity(resultSet.getString("city"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }

    private static Connection getConfiguredConnection() throws SQLException {
        PropertiesJDBCConfiguration prop = new PropertiesJDBCConfiguration();
        Configuration conf = prop.load();
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://"+ conf.getHost() + ":" + conf.getPort()+ "/" + conf.getDatabase()+ "?createDatabaseIfNotExists=true&serverTimezone=UTC",
                conf.getUsername(),
                conf.getPassword());

        return connection;
    }
}