package br.edu.unoesc.pi2.restaurantes.dtos;

public class MenuOrderDto {
    private String menu;
    private Integer quantity;

    public MenuOrderDto(String menu, Integer quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
