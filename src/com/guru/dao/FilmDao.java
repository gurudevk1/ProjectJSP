package com.guru.dao;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;

import com.guru.bean.Film; 
public class FilmDao {
  
public static Connection getConnection(){  
    Connection con=null;  
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","admin");  
    }catch(Exception e){System.out.println(e);}  
    return con;  
}  
public static int save(Film u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into film(title,description,language_id) values(?,?,1)");  
        ps.setString(1,u.getTitle());  
        ps.setString(2,u.getDescription());  
      //  ps.setDate(3,(Date) u.getReleaseYear());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(Film u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update film set title=?,description=?,release_year=? where film_id=?");  
        ps.setString(1,u.getTitle());  
        ps.setString(2,u.getDescription());  
        ps.setDate(3,(Date) u.getReleaseYear());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(Film u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from film where film_id=?");  
        ps.setInt(1,u.getFilmId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<Film> getAllRecords(){  
    List<Film> list=new ArrayList<Film>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from film");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
        	Film u=new Film();  
           // u.setFilmId(rs.getInt("film_id"));  
            u.setTitle(rs.getString("title"));  
            u.setDescription(rs.getString("description"));  
            u.setReleaseYear(rs.getDate("release_year"));
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
/*public static User getRecordById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from register where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            u.setSex(rs.getString("sex"));  
            u.setCountry(rs.getString("country"));  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
} */ 
}  