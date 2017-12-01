package semaphores;

public class GreenLight implements TricolorStateLight, BicolorStateLight
{

	@Override
	public void change(BicolorLight bicolorLight)
	{
		bicolorLight.setState(new RedLight());
	}

	@Override
	public void change(TricolorLight tricolorLight)
	{
		tricolorLight.setState(new OrangeLight());
	}

	@Override
	public void changeB(TraficL<BicolorStateLight> bicolorLight)
	{
		bicolorLight.setState(new RedLight());
	}

	@Override
	public void changeT(TraficL<TricolorStateLight> tricolorLight)
	{
		tricolorLight.setState(new OrangeLight());
	}

	@Override
	public String toString()
	{
		return "GreenLight";
	}
	
	
	
}
