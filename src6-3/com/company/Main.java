package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahsaeft",
                "mahsa77")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            /* insert into DB */
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("insert into siteUser (id,username,usercode,password,email,age,Education) values (?,?,?,?,?,?,?)");
            preparedStatement1.setLong(1, 1);
            preparedStatement1.setString(2, "mahsa_er");
            preparedStatement1.setString(3, "1113075");
            preparedStatement1.setString(4, "mahsa77");
            preparedStatement1.setString(5, "eftmahsa@gmail.com");
            preparedStatement1.setString(6, "21");
            preparedStatement1.setString(7, "lisans");
            System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());

            PreparedStatement preparedStatement2 =
                    connection.prepareStatement("insert into siteUser (id,username,usercode,password,email,age,Education) values (?,?,?,?,?,?,?)");
            preparedStatement2.setLong(1, 2);
            preparedStatement2.setString(2, "mobina_ssh");
            preparedStatement2.setString(3, "1201075");
            preparedStatement2.setString(4, "mobinashah");
            preparedStatement2.setString(5, "mobina.999@yahoo.com");
            preparedStatement2.setString(6, "18");
            preparedStatement2.setString(7, "diplom");

            System.out.println ("Insert into DB: "+preparedStatement2.executeUpdate());



            /*Select from DB*/
            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from siteUser where id>=?");
            preparedStatement4.setLong(1,1);
            ResultSet resultSet = preparedStatement4.executeQuery();
            System.out.println ("Select results are as follows:");
            while (resultSet.next()) {
                System.out.println("ID: "+resultSet.getLong("ID"));
                System.out.println("username: "+resultSet.getString("username"));
                System.out.println("usercode: "+resultSet.getString("usercode"));
                System.out.println("password: "+resultSet.getString("password"));
                System.out.println("email: "+resultSet.getString("email"));
                System.out.println("Age: "+resultSet.getString("age"));
                System.out.println("Education: "+resultSet.getString("Education"));
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
