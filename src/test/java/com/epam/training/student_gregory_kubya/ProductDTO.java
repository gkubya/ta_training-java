package com.epam.training.student_gregory_kubya;

import java.util.Objects;

public class ProductDTO {

  private int referenceNumber;

  private String name;

  private double price;

  private int quantity;


  public ProductDTO(int referenceNumber, String name, double price, int quantity) {
    this.name = name;
    this.referenceNumber = referenceNumber;
    this.price = price;
    this.quantity = quantity;
  }

  public int getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(int referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDTO that = (ProductDTO) o;
    return referenceNumber == that.referenceNumber && Double.compare(price, that.price) == 0
        && quantity == that.quantity && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referenceNumber, name, price, quantity);
  }
}
