import java.util.Scanner;

public class Atom {

    /*
    TODO figure out ionization energy
    TODO limit number of energy levels that use can input
    TODO calculate ionization energy

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

    public int getN1(){
        Scanner kb = new Scanner(System.in);
        System.out.println("input initial energy level: ");
        n1 = kb.nextInt();
        return n1;
    }

    public int getN2(){
        Scanner kb = new Scanner(System.in);
        System.out.println("input final energy level: ");
        n2 = kb.nextInt();
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
        double iE = chR*(1 / (double)n*n);
        System.out.println(iE + "eV\n" + "In joules: " + convertEVtoJoules(iE));
        return iE;
    }



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
    }


}
