import org.assertj.core.api.Assertions;
import org.example.TemperatureConversion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureConversionTDD {


    @Test
    @DisplayName("Class was created")
    public void classInitiate() {
        TemperatureConversion temperatureConversion = new TemperatureConversion();
    }

    @Test
    @DisplayName("Method was created")
    public void methodCall() {
        TemperatureConversion.fahrenheitToCelsius(3);

    }

    @Test
    @DisplayName("Conversion formula works correctly")
    public void convertsCorrectly() {
        //GIVEN
        int temperature = 0;
        double temperature2 = 50;

        //WHEN
        double result = TemperatureConversion.fahrenheitToCelsius(temperature);
        double result2 = TemperatureConversion.fahrenheitToCelsius(temperature2);

        //THEN
        Assertions.assertThat(result).isEqualTo(-17.77777777777778);
        Assertions.assertThat(result2).isEqualTo(10);
    }

    @Test
    @DisplayName("Throws NullPointerException")
    public void nullPointerException() {
        //GIVEN
        Double temperature = null;

        //WHEN - THEN
        org.junit.jupiter.api.Assertions.assertThrows(NullPointerException.class, ()
        -> {double result = TemperatureConversion.fahrenheitToCelsius(temperature);});
    }

}
