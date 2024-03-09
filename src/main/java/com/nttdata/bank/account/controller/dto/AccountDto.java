package com.nttdata.bank.account.controller.dto;

import lombok.Data;

@Data
public class AccountDto {
    private String accountId;
    private String clientId;
    private String accountType;
    private String balance;
    private int limitMovement;
    private String commission;
    private String dateMovement;
}
