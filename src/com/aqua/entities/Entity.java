package com.aqua.entities;

import java.util.List;

import com.aqua.Direction;
import com.aqua.animations.AnimatedActor;
import com.aqua.entities.states.DefaultState;
import com.aqua.entities.states.NormalFishState;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;

/**
 * 
 * @author Gallo
 *
 *Entity Class. This class is an abstract class that 
 *holds all common methods for our game objects. 
 *This class will make it easy to check collisions,
 *and finding the closest entities by using midpoints
 *
 *
 */

public abstract class Entity extends AnimatedActor{
	
	private String entityName;
	private int entityId;
	protected GameView gameView;
	private State currentState;
	
	
	/**
	 * 
	 * @param gameView takes in a game object
	 * @param entityId the entity id being created by the singleton
	 */
	//might change constructor to allow singleton to create id inside entity class
	public Entity(GameView gameView, int entityId) {
		this.gameView = gameView;
		this.entityId = entityId;
		setEntityName(createName());
		setCurrentState(initState());
		
	}
	
	
	/**
	 * acts using the current states movement function
	 */
	@Override
	public void act(float delta) {
		currentState.movement(delta);
		super.act(delta);
	}
	
	protected abstract State initState();
	
	/**
	 * 
	 * @return gets the state of this entity.
	 * The state could be anything from normal, hungry, dead, opened, closed etc.
	 */
	public State getCurrentState() {
		return currentState;
	}
	
	/**
	 * 
	 * @param currentState sets the state of this entity
	 */
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	protected abstract String createName();
	
	/**
	 * 
	 * @param entityName entity name to be set
	 */
	protected void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	/**
	 * 
	 * @return the name of the specific entity type
	 */
	public String getEntityName() {
		return entityName;
	}
	
	/**
	 * 
	 * @return unique id for each instance of an entity
	 */
	public int getEntityId() {
		return entityId;
	}
	
	/**
	 * 
	 * @return returns the current gameview
	 */
	public GameView getGameView() {
		return gameView;
	}
	
	/**
	 * removes this entity
	 */
	public void removeThis(){
		gameView.removeEntity(this);
	}
	
	/**
	 * 
	 * @param collider other entity to check collision with
	 * @return returns true if the two entities have collided
	 */
	public boolean collidesWith(Entity collider){
		if(this.getX() < collider.getX()+collider.getWidth() && this.getX()+this.getWidth()> collider.getX()){
			System.out.println("entity X: "+this.getX()+" entity Y: "+this.getY()+" entity width: "+this.getWidth() +" entity height: "+ this.getHeight()
					+" collider X: "+ collider.getX()+" collider Y: "+ collider.getY()+ " collider width: "+collider.getWidth() +" collider height: "+ collider.getHeight());
			if(this.getY() < collider.getY()+collider.getHeight() && this.getY()+this.getHeight() > collider.getY()){
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param entities the list of entities to check for distances
	 * @return returns the closest entity to this entity
	 */
	public Entity findClosestEntity(List<Entity> entities){
		Entity closest = entities.get(0);
		double currentDistance = distanceFormula(closest);
		double distance;
		for(int i = 1; i < entities.size(); i++){
			distance = distanceFormula(entities.get(i));
			if(distance < currentDistance){
				currentDistance = distance;
				closest = entities.get(i);
			}
		}
		return closest;
	}

	/**
	 * 
	 * @param entity entity to check distance with
	 * @return the distance away from entity
	 */
	private double distanceFormula(Entity entity){
		return Math.sqrt((this.getCenterX()-entity.getCenterX())*(this.getCenterX()-entity.getCenterX()) 
				+ (this.getCenterY()-entity.getCenterY())*(this.getCenterY()-entity.getCenterY()));
	}
	
	/**
	 * 
	 * @return gets the center of the entities x position
	 */
	public float getCenterX(){
		return (this.getWidth()/2)+this.getX();
	}
	
	/**
	 * 
	 * @return gets the center of the entities y position
	 */
	public float getCenterY(){
		return (this.getHeight()/2)+this.getY();
	}

	/**
	 * makes sure no entity goes out of the gameView region
	 * (maybe switch direction)
	 */
	public void checkHorizontalWalls() {
		//Horizontal walls
		if(getX()< 0){
			setX(0);
			setDirectionHorizontal(Direction.RIGHT);
		}
		else if(getX()+getWidth() > gameView.getWidth()){
			setX(gameView.getWidth()-getWidth());
			setDirectionHorizontal(Direction.LEFT);
		}
		
	}
	
	public void checkVerticleWalls(){
		//Vertical Walls
		if(getY() < 0){
			setY(0);
			setDirectionVerticle(Direction.UP);
		}
		else if(getY()+getHeight() > gameView.getHeight()){
			setY(gameView.getHeight()-getHeight());
			setDirectionVerticle(Direction.DOWN);
		}
	}

}
