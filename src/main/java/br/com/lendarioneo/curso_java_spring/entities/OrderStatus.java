package br.com.lendarioneo.curso_java_spring.entities;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus (int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value: OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }
}