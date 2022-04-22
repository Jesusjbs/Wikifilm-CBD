package cbd.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	Long id;

	private String title;

	public Lista() {
	}

	public Lista(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}