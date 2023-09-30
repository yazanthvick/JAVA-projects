package BANKSYSTEM;

import java.io.Serializable;
import java.util.ArrayList;

public class Address implements Serializable {
    private int streetNumber;
    private String streetName;
    private String postalCode;
    private String city;
    private String province;
    private String country;
    private ArrayList<Customer> customers;

    private Address() {
    }

    public Address(int streetNumber, String streetName, String postalCode, String city, String province, String country) {
        setStreetNumber(streetNumber);
        setStreetName(streetName);
        setPostalCode(postalCode);
        setCity(city);
        setProvince(province);
        setCountry(country);
    }

    public int getStreetNumber() {
        return this.streetNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCountry() {
        return this.country;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setStreetNumber(int streetNumber) {
        if (streetNumber <= 9999 && streetNumber >= 1) {
            this.streetNumber = streetNumber;
        } else {
            System.out.println("Error ... street number set to invalid ");
        }

    }

    public void setStreetName(String streetName) {
        if (streetName.length() > 20) {
            System.out.println("Error ... streetName can accept up to 20 charachter, street name has been truncated to the first 20 letters");
            this.streetName = streetName.substring(0, 19);
        } else {
            this.streetName = streetName;
        }

    }

    private boolean checkPostalCode(String postalCode){
        if(postalCode == null || postalCode.length() != 6){
            return false;
        }
        for(int i=0; i<postalCode.length(); i++){
            byte index = (byte)postalCode.charAt(i);
            if(i%2==0){
                if(!(index >= 65 && index <=90 || index >= 97 && index <= 122)){
                    return false;
                }
            }else{
                if(!(index >= 48 && index <=57)){
                    return false;
                }
            }
        }
        return true;
    }

    public void setPostalCode(String postalCode) {
        boolean flag = false;
        int index;
        if (postalCode.length() == 6) {
            index = postalCode.indexOf(" ");
            if (index == -1) {
                if(checkPostalCode(postalCode)) {
                    this.postalCode = postalCode;
                    flag = true;
                }
            }
        } else {
            index = postalCode.indexOf(" ");
            if (index != -1) {
                postalCode = postalCode.replace(" ", "");
                if (postalCode.length() == 6) {
                    if(checkPostalCode(postalCode)) {
                        this.postalCode = postalCode;
                        flag = true;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("Error... postal code invalid format");
        }
    }
    public void setCity(String city){
        if(city == null){
            System.out.println("invalid city");
        }else{
            this.city = city;
        }
    }

    public void setProvince(String province){
        if(province == null){
            System.out.println("invalid province");
        }else if(province.length()!=2){
            System.out.println("Invalid province...will be truncated to 2 letters");
            this.province = province.substring(0,1);
        }else{
            this.province = province;
        }
    }

    public void setCountry(String country){
        if(country == null){
            System.out.println("invalid country");
        }else{
            this.country = country;
        }
    }

    public void setCustomers() {
        this.customers = new ArrayList<Customer>();
    }
}

