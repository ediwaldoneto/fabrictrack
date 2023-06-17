/**
 * 
 */
package br.com.nt.fabrictrack.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import br.com.nt.fabrictrack.model.Product;

/**
 * @author Neto
 *
 */
public class ProductDTO {

    private Long id;
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "description cannot be null")
    private String description;
    @NotNull(message = "brand cannot be null")
    private String brand;
    @NotNull(message = "category cannot be null")
    private String category;
    @NotNull(message = "size cannot be null")
    private int size;
    @NotNull(message = "color cannot be null")
    private String color;
    private String material;
    @NotNull(message = "productValue cannot be null")
    private BigDecimal productValue;

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

    public Product convertEntity() {
	return new ModelMapper().map(this, Product.class);
    }
}
