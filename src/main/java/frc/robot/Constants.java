/*
 * Copyright (c) 2025 Newport Robotics Group. All Rights Reserved.
 *
 * Open Source Software; you can modify and/or share it under the terms of
 * the license file in the root directory of this project.
 */
 
package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  /** Constants for robot elements. */
  public static class RobotConstants {
    /** The maximum battery voltage. */
    public static final double MAX_BATTERY_VOLTAGE = 12.0;

    /** The swerve drive wheel diameter in meters. */
    public static final double WHEEL_DIAMETER =
        Units.inchesToMeters(3.875); // This is for the practice bot.

    // public static final double WHEEL_DIAMETER = 0.0997; // This is for the comp bot;

    /** The length of the robot including bumpers. */
    public static final double ROBOT_LENGTH = 0.928;

    /** The width of the robot including bumpers. */
    public static final double ROBOT_WIDTH = 0.928;

    /** The mass in kg of a typical battery plus its connecting cables. */
    private static final double BATTERY_KG = Units.lbsToKilograms(13.2);

    /**
     * The mass in kg of the bumpers.
     *
     * <p>Takes the average of the weights of the blue and red bumpers.
     */
    private static final double BUMPER_KG = Units.lbsToKilograms((20.3 + 19.3) / 2);

    /** The mass in kg of the competition robot without bumpers and battery. */
    private static final double COMPETITION_CHASSIS_KG = Units.lbsToKilograms(113.5);

    /** The mass in kg of the practice robot without bumpers and battery. */
    private static final double PRACTICE_CHASSIS_KG = Units.lbsToKilograms(115.0);

    /** The total mass in kg of the competition robot including bumpers and battery. */
    public static final double COMPETITION_ROBOT_MASS_KG =
        COMPETITION_CHASSIS_KG + BATTERY_KG + BUMPER_KG;

    /** The total mass in kg of the practice robot including bumpers and battery. */
    public static final double PRACTICE_ROBOT_MASS_KG = 99.0;

    /** The average mass of the coral in kg. */
    public static final double CORAL_MASS_KG = 0.68;

    /** The coral arm mass in kg. */
    public static final double OLD_CORAL_GROUND_INTAKE_ARM_MASS_KG = 4.245;

    /** The coral arm mass in kg. */
    public static final double NEW_CORAL_GROUND_INTAKE_ARM_MASS_KG = 4.178; // est.

    /**
     * The x distance from the odometry center (center of the wheels) to the edge of the front
     * bumper.
     */
    public static final double ODOMETRY_CENTER_TO_FRONT_BUMPER_DELTA_X = 0.46; // ROBOT_LENGTH / 2;

    /**
     * The x distance from the odometry center (center of the wheels) to the edge of the rear
     * bumper.
     */
    public static final double ODOMETRY_CENTER_TO_REAR_BUMPER_DELTA_X = ROBOT_LENGTH / 2;

    /** The robot iteration period in seconds. */
    public static final double PERIODIC_INTERVAL = 0.02;

    /**
     * The y-offset of the coral end effector from the center of the robot in the robot's frame of
     * reference.
     */
    public static final double CORAL_ARM_CENTER_Y_OFFSET = -Units.inchesToMeters(10.25);

    /** The x distance from the laser CANs to the edge of the rear bumper. */
    // TODO: find actual distance
    public static final double LASER_CAN_TO_REAR_BUMBER_DELTA_X = 0.1;

    public static class PWMPort {
      public static final int LED = 1;
    }

    public static class LEDSegment {
      public static final int STATUS_FIRST_LED = 0;
      public static final int STATUS_LED_COUNT = 56; // 15 on front, 20+21 on coral chute sides
    }

    public static final int LED_COUNT = 77;

    /** CANBus device IDs. */
    public static final class CAN {
      public static final class TalonFX {
        public static final int CORAL_ARM_MOTOR_ID = 4; // For both bots
        public static final int CORAL_ROLLER_MOTOR_ID = 5; // For both bots
        public static final int OLD_CORAL_GROUND_INTAKE_ARM_MOTOR_ID = 12;
        public static final int OLD_CORAL_GROUND_INTAKE_GRABBER_MOTOR_ID = 3;
        public static final int NEW_CORAL_GROUND_INTAKE_ARM_MOTOR_ID = 3;
        public static final int NEW_CORAL_GROUND_INTAKE_GRABBER_MOTOR_ID = 12;
        public static final int PRACTICE_BOT_CLIMBER_MOTOR_ID = 6; // not present
        public static final int COMPETITION_BOT_CLIMBER_MOTOR_ID = 11;
      }

      // TODO: verify laser CAN IDs.
      /** The laser CAN closest to the funnel. */
      public static final int LEFT_LASER_CAN_ID = 23;

      /** The laser CAN closest to the ground intake. */
      public static final int RIGHT_LASER_CAN_ID = 22;
    }

    /** Digital I/O port numbers. */
    public static class DigitalIO {
      public static final int CORAL_ROLLER_BEAM_BREAK = 9;
      public static final int CORAL_GROUND_INTAKE_BEAM_BREAK = 8;
      public static final int CLIMBER_ABSOLUTE_ENCODER = 2;
    }
  }

  /** Constants for the robot operator. */
  public static class OperatorConstants {

    /** The driver Xbox controller port. */
    public static final int DRIVER_CONTROLLER_PORT = 0;

    /** The driver Xbox manipulator port. */
    public static final int MANIPULATOR_CONTROLLER_PORT = 1;
  }

  public static class VisionConstants {

    /** The distance from each reef branch from the center of the apriltag. */
    public static final double BRANCH_TO_REEF_APRILTAG = 0.165;

    /** The translational tolerance value for aligning to the reef. */
    public static final double POSE_ALIGNMENT_TOLERANCE_XY = 0.02; // in m

    /** The rotational tolerance value for aligning to the reef. */
    public static final double POSE_ALIGNMENT_TOLERANCE_R = 1.0; // in deg
  }
}
