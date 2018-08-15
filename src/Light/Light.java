package Light;

import Primitives.cVector;

import java.awt.*;

public class Light {
    cVector position;
    cVector Intesity ;
    public Light(cVector position, cVector intesity) {
        this.position = position;
        this.Intesity = intesity;
    }

    public cVector getPosition() {
        return position;
    }

    public void setPosition(cVector position) {
        this.position = position;
    }

    public cVector getIntesity() {
        return Intesity;
    }

    public void setIntesity(cVector intesity) {
        Intesity = intesity;
    }
}
