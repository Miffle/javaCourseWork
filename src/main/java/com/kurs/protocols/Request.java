package com.kurs.protocols;

import com.kurs.client.elements.menu.MenuOption;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class Request {
    /**
     * Номер запроса
     * <ol>
     *     <li>Просмотр меню гостем</li>
     *     <li>Просмотр меню огузками</li>
     *     <li>Заказать блюдо</li>
     *     <li>Предложить блюдо</li>
     *     <li>Создать блюдо</li>
     *     <li>Удалить блюдо</li>
     *     <li>Одобрить заявку</li>
     *     <li>Разориться</li>
     * </ol>
     */
    private final int requestID;
    private String newDishName = null;
    private Double newDishPrice = null;
    private Integer dishID = null;
    private List<MenuOption> order = null;

    public Request(int requestID) {
        this.requestID = requestID;
    }

    public Request(int requestID, String newDishName, Double newDishPrice) {
        this.requestID = requestID;
        this.newDishName = newDishName;
        this.newDishPrice = newDishPrice;
    }

    public Request(int requestID, int dishID) {
        this.requestID = requestID;
        this.dishID = dishID;
    }

    public Request(int requestID, List<MenuOption> order) {
        this.requestID = requestID;
        this.order = order;
    }
}
