package net.webapp.domain;

import java.util.Date;

import org.springframework.security.core.userdetails.User;

public class Topic {
	private String title;
	private String slugName;
	private User author;
	private Date creationDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getSlugName() {
		return slugName;
	}

	public void setSlugName(String slugName) {
		this.slugName = slugName;
	}

}
