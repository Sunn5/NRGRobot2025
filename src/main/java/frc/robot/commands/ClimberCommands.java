/*
 * Copyright (c) 2025 Newport Robotics Group. All Rights Reserved.
 *
 * Open Source Software; you can modify and/or share it under the terms of
 * the license file in the root directory of this project.
 */
 
package frc.robot.commands;

import static frc.robot.parameters.ElevatorLevel.STOWED;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.StatusLED;
import frc.robot.subsystems.Subsystems;

/** A namespace for climber command factory methods. */
public final class ClimberCommands {
  private static final double CLIMB_ANGLE = Math.toRadians(-94);
  private static final double STOW_ANGLE = Math.toRadians(90);
  private static final double CLIMB_GROUND_INTAKE_ANGLE = Math.toRadians(97);

  /** Returns a command that climbs. */
  public static Command climb(Subsystems subsystems) {
    Climber climber = subsystems.climber;
    StatusLED statusLEDs = subsystems.statusLEDs;
    Arm coralArm = subsystems.coralArm;

    return Commands.parallel(
            Commands.runOnce(() -> coralArm.setGoalAngle(STOWED.getArmAngle())),
            Commands.runOnce(() -> climber.setGoalAngle(CLIMB_ANGLE)),
            new RainbowCycle(statusLEDs))
        .withName("Climb");
  }

  public static Command unclimb(Subsystems subsystems) {
    return Commands.sequence(
            Commands.runOnce(() -> subsystems.climber.setGoalAngle(STOW_ANGLE), subsystems.climber),
            Commands.idle(subsystems.climber).until(() -> subsystems.climber.atGoalAngle()))
        .finallyDo(subsystems.climber::disable);
  }

  public static Command prepareToClimb(Subsystems subsystems) {
    return Commands.runOnce(
        () -> subsystems.coralIntakeArm.setGoalAngle(CLIMB_GROUND_INTAKE_ANGLE),
        subsystems.coralIntakeArm);
  }
}
