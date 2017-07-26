package com.rundatop.sys.model;

import javax.persistence.*;

@Table(name = "sys_routes")
public class SysRoutes {
    @Id
    @Column(name = "function_id")
    private Integer functionId;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "state_title")
    private String stateTitle;

    @Column(name = "state_url")
    private String stateUrl;

    @Column(name = "controller_name")
    private String controllerName;

    @Column(name = "controller_name_as")
    private String controllerNameAs;

    @Column(name = "templateUrl")
    private String templateurl;

    private String resolve;
    
    private String stateParams;

    @Transient
    private String[] ids;
    @Transient
    private String functionName;
    
    public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
     * @return function_id
     */
    public Integer getFunctionId() {
        return functionId;
    }

    /**
     * @param functionId
     */
    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    /**
     * @return state_name
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @return state_title
     */
    public String getStateTitle() {
        return stateTitle;
    }

    /**
     * @param stateTitle
     */
    public void setStateTitle(String stateTitle) {
        this.stateTitle = stateTitle;
    }

    /**
     * @return state_url
     */
    public String getStateUrl() {
        return stateUrl;
    }

    /**
     * @param stateUrl
     */
    public void setStateUrl(String stateUrl) {
        this.stateUrl = stateUrl;
    }

    /**
     * @return controller_name
     */
    public String getControllerName() {
        return controllerName;
    }

    /**
     * @param controllerName
     */
    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    /**
     * @return controller_name_as
     */
    public String getControllerNameAs() {
        return controllerNameAs;
    }

    /**
     * @param controllerNameAs
     */
    public void setControllerNameAs(String controllerNameAs) {
        this.controllerNameAs = controllerNameAs;
    }

    /**
     * @return templateUrl
     */
    public String getTemplateurl() {
        return templateurl;
    }

    /**
     * @param templateurl
     */
    public void setTemplateurl(String templateurl) {
        this.templateurl = templateurl;
    }

    /**
     * @return resolve
     */
    public String getResolve() {
        return resolve;
    }

    /**
     * @param resolve
     */
    public void setResolve(String resolve) {
        this.resolve = resolve;
    }

	public String getStateParams() {
		return stateParams;
	}

	public void setStateParams(String stateParams) {
		this.stateParams = stateParams;
	}
    
    
}