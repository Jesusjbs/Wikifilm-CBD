package cbd.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Unique;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Serie extends Path implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Unique
	private String title;
	
	private LocalDate released;
	
	private String runtime;
	
	private String plot;
	
	private Integer totalSeasons;
	
	private String genre;
	
	private String channel;

	@NotNull
	private Boolean terminated;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Actor> actors;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "serie", fetch = FetchType.EAGER)
	private List<Comment> comments;

	public Serie() {
	}

	public Serie(String title, LocalDate released, String runtime, String plot, Integer totalSeasons, String genre,
			String channel, Boolean terminated, String poster,String video) {
		this.title = title;
		this.released = released;
		this.runtime = runtime;
		this.plot = plot;
		this.totalSeasons = totalSeasons;
		this.genre = genre;
		this.channel = channel;
		this.terminated = terminated;
		this.profilePath = poster;
		this.videoPath = video;
	}

	public LocalDate getReleased() {
		return released;
	}

	public void setReleased(LocalDate released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
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

	public Integer getTotalSeasons() {
		return totalSeasons;
	}

	public void setTotalSeasons(Integer totalSeasons) {
		this.totalSeasons = totalSeasons;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Boolean getTerminated() {
		return terminated;
	}

	public void setTerminated(Boolean terminated) {
		this.terminated = terminated;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Actor getActor(Long id) {
		if (actors == null) {
			return null;
		}
		Actor act = null;
		for (Actor a : actors) {
			if (a.getId().equals(id)) {
				act = a;
				break;
			}
		}
		return act;
	}

	public void addActor(Actor act) {
		if (actors == null)
			actors = new ArrayList<Actor>();
		actors.add(act);
	}

	public void deleteActor(Actor act) {
		actors.remove(act);
	}

	public void deleteActor(Long id) {
		Actor a = getActor(id);
		if (a != null)
			actors.remove(a);
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment getComment(Long id) {
		if (comments == null) {
			return null;
		}
		Comment com = null;
		for (Comment c : comments) {
			if (c.getId().equals(id)) {
				com = c;
				break;
			}
		}
		return com;
	}

	public void addComment(Comment com) {
		if (comments == null)
			comments = new ArrayList<Comment>();
		comments.add(com);
	}

	public void deleteComment(Comment com) {
		comments.remove(com);
	}

	public void deleteComment(Long id) {
		Comment c = getComment(id);
		if (c != null)
			comments.remove(c);
	}

}
