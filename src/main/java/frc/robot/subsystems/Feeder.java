package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase{
    /*
     * checked the motor ID (device number) and fixed it
     * checked that motor was the correct hardware 
     * fixed hardware configuration (motor direction) from coast to brake for borth left & front 
     */ 
    private VictorSPX leftFeeder = new VictorSPX(5);
    private VictorSPX frontFeeder = new VictorSPX(6);

    private DigitalInput feederSensor = new DigitalInput(0);

    public Feeder(){
        leftFeeder.setInverted(false);
        frontFeeder.setInverted(true);
        leftFeeder.setNeutralMode(NeutralMode.Brake);
        frontFeeder.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }

    public void spinFeeder(double speed) {
        //This method was tested and the feeder did not spin. 
        //Can you fix the method?
        leftFeeder.set(ControlMode.PercentOutput, 0.5);
        frontFeeder.set(ControlMode.PercentOutput,0.5);
    }

    public void stopFeeder(){
        leftFeeder.set(ControlMode.PercentOutput,0);
        frontFeeder.set(ControlMode.PercentOutput,0);
    }
    
    public boolean sense_ball(){
        return feederSensor.get();
    }



}
