package de.daug.semanticchess.Database;

import java.io.*;
import java.sql.*;

import de.daug.semanticchess.Configurations;

//https://www.openlinksw.com/vos/main/Main/VirtTipsAndTricksLoadDataInTransactionMode
public class LoadData {

	  public static void main(String[] args) 
	  {
	    try {
	      Class.forName("virtuoso.jdbc4.Driver");

	      String urlDB = Configurations.DB;
	      String userDB = Configurations.DB_USER;
	      String userPW = Configurations.DB_PASSWORD;

	      Connection conn = DriverManager.getConnection(urlDB,userDB,userPW);
	      Statement st;

	      st = conn.createStatement();

	     // st.execute("sparql clear graph <testlog>");
	      conn.setAutoCommit(false);
	      String fileName = "Nimzowitsch";
	      String data = load_ttl("src/main/resources/static/openings/eco.txt.ttl");
	      //String data = load_ttl("src/test/resources/"+fileName+".ttl");
	      //String meta_data = load_ttl("src/test/resources/"+fileName+"_meta.ttl");
	      if (data!=null) {
	        insert_data(data, "http://www.example.com/", conn);
	        //insert_data(meta_data, "http://www.example.com/", conn);
	        // Commit or Rollback the transaction

	        // conn.commit();
	        // System.out.println("Commit insert");
	        conn.rollback();
	        System.out.println("Rollback insert");

	        //String query = "sparql SELECT * from <http://www.example.com/> WHERE {?s ?p ?o}";
	        //ResultSet rs = st.executeQuery(query);
	        //prnRs(rs);
	        //rs.close();
	      }
	      
	      
	      st.close();
	      conn.close();

	    } catch (Exception e) {
	      System.out.println("Ex="+e);
	    }
	  }


	  public static String load_ttl(String fname)
	  {
	    try {
	      BufferedReader r = new BufferedReader(new FileReader(fname));
	      StringBuilder sb = new StringBuilder();

	      String s;
	      while((s = r.readLine())!=null){
	    	  sb.append(s);
	    	  sb.append(" ");
	    	  
	      }
	        
	      

	      return sb.toString();
	    } catch (Exception e) {
	    }
	    return null;
	  }
	    
	  public static void insert_data(String data, String gr_name, Connection conn)
	  {
	     try{
	       PreparedStatement ps = conn.prepareStatement("DB.DBA.TTLP_MT (?, ?, ?)");

	       ps.setString(1, data);
	       ps.setString(2, "");
	       ps.setString(3, gr_name);


	       System.out.println("Executing insert..");
	       ps.execute();
	       ps.close();
	     } catch (Exception e) {
	       System.out.println("Ex:"+e);
	     }
	  }


	 public static void prnRs(ResultSet rs)
	 {
	   try {
	     ResultSetMetaData rsmd;

	   System.out.println(">>>>>>>>");
	     rsmd = rs.getMetaData();
	     int cnt = rsmd.getColumnCount();

	       while(rs.next()) {
	         Object o;

	         System.out.print("Thread:"+Thread.currentThread().getId()+"  ");
	         for (int i = 1; i <= cnt; i++) {
	           o = rs.getObject(i);
	           if (rs.wasNull())
	             System.out.print("<NULL> ");
	           else
	             System.out.print("["+ o + "] ");
	         }
	         System.out.println();
	       }

	   } catch (Exception e) {
	     System.out.println(e);
	     e.printStackTrace();
	   }
	   System.out.println(">>>>>>>>");
	 }


	  public static String create_query(String fname)
	  {
	    try {
	      BufferedReader r = new BufferedReader(new FileReader(fname));
	      StringBuilder sb = new StringBuilder();

	      String s;
	      while((s = r.readLine())!=null)
	        sb.append(s);

	      if (sb.length()>0)
	        return "sparql insert into graph <testyear> { "+ sb.toString() + " } ";
	    } catch (Exception e) {
	    }
	    return null;
	  }


	}