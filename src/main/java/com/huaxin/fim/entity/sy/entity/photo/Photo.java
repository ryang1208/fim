package com.huaxin.fim.entity.sy.entity.photo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;

@Entity
@Table(name = "t_photo")
public class Photo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1579576331954857223L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="seq_t_photo")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "photo_url", nullable = false, length = 200)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 200)
	private String photoUrl;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "photo_data")
	@NotNull
	@NotEmpty
	private byte[] photoData;

	@Transient
	private File tmpFile;
	
	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public byte[] getPhotoData() {
		return photoData;
	}

	public void setPhotoData(byte[] photoData) {
		this.photoData = photoData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getTmpFile() {
		return tmpFile;
	}

	public void setTmpFile(File tmpFile) {
		this.tmpFile = tmpFile;
	}
	
	
}
