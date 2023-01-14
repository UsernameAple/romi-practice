// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/** An example command that uses an example subsystem. */
public class Forward2 extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_Forward; // part of romidrivetrain
  private final double distance; // holds the distance


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  
  public Forward2 (RomiDrivetrain db, double inches ) {
    m_Forward = db; // set local to global
    if (inches > 0) {
      distance = inches; // set distance to inches only if the inches inputed is over 0
    }
    else {
      distance = 0; // else the amount will be zero
    }
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Forward.resetEncoders(); // resets the encoders we are using
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Forward.arcadeDrive(0.5,0); // move forward at a speed of 0.5
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Forward.arcadeDrive(0,0);  // stops all movement and rotation of the robot
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_Forward.getAverageDistance() >= distance); // check if the distance moved past the distance we wish to move
  }
}
