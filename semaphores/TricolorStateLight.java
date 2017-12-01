package semaphores;

public interface TricolorStateLight extends IState
{
	public void change(TricolorLight tricolorLight);
	
	public void changeT(TraficL<TricolorStateLight> tricolorLight);
}

