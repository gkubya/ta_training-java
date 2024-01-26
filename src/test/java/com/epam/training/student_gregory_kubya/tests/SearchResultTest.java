package com.epam.training.student_gregory_kubya.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchResultTest extends CommonConditions {

  @Test
  void checkSearchResultQuantity() {

    mainPage.searchForValue("abrigo");

    Assertions.assertThat(mainPage.getSearchResultQuantity()).as("Check search result quantity")
        .isGreaterThan(300);
  }

}
