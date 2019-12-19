package org.manjunath.voterservice.model;

import java.io.Serializable;

public class ApiInfoModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6907011180382456987L;
	private String _service_name;
	private String _version;
	private String _message;
	private String _usage;
	private EndpointsDescription[] _endpoints;
	
	public ApiInfoModel() {}

	/**
	 * @param _service_name
	 * @param _version
	 * @param _message
	 * @param _usage
	 * @param endpoints
	 */
	public ApiInfoModel(String _service_name, String _version, String _message, String _usage, EndpointsDescription[] _endpoints) {
		this._service_name = _service_name;
		this._version = _version;
		this._message = _message;
		this._usage = _usage;
		this._endpoints = _endpoints;
	}

	public String get_service_name() {
		return _service_name;
	}

	public void set_service_name(String _service_name) {
		this._service_name = _service_name;
	}

	public String get_version() {
		return _version;
	}

	public void set_version(String _version) {
		this._version = _version;
	}

	public String get_message() {
		return _message;
	}

	public void set_message(String _message) {
		this._message = _message;
	}

	public String get_usage() {
		return _usage;
	}

	public void set_usage(String _usage) {
		this._usage = _usage;
	}

	public EndpointsDescription[] get_endpoints() {
		return _endpoints;
	}

	public void set_endpoints(EndpointsDescription[] _endpoints) {
		this._endpoints = _endpoints;
	}
}
