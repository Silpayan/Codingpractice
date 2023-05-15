package appfolio;

public class LightRemote {

    public static void main(String args[]){

        System.out.println("Welcome");

        Remote r = new Remote();

        r.assignLight();
        for(int i=0; i<7;i++) {
            r.on(i);
        }

        System.out.println();

        for(int i=0; i<7;i++) {
            r.off(i);
        }
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
        System.out.print(" : On\n");
    }

    public void off() {
        System.out.println(" : Off");
    }

}

class Remote {

    Light light[];
    final int LIGHT_COUNT = 7;

    public void assignLight() {
        light = new Light[LIGHT_COUNT];//new Light();
        for(int i=0; i<LIGHT_COUNT; i++){
            light[i] = new Light();
        }

    }

    public void on(int id) {
        System.out.print(id);
        light[id].on();
    }

    public void off(int id) {
        System.out.print(id);
        light[id].off();

    }
}
