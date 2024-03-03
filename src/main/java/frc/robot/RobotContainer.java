package frc.robot;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj.advantagescope.advantagescope;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final PS4Controller stick = new PS4Controller(0);
    // private final PS4Controller stick1 = new PS4Controller(1);

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
    private final JoystickButton L1 = new JoystickButton(stick, PS4Controller.Button.kL1.value);
    private final JoystickButton R1 = new JoystickButton(stick, PS4Controller.Button.kR1.value);
    private final JoystickButton options = new JoystickButton(stick, PS4Controller.Button.kOptions.value);


    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    private final Ballscrew ballscrew = new Ballscrew();
    private final Intake intake = new Intake();
    private final Flywheel flywheel = new Flywheel();
    private final Conveyor conveyor = new Conveyor();
    private final Limelight limelight = new Limelight();
    private final Winch winch = new Winch();

    // Timer
    edu.wpi.first.wpilibj.Timer timer = new edu.wpi.first.wpilibj.Timer();

    //public boolean ballscrewtoggle = true;
    

    /* Autonoumous */
    private final SendableChooser<Command> autoChooser;

    /*
     * private final Command OneNoteExit = new SequentialCommandGroup(new
     * BallscrewPID(ballscrew, 365),
     * new FlywheelAuto(flywheel, conveyor, timer), new BallscrewPID(ballscrew, 0),
     * new ParallelCommandGroup(new DriveFwd(s_Swerve), new IntakeAuto(intake,
     * conveyor))/*,
     * new DriveBackward(s_Swerve), new FlywheelAuto(flywheel, conveyor, timer));
     * private final Command Exit = new DriveFwd(s_Swerve);
     * private final Command NoAuto = null;
     */

    /* Sendable chooser for Auto */
    SendableChooser<Command> m_Chooser = new SendableChooser<>();
    /* Add commands for auto */

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
                new TeleopSwerve(
                        s_Swerve,
                        () -> -stick.getRawAxis(translationAxis),
                        () -> -stick.getRawAxis(strafeAxis),
                        () -> -stick.getRawAxis(rotationAxis),
                        () -> robotCentric.getAsBoolean()));



        //FIXME
        //ballscrew.setDefaultCommand(new BallscrewJoystickCMD(ballscrew, () -> (stick.getL2Axis() - stick.getR2Axis())));
        
        
    
        // winch.setDefaultCommand(new ClimbingWinchCMD(winch, () -> climb.getAsBoolean()));




        //FIXME
        ballscrew.setDefaultCommand(new BallscrewAutoSet(ballscrew, conveyor));


        L1.whileTrue(new AmpAutoSet(ballscrew));

        intake.setDefaultCommand(new IntakeJoystickCMD(intake, conveyor, () -> cross.getAsBoolean()));
        conveyor.setDefaultCommand(new ConveyorJoystickCMD(conveyor, () -> cross.getAsBoolean()));
        flywheel.setDefaultCommand(new FlywheelJoystickCMD(flywheel, () -> square.getAsBoolean()));
        //flywheel.setDefaultCommand(new ));
        // winch.setDefaultCommand(new ClimbingWinchCMD(winch, () -> touchpad.getAsBoolean()));
        
        //options.toggleOnTrue(ballscrew.);

        // Adding options
        /*
         * m_Chooser.addOption("One Note Exit", OneNoteExit);
         * m_Chooser.addOption("Exit", Exit);
         * m_Chooser.addOption("No Auto", NoAuto);
         */
        // m_Chooser.addOption("path planner test", new PathPlannerAuto("Example
        // Path"));

        // Named Commands
        NamedCommands.registerCommand("FlywheelAuto", new FlywheelAuto(flywheel, conveyor, timer));
        NamedCommands.registerCommand("IntakeAuto", new IntakeAuto(intake, conveyor));

        // Autonomous chooser
        autoChooser = AutoBuilder.buildAutoChooser();
        SmartDashboard.putData("Auto Chooser", autoChooser);
        SmartDashboard.putData(m_Chooser);

        // Adding options
        //autoChooser.addOption("null", null);

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroHeading()));
        circle.whileTrue(new ParallelCommandGroup(new ConveyorShootCMD(conveyor)));
        triangle.whileTrue(new FlywheelAmp(flywheel));
        // climb.whileTrue(new InstantCommand(new winch.runWinch(1)));
        // L1.whileTrue(new ClimbingWinchCMD(winch, -.10));
        R1.whileTrue(new ClimbingWinchCMD(winch, .75));
        //options.toggleOnTrue(new BallscrewToggle(null));
        //options.onTrue(ballscrewtoggle = !ballscrewtoggle);
        //options.toggleOnTrue(ballscrewtoggle = !ballscrewtoggle)


        //options.whileTrue(new BallscrewJoystickCMD(ballscrew, () -> (stick.getL2Axis() - stick.getR2Axis())));

        options.toggleOnTrue(new BallscrewJoystickCMD(ballscrew, () -> (stick.getL2Axis() - stick.getR2Axis())));


        //FIXME
        //options.toggleOnTrue(new BallscrewToggle());
        
        /*if(BallscrewToggle().ballscrewToggle = true){
            ballscrew.setDefaultCommand(new BallscrewJoystickCMD(ballscrew, () -> (stick.getL2Axis() - stick.getR2Axis())));
        }else if(ballscrewtoggle = false){
            ballscrew.setDefaultCommand(new BallscrewAutoSet(ballscrew, conveyor));
        }*/
        //FIXME





       // options.toggleOnTrue(new BallscrewJoystickCMD(ballscrew, () -> (stick.getL2Axis() - stick.getR2Axis())));
       //options.toggleOnFalse(new BallscrewAutoSet(ballscrew, conveyor));

        // triangle.onTrue(new BallscrewPID(ballscrew, 365));
    }
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        //return new PathPlannerAuto("4 Note Red");
        return autoChooser.getSelected();

        // return new FlywheelAuto(flywheel, conveyor, timer);

        // An ExampleCommand will run in autonomous
        //return.m_Chooser(getAutonomousCommand(auto));
    }
}
