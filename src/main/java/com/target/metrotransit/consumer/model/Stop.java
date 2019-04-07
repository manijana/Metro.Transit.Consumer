package com.target.metrotransit.consumer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Stop implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String STOPS = "Stops";

	@JsonProperty(value = "Text")
	private String stopName;
	
	@JsonProperty(value = "Value")
	private String stopId;
	
	public enum Direction {
        south("1"),
        east("2"),
        west("3"),
        north("4");

        private final String directionId;

        Direction(String directionId) {
            this.directionId = directionId;
        }

        public String getDirectionId() {
            return directionId;
        }
    }

	public Stop() {
		super();
	}
	
	/**
	 * @return the stopName
	 */
	public String getStopName() {
		return stopName;
	}

	/**
	 * @param stopName the stopName to set
	 */
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	/**
	 * @return the stopId
	 */
	public String getStopId() {
		return stopId;
	}

	/**
	 * @param stopId the stopId to set
	 */
	public void setStopId(String stopId) {
		this.stopId = stopId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stopId == null) ? 0 : stopId.hashCode());
		result = prime * result + ((stopName == null) ? 0 : stopName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stop other = (Stop) obj;
		if (stopId == null) {
			if (other.stopId != null)
				return false;
		} else if (!stopId.equals(other.stopId))
			return false;
		if (stopName == null) {
			if (other.stopName != null)
				return false;
		} else if (!stopName.equals(other.stopName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stop [stopName=" + stopName + ", stopId=" + stopId + "]";
	}
}