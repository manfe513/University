package com.example.drugs.model;

public class DrugInfo {

    private Drug drug;

    private DrugType drugType;

    public DrugInfo() {}

    public DrugInfo(
            Drug drug,
            DrugType drugType
    ) {
        this.drug = drug;
        this.drugType = drugType;
    }

    public Drug getDrug() {
        return drug;
    }

    public DrugType getDrugType() {
        return drugType;
    }
}