package ru.digdes.steammarketparser.service.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.model.entity.Price;
import ru.digdes.steammarketparser.service.PriceParser;

import java.math.BigDecimal;

/**
 * TODO javadoc
 */
@Service
public class PriceParserImpl implements PriceParser{
    @Override
    public Price parse(String jsonText) {
        Price answer = null;
        JSONObject json = new JSONObject(jsonText);
        boolean success = (boolean)json.get("success");
        if (success){
            answer = new Price();

            String stringMedianPrice = (String)json.get("median_price");
            stringMedianPrice = stringMedianPrice.split(" ")[0];
            stringMedianPrice = stringMedianPrice.replaceAll(",",".");
            BigDecimal medianPrice = new BigDecimal(stringMedianPrice);
            answer.setValue(medianPrice);
        }

        return answer;
    }
}
