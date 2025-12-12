
package factory;

class Zombie implements Enemy {

    @Override
    public void attack() {
        System.out.println("Zombie bites viciously!");
    }
}
