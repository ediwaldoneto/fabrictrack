/**
 * 
 */
package br.com.nt.fabrictrack.model;

import java.math.BigDecimal;
import java.util.Date;

import org.modelmapper.ModelMapper;

import br.com.nt.fabrictrack.model.dto.ProductDTO;

/**
 * @author Neto
 *
 */
public class Product {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private String category;
    private int size;
    private String color;
    private String material;
    private BigDecimal productValue;
    private Date dateRegister;

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
	return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
	this.brand = brand;
    }

    /**
     * @return the category
     */
    public String getCategory() {
	return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
	this.category = category;
    }

    /**
     * @return the size
     */
    public int getSize() {
	return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
	this.size = size;
    }

    /**
     * @return the color
     */
    public String getColor() {
	return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
	this.color = color;
    }

    /**
     * @return the material
     */
    public String getMaterial() {
	return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(String material) {
	this.material = material;
    }

    /**
     * @return the productValue
     */
    public BigDecimal getProductValue() {
	return productValue;
    }

    /**
     * @param productValue the productValue to set
     */
    public void setProductValue(BigDecimal productValue) {
	this.productValue = productValue;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public ProductDTO convertEntity() {
	return new ModelMapper().map(this, ProductDTO.class);
    }

    public Date getDateRegister() {
	return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
	this.dateRegister = dateRegister;
    }
}
