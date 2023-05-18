// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {
  private static final int kFrontLeftID = 1;
  private static final int kRearLeftID = 2;
  private static final int kFrontRightID = 3;
  private static final int kRearRightID = 4;

  private static final int kJoystickChannelLeft = 0;

  private final SendableChooser<Command> sendableChooser = new SendableChooser<>();

  private MecanumDrive m_robotDrive;
  private XboxController leftJoystick;

  @Override
  public void robotInit() {
    MyTalonSRX frontLeft = new MyTalonSRX(kFrontLeftID);
    MyTalonSRX rearLeft = new MyTalonSRX(kRearLeftID);
    MyTalonSRX frontRight = new MyTalonSRX(kFrontRightID);
    MyTalonSRX rearRight = new MyTalonSRX(kRearRightID);

    

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    leftJoystick = new XboxController(kJoystickChannelLeft);

    sendableChooser.setDefaultOption(null, null);
  }

  @Override
  public void teleopPeriodic() {
    // Use the joystick X axis for forward movement, Y axis for lateral
    // movement, and Z axis for rotation.
    m_robotDrive.driveCartesian(-leftJoystick.getLeftY(), -leftJoystick.getLeftX(), -leftJoystick.getRightX());
  }
}
