package com.random.address.util;

import java.util.HashMap;
import java.util.Map;

/**
 * This class holds static data of states codes vs state names of USA, CAN, MEX, NLD
 */
public class StatesAndCodes {
    public static final Map<String, String> stateCodeVsName = new HashMap<>();

    static {
        // Load US Codes.
        stateCodeVsName.put("AK", "Alaska");
        stateCodeVsName.put("AL", "Alabama");
        stateCodeVsName.put("AR", "Arkansas");
        stateCodeVsName.put("AZ", "Arizona");
        stateCodeVsName.put("CA", "California");
        stateCodeVsName.put("CO", "Colorado");
        stateCodeVsName.put("CT", "Connecticut");
        stateCodeVsName.put("DC", "District of Columbia");
        stateCodeVsName.put("DE", "Delaware");
        stateCodeVsName.put("FL", "Florida");
        stateCodeVsName.put("GA", "Georgia");
        stateCodeVsName.put("HI", "Hawaii");
        stateCodeVsName.put("IA", "Iowa");
        stateCodeVsName.put("ID", "Idaho");
        stateCodeVsName.put("IL", "Illinois");
        stateCodeVsName.put("IN", "Indiana");
        stateCodeVsName.put("KS", "Kansas");
        stateCodeVsName.put("KY", "Kentucky");
        stateCodeVsName.put("LA", "Louisiana");
        stateCodeVsName.put("MA", "Massachusetts");
        stateCodeVsName.put("MD", "Maryland");
        stateCodeVsName.put("ME", "Maine");
        stateCodeVsName.put("MI", "Michigan");
        stateCodeVsName.put("MN", "Minnesota");
        stateCodeVsName.put("MO", "Missouri");
        stateCodeVsName.put("MS", "Mississippi");
        stateCodeVsName.put("MT", "Montana");
        stateCodeVsName.put("NC", "North Carolina");
        stateCodeVsName.put("ND", "North Dakota");
        stateCodeVsName.put("NE", "Nebraska");
        stateCodeVsName.put("NH", "New Hampshire");
        stateCodeVsName.put("NJ", "New Jersey");
        stateCodeVsName.put("NM", "New Mexico");
        stateCodeVsName.put("NV", "Nevada");
        stateCodeVsName.put("NY", "New York");
        stateCodeVsName.put("OH", "Ohio");
        stateCodeVsName.put("OK", "Oklahoma");
        stateCodeVsName.put("OR", "Oregon");
        stateCodeVsName.put("PA", "Pennsylvania");
        stateCodeVsName.put("RI", "Rhode Island");
        stateCodeVsName.put("SC", "South Carolina");
        stateCodeVsName.put("SD", "South Dakota");
        stateCodeVsName.put("TN", "Tennessee");
        stateCodeVsName.put("TX", "Texas");
        stateCodeVsName.put("UT", "Utah");
        stateCodeVsName.put("VA", "Virginia");
        stateCodeVsName.put("VT", "Vermont");
        stateCodeVsName.put("WA", "Washington");
        stateCodeVsName.put("WI", "Wisconsin");
        stateCodeVsName.put("WV", "West Virginia");
        stateCodeVsName.put("WY", "Wyoming");
        stateCodeVsName.put("GU", "Guam");
        stateCodeVsName.put("VI", "Virgin Islands");
        stateCodeVsName.put("PR", "Puerto Rico");
        stateCodeVsName.put("AE", "Armed forces - Europe");
        stateCodeVsName.put("AA", "Armed forces - America");
        stateCodeVsName.put("AP", "Armed forces - Pacific");

        // Load Canada Codes.
        stateCodeVsName.put("AB", "Alberta");
        stateCodeVsName.put("BC", "British Columbia");
        stateCodeVsName.put("MB", "Manitoba");
        stateCodeVsName.put("NB", "New Brunswick");
        stateCodeVsName.put("NL", "Newfoundland and Labrador");
        stateCodeVsName.put("NT", "Northwest Territories");
        stateCodeVsName.put("NS", "Nova Scotia");
        stateCodeVsName.put("NU", "Nunavut");
        stateCodeVsName.put("ON", "Ontario");
        stateCodeVsName.put("PE", "Prince Edward Island");
        stateCodeVsName.put("QC", "Quebec");
        stateCodeVsName.put("SK", "Saskatchewan");
        stateCodeVsName.put("YT", "Yukon");

        // Load México Codes.
        stateCodeVsName.put("AGU", "Aguascalientes");
        stateCodeVsName.put("BCN", "Baja California");
        stateCodeVsName.put("BCS", "Baja California Sur");
        stateCodeVsName.put("CAM", "Campeche");
        stateCodeVsName.put("CHP", "Chiapas");
        stateCodeVsName.put("CHH", "Chihuahua");
        stateCodeVsName.put("COA", "Coahuila");
        stateCodeVsName.put("COL", "Colima");
        stateCodeVsName.put("DIF", "Distrito Federal");
        stateCodeVsName.put("DUR", "Durango");
        stateCodeVsName.put("GUA", "Guanajuato");
        stateCodeVsName.put("GRO", "Guerrero");
        stateCodeVsName.put("HID", "Hidalgo");
        stateCodeVsName.put("JAL", "Jalisco");
        stateCodeVsName.put("MEX", "México");
        stateCodeVsName.put("MIC", "Michoacán");
        stateCodeVsName.put("MOR", "Morelos");
        stateCodeVsName.put("NAY", "Nayarit");
        stateCodeVsName.put("NLE", "Nuevo León");
        stateCodeVsName.put("OAX", "Oaxaca");
        stateCodeVsName.put("PUE", "Puebla");
        stateCodeVsName.put("QUE", "Querétaro");
        stateCodeVsName.put("ROO", "Quintana Roo");
        stateCodeVsName.put("SLP", "San Luis Potosí");
        stateCodeVsName.put("SIN", "Sinaloa");
        stateCodeVsName.put("SON", "Sonora");
        stateCodeVsName.put("TAB", "Tabasco");
        stateCodeVsName.put("TAM", "Tamaulipas");
        stateCodeVsName.put("TLA", "Tlaxcala");
        stateCodeVsName.put("VER", "Veracruz");
        stateCodeVsName.put("YUC", "Yucatán");
        stateCodeVsName.put("ZAC", "Zacatecas");

        // Load NetherLands Codes.
        stateCodeVsName.put("DR","Drenthe");
        stateCodeVsName.put("FR","Friesland");
        stateCodeVsName.put("GE","Gelderland");
        stateCodeVsName.put("GR","Groningen");
        stateCodeVsName.put("LI","Limburg");
        stateCodeVsName.put("OV","Overijssel");
        stateCodeVsName.put("ZH","South Hollan");
        stateCodeVsName.put("ZE","Zeeland");

    }
}
