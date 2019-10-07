package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.OI;
import frc.robot.subsystems.*;


public class Robot extends TimedRobot {
  public static Drivebase m_drivebase = new Drivebase();
  public OI m_oi;

  // Pneumatics
  Compressor c = new Compressor(0);
  public static ToggledSolenoid shifters = new ToggledSolenoid(3, 4);
  public boolean shiftState = false;

  public static ToggledSolenoid intakeActuator = new ToggledSolenoid(0, 1);

  @Override
  public void robotInit() {
    m_oi = new OI();
  }

  
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopPeriodic() {
    //Shifters
    if (m_oi.getDriveJoyBLPressed()) {
      shifters.togglePiston();
      shiftState = !shiftState;
    }
    SmartDashboard.putString("Gear", shiftState ? "High" : "Low");

    //Intake Actuator
    if (m_oi.getOpJoyBLPressed()) {
      intakeActuator.togglePiston();
    }
    
    /*if (Math.abs(m_oi.driveJoy.getTriggerAxis(Hand.kLeft)) > 0.1) {
        hatchIntake.set(Value.kForward);
      } else if (Math.abs(m_oi.driveJoy.getTriggerAxis(Hand.kRight)) > .1) {
        hatchIntake.set(Value.kReverse); 
      } else {
        hatchIntake.set(Value.kOff);
    }*/ 
    
  }

  @Override
  public void testPeriodic() {
  }
}
