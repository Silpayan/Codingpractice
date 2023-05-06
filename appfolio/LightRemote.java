package appfolio;

public class LightRemote {

    public static void main(String args[]){

        System.out.println("Welcome");

        Remote r = new Remote();

        r.assignLight();
        r.on();
        r.off();
    }

    /*
     * static is required if it is iiner class so moving out as normal class
    public static class Light{

        public void on(){
            System.out.println("On");
        }

        public void off(){
            System.out.println("Off");
        }

    }

    public static class Remote{

        Light light;

        public void assignLight(){
            light = new Light();
        }

        public void on(){
            light.on();
        }

        public void off(){
            light.off();
        }

    }*/
}

class Light {

    public void on() {
        System.out.println("On");
    }

    public void off() {
        System.out.println("Off");
    }

}

class Remote {

    Light light;

    public void assignLight() {
        light = new Light();
    }

    public void on() {
        light.on();
    }

    public void off() {
        light.off();
    }
}
