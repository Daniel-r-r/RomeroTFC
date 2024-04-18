package com.romero.ecommerce.entity;

import javax.persistence.*;

/**
 * Clase que representa un modelo de imagen en la aplicación de comercio
 * electrónico. Esta clase se utiliza para almacenar información sobre las
 * imágenes asociadas a los productos.
 *
 * @author Daniel Romero
 */

@Entity
@Table(name = "image_model")
public class ImageModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String type;

	@Column(length = 500000000)
	private byte[] picByte;

	public ImageModel() {

	}

	public ImageModel(String name, String type, byte[] picByte) {
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

}
