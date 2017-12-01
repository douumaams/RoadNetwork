package semaphores;

public interface BicolorStateLight extends IState
{
	public void change(BicolorLight bicolorLight);
	
	public void changeB(TraficL<BicolorStateLight> bicolorLight);
}
