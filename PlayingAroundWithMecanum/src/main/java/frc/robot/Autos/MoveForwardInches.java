package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.MyTalonSRX;

public class MoveForwardInches extends CommandBase{
    private MyTalonSRX frontLeft;
    private MyTalonSRX frontRight;
    private MyTalonSRX rearLeft;
    private MyTalonSRX rearRight;

    public MoveForwardInches(){
        
    }
}
