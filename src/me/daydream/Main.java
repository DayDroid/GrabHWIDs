package me.daydream;

public class Main {
    public static void main(String[] args) {
            checkOS(); // executes method `checkOS()` on main method execution
    }
        private static void checkOS() {
        String OS = System.getProperty("os.name").toLowerCase(); // gets operating system
            if(OS.contains("windows")) {
                System.out.println("You are on Windows" + "\n");
                getIDs.getHWIDIds(); // only works if Operating system is = windows
            }
            else if(OS.contains("mac")) {
                System.out.println("You need to be on Windows!");
                System.exit(1);
            }
            else if(OS.contains("sunos")) {
                System.out.println("You need to be on Windows!");
                System.exit(1);
            }
            else if(OS.contains("nix") || OS.contains("nux") || OS.contains("aix")) {
                System.out.println("You need to be on Windows!");
                System.exit(1);
            }

    }
}
