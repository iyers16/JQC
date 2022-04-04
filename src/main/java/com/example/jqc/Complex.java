package com.example.jqc;

public class Complex extends Object{
    private double real;
    private double imaginary;

    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public Complex(double x) {
        this.real = x;
        this.imaginary = 0.0;
    }

    public Complex(double x, double y) {
        this.real = x;
        this.imaginary = y;
    }

    public Complex add(Complex x) {
        return new Complex(
            this.real + x.getReal(), 
            this.imaginary + x.getImaginary()
        );
    }
    public Complex subtract(Complex x) {
        return new Complex(
            this.real - x.getReal(), 
            this.imaginary - x.getImaginary()
        );
    }
    
    public Complex multiply(Complex x) {
        return new Complex(
            this.real * x.getReal() + this.imaginary * x.getImaginary(), 
            this.real * x.getImaginary() + this.imaginary * x.getReal()
        );
    }

    public Complex divide(Complex x) {
        double denominator = Math.pow(x.getModulus(), 2);
        return new Complex(
            (this.real * x.getReal() + this.imaginary * x.getImaginary()) / denominator, 
            (this.imaginary * x.getReal() - this.real * x.getImaginary()) / denominator
        );
    }

    public double getModulus() {
        if(
            this.real != 0
            || this.imaginary != 0
        ) {
            return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
        }
        else {
            return 0.0;
        }
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    @Override
    public String toString() {
        if(
            this.real == 0 
            && this.imaginary != 0
        ) {
            return (this.imaginary + "i");
        } else if(
            this.real != 0 
            && this.imaginary == 0
        ) {
            return String.valueOf(this.real);
        } else if(
            this.real == 0 
            && this.imaginary == 0
        ) {
            return String.valueOf(0.0);
        } else if(
            this.real != 0 
            && this.imaginary > 0
        ) {
            return this.real + " + " + this.imaginary + "i";
        } else if(
            this.real != 0 
            && this.imaginary < 0
        ) {
            return this.real + " - " + this.imaginary + "i";
        } else {
            return null;
        }
    }

}
