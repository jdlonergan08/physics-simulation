import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Color;


public class Atom extends JFrame{


    /*

    TODO create equations for calculating color of photon
    TODO make GUI

    TODO make atom a super class
    TODO apply program to more than hydrogen
    TODO update GUI
    TODO connect to website
     */
    public int atomicNum;

    public int numElectrons; // can calculate num electrons from atomicNum, but it may be necessary to define this differently later on
    public double photonEnergy; // measured in electron volts (eV)
    public double waveLength; //in nanometers
    public double frequency; // in inverse seconds
    public double ionizationE; //ionization energy
    public int r;
    public int g;
    public int b; // colors r g and b
    public int energyLevels; // will be 4 for H atoms
    public int n1; //first electron level
    public int n2; //second electron level
    public int ionizationCounter; // counts number of times electron is ionized

    public static final double chR = 13.6; //speed of light*plank's constant*rydberg constant in electron volts

    public static final double c = 299792458; // speed of light in m/s
    public static final double h = 6.62607004*Math.pow(10,-34);




    public void getAtomicNum(){
        Scanner kb = new Scanner(System.in);
        System.out.println("input atomic number: ");
        atomicNum = kb.nextInt();
    }

    public void getNumElectrons(){
        numElectrons = atomicNum - ionizationCounter;
    }

    public void getEnergyLevels(){
        Scanner kb = new Scanner(System.in);
        System.out.println("input number of energy levels: ");
        energyLevels = kb.nextInt();
    }

    public void isInEnergyBounds(int energyLevels, int n){

        if (n<=energyLevels) {
        }
        else{
            System.out.println("error: energy level exists outside atom");
        }
    }

    public int getN1(){
        Scanner kb = new Scanner(System.in);
        System.out.println("input initial energy level: ");
        n1 = kb.nextInt();
        isInEnergyBounds(energyLevels,n1);
        return n1;
    }

    public int getN2(){
        Scanner kb = new Scanner(System.in);
        System.out.println("input final energy level: ");
        n2 = kb.nextInt();
        isInEnergyBounds(energyLevels,n2);
        return n2;
    }

    public double getphotonEnergy(int n1, int n2){

        if (n1<n2){
            System.out.println("electron is excited to more energetic state. Photon is absorbed");
        }
        else
        {
            System.out.println("electron is dropped to more stable state. Photon is emitted");
        }

        photonEnergy = chR*( (1 / ((double)n1 * n1) - (1 / ((double)n2 * n2) ) ) ); // in electron volts

        return photonEnergy;

    }

    public double convertEVtoJoules (double input){ //input is really just photon energy
        double inJoules = input*1.60218*Math.pow(10,-19);
        System.out.println(inJoules + " Joules");
        return inJoules;
    }


    public double getFrequency(double input){
        double photonEnergyJ = Math.abs(convertEVtoJoules(photonEnergy));
        frequency = photonEnergyJ/h; // in inverse seconds
        System.out.println(frequency + " inverse seconds");
        return frequency;
    }

    public double getWavelength(){
        waveLength = c/frequency;
        waveLength *= Math.pow(10,9);// in nanometers
        System.out.println(waveLength + " nanometers");
        return waveLength;
    }

    public double getIonizationE(){  //ionization energy is just taking electron to an energy level of 0 so it's just negative of energy level
        Scanner kb = new Scanner(System.in);
        System.out.println("input energy level electron is in: ");
        int n = kb.nextInt();
        double iE = chR*(1 / ((double)n*n));
        System.out.println(iE + "eV\n" + "In joules: " + convertEVtoJoules(iE));
        return iE;
    }

//    public Atom(){
//        setTitle("Color of photon");
//        setSize(400,200);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }

//
//    public void paint (Graphics G)
//    {
//        // paint color between 380 and 720 nm TODO indicate if ultraviolet or ir or what other wavelength if it's note visible light
//        wl2rgb(waveLength);
//        Color custom = new Color(r,g,b);
//        G.setColor(custom);
//        G.fillRect(0,0,400,200);
//
//    }

    public double getWavelength(double wave) {
        waveLength = wave;
        System.out.println(wave);
        return waveLength;
    }


    public void wl2rgb(double wavelength) {
        if (wavelength >= 380 && wavelength <= 440) {
            r = 120;
            g = 0;
            b = 233;
            System.out.println("PART A: " + r + g + b);
        } else if (wavelength >= 441 && wavelength <= 490) {
            r = 0;
            g = 156;
            b = 255;
            System.out.println("PART B: " + r + g + b);

        } else if (wavelength >= 491 && wavelength <= 510) {
            r = 0;
            g = 255;
            b = 149;
            System.out.println("PART C: " + r + g + b);

        } else if (wavelength >= 511 && wavelength <= 580) {
            r = (int) (wavelength - 510) / (580 - 510);
            g = 176;
            b = 255;
            System.out.println("PART D: " + r + g + b);

        } else if (wavelength >= 581 && wavelength <= 645) {
            r = 255;
            g = 152;
            b = 0;
            System.out.println("PART E: " + r + " " + g + " " + b);

        } else if (wavelength >= 646 && wavelength <= 780) {
            r = 235;
            g = 0;
            b = 0;
            System.out.println("PART F: " + r + " " + g + " " + b);

        }



    }

    public Atom(){
        setTitle("Color of photon");
        setSize(400,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//
//    public Atom(){
//        setTitle("Color of photon");
//        setSize(400,200);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//
    public void paint (Graphics G)
    {
        // paint color between 380 and 720 nm TODO indicate if ultraviolet or ir or what other wavelength if it's note visible light
        Color custom = new Color(r,g,b);
        G.setColor(custom);
        G.fillRect(0,0,400,200);

    }


//    public void wl2rgb(double wavelength) {
//        if (wavelength >= 380 && wavelength <= 440) {
//            r = 120;
//            g = 0;
//            b = 233;
//            System.out.println("PART A: " + r + g + b);
//        } else if (wavelength >= 441 && wavelength <= 490) {
//            r = 0;
//            g = 156;
//            b = 255;
//            System.out.println("PART B: " + r + g + b);
//
//        } else if (wavelength >= 491 && wavelength <= 510) {
//            r = 0;
//            g = 255;
//            b = 149;
//            System.out.println("PART C: " + r + g + b);
//
//        } else if (wavelength >= 511 && wavelength <= 580) {
//            r = (int) (wavelength - 510) / (580 - 510);
//            g = 176;
//            b = 255;
//            System.out.println("PART D: " + r + g + b);
//
//        } else if (wavelength >= 581 && wavelength <= 645) {
//            r = 255;
//            g = 152;
//            b = 0;
//            System.out.println("PART E: " + r + " " + g + " " + b);
//
//        } else if (wavelength >= 646 && wavelength <= 780) {
//            r = 235;
//            g = 0;
//            b = 0;
//            System.out.println("PART F: " + r + g + b);
//
//        }




    public static void main(String[] args) {

        Atom test = new Atom();
        test.getAtomicNum();
        test.getNumElectrons();
        test.getEnergyLevels();
        double photonEnergy = test.getphotonEnergy(test.getN1(),test.getN2());
        System.out.println(photonEnergy);

        double frequency = test.getFrequency(photonEnergy);
        double wavelength = test.getWavelength();
        double ionizationEnergy = test.getIonizationE();
        test.wl2rgb(wavelength);

//        Atom h = new Atom();
//        h.wl2rgb(h.getWavelength());
//        h.paint(h.getGraphics());


    }


}
