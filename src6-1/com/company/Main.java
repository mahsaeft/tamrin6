package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahsaeft",
                "mahsa77")) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            /* insert into DB */
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("insert into student (id,name,year,avrage,studentNum) values (?,?,?,?,?)");
            preparedStatement1.setLong(1, 1);
            preparedStatement1.setString(2, "mahsa eftkhari");
            preparedStatement1.setString(3, "1396");
            preparedStatement1.setString(4, "19");
            preparedStatement1.setString(5, "961113075");
            System.out.println ("Insert into DB: "+preparedStatement1.executeUpdate());

            PreparedStatement preparedStatement5 =
                    connection.prepareStatement("insert into student (id,name,year,avrage,studentNum) values (?,?,?,?,?)");
            preparedStatement5.setLong(1, 2);
            preparedStatement5.setString(2, "ali asadi");
            preparedStatement5.setString(3, "1395");
            preparedStatement5.setString(4, "16");
            preparedStatement5.setString(5, "961135045");
            System.out.println ("Insert into DB: "+preparedStatement5.executeUpdate());

            PreparedStatement preparedStatement6 =
                    connection.prepareStatement("insert into student (id,name,year,avrage,studentNum) values (?,?,?,?,?)");
            preparedStatement6.setLong(1, 3);
            preparedStatement6.setString(2, "mahya zand");
            preparedStatement6.setString(3, "1397");
            preparedStatement6.setString(4, "17");
            preparedStatement6.setString(5, "961125040");
            System.out.println ("Insert into DB: "+preparedStatement6.executeUpdate());

            /* Update inside DB */
            PreparedStatement preparedStatement2 = connection.prepareStatement("update student set name=? WHERE id=? ");
            preparedStatement2.setString(1, "mobina shahsavari");
            preparedStatement2.setLong(2, 3);
            System.out.println ("Update inside DB: "+preparedStatement2.executeUpdate());

            /*Delete from DB*/
            PreparedStatement preparedStatement3 = connection.prepareStatement("delete from student where id=?");
            preparedStatement3.setLong(1, 2);
            System.out.println ("Delete from DB: "+preparedStatement3.executeUpdate());

            /*Select from DB*/
            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from student where id>=?");
            preparedStatement4.setLong(1,1);
            ResultSet resultSet = preparedStatement4.executeQuery();
            System.out.println ("Select results are as follows:");
            while (resultSet.next()) {
                System.out.println("ID: "+resultSet.getLong("ID"));
                System.out.println("Name: "+resultSet.getString("name"));
                System.out.println("Year: "+resultSet.getString("year"));
                System.out.println("Avrage: "+resultSet.getString("avrage"));
                System.out.println("Student Number: "+resultSet.getString("studentNum"));
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
