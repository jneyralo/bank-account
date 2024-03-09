package com.nttdata.bank.account.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("accounts")
public class AccountEntity {
  private String accountId;
  private String clientId;
  private String accountType;
  private String balance;
  private int limitMovement;
  private String commission;
  private String dateMovement;

}
