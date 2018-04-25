package barBossHouse;

public final class Address {
    String cityName, streetName;
    int zipCode, buildingNumber, apartmentNumber;
    char buildingLetter;
    public static final Address EMPTY_ADDRESS = new Address();
    public static final String CITY_NAME_DEFAULT_S="Samara";
    public static final String CITY_NAME_DEFAULT="";
    public static final String STREET_NAME_DEFAULT="";
    public static final int ZIP_CODE_DEFAULT = -1;
    public static final int BUILDING_NUMBER_DEFAULT = -1;
    public static final int APARTMENT_NUMBER_DEFAULT = -1;
    public static final char BUILDING_LETTER_DEFAULT = ' ';


    public Address()
    {
        this(CITY_NAME_DEFAULT,STREET_NAME_DEFAULT,ZIP_CODE_DEFAULT,BUILDING_NUMBER_DEFAULT,BUILDING_LETTER_DEFAULT,APARTMENT_NUMBER_DEFAULT);
    }
    public Address(String streetName, int buildingNumber, char buildingLetter, int apartmentNumber)
    {
        this(CITY_NAME_DEFAULT_S, streetName, ZIP_CODE_DEFAULT, buildingNumber, buildingLetter, apartmentNumber);
    }
    public Address(String cityName, String streetName, int zipCode, int buildingNumber, char buildingLetter, int apartmentNumber)
    {
        this.cityName=cityName;
        this.streetName=streetName;
        this.zipCode=zipCode;
        this.buildingNumber=buildingNumber;
        this.buildingLetter=buildingLetter;
        this.apartmentNumber=apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }
    public int getZipCode() {
        return zipCode;
    }
    public String getStreetName(){
        return streetName;
    }
    public int getBuildingNumber(){
        return buildingNumber;
    }
    public char getBuildingLetter(){
        return buildingLetter;
    }
    public int getApartmentNumber() {
        return apartmentNumber;
    }
    @Override
    public String toString(){
        StringBuilder fullAddress = new StringBuilder("Address: ");
        if((cityName!=null) && (!cityName.isEmpty())) fullAddress.append(cityName+" ");
        if(zipCode!=ZIP_CODE_DEFAULT) fullAddress.append(zipCode+", ");
        if((streetName!=null) && (!streetName.isEmpty())) fullAddress.append(streetName+" ");
        if(buildingNumber!=BUILDING_NUMBER_DEFAULT) fullAddress.append(buildingNumber+" - ");
        if(buildingLetter!=BUILDING_LETTER_DEFAULT) fullAddress.append(buildingLetter);
        if(apartmentNumber!=APARTMENT_NUMBER_DEFAULT) fullAddress.append(APARTMENT_NUMBER_DEFAULT);
        return fullAddress.toString();
    }//“Address: <city> <zipCode>, <street> <buildingNumber><Literal>-<apartmentNumber>”
    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null) return false;
        Address equalsCheck = (Address) obj;
        if ((equalsCheck.cityName.equals(this.cityName)) && ((equalsCheck.streetName.equals(this.streetName)))&& (equalsCheck.buildingNumber==this.buildingNumber) && (equalsCheck.apartmentNumber==this.apartmentNumber) && (equalsCheck.zipCode==this.zipCode) )
        return true;
        else return false;

    }
    @Override
    public int hashCode(){
        return cityName.hashCode()^zipCode^streetName.hashCode()^buildingNumber^buildingLetter^apartmentNumber;
    }
}