package javaapplication;

import java.time.LocalDate;

/**
 *
 * @author lahir
 */


class Customer {
    private String name;
    private String id;
    
    // Constructor
    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
}
