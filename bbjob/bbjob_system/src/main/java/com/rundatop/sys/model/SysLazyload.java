package com.rundatop.sys.model;

import javax.persistence.*;

@Table(name = "sys_lazyload")
public class SysLazyload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String files;

    @Transient
    private String[] ids;

    public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return files
     */
    public String getFiles() {
        return files;
    }

    /**
     * @param files
     */
    public void setFiles(String files) {
        this.files = files;
    }
}