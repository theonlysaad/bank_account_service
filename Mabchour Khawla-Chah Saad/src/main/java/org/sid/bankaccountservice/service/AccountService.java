package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepositpry;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
