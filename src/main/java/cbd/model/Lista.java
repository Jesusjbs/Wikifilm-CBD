package cbd.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	Long id;

	private String title;
	
	@ManyToOne(optional = true)
	private Set<Movie> peliculas;
	
	@ManyToOne(optional = true)
	private Set<Serie> series;

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

	public Set<Movie> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<Movie> peliculas) {
		this.peliculas = peliculas;
	}

	public Set<Serie> getSeries() {
		return series;
	}

	public void setSeries(Set<Serie> series) {
		this.series = series;
	}

}