/**
 * 
 */
package br.com.nt.fabrictrack.model.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.modelmapper.ModelMapper;
import br.com.nt.fabrictrack.model.Client;

/**
 * @author Neto
 *
 */
public class ClientDTO {

    @NotNull(message = "name cannot be null")
    private String name;
    @Positive(message = "the value must be greater than zero")
    @Digits(integer = 2, message = "age has a maximum of 2 digits", fraction = 0)
    private int age;
    @NotNull(message = "address cannot be null")
    private String address;
    @NotNull(message = "phone cannot be null")
    private String phone;
    @NotNull(message = "email cannot be null")
    private String email;
    @NotNull(message = "cpf cannot be null")
    @NotBlank(message = "cpf cannot be blank")
    private String cpf;
    @NotNull(message = "rg cannot be null")
    private String rg;
    @NotNull(message = "sex cannot be null")
    private String sex;
    @NotNull(message = "maritalStatus cannot be null")
    private String maritalStatus;

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

    public Client convertEntity() {
	return new ModelMapper().map(this, Client.class);
    }
}
