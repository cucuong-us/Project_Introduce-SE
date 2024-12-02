package com.introduce_SE.demo.ClinicWeb.dto;

public class MedicineDTO {

    private String name;
    private String unit;
    private Long quantity;
    private Long numberOfUse;

    public MedicineDTO(String name, String unit, Long quantity, Long numberOfUse) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.numberOfUse = numberOfUse;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getNumberOfUse() {
        return numberOfUse;
    }

    public void setNumberOfUse(Long numberOfUse) {
        this.numberOfUse = numberOfUse;
    }
}
