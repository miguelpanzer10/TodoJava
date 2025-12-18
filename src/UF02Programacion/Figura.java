package UF02Programacion;

public class Figura {
    protected double base;
    protected double altura;

    public Figura(double base, double altura) {
        this.altura = altura;
        this.base = base;
    }

    public void main(String[] args){
        System.out.println("Tus valores son:");
        System.out.println("Base " + base);
        System.out.println("Altura " + altura);

    }
}
