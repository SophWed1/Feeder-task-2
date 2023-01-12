# Instructions for the Robot Coding Kickoff Warmup Tasks
These are warm-up coding tasks for FRC. They are structured into four stages. The first stage was the coding tasks I released last week. They are optional and designed to improve your java coding abilities. If you struggle to complete the latest stages I would you suggest you give the coding tasks a go.

The next three stages are based around the 2022 robot and will increase in complexity. In the second stage you are given a partially programmed subsystem with a corresponding set of commands. You need to examine the 2022 robot to figure out details such as the motor controllers used and their IDs. 

Additionally, you need to complete missing sections in code such as commands that haven’t been completed. Stage three will make you program a different subsystem at a similar level of complexity but with no help provided. Stage four will require you to program another subsystem but have more difficult challenges involved which may require you to do research online. 

If you ever need help, the first place to check is 
https://docs.wpilib.org/en/stable/index.html

But FIRST…  (lol it’s a pun)

Prior to beginning stage two, you will need to download the 2023 version of WPI, the 2023 version of the ctre and rev library and the new NI FRC libraries for 2023. This is the exact same process as occurred in 2022.

Also if you have forgotten the basics of command based programming then this guide may be helpful:
https://docs.wpilib.org/en/stable/docs/software/commandbased/what-is-command-based.html.

Note: When the tasks refer to an inline command, they mean a command defined entirely within robotContainer with no individual file for that command. The documentation no longer uses this terminology and instead labels them “included commands”. To refresh how to do this I suggest you read this link: https://docs.wpilib.org/en/stable/docs/software/commandbased/commands.html.


## Stage 2 (Stage 1 was optional):
You need to complete the feeder subsystem. It has mostly been filled out for you but not everything is correct. You need to check that the subsystem has correct hardware (e.g. motor types), that the motor IDs are all correct, that all the hardware configurations (motor direction etc.) are correct and that the internal logic is correct. Additionally, the commands are only partially complete but lack critical details.

It should be noted that WPI have made some useful changes to the command-based library. I would suggest you read this link to understand the changes to triggering commands.
https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers.html
You can also look at the provided RobotContainer as some sample code.

Tips: 

•	Visually inspect the subsystem and understand how it works physically before you try and actually program it.

•	Use tools such as phoenix tuner and the rev hardware client to evaluate hardware devices.

•	If two motors operate a system together (e.g. two motors powering the same shooter) then make sure to ask a mentor how you should test the subsystem to ensure you don’t damage it (e.g. spinning the two motors in opposing directions).

•	If in doubt, never be afraid to look online or ask someone for help.

Tasks:
1.	Complete feeder subsystem class
2.	FeedBall: Finish the command which spins the feeder motor when a button is pressed.
3.	Test the FeedBallbyJoystick command. Do you need to change anything to make it work?
4.	Try using an inline command to replace the FeedBall command. //finished
5.	The feedBall using joystick command uses a spooky DoubleSupplier to make it work. However you can write this command inline using lambda statements. Attempt to do this. //finished


## Stage 3:
Congratulations on finishing stage 2. Stage 3 involves you programming the shooter subsystem but with limited pre-written code for you to use.

Ensure you understand how the subsystem is supposed to work in the real world before you consider trying to program it.

Stage 2 did not feature the use of sensors, however in stage 3 since you a programming a subsystem in its entirety you will need to include functionality for all the sensors on your subsystem. 

Many subsystems include a digital sensor. This sensor simply provides a Boolean value. The WPI documentation explains how to use them.

Tasks:
1.	Program shooter subsystem. Note that it has three motors.  Make sure you test that each motor spins in the same direction before you send a high power through. Consider setting the motors to use a coast neutral mode. 
2.	Write a command which spins the shooter at a desired percentage power when a button is pressed.
3.	Write a command which sets the shooter speed to that of an analog trigger on the joystick.
4.	Write a command which spins the shooter 5000 encoder ticks in the clockwise direction before stopping using a WPI PID controller. The WPI documentation has a page which explains how to use a WPI PID controller. The key method is the calculate method. You should use the value the calculate method calculates as the power you set to the feeder motor.


## Stage 4: 
If you were able to complete all of stage three then you are well set for the season. If you struggled a bit, don’t stress it just takes practice. Stage four is similar to stage three in that you have to program another subsystem however the later part of stage four will be a bit more challenging. 
The subsystem you need to program is the climber. 

Tasks:
1.	Program the climber subsystem.
It has a motor, a climb pneumatic and  hook pneumatic as well as a digital sensor.
2.	Write all the methods to set the pneumatic positions, control motor and read sensor.
3.	Create command which raises climber at speed of joystick.
4.	Create commands to control pneumatics manually.
5.	Using WPI PID controller, program the climber to go between 3 set positions, controlled on the dpad, sort of like an elevator.
6.	Create a command which climbs somewhat automatically using the digital sensor. This is something which should be teste very cautiously.
7.	To accurately and quickly move between different positions, it is best to follow what is known as a motion profile. The math for this can be somewhat frightening. However many pre-existing solutions exist for this. 
Use the inbuilt motion magic in the talonFX to smoothly move the climber between the set positions from part 6. 

