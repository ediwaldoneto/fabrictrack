/**
 * 
 */
package br.com.nt.fabrictrack.model;

import java.util.Date;

/**
 * @author Neto
 *
 */
public class Person {

    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String cpf;
    private String rg;
    private String sex;
    private String maritalStatus;
    private Date birthDate;

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
	return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
	this.age = age;
    }

    /**
     * @return the address
     */
    public String getAddress() {
	return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
	return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
	this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
	return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
	return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
	this.rg = rg;
    }

    /**
     * @return the sex
     */
    public String getSex() {
	return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
	this.sex = sex;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
	return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
	this.maritalStatus = maritalStatus;
    }

}
