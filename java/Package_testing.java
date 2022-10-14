import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Package;
import model.TravelAgency;

public class Package_testing {

	public static void main(String[] args) throws IOException, SQLException {
		
		TravelAgency Ta = new TravelAgency();
		System.out.println("Package with minimum days: ");
		List<Package> p2 = Ta.findPackageWithMinimumNumberOfDays();
		for(Package p : p2 ) {
			System.out.println(p.getBasicFare()+" "+p.getSourcePlace()+" "+p.getDestinationPlace()+" "+p.getNoOfDays()+" "+p.getPackageCost());
		}
		
			
		}
}