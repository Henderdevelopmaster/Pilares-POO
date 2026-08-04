package Encapsulamiento.Taller1.Ejercicio1;

public class CuentaBancaria {

   //Atributos privados - encapsulamiento


          private String numeroCuenta;
          private String titular;
          private double saldo;


          public CuentaBancaria(String numeroCuenta,String titular){
              this.numeroCuenta=numeroCuenta;
              this.titular=titular;
              this.saldo=0.0;

          }

          public void transferir(CuentaBancaria destino, double cantidad) {
              if (destino == null) {
                  System.out.println("Error: la cuenta destino no existe.");
                  return;
              }
              if (cantidad <= 0) {
                  System.out.println("Error: la cantidad debe ser positiva.");
                  return;
              }
              if (cantidad > saldo) {
                  System.out.println("Error: saldo insuficiente para transferir.");
                  return;
              }
                  this.saldo -= cantidad;
                  destino.saldo += cantidad;
                  System.out.println("Transferencia exitosa de $" + cantidad + " a la cuenta de " + destino.getTitular());
          }
          //Getters -solo lectura desde el exterior


    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

        public void depositar(double cantidad) {
            if (cantidad > 0) {
                saldo += cantidad;
                System.out.println("Deposito exitoso de $" + cantidad);
            } else {
                System.out.println("Error: la cantidad debe ser positiva.");
            }
        }
        public void retirar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("Error: la cantidad debe ser positiva.");
            } else if (cantidad > saldo) {
                System.out.println("Error: saldo insuficiente.");
            } else {
                saldo -= cantidad;
                System.out.println("Retiro exitoso de $" + cantidad);
            }
        }
    }

