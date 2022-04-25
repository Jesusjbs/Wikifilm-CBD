package cbd.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.jdo.annotations.Unique;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;

@Entity
public class Actor extends Path implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Unique
	private String name;
	
	@Past
	private LocalDate birthday;
	
	private LocalDate deathday;
	private Integer age;
	private String biography;
	private String placeOfBirth;
	private String gender;

	public Actor() {
	}

	public Actor(String name, LocalDate birthday, LocalDate deathday, Integer age, String biography,
			String placeOfBirth, String gender, String poster) {
		this.name = name;
		this.birthday = birthday;
		this.deathday = deathday;
		this.age = age;
		this.biography = biography;
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		this.profilePath = poster;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public LocalDate getDeathday() {
		return deathday;
	}

	public void setDeathday(LocalDate deathday) {
		this.deathday = deathday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
