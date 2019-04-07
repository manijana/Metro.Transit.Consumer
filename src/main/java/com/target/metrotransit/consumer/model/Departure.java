package com.target.metrotransit.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Departure implements Serializable {

	private static final long serialVersionUID = 1L;

    @JsonProperty(value = "Actual")
    private boolean actual;
    
    @JsonProperty(value = "BlockNumber")
    private int blockNumber;

    @JsonProperty(value = "DepartureText")
    private String departureText;

    @JsonProperty(value = "DepartureTime")
    private String departureTime;

    @JsonProperty(value = "Description")
    private String description;

    @JsonProperty(value = "Gate")
    private String gate;

    @JsonProperty(value = "Route")
    private String route;

    @JsonProperty(value = "RouteDirection")
    private String routeDirection;

    @JsonProperty(value = "Terminal")
    private String terminal;

    @JsonProperty(value = "VehicleHeading")
    private int vehicleHeading;

    @JsonProperty(value = "VehicleLatitude")
    private long vehicleLatitude;

    @JsonProperty(value = "VehicleLongitude")
    private long vehicleLongitude;

	public Departure() {
		super();
	}

	/**
	 * @return the actual
	 */
	public boolean isActual() {
		return actual;
	}

	/**
	 * @param actual the actual to set
	 */
	public void setActual(boolean actual) {
		this.actual = actual;
	}

	/**
	 * @return the blockNumber
	 */
	public int getBlockNumber() {
		return blockNumber;
	}

	/**
	 * @param blockNumber the blockNumber to set
	 */
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}

	/**
	 * @return the departureText
	 */
	public String getDepartureText() {
		return departureText;
	}

	/**
	 * @param departureText the departureText to set
	 */
	public void setDepartureText(String departureText) {
		this.departureText = departureText;
	}

	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the gate
	 */
	public String getGate() {
		return gate;
	}

	/**
	 * @param gate the gate to set
	 */
	public void setGate(String gate) {
		this.gate = gate;
	}

	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}

	/**
	 * @return the routeDirection
	 */
	public String getRouteDirection() {
		return routeDirection;
	}

	/**
	 * @param routeDirection the routeDirection to set
	 */
	public void setRouteDirection(String routeDirection) {
		this.routeDirection = routeDirection;
	}

	/**
	 * @return the terminal
	 */
	public String getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the vehicleHeading
	 */
	public int getVehicleHeading() {
		return vehicleHeading;
	}

	/**
	 * @param vehicleHeading the vehicleHeading to set
	 */
	public void setVehicleHeading(int vehicleHeading) {
		this.vehicleHeading = vehicleHeading;
	}

	/**
	 * @return the vehicleLatitude
	 */
	public long getVehicleLatitude() {
		return vehicleLatitude;
	}

	/**
	 * @param vehicleLatitude the vehicleLatitude to set
	 */
	public void setVehicleLatitude(long vehicleLatitude) {
		this.vehicleLatitude = vehicleLatitude;
	}

	/**
	 * @return the vehicleLongitude
	 */
	public long getVehicleLongitude() {
		return vehicleLongitude;
	}

	/**
	 * @param vehicleLongitude the vehicleLongitude to set
	 */
	public void setVehicleLongitude(long vehicleLongitude) {
		this.vehicleLongitude = vehicleLongitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (actual ? 1231 : 1237);
		result = prime * result + blockNumber;
		result = prime * result + ((departureText == null) ? 0 : departureText.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((gate == null) ? 0 : gate.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result + ((routeDirection == null) ? 0 : routeDirection.hashCode());
		result = prime * result + ((terminal == null) ? 0 : terminal.hashCode());
		result = prime * result + vehicleHeading;
		result = prime * result + (int) (vehicleLatitude ^ (vehicleLatitude >>> 32));
		result = prime * result + (int) (vehicleLongitude ^ (vehicleLongitude >>> 32));
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
		Departure other = (Departure) obj;
		if (actual != other.actual)
			return false;
		if (blockNumber != other.blockNumber)
			return false;
		if (departureText == null) {
			if (other.departureText != null)
				return false;
		} else if (!departureText.equals(other.departureText))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (gate == null) {
			if (other.gate != null)
				return false;
		} else if (!gate.equals(other.gate))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (routeDirection == null) {
			if (other.routeDirection != null)
				return false;
		} else if (!routeDirection.equals(other.routeDirection))
			return false;
		if (terminal == null) {
			if (other.terminal != null)
				return false;
		} else if (!terminal.equals(other.terminal))
			return false;
		if (vehicleHeading != other.vehicleHeading)
			return false;
		if (vehicleLatitude != other.vehicleLatitude)
			return false;
		if (vehicleLongitude != other.vehicleLongitude)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Departure [actual=" + actual + ", blockNumber=" + blockNumber + ", departureText=" + departureText
				+ ", departureTime=" + departureTime + ", description=" + description + ", gate=" + gate + ", route="
				+ route + ", routeDirection=" + routeDirection + ", terminal=" + terminal + ", vehicleHeading="
				+ vehicleHeading + ", vehicleLatitude=" + vehicleLatitude + ", vehicleLongitude=" + vehicleLongitude
				+ "]";
	}
}