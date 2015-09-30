package cagehos.tests;

import cagehos.exc.InvalidAddressException;
import cagehos.lib.Address;

public class TestAddress {
    public static void main(String[] args) throws InvalidAddressException {
        Address validAddress = new Address("Rua Max Padaratz", 737, "Centro", "Getúlio Vargas", "RS", "Brasil", 99900000);
        
        System.out.println(validAddress);
        
        Address invalidAddress = new Address("{}[]", 100);
        
        System.out.println(invalidAddress);
    }
}
