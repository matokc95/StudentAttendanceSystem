package com.foi.air.core.entities;

public class Student {
    int idStudenta;
    private String email;
    private String lozinka;

    public Student(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }

    public Student(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    public int getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

}
