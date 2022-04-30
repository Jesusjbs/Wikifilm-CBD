package cbd.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Lista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private String title;

	private String description;

	@NotNull
	private Boolean privateList;

	@ManyToOne(optional = true)
	private Set<Movie> movies;

	@ManyToOne(optional = true)
	private Set<Serie> series;

	@OneToOne
	@JoinColumn(name = "username")
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPrivateList() {
		return privateList;
	}

	public void setPrivateList(Boolean privateList) {
		this.privateList = privateList;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public void addMovies(Movie mov) {
		if (movies == null)
			movies = new HashSet<Movie>();
		movies.add(mov);
	}

	public void deleteMovie(Movie mov) {
		movies.remove(mov);
	}

	public Set<Serie> getSeries() {
		return series;
	}

	public void setSeries(Set<Serie> series) {
		this.series = series;
	}

	public void addSeries(Serie ser) {
		if (series == null)
			series = new HashSet<Serie>();
		series.add(ser);
	}

	public void deleteSerie(Serie ser) {
		series.remove(ser);
	}

}