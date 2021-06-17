package testing;

import java.util.*;  
import java.sql.*;  
  
public class EmpDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/truvaileDb?useSSL=false","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "INSERT INTO Package_table(Package_ID, Package_Name, Package_type, Inclusions, Nights, Price_per_person)VALUES(?,?,?,?,?,?)");  
            ps.setString(1,e.getPackage_ID());  
            ps.setString(2,e.getPackage_Name());  
            ps.setString(3,e.getPackage_type());  
            ps.setString(4,e.getInclusions());  
            ps.setString(5,e.getNights());  
            ps.setLong(6,e.getPrice_per_person());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Package_table set  Package_Name= ?, Package_type=?, Inclusions=?, Nights=?, Price_per_person=? where Package_ID=? ");  
            
            ps.setString(1,e.getPackage_Name());  
            ps.setString(2,e.getPackage_type());  
            ps.setString(3,e.getInclusions());  
            ps.setString(4,e.getNights());  
            ps.setLong(5,e.getPrice_per_person());  
            ps.setString(6,e.getPackage_ID());  
            
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(String sid){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Package_table where Package_ID =?");  
            ps.setString(1,sid);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
   public static Emp getEmployeeById(String sid){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Package_table where Package_ID=?");  
            ps.setString(1,sid);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setPackage_ID(rs.getString(1));
                e.setPackage_Name(rs.getString(2));
                e.setPackage_type(rs.getString(3));
                e.setInclusions(rs.getString(4));
                e.setNights(rs.getString(5));
                e.setPrice_per_person(rs.getLong(6));
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Package_table");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setPackage_ID(rs.getString(1));
                e.setPackage_Name(rs.getString(2));
                e.setPackage_type(rs.getString(3));
                e.setInclusions(rs.getString(4));
                e.setNights(rs.getString(5));
                e.setPrice_per_person(rs.getLong(6));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  