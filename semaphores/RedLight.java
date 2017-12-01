package semaphores;

public class RedLight implements TricolorStateLight, BicolorStateLight
{

	@Override
	public void change(BicolorLight bicolorLight)
	{
		bicolorLight.setState(new GreenLight());
	}
	
	@Override
	public void change(TricolorLight tricolorLight)
	{
		tricolorLight.setState(new GreenLight());
	}

	@Override
	public void changeB(TraficL<BicolorStateLight> bicolorLight)
	{
		bicolorLight.setState(new GreenLight());		
	}

	@Override
	public void changeT(TraficL<TricolorStateLight> tricolorLight)
	{
		tricolorLight.setState(new GreenLight());
	}

	@Override
	public String toString()
	{
		return "RedLight";
	}

	
}
