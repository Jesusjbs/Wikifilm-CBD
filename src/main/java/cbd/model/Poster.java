package cbd.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Poster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	Long id;
	private String profilePath;

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

}

