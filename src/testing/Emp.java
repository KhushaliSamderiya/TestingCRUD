package testing;

public class Emp {  
private long Price_per_person;  
private String Package_ID,Package_Name,Package_type,Inclusions,Nights;

public long getPrice_per_person() {
	return Price_per_person;
}
public void setPrice_per_person(long price_per_person) {
	Price_per_person = price_per_person;
}
public String getPackage_ID() {
	return Package_ID;
}
public void setPackage_ID(String package_ID) {
	Package_ID = package_ID;
}
public String getPackage_Name() {
	return Package_Name;
}
public void setPackage_Name(String package_Name) {
	Package_Name = package_Name;
}
public String getPackage_type() {
	return Package_type;
}
public void setPackage_type(String package_type) {
	Package_type = package_type;
}
public String getInclusions() {
	return Inclusions;
}
public void setInclusions(String inclusions) {
	Inclusions = inclusions;
}
public String getNights() {
	return Nights;
}
public void setNights(String nights) {
	Nights = nights;
}  
}