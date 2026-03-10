package Utils;

import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculations {


    public List<Double> getData(ElementsCollection priceElements){
        List<Double> actualPrices = new ArrayList<>();
        for (int i = 0; i < priceElements.size(); i++) {
            String raw = priceElements.get(i).getText().replace("$", "").trim();
            actualPrices.add(Double.parseDouble(raw));
           // System.out.println(raw);
        }
        return actualPrices;
    }
    public List<Double> sort( List<Double> list){
        List<Double> expectedPrices = new ArrayList<>(list);
        Collections.sort(expectedPrices);
        return expectedPrices;
    }

}
