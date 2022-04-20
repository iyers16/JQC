package com.example.jqc;

public class Complex extends Object{
    private double real;
    private double imgn;

    public Complex() {
        this.real = 0.0;
        this.imgn = 0.0;
    }

    public Complex(double x) {
        this.real = x;
        this.imgn = 0.0;
    }

    public Complex(double x, double y) {
        this.real = x;
        this.imgn = y;
    }

    public Complex add(Complex x) {
        return new Complex(
            this.real + x.getReal(), 
            this.imgn + x.getImgn()
        );
    }
    public Complex subtract(Complex x) {
        return new Complex(
            this.real - x.getReal(), 
            this.imgn - x.getImgn()
        );
    }
    
    public Complex multiply(Complex x) {
        return new Complex(
            this.real * x.getReal() + this.imgn * x.getImgn(), 
            this.real * x.getImgn() + this.imgn * x.getReal()
        );
    }

    public Complex divide(Complex x) {
        double denominator = Math.pow(x.getModulus(), 2);
        return new Complex(
            (this.real * x.getReal() + this.imgn * x.getImgn()) / denominator, 
            (this.imgn * x.getReal() - this.real * x.getImgn()) / denominator
        );
    }

    public double getModulus() {
        if(
            this.real != 0
            || this.imgn != 0
        ) {
            return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imgn, 2));
        }
        else {
            return 0.0;
        }
    }

    public double getReal() {
        return this.real;
    }

    public double getImgn() {
        return this.imgn;
    }

    @Override
    public String toString() {
        if(
            this.real == 0 
            && this.imgn != 0
        ) {
            return (this.imgn + "i");
        } else if(
            this.real != 0 
            && this.imgn == 0
        ) {
            return String.valueOf(this.real);
        } else if(
            this.real == 0 
            && this.imgn == 0
        ) {
            return String.valueOf(0.0);
        } else if(
            this.real != 0 
            && this.imgn > 0
        ) {
            return this.real + " + " + this.imgn + "i";
        } else if(
            this.real != 0 
            && this.imgn < 0
        ) {
            return this.real + " - " + this.imgn + "i";
        } else {
            return null;
        }
    }

}
