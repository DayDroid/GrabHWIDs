package me.daydream;


import java.io.*;

public class getIDs {


    public static void getHWIDIds() {
        String OS = System.getProperty("os.name").toLowerCase();
        String properties = String.valueOf(System.getProperties());


        System.out.println("Your OS: " + OS + "\n"); // returns Operating system



        /*runtime executables to run commands*/
        try {
            Process p = Runtime.getRuntime().exec("wmic csproduct get UUID");
            Process getDiskSerial = Runtime.getRuntime().exec("wmic diskdrive get DeviceID, SerialNumber");
            Process getSMBIOS = Runtime.getRuntime().exec("wmic path win32_computersystemproduct get uuid");
            Process timeZone = Runtime.getRuntime().exec("wmic timezone");
            Process getMacAddresses = Runtime.getRuntime().exec("getmac /v");
            Process getNGPUUUID = Runtime.getRuntime().exec("nvidia-smi -L");
            Process getARPinfo = Runtime.getRuntime().exec("arp -a"); // no idea if this is needed but its good info to have displayed :D

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(getDiskSerial.getInputStream()));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(getSMBIOS.getInputStream()));
            BufferedReader reader3 = new BufferedReader(new InputStreamReader(timeZone.getInputStream()));
            BufferedReader reader4 = new BufferedReader(new InputStreamReader(getMacAddresses.getInputStream()));
            BufferedReader reader5 = new BufferedReader(new InputStreamReader(getNGPUUUID.getInputStream()));
            BufferedReader reader6 = new BufferedReader(new InputStreamReader(getARPinfo.getInputStream()));



            /*Prints HWID*/
            reader.readLine();
            reader.readLine();
            System.out.println("Hardware ID: \n" + reader.readLine() + "\n");

            /* Prints disk serials*/
            reader1.readLine();
            System.out.println("Disk Locations and Serials (ignore the empty and null because i am a bad programmer): ");
            while (!(reader1.readLine() == null)) {
                System.out.println("Disk drive is: " + reader1.readLine()); // this will print your drives here. After drives are finished printing, will show an empty drive and a null drive. you are looking for ones with text in it
            }

            System.out.println(""); // new line for cleanliness
            /*Prints SMBIOS (System Management BIOS)*/
            reader2.readLine();
            reader2.readLine();
            System.out.println("System Management BIOS (SMBIOS): \n" + reader2.readLine() + "\n");

            /*Prints user's timezone*/
            reader3.readLine();
            reader3.readLine();
            System.out.printf("Timezone Information: \n" + "%-30s", reader3.readLine() + "\n");

            System.out.println(""); // new line

            /*Get Mac Addresses*/
            reader4.readLine();
            reader4.readLine();
            System.out.println("Mac Addresses are:");
            while (!(reader4.readLine() == null)) {
                System.out.println(reader4.readLine()); // this will print your drives here. After drives are finished printing, will show an empty drive and a null drive. you are looking for ones with text in it
            }
            System.out.println("");



            /*Get nVidia GPU UUId*/
            try { // surrounded with try / catch incase user has amd card
                System.out.println("NVIDIA GPU UUID: \n" + reader5.readLine() + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            /*Get ARP information (doesn't seem necessary but good info nonetheless)*/
            reader6.readLine();
            reader6.readLine();
            System.out.println("ARP Information: \n");
            while(!(reader6.readLine() == null)) {
                System.out.println(reader6.readLine());
            }
        } catch (IOException e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }
}


