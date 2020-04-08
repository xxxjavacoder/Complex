package com.company;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;


public class Complex implements Serializable {

    // for read from console
    private static final Scanner sc = new Scanner(System.in);
    // if imag = 0
    public static final double ZERO = 0.0d;

    private double real;
    private double imag;



    public Complex(double real)
    {
        this(real, ZERO);
    }


    public Complex(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }


    public double getReal() {
        return real;
    }


    public void setReal(double real) {
        this.real = real;
    }


    public double getImag() {
        return imag;
    }


    public void setImag(double imag) {
        this.imag = imag;
    }


    public Complex add(Complex z)
    {
        return new Complex(this.real + z.getReal(), this.imag + z.getImag());
    }


    public Complex add(double z)
    {
        return new Complex(this.real + z, this.imag);
    }


    public Complex add(int z)
    {
        return new Complex(this.real + z, this.imag);
    }


    public Complex add(long z)
    {
        return new Complex(this.real + z, this.imag);
    }


    public Complex subtract(Complex z)
    {
        return new Complex(this.real - z.getReal(), this.imag - z.getImag());
    }


    public Complex subtract(int z)
    {
        return new Complex(this.real - z, this.imag);
    }


    public Complex subtract(long z)
    {
        return new Complex(this.real - z, this.imag);
    }


    public Complex subtract(double z)
    {
        return new Complex(this.real - z, this.imag);
    }


    public Complex multiply(Complex z)
    {
        if (this.imag == 0d || z.getImag() == 0d)
        {
            return new Complex(this.real*z.getReal());
        }

        return new Complex((this.real*z.getReal()) - (this.imag* z.getImag()),
                (this.real*z.getImag()) + (this.imag* z.getReal()));
    }


    public Complex multiply(int z)
    {
        return new Complex(this.real*z, this.imag*z);
    }


    public Complex multiply(long z)
    {
        return new Complex(this.real*z, this.imag*z);
    }


    public Complex multiply(double z)
    {
        return new Complex(this.real*z, this.imag*z);
    }


    public Complex divide(Complex z)
    {
        double c = z.getReal();
        double d = z.getImag();

        // check for Re,Im(z) == 0 to avoid +/-infinity in result
        double zreal2 = 0.0;
        if (c != 0.0)
        {
            zreal2 = StrictMath.pow(c, 2d);
        }
        double zimag2 = 0.0;
        if (d != 0.0)
        {
            zimag2 = StrictMath.pow(d, 2d);
        }

        double ac = this.real*c;
        double bd = this.imag*d;
        double bc = this.imag*c;
        double ad = this.real*d;

        return new Complex((ac+bd)/(zreal2+zimag2),(bc-ad)/(zreal2+zimag2));
    }


    public static Complex readFromConsole(){
        double real = sc.nextDouble();
        double imag = sc.nextDouble();

        return new Complex(real, imag);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.imag, imag) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }


    @Override
    public String toString() {
        return "real=" + real +
                ", imag=" + imag;
    }
}

