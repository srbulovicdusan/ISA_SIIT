package ProjectIsa.bioskop.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
@Component
public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    	System.out.println("USAOOO");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = jsonParser.getText();
        try {
            return  format.parse(date);
            
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}