package com.story.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Novel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "novel", catalog = "story")
public class Novel implements java.io.Serializable {

	// Fields

	private Integer novelid;
	private Person person;
	private Category category;
	private String novelname;
	private String content;
	private Set<Comments> commentses = new HashSet<Comments>(0);

	// Constructors

	/** default constructor */
	public Novel() {
	}

	/** minimal constructor */
	public Novel(String novelname, String content) {
		this.novelname = novelname;
		this.content = content;
	}

	/** full constructor */
	public Novel(Person person, Category category, String novelname,
			String content, Set<Comments> commentses) {
		this.person = person;
		this.category = category;
		this.novelname = novelname;
		this.content = content;
		this.commentses = commentses;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "novelid", unique = true, nullable = false)
	public Integer getNovelid() {
		return this.novelid;
	}

	public void setNovelid(Integer novelid) {
		this.novelid = novelid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categorys")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "novelname", nullable = false, length = 30)
	public String getNovelname() {
		return this.novelname;
	}

	public void setNovelname(String novelname) {
		this.novelname = novelname;
	}

	@Column(name = "content", nullable = false, length = 5000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "novel")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}

}