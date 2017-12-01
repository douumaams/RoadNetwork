package semaphores;

public class OrangeLight implements TricolorStateLight
{

	@Override
	public void change(TricolorLight tricolorLight)
	{
		tricolorLight.setState(new RedLight());
	}

	@Override
	public void changeT(TraficL<TricolorStateLight> tricolorLight)
	{
		tricolorLight.setState(new RedLight());
	}

	@Override
	public String toString()
	{
		return "OrangeLight";
	}
	
	

}
