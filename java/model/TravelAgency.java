package model;

import java.io.*;
import java.sql.*;
import java.util.*;

import utility.JdbcUtility;

public class TravelAgency {
	public List<Package> listOfPackage = new ArrayList();
	
public static boolean validatePackageID(String s) {
	if(s.length()==7 && s.charAt(3)=='/') {
		return true;
	}
	return false;
	
}
public List<Package> generatePackageCost(String filePath) throws IOException, SQLException {
	
	Connection connection=	JdbcUtility.connect();
	File file = new File(filePath);
	Scanner scan = new Scanner(file);
	
	while(scan.hasNextLine()) {
		String st = scan.nextLine();
		String[] s = st.split(",");
		String packageID = s[0];
		
		if(validatePackageID(packageID)) {
			PreparedStatement ps=connection.prepareStatement("insert into package values(?,?,?,?,?)");
			ps.setString(1, s[0]);
			ps.setString(2, s[1]);
			ps.setString(3, s[2]);
			ps.setInt(4, Integer.parseInt(s[4]));
			Package p = new Package();
			p.setPackageId(s[0]);
			p.setSourcePlace(s[1]);
			p.setDestinationPlace(s[2]);
			p.setBasicFare(Integer.parseInt(s[3]));
			p.setNoOfDays(Integer.parseInt(s[4]));
			p.calculatePackageCost();
			ps.setInt(5,(int)p.packageCost);
			listOfPackage.add(p);
			ps.executeUpdate();
		
		}
		
	
	}
	
	return listOfPackage;
}
public List<Package> findPackageWithMinimumNumberOfDays(){
	List<Package> list = new ArrayList();
	try {
		Connection connection = JdbcUtility.connect();
		PreparedStatement ps = connection.prepareStatement("select * from package where no_of_days = (select MIN(no_of_days) from package);");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
				Package p = new Package();
				p.setPackageId(rs.getString(1));
				p.setSourcePlace(rs.getString(2));
				p.setDestinationPlace(rs.getString(3));
				p.setNoOfDays(rs.getInt(4));
				p.setPackageCost(rs.getDouble(5));
				list.add(p);
			
		}
		return list;
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	return list;
}

	}