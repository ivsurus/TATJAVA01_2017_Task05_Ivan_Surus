package com.epam.menu.controller.util;

import com.epam.menu.bean.Appetizer;
import com.epam.menu.bean.Food;
import com.epam.menu.bean.menuName.MenuAttributeName;
import com.epam.menu.bean.menuName.MenuTagName;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ControllerTool {

    public static String createResponseForUser(Map menu){
        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<Appetizer, List<Food>>> foodIterator =
                menu.entrySet().iterator();
        while (foodIterator.hasNext()){
            Map.Entry<Appetizer, List<Food>> pair = foodIterator.next();
            builder.append(pair.getKey().getName()+"\n");
            for (Food food : pair.getValue()) {
                builder.append(MenuAttributeName.ID + " " + food.getId()+"\n");
                builder.append(MenuTagName.PICTURE + " " + food.getPicture()+"\n");
                builder.append(MenuTagName.NAME + " " + food.getName()+"\n");
                builder.append(MenuTagName.PORTION + " " + food.getPortion()+"\n");
                Iterator<Map.Entry<String, Map<String,String>>> typesIterator =
                        food.getTypes().entrySet().iterator();
                while (typesIterator.hasNext()){
                    Map.Entry<String, Map<String,String>> typesPair =
                            typesIterator.next();
                    builder.append(MenuAttributeName.ID + " " + typesPair.
                            getKey()+"\n");
                    Iterator<Map.Entry<String,String>> typeIterator =
                            typesPair.getValue().entrySet().iterator();
                    while(typeIterator.hasNext()){
                        Map.Entry<String,String> typePair = typeIterator.next();
                        builder.append(MenuTagName.DESCRIPTION + " " +
                                typePair.getKey()+"\n");
                        builder.append(MenuTagName.PRICE + " " +
                                typePair.getValue()+"\n");
                    }
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
