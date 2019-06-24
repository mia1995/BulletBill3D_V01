package Physics;

import Sprite.Sphere;

public class Movement {



    public Movement (Sphere sphere, Sphere sphereXY, Sphere sphereXZ, Sphere sphereYZ) {

        path(sphere, sphereXY, sphereXZ, sphereYZ);

    }


    public static double getVelocity (Sphere sphere) {

        double vectorLenght = Math.sqrt(Math.pow(sphere.getVx(), 2) + Math.pow(sphere.getVy(), 2) + Math.pow(sphere.getVz(), 2));
        double betrag = Math.abs(vectorLenght);

        return betrag;
    }

    public static void movingSphere (Sphere sphere) {

        //Ermittlung der Startwerte
        double startX = sphere.getX0();
        double startY = sphere.getY0();
        double startZ = sphere.getZ0();

        double startVx = sphere.getVx();
        double startVy = sphere.getVy();
        double startVz = sphere.getVz();

        double startAx = sphere.getAx();
        double startAy = sphere.getAy();
        double startAz = sphere.getAz();

        // Bewegungsformel für neue Positionen

        double newX = startX + startVx * Time.timeFraction + 0.5 * startAx * (Time.timeFraction * Time.timeFraction);
        double newY = startY + startVy * Time.timeFraction + 0.5 * startAy * (Time.timeFraction * Time.timeFraction);
        double newZ = startZ + startVz * Time.timeFraction + 0.5 * startAz * (Time.timeFraction * Time.timeFraction);


        double newVx = startVx + startAx * Time.timeFraction;
        double newVy = startVy + startAy * Time.timeFraction;
        double newVz = startVz + startAz * Time.timeFraction;

        //setze neue Werte

        sphere.updatePos(newX, newY, newZ);
        sphere.updateVelocity(newVx, newVy, newVz);
    }


    public void path(Sphere sphere, Sphere sphereXY, Sphere sphereXZ, Sphere sphereYZ) {

        //Ich setzte alle Koordianten gleich
        sphereXY.setZ0(sphereXZ.getZ0());
        sphereXZ.setY0(sphereXY.getY0());
        sphereYZ.setX0(sphereXY.getX0());

        //System.out.println("Pos: " + "x: " + (int) sphere.getX0() + ", y: " + (int) sphere.getY0() + ", z: " + (int) sphere.getZ0());
        //System.out.println("Velocity: " + "vx: " + (int) sphere.getVx() + ", vy: " + (int) sphere.getVy() + ", vz: " + (int) sphere.getVz());


        //Methode zur Kugelbewegung
        movingSphere(sphere);


        /**
         * Hiermit lasse ich die Kugel durch die strecke laufen in dem ich die Geschwindigkeit in einzelnen Richtungen manipulieren
         */


        if (sphere.getY0() > 137 && sphere.getY0() < 153) {
            sphere.setVz(-40);
            sphere.setVy(32);

        }
        if (sphere.getY0() > 153) {
            sphere.setVy(0);
        }

        if (sphereXZ.getZ0() < 70) {
            sphere.setVx(-20);
            sphere.setVz(-32);
            sphere.setVy(4);
        }

        if (sphereXZ.getZ0() < 65) {
            sphere.setVx(-48);
            sphere.setVz(-48);
            sphere.setVy(24);
        }

        if (sphereXZ.getZ0() < 60) {
            sphere.setVx(-28);
            sphere.setVz(-16);
            sphere.setVy(20);
        }

        if (sphereXZ.getZ0() < 55) {
            sphere.setVx(-32);
            sphere.setVz(-8);
            sphere.setVy(16);
        }


        if (sphereXZ.getZ0() < 50) {
            sphere.setVx(-40);
            sphere.setVz(0);
            sphere.setVy(8);
        }

        if (sphereXY.getX0() < 705) {
            sphere.setVy(0);
            sphere.setVx(-32);

        }

        if (sphereXY.getX0() < 695) {
            sphere.setVy(8);
            sphere.setVx(-28);
        }

        if (sphereXY.getX0() < 685) {
            sphere.setVy(20);
            sphere.setVx(-24);
        }

        if (sphereXY.getX0() < 675) {
            sphere.setVy(28);
            sphere.setVx(-16);
        }

        if (sphereXY.getY0() > 205) {
            sphere.setVy(0);
            sphere.setVx(-32);
        }

        // Gerade strecke - Fall auf gerade Strecke

        if (sphereXY.getX0() < 495) {
            sphere.setVy(4);

        }
        if (sphereXY.getX0() < 490) {
            sphere.setVy(8);

        }

        if (sphereXY.getX0() < 485) {
            sphere.setVy(8);

        }

        if (sphereXY.getX0() < 480) {
            sphere.setVy(12);

        }

        if (sphereXY.getX0() < 475) {
            sphere.setVy(16);
            sphere.setVx(-28);
        }

        if (sphereXY.getX0() < 470) {
            sphere.setVy(20);
            sphere.setVx(-24);
        }

        if (sphereXY.getX0() < 465) {
            sphere.setVy(36);
            sphere.setVx(-20);
        }

        //Ball prallt auf (ohne Kollision)

        if (sphereXY.getY0() > 305) {
            sphere.setVy(0);
            sphere.setVx(-32);
        }

        // Ball macht links Kurve

        if (sphereXY.getX0() < 300) {
            sphere.setVz(0);
            sphere.setVx(-40);
        }

        if (sphereXY.getX0() < 290) {
            sphere.setVz(8);
            sphere.setVx(-32);
        }

        if (sphereXY.getX0() < 280) {
            sphere.setVz(16);
            sphere.setVx(-28);
        }

        if (sphereXY.getX0() < 270) {
            sphere.setVz(24);
            sphere.setVx(-24);
        }

        if (sphereXY.getX0() < 260) {
            sphere.setVz(32);
            sphere.setVx(-16);
        }

        if (sphereXY.getX0() < 250) {
            sphere.setVz(40);
            sphere.setVx(0);
        }

        // Ball fällt durch Loch in Kurve

        if (sphereYZ.getZ0() > 130 && sphereYZ.getY0() > 300) {
            sphere.setVz(32);
            sphere.setVy(8);
        }

        if (sphereYZ.getZ0() > 135 && sphereYZ.getY0() > 300) {
            sphere.setVz(24);
            sphere.setVy(16);
        }

        if (sphereYZ.getZ0() > 140 && sphereYZ.getY0() > 300) {
            sphere.setVz(16);
            sphere.setVy(24);
        }

        if (sphereYZ.getZ0() > 145 && sphereYZ.getY0() > 300) {
            sphere.setVz(8);
            sphere.setVy(32);
        }

        if (sphereYZ.getZ0() > 150 && sphereYZ.getY0() > 300) {
            sphere.setVz(0);
            sphere.setVy(40);
        }

        // Kurve nach Fall

        if (sphereYZ.getY0() > 337) {
            sphere.setVy(24);
            sphere.setVz(16);
        }

        if (sphereYZ.getY0() > 340) {
            sphere.setVy(20);
            sphere.setVz(20);
        }

        if (sphereYZ.getY0() > 345) {
            sphere.setVy(16);
            sphere.setVz(28);
        }

        if (sphereYZ.getY0() > 354) {
            sphere.setVy(4);
            sphere.setVz(36);
        }

        if (sphereYZ.getY0() > 355) {
            sphere.setVy(0);
            sphere.setVz(40);
        }

        // Kleiner freier Fall


        if (sphereYZ.getZ0() > 200 && sphereYZ.getY0() > 300) {
            sphere.setVz(32);
            sphere.setVy(8);
        }

        if (sphereYZ.getZ0() > 210 && sphereYZ.getY0() > 300) {
            sphere.setVz(24);
            sphere.setVy(16);
        }

        if (sphereYZ.getZ0() > 220 && sphereYZ.getY0() > 300) {
            sphere.setVz(16);
            sphere.setVy(24);
        }

        if (sphereYZ.getZ0() > 230 && sphereYZ.getY0() > 300) {
            sphere.setVz(8);
            sphere.setVy(32);
        }

        if (sphereYZ.getZ0() > 240 && sphereYZ.getY0() > 300) {
            sphere.setVz(0);
            sphere.setVy(40);
        }

        //Sofortige Rechts Kurve nach kleinem Fall


        if (sphereYZ.getY0() > 405) {
            sphere.setVy(0);
            sphere.setVz(20);
            sphere.setVx(-20);
        }

        if (sphereYZ.getZ0() > 250 && sphereYZ.getY0() > 400) {
            sphere.setVz(0);
            sphere.setVx(-40);
        }

        // Nächste Kurve

        if (sphereXZ.getX0() < 90) {
            sphere.setVx(-40);
            sphere.setVz(8);
        }

        if (sphereXZ.getX0() < 80) {
            sphere.setVx(-24);
            sphere.setVz(16);
        }

        if (sphereXZ.getX0() < 70) {
            sphere.setVx(-42);
            sphere.setVz(24);
        }

        if (sphereXZ.getX0() < 60) {
            sphere.setVx(-16);
            sphere.setVz(32);
        }

        if (sphereXZ.getX0() < 50) {
            sphere.setVx(-0);
            sphere.setVz(40);
        }

        // next curve

        if (sphereXZ.getZ0() > 310) {
            sphere.setVz(40);
            sphere.setVx(8);
        }

        if (sphereXZ.getZ0() > 320) {
            sphere.setVz(24);
            sphere.setVx(16);
        }

        if (sphereXZ.getZ0() > 330) {
            sphere.setVz(24);
            sphere.setVx(24);
        }

        if (sphereXZ.getZ0() > 340) {
            sphere.setVz(16);
            sphere.setVx(32);
        }

        if (sphereXZ.getZ0() > 350) {
            sphere.setVz(0);
            sphere.setVx(40);
        }
    }
}












