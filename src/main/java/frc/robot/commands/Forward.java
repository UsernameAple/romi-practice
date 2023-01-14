// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/** An example command that uses an example subsystem. */
public class Forward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db; // part of romidrivetrain
  private final double distance; // holds the distance


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  
  public Forward (RomiDrivetrain db, double inches ) {
    m_forward = db; // set local to global
    if (inches > 0) {
      distance = inches; // 
    }
    else {
      distance = 0;
    }
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_db.resetEncoders(); // resets the encoders accessing the romidrvietrain class
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_db.arcadeDrive(RobotContainer.controller.getLeftY(), RobotContainer.controller.getRightx());
    //replaces the code that we hade for 0.5 and 0 with the joystick code of get left and get right as the values
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_db.arcadeDrive(0,0);  // stops movment and rotation of the robot
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_db.getAverageDistance() >= 14); // runs the end method if the the distance is over 14
  }
}
