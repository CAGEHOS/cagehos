package cagehos.lib;

import cagehos.exc.InvalidAddressException;

/**
 * The Address class provides methods to create and access address information, such as district, number, address name and others.
 * @author Julio Ceron, Leonardo Falk
 */
public class Address {
    private String addressName;
    private int addressNumber;
    private String addressZipCode;
    private String addressDistrict;
    private String addressCity;
    private String addressState;
    private String addressComplement;

    /**
     * Creates the object Address with the information about someone's address.
     * @param name The address name.
     * @param number The address number.
     * @throws InvalidAddressException If the address contains invalid parameters, such as negative number or invalid characters on the name.
     */
    public Address(String name, int number) throws InvalidAddressException {
        if (number < 0) {
            throw new InvalidAddressException("Número de endereço inválido.");
        }
        
        if (name.length() == 0) {
            throw new InvalidAddressException("Endereço em branco.");
        }
        
        if (name.matches("[^a-zA-Z0-9\\s]+")) {
            throw new InvalidAddressException("Caracteres inválidos para o nome do endereço. Utilize letras e/ou números.");
        }
        
        addressName = name;
        addressNumber = number;
    }
    
    /**
     * Creates the object Address with the full information about someone's address.
     * @param name The address name.
     * @param number The address number.
     * @param district The district name.
     * @param city The city name.
     * @param state The state name.
     * @param zipCode The zip code number.
     * @param complement The address complement information.
     * @throws InvalidAddressException If any of the information was given using invalid characters or numbers.
     */
    public Address(String name, int number, String district, String city, String state, String zipCode, String complement) throws InvalidAddressException {
        if (number <= 0) {
            throw new InvalidAddressException("Número de endereço inválido.");
        }
        
        if (name.length() == 0) {
            throw new InvalidAddressException("Endereço em branco.");
        } else if (name.matches("[^a-zA-Z0-9\\s]+")) {
            throw new InvalidAddressException("Letras inválidas para o nome do endereço. Utilize e/ou números.");
        }
        
        if (district.length() == 0) {
            throw new InvalidAddressException("Bairro em branco.");
        } else if (district.matches("[^a-zA-Z0-9\\s]+")) {
            throw new InvalidAddressException("Letras inválidas para o nome do bairro. Utilize letras e/ou números.");
        }
        
        if (city.length() == 0) {
            throw new InvalidAddressException("Cidade em branco.");
        } else if (city.matches("[^a-zA-Z\\s]+")) {
            throw new InvalidAddressException("Letras inválidas para o nome da cidade. Utilize apenas letras.");
        }
        
        if (state.length() == 0) {
            throw new InvalidAddressException("Estado em branco.");
        } else if (state.matches("[^a-zA-Z\\s]+")) {
            throw new InvalidAddressException("Letras inválidas para o nome do estado. Utilize apenas letras.");
        }
        
        addressName = name;
        addressNumber = number;
        addressDistrict = district;
        addressCity = city;
        addressState = state;
        addressZipCode = zipCode;
        addressComplement = complement;
    }
    
    /**
     * Returns the current address name.
     * @return The current address name.
     */
    public String getName() {
        return addressName;
    }
    
    /**
     * Sets the new address name for he object.
     * @param name The new address name.
     * @throws InvalidAddressException If the name contains invalid characters.
     */
    public void setName(String name) throws InvalidAddressException {
        if (name.length() == 0) {
            throw new InvalidAddressException("Endereço em branco.");
        } else if (name.matches("[^a-zA-Z0-9\\s]+")) {
            throw new InvalidAddressException("Letras inválidos para o nome do endereço. Utilize letras apenas.");
        }
        
        addressName = name;
    }
    
    /**
     * Returns the current address number.
     * @return The current address number.
     */
    public int getNumber() {
        return addressNumber;
    }
    
    /**
     * Sets the new address number for the object.
     * @param number The new address number.
     * @throws InvalidAddressException If the number is negative or zero.
     */
    public void setNumber(int number) throws InvalidAddressException {
        if (number <= 0) {
            throw new InvalidAddressException("Número de endereço inválido.");
        }
        
        addressNumber = number;
    }
    
    /**
     * Returns the current city name of the address object.
     * @return The current city name.
     */
    public String getCityName() {
        return addressCity;
    }
    
    /**
     * Sets the new city name of the address object.
     * @param city The new city name.
     * @throws InvalidAddressException If the name contains invalid characters.
     */
    public void setCityName(String city) throws InvalidAddressException {
        if (city.length() == 0) {
            throw new InvalidAddressException("Cidade em branco.");
        } else if (city.matches("[^a-zA-Z\\s]+")) {
            throw new InvalidAddressException("Letras inválidas para o nome da cidade. Utilize apenas letras.");
        }
        
        addressCity = city;
    }
    
    /**
     * Returns the current state name of the address object.
     * @return The current state name.
     */
    public String getStateName() {
        return addressState;
    }
    
    /**
     * Sets the new state name for the address object.
     * @param state The new state name.
     * @throws InvalidAddressException If the name contains invalid characters.
     */
    public void setStateName(String state) throws InvalidAddressException {
        if (state.length() == 0) {
            throw new InvalidAddressException("Estado em branco.");
        } else if (state.matches("[^a-zA-Z\\s]+")) {
            throw new InvalidAddressException("Letras inválidas para o nome do Estado. Utilize apenas letras.");
        }
        
        addressState = state;
    }
    
    /**
     * Returns the current zip code number of the address object.
     * @return The current zip code.
     */
    public String getZipCode() {
        return addressZipCode;
    }
    
    /**
     * Sets the new zip code for the address object.
     * @param zipCode The new zip code.
     */
    public void setZipCode(String zipCode) {
        addressZipCode = zipCode;
    }
    
    /**
     * Returns the current district name of the address object.
     * @return The current district name.
     */
    public String getDistrict() {
        return addressDistrict;
    }
    
    /**
     * Sets the new district name for the address object.
     * @param district The new district name.
     * @throws InvalidAddressException If the name contains invalid characters.
     */
    public void setDistrict(String district) throws InvalidAddressException {
        if (district.length() == 0) {
            throw new InvalidAddressException("Bairro em branco.");
        } else if (district.matches("[^a-zA-Z0-9\\s]+")) {
            throw new InvalidAddressException("Letras inválidas para o nome do bairro. Utilize letras e/ou números.");
        }
        
        addressDistrict = district;
    }
    
    /**
     * Returns the current complement information about the address object.
     * @return The complement information.
     */
    public String getComplement() {
        return addressComplement;
    }
    
    /**
     * Sets the new complement information for the address object.
     * @param complement The new complement information.
     */
    public void setComplement(String complement) {
        addressComplement = complement;
    }
    
    /**
     * Returns the address object information formatted in the brazilian postcard standards.
     * @return The address object formatted as a string.
     */
    @Override
    public String toString() {
        return String.format("%s, %d\n%s\nCEP: %s, %s - %s",
            addressName,
            addressNumber,
            addressDistrict,
            addressZipCode,
            addressCity,
            addressState);
    }
}
