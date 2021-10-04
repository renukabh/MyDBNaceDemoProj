package com.db.clm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nace")
public class Nace {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERID",updatable = false, nullable = false)
	private int order;

	@Column(name = "Levelid")
	private int level;

	@Column(name = "Code")
	private String code;

	@Column(name = "Parent")
	private String parent;

	@Column(name = "Description")
	private String description;

	@Column(name = "itemIncludes")
	private String itemIncludes;

	@Column(name = "itemAlsoIncludes")
	private String itemAlsoIncludes;

	@Column(name = "Rulings")
	private String rulings;

	@Column(name = "itemExcludes")
	private String excludes;

	@Column(name = "Refid")
	private String referenceRev;

	public Nace() {
		super();
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemIncludes() {
		return itemIncludes;
	}

	public void setItemIncludes(String itemIncludes) {
		this.itemIncludes = itemIncludes;
	}

	public String getItemAlsoIncludes() {
		return itemAlsoIncludes;
	}

	public void setItemAlsoIncludes(String itemAlsoIncludes) {
		this.itemAlsoIncludes = itemAlsoIncludes;
	}

	public String getRulings() {
		return rulings;
	}

	public void setRulings(String rulings) {
		this.rulings = rulings;
	}

	public String getExcludes() {
		return excludes;
	}

	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}

	public String getReferenceRev() {
		return referenceRev;
	}

	public void setReferenceRev(String referenceRev) {
		this.referenceRev = referenceRev;
	}

	@Override
	public String toString() {
		return "Nace [order=" + order + ", level=" + level + ", code=" + code + ", parent=" + parent + ", description="
				+ description + ", itemIncludes=" + itemIncludes + ", itemAlsoIncludes=" + itemAlsoIncludes
				+ ", rulings=" + rulings + ", excludes=" + excludes + ", referenceRev=" + referenceRev + "]";
	}

}
