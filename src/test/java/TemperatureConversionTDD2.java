import org.assertj.core.api.Assertions;
import org.example.TemperatureConversion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureConversionTDD2 {

    @Test
    @DisplayName("Class was created")
    public void classInitiate() {
        TemperatureConversion temperatureConversion = new TemperatureConversion();
    }

    @Test
    @DisplayName("Method was created")
    public void methodCall() {
        TemperatureConversion.celsiusToFahrenheit(3);

    }

    @Test
    @DisplayName("Conversion formula works correctly")
    public void convertsCorrectly() {
        //GIVEN
        double temperature = 0;
        int temperature2 = 123;

        //WHEN
        double result = TemperatureConversion.celsiusToFahrenheit(temperature);
        double result2 = TemperatureConversion.celsiusToFahrenheit(temperature2);

        //THEN
        Assertions.assertThat(result).isEqualTo(32);
        Assertions.assertThat(result2).isEqualTo(253.4);
    }

    @Test
    @DisplayName("Throws NullPointerException")
    public void nullPointerException() {
        //GIVEN
        Double temperature = null;

        //WHEN - THEN
        org.junit.jupiter.api.Assertions.assertThrows(NullPointerException.class, ()
                -> {double result = TemperatureConversion.celsiusToFahrenheit(temperature);});
    }

}
