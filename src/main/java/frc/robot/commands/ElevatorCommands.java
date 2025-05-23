/*
 * Copyright (c) 2025 Newport Robotics Group. All Rights Reserved.
 *
 * Open Source Software; you can modify and/or share it under the terms of
 * the license file in the root directory of this project.
 */
 
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.parameters.ElevatorLevel;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.CoralRoller;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Subsystems;

/** A namespace for elevator command factory methods. */
public final class ElevatorCommands {
  /** Returns a command that goes to the given elevator level. */
  public static Command seekToElevatorLevel(Subsystems subsystems, ElevatorLevel level) {
    Elevator elevator = subsystems.elevator;

    return Commands.runOnce(() -> elevator.setGoalHeight(level), elevator)
        .withName(String.format("GoToElevatorLevel(%s)", level.name()));
  }

  /** Returns a command that waits for elevator to reach goal position. */
  public static Command waitForElevatorToReachGoalHeight(Elevator elevator) {
    return Commands.idle(elevator)
        .until(elevator::atGoalHeight)
        .withName("WaitForElevatorToReachGoalPosition");
  }

  /** Returns a command that stows elevator. */
  public static Command stowElevator(Subsystems subsystems) {
    return stowElevator(subsystems.elevator);
  }

  /**
   * Returns a command that stows elevator.
   *
   * @param elevator The elevator subsystem.
   * @return A command that stows elevator.
   */
  public static Command stowElevator(Elevator elevator) {
    return Commands.sequence(
            Commands.runOnce(() -> elevator.setGoalHeight(ElevatorLevel.STOWED), elevator),
            waitForElevatorToReachGoalHeight(elevator),
            Commands.runOnce(() -> elevator.disable(), elevator))
        .withName("Stow Elevator");
  }

  /** Returns a command that stows the elevator and the arm. */
  public static Command stowElevatorAndArm(Subsystems subsystems) {
    return Commands.sequence(CoralCommands.stowArm(subsystems), stowElevator(subsystems))
        .withName("StowElevatorAndArm");
  }

  public static Command stowElevatorAndArmForCoral(Subsystems subsystems) {
    Elevator elevator = subsystems.elevator;
    Arm coralArm = subsystems.coralArm;
    CoralRoller coralRoller = subsystems.coralRoller;

    return Commands.sequence(
            Commands.idle(elevator, coralArm).until(() -> !coralRoller.hasCoral()),
            stowElevatorAndArm(subsystems))
        .withName("StowElevatorAndArmForCoral");
  }
}
