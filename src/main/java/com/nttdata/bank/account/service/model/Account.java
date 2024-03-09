package com.nttdata.bank.account.service.model;

import lombok.Data;

@Data
public class Account {
    private String accountId;
    private String clientId;
    private String accountType;
    private String balance;
    private int limitMovement;
    private String commission;
    private String dateMovement;
}
