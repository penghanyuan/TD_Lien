import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import com.mysql.jdbc.ExceptionInterceptor;

public class MainClass {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			System.out.println("class failed");
			System.out.println(cnf.getMessage());
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/TP4", "root", "phy8955743");
		} catch (SQLException ex) {
			System.out.println("failed");
			System.out.println(ex.getMessage());
		}

//		try {
//			
//			PreparedStatement statement = con.prepareStatement("INSERT INTO Produit values(10,'type22',123,?);");
//			try {
//				//statement.setBlob(1, new FileInputStream("/Users/penghanyuan/Documents/Programs/test.jpg"));
//				//statement.executeUpdate();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//Blob blob = new Blob( new FileInputStream("f:/naruto.png"));
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		try {
			 byte[] data = null;
			// StringBuffer myStringBuffer = new StringBuffer();
			PreparedStatement statement = con.prepareStatement("Select image from Produit where id = 10;");
			try {
			
				ResultSet rs = statement.executeQuery();
				rs.next();
				Blob blob = (Blob) rs.getBlob("image");
				
				InputStream inStream = blob.getBinaryStream();
				long nLen = blob.length();

                int nSize = (int) nLen;

                //System.out.println("img data size is :" + nSize);

                data = new byte[nSize];

                inStream.read(data);
                inStream.close();
                
                JFrameTest jf = new JFrameTest("test");
                //jf.showImage(data);
             //   data = OrcleQuery.GetImgByteById(strID, nWith, nHeight);

             //   ServletOutputStream op = response.getOutputStream();       
              
			} catch (Exception e) {
				System.out.println("error:"+e.getMessage());
			}
			
		//	System.out.println(myStringBuffer.toString());
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try {
		// con.setAutoCommit(false);
		// Scanner sc = new Scanner(System.in);
		// boolean neg = false;
		// int i = 0;
		// while (i != 123) {
		// i = sc.nextInt();
		// System.out.println(i);
		// PreparedStatement statement = con.prepareStatement("Insert into ID
		// values(?)");
		// statement.setInt(1, i);
		// statement.executeUpdate();
		// if (i < 0) {
		// SQLException e = new SQLException("can't be negative");
		// throw e;
		// }
		// }
		// con.commit();
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// try {
		// con.rollback();
		// } catch (SQLException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// }
	}

}
