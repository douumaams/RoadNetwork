package semaphores;

public class BicolorLight extends TrafficLight 
{
	private BicolorStateLight state;

	public BicolorLight(BicolorStateLight stateLight)
	{
		this.state = stateLight;
	}
	
	public BicolorLight()
	{
		this.state = new RedLight();
	}
	
	@Override
	public void changeColor()
	{
		state.change(this);
	}
	
	public void setState(BicolorStateLight state)
	{
		this.state = state;
	}

	@Override
	public String toString()
	{
		return "BicolorLight " + super.toString() + state.toString() +"]";
	}
	
	
}
