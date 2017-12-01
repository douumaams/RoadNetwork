package semaphores;

public class TricolorLight extends TrafficLight
{
	private TricolorStateLight state;

	public TricolorLight(TricolorStateLight stateLight)
	{
		this.state = stateLight;
	}
	
	public TricolorLight()
	{
		this.state = new RedLight();
	}
	
	@Override
	public void changeColor()
	{
		state.change(this);
	}
	
	public void setState(TricolorStateLight state)
	{
		this.state = state;
	}
	
	public TricolorStateLight getState()
	{
		return state;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
