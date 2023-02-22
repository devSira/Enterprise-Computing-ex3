package mybean;

import javax.ejb.Remote;

@Remote
public interface TempConversionBeanRemote {

    double fToC(double F);
    
}
