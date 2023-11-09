package BankSystemPackage;

import javax.xml.validation.SchemaFactoryLoader;
import java.io.Serializable;

public class Address implements Serializable {
    private int streetNumber;
    private String streetName;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    private Address(){
    }

    public Address(int streetNumber, String streetName, String postalCode, String city, String province, String country){
        setStreetNumber(streetNumber);
        setStreetNumber(streetNumber);
        setPostalCode(postalCode);
        setCity(city);
        setProvince(province);
        setCountry(country);
    }

    public int getStreetNumber(){
        return streetNumber;
    }
    public String getStreetName(){
        return streetName;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public String getCity(){
        return city;
    }
    public String getProvince(){
        return province;
    }
    public String getCountry(){
        return country;
    }

    public void setStreetNumber(int streetNumber){
        if(streetNumber>9999 || streetNumber<1){
            System.out.println("Error ... street number set to invalid ");
            // logging into a file system
        }else{
            this.streetNumber = streetNumber;
        }
    }

    public void setStreetName(String streetName){
        if(streetName.length()>20){
            System.out.println("Error ... streetName can accept up to 20 charachter, street name has been truncated to the first 20 letters");
            // logging into a file system
            this.streetName = streetName.substring(0,19);
        }else{
            this.streetName = streetName;
        }
    }
    private boolean checkPostalCodeFormat(String postalCode){
        if(postalCode==null || postalCode.length()!=6){
            return false;
        }
        // L5A3Y4
        for(int i=0; i<postalCode.length(); i++){
            char ch = postalCode.charAt(i);
            byte asciiCode = (byte)ch;
            if(i%2 ==0){ // even index number --> charachters
                if( !((asciiCode>=97 && asciiCode<=122) || (asciiCode>=65 && asciiCode<=90))){
                    return false;
                }
            }else{ // odd index numbers --> numbers
                if( !(asciiCode>=48 && asciiCode<=57) ){
                    return false;
                }
            }
        }
        return true;
    }

    public void setPostalCode(String postalCode){
        boolean success = false;
        if(postalCode !=null) {
            int index = postalCode.indexOf(" ");
            if (postalCode.length() == 6) {
                if (index == -1) {
                    if (checkPostalCodeFormat(postalCode)) {
                        this.postalCode = postalCode;
                        success = true;
                    }
                }
            } else {
                if (index != -1) {
                    postalCode = postalCode.replace(" ", "");
                    if (postalCode.length() == 6) {
                        if (checkPostalCodeFormat(postalCode)) {
                            this.postalCode = postalCode;
                            success = true;
                        }

                    }
                }
            }
        }
        if(!success){
            System.out.println("Error... postal code invalid format");
            //logging into a file system
        }
    }
    public void setCity(String city){
        if(city ==null){
            System.out.println("Error... City cannot be null");
        }else{
            this.city = city;
        }

    }

    public void setProvince(String province){
        if(province == null){
            System.out.println("Error... Province cannot be null");
        }else if(province.length()>2){
            System.out.println("Warning... Invalid province...will be truncated to 2 characters");
            this.province= province.substring(0,1);
        }else{
            this.province = province;
        }
    }
    public void setCountry(String country){
        if(country ==null){
            System.out.println("Error... Country cannot be null");
        }else{
            this.country = country;
        }
    }
}
