package com.target.metrotransit.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostBody {
	
	@JsonProperty(value = "BUS_ROUTE")
	private String source;
	
	@JsonProperty(value = "BUS_STOP_NAME")
	private String destination;
	
	@JsonProperty(value = "DIRECTION")
	private String direction;
	
	public PostBody() {
		super();
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostBody [source=" + source + ", destination=" + destination + ", direction=" + direction + "]";
	}
}