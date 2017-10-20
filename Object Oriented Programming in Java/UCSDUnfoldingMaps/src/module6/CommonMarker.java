package module6;


import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PGraphics;

/** Implements a common marker for cities and earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 *
 */
public abstract class CommonMarker extends SimplePointMarker {

	// Records whether this marker has been clicked (most recently)
	protected boolean clicked = false;
	
	public CommonMarker(Location location) {
		super(location);
	}
	
	public CommonMarker(Location location, java.util.HashMap<java.lang.String,java.lang.Object> properties) {
		super(location, properties);
	}
	
	// Getter method for clicked field
	public boolean getClicked() {
		return clicked;
	}
	
	// Setter method for clicked field
	public void setClicked(boolean state) {
		clicked = state;
	}
	
	// Common piece of drawing method for markers; 
	// YOU WILL IMPLEMENT. 
	// Note that you should implement this by making calls 
	// drawMarker and showTitle, which are abstract methods 
	// implemented in subclasses
	public void draw(PGraphics pg, float x, float y) {
		// For starter code just drawMaker(...)
		if (!hidden) {
			drawMarker(pg, x, y);
			if (selected) {
				showTitle(pg, x, y);
			}
		}
	}
	
	// Returns the distance (in km) between two commonMarker instances.
	public double getDist(CommonMarker other)
	{
		return getDistanceTo(other.getLocation());
	}
	
	// A method to draw between an EQ and cities in its threat radius.
	// This method does nothing unless it is called by an earthquakeMarker
	protected void drawLines(EarthquakeCityMap pg, boolean visible, List<Marker> cities, UnfoldingMap map)
	{
		;
	}
	
	// A helper method to draw a line between to screenPosition instances.
	protected void drawLine(EarthquakeCityMap pg, ScreenPosition pos1, ScreenPosition pos2)
	{
		pg.line(pos1.x, pos1.y, pos2.x, pos2.y);
	}
	
	protected void drawLine(EarthquakeCityMap pg, Location loc)
	{
		System.out.println("Drawing line from (" + this.getLocation().x + ","
							+ this.getLocation().y + ") to ("+  loc.x + ", " +  loc.y + ").");
		pg.line(this.getLocation().x, this.getLocation().y, loc.x, loc.y);
	}
	
	public abstract void drawMarker(PGraphics pg, float x, float y);
	public abstract void showTitle(PGraphics pg, float x, float y);
}