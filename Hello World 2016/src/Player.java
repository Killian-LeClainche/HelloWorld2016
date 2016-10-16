import org.joml.Vector3d;

public class Player extends Block
{
	private Vector3d movement;
	private int numJumps;
	private Beam currentBeam;
	private double beamTicks = .25;
	
	public Player(World world, double x, double y, double size)
	{
		super(world, x, y, size, size);
		movement = new Vector3d(0, 0, 0);
		numJumps = 2;
	}
	
	public void update(double delta)
	{
		movement.x /= 2d;
		if(currentBeam != null)
		{
			beamTicks -= delta;
			if(beamTicks <= 0)
			{
				currentBeam = null;
			}
		}
	}
	
	public void useJump()
	{
		numJumps--;
	}
	
	public void resetJumps()
	{
		numJumps = 2;
	}
	
	public void nullifyJumps()
	{
		numJumps = 0;
	}
	
	public double getSize()
	{
		return pos.z;
	}
	
	public double getVelX()
	{
		return movement.x;
	}
	
	public double getVelY()
	{
		return movement.y;
	}
	
	public double getAccelX()
	{
		return movement.z;
	}
	
	public int getNumJumps()
	{
		return numJumps;
	}
	
	public double getBeamTicks()
	{
		return beamTicks;
	}
	
	public void setSize(double s)
	{
		pos.z = s;
		pos.w = s;
	}
	
	public void setVelX(double vx)
	{
		movement.x = vx;		
	}
	
	public void setVelY(double vy)
	{
		movement.y = vy;
	}
	
	public void setAccelX(double ax)
	{
		movement.z = ax;
	}
	
	public Vector3d getMoveVector()
	{
		return movement;
	}
	
	public void setBeam(Beam b)
	{
		currentBeam = b;
		beamTicks = .25;
	}
	
	public Beam getBeam()
	{
		return currentBeam;
	}

}
