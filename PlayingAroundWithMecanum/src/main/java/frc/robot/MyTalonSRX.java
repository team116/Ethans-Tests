package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class MyTalonSRX extends TalonSRX implements MotorController{
    private double lastSpeed = 0;

    public MyTalonSRX(int deviceNumber) {
        super(deviceNumber);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void set(double speed) {
        lastSpeed = speed;
        super.set(getControlMode(), speed);
    }

    @Override
    public double get() {
        return lastSpeed;
    }

    @Override
    public void disable() {
        set(0.0);
    }

    @Override
    public void stopMotor() {
        disable();
    }
    
}
