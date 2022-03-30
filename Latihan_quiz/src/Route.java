

public class Route {
	
	private String routeName;
	private Integer routeDistance;
	private String routeID;
	private Integer routePrice;
	
	public Route(String routeName, Integer routeDistance, String routeID, Integer routePrice) {
		super();
		this.routeName = routeName;
		this.routeDistance = routeDistance;
		this.routeID = routeID;
		this.routePrice = routePrice;
	}
	
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Integer getRouteDistance() {
		return routeDistance;
	}
	public void setRouteDistance(Integer routeDistance) {
		this.routeDistance = routeDistance;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public Integer getRoutePrice() {
		return routePrice;
	}

	public void setRoutePrice(Integer routePrice) {
		this.routePrice = routePrice;
	}
	
	

}


