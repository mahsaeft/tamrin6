package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahsaeft",
                "mahsa77")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            /* insert into DB */
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("insert into employes (id,name,fatherName,meliCode,post,age,salary,workHistory) values (?,?,?,?,?,?,?,?)");
            preparedStatement1.setLong(1, 1);
            preparedStatement1.setString(2, "mahsa eftekhari");
            preparedStatement1.setString(3, "masoud");
            preparedStatement1.setString(4, "0021875413");
            preparedStatement1.setString(5, "manager");
            preparedStatement1.setString(6, "21");
            preparedStatement1.setString(7, "1200");
            preparedStatement1.setString(8, "2");
            System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());

            PreparedStatement preparedStatement2 =
                    connection.prepareStatement("insert into employes (id,name,fatherName,meliCode,post,age,salary,workHistory) values (?,?,?,?,?,?,?,?)");
            preparedStatement2.setLong(1, 2);
            preparedStatement2.setString(2, "mahdis eftekhari");
            preparedStatement2.setString(3, "mehdi");
            preparedStatement2.setString(4, "0021586920");
            preparedStatement2.setString(5, "assistant");
            preparedStatement2.setString(6, "18");
            preparedStatement2.setString(7, "800");
            preparedStatement2.setString(8, "1");
            System.out.println ("Insert into DB: "+preparedStatement2.executeUpdate());



            /*Select from DB*/
            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from employes where id>=?");
            preparedStatement4.setLong(1,1);
            ResultSet resultSet = preparedStatement4.executeQuery();
            System.out.println ("Select results are as follows:");
            while (resultSet.next()) {
                System.out.println("ID: "+resultSet.getLong("ID"));
                System.out.println("Name: "+resultSet.getString("name"));
                System.out.println("FatherName: "+resultSet.getString("fatherName"));
                System.out.println("MeliCode: "+resultSet.getString("meliCode"));
                System.out.println("Post: "+resultSet.getString("post"));
                System.out.println("Age: "+resultSet.getString("age"));
                System.out.println("Salary: "+resultSet.getString("salary"));
                System.out.println("WorkHistory: "+resultSet.getString("workHistory"));
            }

        } catch (ClassNotFoundException e)// if no lib files are added
        {
            System.out.println("DB Driver Not Exist!!");
        } catch (SQLException e)
        {
            System.out.println("DB ERROR " + e.getMessage());
        }
    }
}
