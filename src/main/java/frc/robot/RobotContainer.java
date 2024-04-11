package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {
    /* Controllers */
    private final PS4Controller stick = new PS4Controller(0);
    private final PS4Controller stick1 = new PS4Controller(1);

    /* Drive Controls */
    private final int translationAxis = PS4Controller.Axis.kLeftY.value;
    private final int strafeAxis = PS4Controller.Axis.kLeftX.value;
    private final int rotationAxis = PS4Controller.Axis.kRightX.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(stick, PS4Controller.Button.kShare.value);
    private final JoystickButton robotCentric = new JoystickButton(stick, PS4Controller.Button.kOptions.value);
    private final JoystickButton circle = new JoystickButton(stick, PS4Controller.Button.kCircle.value);
    private final JoystickButton cross = new JoystickButton(stick, PS4Controller.Button.kCross.value);
    private final JoystickButton square = new JoystickButton(stick, PS4Controller.Button.kSquare.value);
    private final JoystickButton triangle = new JoystickButton(stick, PS4Controller.Button.kTriangle.value);
    private final JoystickButton R1 = new JoystickButton(stick, PS4Controller.Button.kR1.value);
    private final JoystickButton options = new JoystickButton(stick, PS4Controller.Button.kOptions.value);
    private final JoystickButton L1 = new JoystickButton(stick, PS4Controller.Button.kL1.value);
    private final JoystickButton purgeNote = new JoystickButton(stick, PS4Controller.Button.kL2.value);

    /* Subsystems */
    public static final Swerve s_Swerve = new Swerve();
    public static final Ballscrew ballscrew = new Ballscrew();
    public static final Intake intake = new Intake();
    public static final Flywheel flywheel = new Flywheel();
    public static final Conveyor conveyor = new Conveyor();
    public static final Limelight limelight = new Limelight();
    public static final Winch winch = new Winch();
    public static final Spoiler spoiler = new Spoiler();

    /* Timer */
    edu.wpi.first.wpilibj.Timer timer = new edu.wpi.first.wpilibj.Timer();

    /* Autonoumous */
    private final SendableChooser<Command> autoChooser;

    /* Sendable chooser for Auto */
    SendableChooser<Command> m_Chooser = new SendableChooser<>();

    public RobotContainer() {

        s_Swerve.setDefaultCommand(
                new TeleopSwerve(
                        s_Swerve,
                        () -> -stick.getRawAxis(translationAxis),
                        () -> -stick.getRawAxis(strafeAxis),
                        () -> -stick.getRawAxis(rotationAxis),
                        () -> robotCentric.getAsBoolean()));

        ballscrew.setDefaultCommand(new BallscrewAutoSet(ballscrew, conveyor, limelight));
        intake.setDefaultCommand(new IntakeJoystickCMD(intake, conveyor, () -> cross.getAsBoolean()));
        conveyor.setDefaultCommand(new ConveyorJoystickCMD(conveyor, () -> cross.getAsBoolean()));
        flywheel.setDefaultCommand(new FlywheelJoystickCMD(flywheel, () -> square.getAsBoolean()));
        spoiler.setDefaultCommand(new SpoilerTest(spoiler, () -> stick1.getRawAxis(5)));

        // Named Commands
        NamedCommands.registerCommand("FlywheelAuto", new FlywheelAuto(flywheel, conveyor, timer));
        NamedCommands.registerCommand("IntakeAuto", new IntakeAuto(intake, conveyor));

        // Autonomous chooser
        autoChooser = AutoBuilder.buildAutoChooser();
        SmartDashboard.putData("Auto Chooser", autoChooser);
        SmartDashboard.putData(m_Chooser);

        // Configure the button bindings
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroHeading()));
        circle.whileTrue(new ParallelCommandGroup(new ConveyorShootCMD(conveyor)));
        triangle.whileTrue(new ParallelCommandGroup(new FlywheelAmp(flywheel), new SpoilerPId(spoiler, .41)));
        //purgeNote.whileTrue(new PurgeCMD(intake, conveyor, -.5));
        //test.whileTrue(new SpoilerTest(spoiler, .5));
        //Aim.toggleOnTrue(new AimBotExE());
        // climb.whileTrue(new InstantCommand(new winch.runWinch(1)));
        L1.whileTrue(new ClimbingWinchCMD(winch, -.75));
        R1.whileTrue(new ClimbingWinchCMD(winch, .75));
        options.toggleOnTrue(new BallscrewJoystickCMD(ballscrew, () -> (stick.getL2Axis() - stick.getR2Axis())));
    }

    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}
