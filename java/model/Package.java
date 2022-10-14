package model;

public class Package {
	String packageId;
	String sourcePlace;
	String destinationPlace;
	int noOfDays;
	double basicFare;
	double packageCost;
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getSourcePlace() {
		return sourcePlace;
	}
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getBasicFare() {
		return basicFare;
	}
	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}
	public double getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	
	public void calculatePackageCost() {
		double discount=0;
		if(noOfDays>5 && noOfDays<=8) {
			discount = (3*basicFare*noOfDays)/100;
		}
		else if(noOfDays>8 && noOfDays<=10) {
			discount = (5*basicFare*noOfDays)/100;
		}
		else if(noOfDays>10) {
			discount = (7*basicFare*noOfDays)/100;
		}
		this.packageCost = ((basicFare*noOfDays)-discount)+(12*((basicFare*noOfDays)-discount)/100);
		
	}
	

}