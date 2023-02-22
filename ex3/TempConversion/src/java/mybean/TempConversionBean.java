package mybean;

import javax.ejb.Stateless;

@Stateless
public class TempConversionBean implements TempConversionBeanRemote {
    @Override
    public double fToC(double F) {
        double C = (5*(F-32))/9;
        return C;
    }
}
