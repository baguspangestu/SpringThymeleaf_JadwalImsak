package com.irvanudin.kuis.models;

import java.util.List;

public class KabKotaModel {
  private int code;
  private String message;
  private List<String> data;

  public int getCode() {
      return code;
  }

  public void setCode(int code) {
      this.code = code;
  }

  public String getMessage() {
      return message;
  }

  public void setMessage(String message) {
      this.message = message;
  }

  public List<String> getData() {
      return data;
  }

  public void setData(List<String> data) {
      this.data = data;
  }
}
