package com.story.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "person", catalog = "story")
public class Person implements java.io.Serializable {

	// Fields

	private Integer personid;
	private String account;
	private String password;
	private String email;
	private String sex;
	private String signature;
	private String filepath;
	private Set<Comments> commentses = new HashSet<Comments>(0);
	private Set<Novel> novels = new HashSet<Novel>(0);

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** minimal constructor */
	public Person(String account, String password) {
		this.account = account;
		this.password = password;
	}

	/** full constructor */
	public Person(String account, String password, String email, String sex,
			String signature, String filepath, Set<Comments> commentses,
			Set<Novel> novels) {
		this.account = account;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.signature = signature;
		this.filepath = filepath;
		this.commentses = commentses;
		this.novels = novels;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "personid", unique = true, nullable = false)
	public Integer getPersonid() {
		return this.personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	@Column(name = "account", nullable = false, length = 15)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "sex", length = 5)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "signature", length = 200)
	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "filepath", length = 40)
	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	public Set<Novel> getNovels() {
		return this.novels;
	}

	public void setNovels(Set<Novel> novels) {
		this.novels = novels;
	}

}