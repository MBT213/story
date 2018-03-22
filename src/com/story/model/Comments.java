package com.story.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comments", catalog = "story")
public class Comments implements java.io.Serializable {

	// Fields

	private Integer commentid;
	private Person person;
	private Novel novel;
	private String comment;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(Novel novel) {
		this.novel = novel;
	}

	/** full constructor */
	public Comments(Person person, Novel novel, String comment) {
		this.person = person;
		this.novel = novel;
		this.comment = comment;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "commentid", unique = true, nullable = false)
	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "people")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "story", nullable = false)
	public Novel getNovel() {
		return this.novel;
	}

	public void setNovel(Novel novel) {
		this.novel = novel;
	}

	@Column(name = "comment", length = 200)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}