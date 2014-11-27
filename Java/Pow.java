// binary calculate
public double pow(double x, int n) {
    if (n == 0)
        return 1.0;
    if (n < 0)
        return 1/x*pow(1/x,-(n + 1));	// -n may overflow when Integer.MIN_VALUE
    if (n%2 == 0)
        return pow(x*x, n/2);
    return x*pow(x*x, (n - 1)/2);
}

// always n/2 before check n < 0, so no worries about overflow
public double pow(double x, int n) {
    if (n == 0)
        return 1.0;
    double temp = pow(x, n/2);
    if (n%2 == 0)
        return temp*temp;
    if (n < 0)
        return 1/x*temp*temp;
    return x*temp*temp;
}
