package com.epam.training.student_gregory_kubya;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

  private int referenceNumber;

  private String name;

  private double price;

  private int quantity;
}
