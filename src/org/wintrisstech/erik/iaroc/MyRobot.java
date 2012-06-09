package org.wintrisstech.erik.iaroc;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;

public class MyRobot extends Trabant
{
    private int howFarHaveweGone = 0;
    private int deltaDistance;
    private int howFarHaveWeTurned = 0;
    private int deltaTurn;

    MyRobot(IOIO ioio, IRobotCreateInterface iRobotCreate, Dashboard dashboard) throws ConnectionLostException
    {
        super(ioio, iRobotCreate, dashboard);
    }

    /*
     * THE FUN STARTS HERE!
     */
    @Override
    public void goRobot()
    {
        dashboard.speak("hello luke. hello joey. hello jenny. what would you like me to draw?(Version 3)");
        goFoward170();
        turn90
    }

    public void goFoward170()
    {
        try
        {
            readSensors(SENSORS_GROUP_ID6);
            driveDirect(100, 100);
            while (true)
            {
                readSensors(SENSORS_GROUP_ID6);
                deltaDistance = getDistance();
                howFarHaveweGone = deltaDistance + howFarHaveweGone;
                dashboard.log(deltaDistance + "/" + howFarHaveweGone);
                if (howFarHaveweGone >= 170)
                {
                    driveDirect(0, 0);
                    dashboard.log("here");
                    break;
                }
            }
        } catch (ConnectionLostException ex)
        {
            dashboard.log("hiccup");
        }
    }
    public void turn90()
    {
        try
        {
            readSensors(SENSORS_GROUP_ID6);
            driveDirect(100, 0);
            while (true)
            {
                readSensors(SENSORS_GROUP_ID6);
                deltaTurn = getAngle();
                howFarHaveWeTurned = deltaTurn + howFarHaveWeTurned;
                dashboard.log(deltaTurn + "/" + howFarHaveWeTurned);
                if (howFarHaveWeTurned >= 90)
                {
                    driveDirect(0, 0);
                    dashboard.log("here");
                    break;
                }
            }
        } catch (ConnectionLostException ex)
        {
            dashboard.log("hiccup");
        }
    }
}
